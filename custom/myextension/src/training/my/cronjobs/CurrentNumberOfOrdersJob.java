package training.my.cronjobs;

import de.hybris.cronjobtutorial.model.CurrentNumberOfOrdersCronJobModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import org.apache.log4j.Logger;
import training.my.service.MyOrderService;

import javax.annotation.Resource;

public class CurrentNumberOfOrdersJob extends AbstractJobPerformable<CurrentNumberOfOrdersCronJobModel> {

    private static long count = 0;

    @Resource
    MyOrderService myOrderService;

    @Override
    public PerformResult perform(final CurrentNumberOfOrdersCronJobModel cronJobModel) {

        Logger LOG = Logger.getLogger(CurrentNumberOfOrdersJob.class.getName());
        LOG.info("Current number of orders is " + myOrderService.getTotalNumberOfOrders() + " " + ++count);
        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }
}
