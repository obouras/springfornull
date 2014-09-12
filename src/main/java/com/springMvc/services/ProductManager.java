package com.springMvc.services;

import com.springMvc.DAO.ProductDAO;
import com.springMvc.domain.Product;

import java.util.List;

/**
 * Created by obouras on 05/08/2014.
 */
public interface ProductManager {
    void increasePrice(int percentage);

    List<Product> getProducts();

    //void setProducts(List<Product> products);
    public ProductDAO getProductDAO();
    void setProductDAO(ProductDAO productDAO);
}




