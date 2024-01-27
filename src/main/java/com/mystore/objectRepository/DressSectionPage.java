package com.mystore.objectRepository;

public interface DressSectionPage {
    String dresses="//div[@class='product-container']//a[@class='product-name']";
    String addToCartButton="//span[contains(text(),'Add to cart')]";
    String cartVerificationWindow="//div[@id='layer_cart']//div[@class='clearfix']";
    String continueShopping="//span[@title='Continue shopping']";
}
