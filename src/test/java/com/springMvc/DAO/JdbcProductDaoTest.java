package com.springMvc.DAO;

import com.springMvc.domain.Product;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import java.util.List;

/**
 * Created by obouras on 06/08/2014.
 */
public class JdbcProductDaoTest extends AbstractTransactionalDataSourceSpringContextTests {
    private ProductDAO productDao;
    @Override
    protected String[] getConfigLocations() {
        return new String[] {"classpath:test/test-context.xml"};
    }

    public ProductDAO getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductDAO productDao) {
        this.productDao = productDao;
    }

    @Override
    protected void onSetUpInTransaction() throws Exception {
        super.deleteFromTables(new String[] {"products"});
        super.executeSqlScript("classpath:db/load_data.sql", true);
    }
    public void testGetProductList() {
        assertEquals("wrong number of products?",3,productDao.getProductList().size());
    }

    public void testSaveProduct(){
        List<Product> products = productDao.getProductList();
        for (Product product:products){
            product.setPrice(200.12);
            productDao.saveProduct(product);
        }
        List<Product> updatedProducts = productDao.getProductList();
        for (Product product:updatedProducts){
            assertEquals("wrong price of product?", 200.12, product.getPrice());
        }
    }
}
