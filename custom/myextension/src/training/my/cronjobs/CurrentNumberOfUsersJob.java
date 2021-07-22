package training.my.cronjobs;

import de.hybris.cronjobtutorial.model.CurrentNumberOfUsersCronJobModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import org.apache.log4j.Logger;
import training.my.service.MyUserService;

import javax.annotation.Resource;

public class CurrentNumberOfUsersJob extends AbstractJobPerformable<CurrentNumberOfUsersCronJobModel> {

    private static long count = 0;

    @Resource
    MyUserService myUserService;

    @Override
    public PerformResult perform(final CurrentNumberOfUsersCronJobModel cronJobModel) {

        Logger LOG = Logger.getLogger(CurrentNumberOfUsersJob.class.getName());
        LOG.info("Current number of users is " + myUserService.getCurrentNumberOfUsers() + " " + ++count);
        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }
}
