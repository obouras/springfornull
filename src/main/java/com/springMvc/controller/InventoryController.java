package com.springMvc.controller;

import com.springMvc.services.ProductManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class InventoryController implements Controller{
    protected final Log logger = LogFactory.getLog(getClass());
    private ProductManager productManager;
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,Object> myModel=new HashMap<String, Object>();
        logger.info("Returning hello view");
        String now = (new Date()).toString();
        myModel.put("now",now);
        myModel.put("products",productManager.getProducts());
        logger.info("Returning hello view with " + now);
        return new ModelAndView("hello","model",myModel);
    }

    public ProductManager getProductManager() {
        return productManager;
    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }
}