package training.my.mycommercefacade;


import training.my.mycommercefacade.product.data.ProductData;

public interface MyProductDataFacade {
    ProductData getProductData(String s) throws Exception;
}
