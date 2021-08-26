package training.my.action;

import de.hybris.platform.processengine.action.AbstractSimpleDecisionAction;
import de.hybris.platform.processengine.model.BusinessProcessModel;
import de.hybris.platform.task.RetryLaterException;

import java.time.LocalDateTime;
import java.util.logging.Logger;

public class NothingChosenRegistrar extends AbstractSimpleDecisionAction {
    private static final Logger LOGGER = Logger.getLogger(NothingChosenRegistrar.class.getName());

    @Override
    public Transition executeAction(BusinessProcessModel businessProcessModel) throws RetryLaterException, Exception {
        LOGGER.info("Nothing is chosen " + LocalDateTime.now());
        return Transition.OK;
    }
}
