package training.my.populator;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import training.my.mycommercefacade.product.data.ProductData;

public class MyPopulator implements Populator<ProductModel, ProductData> {

    @Override
    public void populate(ProductModel productModel, ProductData productData) throws ConversionException {
        productData.setMyCodePK(productModel.getCode() + " " + productModel.getPk());
    }
}