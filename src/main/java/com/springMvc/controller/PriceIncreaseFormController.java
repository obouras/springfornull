package com.springMvc.controller;

import com.springMvc.services.PriceIncrease;
import com.springMvc.services.ProductManager;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by obouras on 06/08/2014.
 */
public class PriceIncreaseFormController extends SimpleFormController {
    private ProductManager productManager;
    public ModelAndView onSubmit(Object command)
            throws ServletException {
        int increase=((PriceIncrease)command).getPercentage();
        logger.info("Increasing prices by " + increase + "%.");
        productManager.increasePrice(increase);
        logger.info("returning from PriceIncreaseForm view to " + getSuccessView());
        return new ModelAndView(new RedirectView(getSuccessView()));
    }


    protected Object formBackingObject(HttpServletRequest request) throws ServletException {
        PriceIncrease priceIncrease = new PriceIncrease();
        priceIncrease.setPercentage(20);
        return priceIncrease;
    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }

    public ProductManager getProductManager() {
        return productManager;
    }
}
