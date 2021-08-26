package training.my.service.impl;

import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import training.my.service.MyOrderService;

import javax.annotation.Resource;

public class MyOrderServiceImpl implements MyOrderService {

    @Resource
    private FlexibleSearchService flexibleSearchService;

    @Override
    public int getTotalNumberOfOrders() {
        final String query = "select {pk} from {order}";
        final SearchResult searchResult = flexibleSearchService.search(query);
        return searchResult.getCount();
    }

    @Override
    public OrderModel getLatestOrder() {
        final String query = "select {pk} from {order} where {date} in ({{select max({date}) from {order}}})";
        final SearchResult<OrderModel> result = flexibleSearchService.search(query);
        return result.getResult().get(0);
    }
}