package com.springMvc.services;

import com.springMvc.DAO.ProductDAO;
import com.springMvc.domain.Product;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * Created by obouras on 05/08/2014.
 */
public class SimpleProductManagerImpl implements ProductManager {
    //private List<Product> products;
    protected final Log logger = LogFactory.getLog(getClass());
    private ProductDAO productDAO;

    public void increasePrice(int percentage){
        //throw new UnsupportedOperationException();
        List<Product> products=productDAO.getProductList();
        if (products!=null){
            for(Product product:products){
                product.setPrice(product.getPrice()*(100+(double)percentage)/100);
                productDAO.saveProduct(product);
                //logger.info("*********************************"+product.getPrice());
            }
        }

    }

    public List<Product> getProducts() {
        //throw new UnsupportedOperationException();
        return productDAO.getProductList();
    }

    //public void setProducts(List<Product> products) {
        //throw new UnsupportedOperationException();
      //  this.products = products;
    //}


    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }


}
