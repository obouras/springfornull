package com.springMvc.annotated.controller;

import com.springMvc.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by obouras on 08/09/2014.
 */
@Controller
@RequestMapping("invokeProducts")
public class GreetingRest {
    @RequestMapping(value="/test",method = RequestMethod.GET)
    //public List getMovie(@PathVariable String name, ModelMap model) {
    public @ResponseBody List getMovie() {
        List products=new ArrayList<Product>();
        for (int i=1;i<11;i++){
            Product product=new Product();
            product.setId(i);
            product.setPrice(i * 50.5);
            product.setDescription("ddddddd" + i);
            products.add(product);
        }
        return products;
       /* Product product=new Product();
        product.setId(1);
        product.setPrice(1 * 50.5);
        product.setDescription("ddddddd" + 1);

        return product;*/

    }

}
