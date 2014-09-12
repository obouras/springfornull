package com.springMvc.domain;

import junit.framework.TestCase;

/**
 * Created by obouras on 05/08/2014.
 */
public class ProductTest extends TestCase {
    private Product product;
    @Override
    protected void setUp() throws Exception {
        //super.setUp();
        product=new Product();
    }

    public void testSetAndGetDescription() {
        String testDescription="ProductTested";
        product.setDescription(testDescription);
        assertNotNull(product.getDescription());
        assertEquals(testDescription,product.getDescription());
    }

    public void testSetAndGetPrice(){
        double testPrice=3.0;
        product.setPrice(testPrice);
        product.setPrice(testPrice);
        assertEquals(testPrice, product.getPrice(), 0);
    }

}
