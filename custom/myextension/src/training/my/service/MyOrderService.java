package training.my.service;

import de.hybris.platform.core.model.order.OrderModel;

public interface MyOrderService {
    int getTotalNumberOfOrders();
    OrderModel getLatestOrder();
}