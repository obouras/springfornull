package com.springMvc.controller;


import com.springMvc.DAO.ProductDAO;
import com.springMvc.controller.InventoryController;
import com.springMvc.domain.Product;
import com.springMvc.repository.InMemoryProductDao;
import com.springMvc.services.ProductManager;
import com.springMvc.services.SimpleProductManagerImpl;
import org.springframework.web.servlet.ModelAndView;
import junit.framework.TestCase;
import java.lang.Exception;
import java.util.ArrayList;
import java.util.Map;

public class InventoryControllerTestCase extends TestCase{

    public void testHandleRequestView() throws Exception{
        InventoryController inventoryController=new InventoryController();
        ProductManager productManager=new SimpleProductManagerImpl();
        productManager.setProductDAO(new InMemoryProductDao(new ArrayList<Product>()));
        //inventoryController.setProductManager(new SimpleProductManagerImpl());
        inventoryController.setProductManager(productManager);
        ModelAndView modelAndView=inventoryController.handleRequest(null,null);
        assertEquals("hello",modelAndView.getViewName());
        assertNotNull(modelAndView);
        String nowValue= (String)((Map)modelAndView.getModel().get("model")).get("now");
        assertNotNull(nowValue);
    }


}