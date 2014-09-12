package com.springMvc.DAO;

import com.springMvc.domain.Product;

import java.util.List;

/**
 * Created by obouras on 06/08/2014.
 */
public interface ProductDAO {

    public List<Product> getProductList();

    public void saveProduct(Product prod);

}
