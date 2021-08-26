package training.my.action;

import de.hybris.platform.processengine.action.AbstractSimpleDecisionAction;
import de.hybris.platform.processengine.model.BusinessProcessModel;
import de.hybris.platform.task.RetryLaterException;

import java.time.LocalDateTime;
import java.util.logging.Logger;

public class RemovedOrderRegistrar extends AbstractSimpleDecisionAction {
    private static final Logger LOGGER = Logger.getLogger(RemovedOrderRegistrar.class.getName());

    @Override
    public Transition executeAction(BusinessProcessModel businessProcessModel) throws RetryLaterException, Exception {
        LOGGER.info("Order is removed from the cart at " + LocalDateTime.now());
        return Transition.OK;
    }
}
