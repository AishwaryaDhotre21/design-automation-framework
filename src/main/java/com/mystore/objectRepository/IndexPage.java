package com.mystore.objectRepository;

public interface IndexPage {
    String dressButton="(//li/a[@title='Dresses'])[2]";
    String tshirtButton="(//li/a[contains(text(),'T-shirts')])[2]";
    String cartButton="//a[@title='View my shopping cart']";
}
