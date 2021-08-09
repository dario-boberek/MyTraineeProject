package training.my.action;

import de.hybris.platform.orderprocessing.model.OrderProcessModel;
import de.hybris.platform.processengine.action.AbstractSimpleDecisionAction;
import de.hybris.platform.processengine.model.BusinessProcessModel;
import de.hybris.platform.task.RetryLaterException;

import java.time.LocalDateTime;
import java.util.logging.Logger;

public class AddToCartRegistrar extends AbstractSimpleDecisionAction {

    private static final Logger LOGGER = Logger.getLogger(AddToCartRegistrar.class.getName());

    @Override
    public Transition executeAction(BusinessProcessModel businessProcessModel) throws RetryLaterException, Exception {
        LOGGER.info("Order is added to the cart at " + LocalDateTime.now());
        return Transition.OK;
    }
}
