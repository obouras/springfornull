package com.springMvc.annotated.controller;

import com.springMvc.annotated.domain.HelloWorld;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by obouras on 07/08/2014.
 */
@Controller
@RequestMapping("sayHello.htm")
public class AnnotatedProductController {
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        HelloWorld hello=helloWorld();
        hello.setMessage("Omar is telling that");
        model.addAttribute("message", hello.getMessage());
        return "redirect:hiagain";

    }
    @RequestMapping(value="hiagain",method=RequestMethod.GET)
    public String concatMessage(ModelMap model){
       String message="concat to hi redirect: fake message";
       model.addAttribute("message", message);
        return "hi";

    }

    @Bean
    public HelloWorld helloWorld(){
        return new HelloWorld();
    }
}
