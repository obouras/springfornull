package com.springMvc.services;

import com.springMvc.DAO.ProductDAO;
import com.springMvc.domain.Product;
import com.springMvc.repository.InMemoryProductDao;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by obouras on 05/08/2014.
 */
public class SimpleProductManagerTest extends TestCase {
    private ProductManager productManager;

    private List<Product> products;

    private static int PRODUCT_COUNT = 2;

    private static Double CHAIR_PRICE = new Double(20.50);
    private static String CHAIR_DESCRIPTION = "Chair";

    private static String TABLE_DESCRIPTION = "Table";
    private static Double TABLE_PRICE = new Double(150.10);
    private static int POSITIVE_PRICE_INCREASE = 10;

    protected void setUp() throws Exception {
        productManager=new SimpleProductManagerImpl();
        products = new ArrayList<Product>();

        // stub up a list of products
        Product product = new Product();
        product.setDescription("Chair");
        product.setPrice(CHAIR_PRICE);
        products.add(product);

        product = new Product();
        product.setDescription("Table");
        product.setPrice(TABLE_PRICE);
        products.add(product);
        ProductDAO productDAO=new InMemoryProductDao(products);
        productManager.setProductDAO(productDAO);
    }

    public void testGetProductsWithNoProducts() {
        productManager=new SimpleProductManagerImpl();
        ProductDAO productDAO=new InMemoryProductDao(null);
        productManager.setProductDAO(productDAO);
        assertNull(productManager.getProducts());
    }

    public void testGetProducts() {
        List<Product> products = productManager.getProducts();
        assertNotNull(products);
        assertEquals(PRODUCT_COUNT, productManager.getProducts().size());

        Product product = products.get(0);
        assertEquals(CHAIR_DESCRIPTION, product.getDescription());
        assertEquals(CHAIR_PRICE, product.getPrice());

        product = products.get(1);
        assertEquals(TABLE_DESCRIPTION, product.getDescription());
        assertEquals(TABLE_PRICE, product.getPrice());
    }

    public void testIncreasePriceWithEmptyListOfProducts(){
        productManager=new SimpleProductManagerImpl();
        try{
            ProductDAO productDAO=new InMemoryProductDao(new ArrayList<Product>());
            productManager.setProductDAO(productDAO);
            //productManager.setProducts(new ArrayList<Product>());
            productManager.increasePrice(POSITIVE_PRICE_INCREASE);
        }
        catch(Exception e){
            fail("Product List is empty");
        }

    }

    public void testIncreasePriceWithPositivePercentage() {
        double expectedChairPriceWithIncrease = 22.55;
        double expectedTablePriceWithIncrease = 165.11;
        productManager.increasePrice(POSITIVE_PRICE_INCREASE);
        assertEquals(expectedChairPriceWithIncrease,productManager.getProducts().get(0).getPrice());
        assertEquals(expectedTablePriceWithIncrease,productManager.getProducts().get(1).getPrice());
    }


}
