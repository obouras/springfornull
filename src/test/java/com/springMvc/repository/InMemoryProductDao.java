package com.springMvc.repository;

import com.springMvc.DAO.ProductDAO;
import com.springMvc.domain.Product;

import java.util.List;

/**
 * Created by obouras on 07/08/2014.
 */
public class InMemoryProductDao implements ProductDAO {
    private List<Product> productList;

    public InMemoryProductDao(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void saveProduct(Product prod) {
    }
}
