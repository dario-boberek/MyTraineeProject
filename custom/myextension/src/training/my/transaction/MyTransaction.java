package training.my.transaction;

import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.tx.Transaction;
import de.hybris.platform.tx.TransactionBody;
import org.apache.log4j.Logger;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.util.List;

public class MyTransaction {
    private static final Logger LOGGER = Logger.getLogger(MyTransaction.class.getName());

    @Resource(name = "txManager")
    PlatformTransactionManager manager;

    @Resource
    private FlexibleSearchService flexibleSearchService;

    public void myHybrisTransaction() {
        Transaction tx = Transaction.current();
        tx.begin();
        boolean success = false;
        try {
            LOGGER.info("Transaction is done");
            success = true;
        } finally {
            if (success) {
                tx.commit();
                LOGGER.info("Transaction is committed");
            } else
                tx.rollback();
        }
    }

    public void myHybrisTransactionBody() throws Exception {
        Transaction.current().execute(new TransactionBody() {
            public <T> T execute() {
                final String query = "SELECT {pk} FROM {user} where {name} LIKE 'S%'";
                final SearchResult<UserModel> searchResult = flexibleSearchService.search(query);
                List<UserModel> users = searchResult.getResult();
                for (UserModel name : users) {
                    LOGGER.info("Transaction from myHybrisTransactionBody() method is done. Name is ... " + name.getName());
                }
                return null;
            }
        });
    }

    public void mySpringTransaction() /* throws Exception */ {
        TransactionTemplate template = new TransactionTemplate(manager);
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(final TransactionStatus status) {
                final String query = "SELECT {pk} FROM {user} WHERE {name} IS NOT NULL";
                final SearchResult<UserModel> searchResult = flexibleSearchService.search(query);
                List<UserModel> users = searchResult.getResult();
                for (UserModel name : users) {
                    LOGGER.info("Transaction from mySpringTransaction method is done. Name is ... " + name.getName());
                }
            }
        });
    }
}
