package training.my.service.impl;

import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import training.my.service.MyUserService;

import javax.annotation.Resource;
import java.util.List;

public class MyUserServiceImpl implements MyUserService {

    @Resource
    private FlexibleSearchService flexibleSearchService;

    @Override
    public List<UserModel> getUserWithMostOrders() {
        final String query = "SELECT {user} FROM {order} GROUP BY {user} HAVING COUNT(*) = " +
                "({{SELECT COUNT(*) FROM {order} GROUP BY {user} ORDER BY COUNT(*) DESC LIMIT 1}})";
        final SearchResult<UserModel> result = flexibleSearchService.search(query);
        return result.getResult();
    }

    @Override
    public int getCurrentNumberOfUsers() {
        final String query = "SELECT {pk} FROM {user}";
        final SearchResult<UserModel> result = flexibleSearchService.search(query);
        return result.getCount();
    }
}