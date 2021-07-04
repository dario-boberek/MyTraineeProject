package training.my.mycommercefacade.Impl;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import training.my.mycommercefacade.MyProductDataFacade;
import training.my.mycommercefacade.product.data.ProductData;

public class MyProductDataFacadeImpl implements MyProductDataFacade {
    private Converter<ProductModel, ProductData> myProductDataConverter;
    private ProductService myProductService;

    @Override
    public ProductData getProductData(String s) throws Exception {
        if (myProductService.getProductForCode(s) == null) throw new Exception();
        return myProductDataConverter.convert(myProductService.getProductForCode(s));
    }

    public Converter<ProductModel, ProductData> getMyProductDataConverter() {
        return myProductDataConverter;
    }

    public void setMyProductDataConverter(Converter<ProductModel, ProductData> myProductDataConverter) {
        this.myProductDataConverter = myProductDataConverter;
    }

    public ProductService getMyProductService() {
        return myProductService;
    }

    public void setMyProductService(ProductService myProductService) {
        this.myProductService = myProductService;
    }
}