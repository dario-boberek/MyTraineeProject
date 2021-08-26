package training.my.listener;

import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.product.UnitModel;
import de.hybris.platform.order.impl.DefaultCartService;
import de.hybris.platform.servicelayer.event.EventService;
import de.hybris.platform.servicelayer.model.ModelService;

import javax.annotation.Resource;

public class MyCartService extends DefaultCartService {
    @Resource
    EventService eventService;

    @Resource
    ModelService modelService;

    @Override
    public void addToCart(final CartModel cartModel, final ProductModel productModel, final long quantity,
                          final UnitModel unitModel) {
        eventService.publishEvent(new MyEvent());
    }
}
