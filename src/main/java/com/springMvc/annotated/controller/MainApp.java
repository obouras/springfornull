package com.springMvc.annotated.controller;

import com.springMvc.annotated.domain.HelloWorld;
import com.springMvc.annotated.services.HelloWorldConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by obouras on 12/08/2014.
 */
public class MainApp {
    public static void main(String[] args){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(HelloWorldConfig.class);
        HelloWorld helloWorld=applicationContext.getBean(HelloWorld.class);
        helloWorld.setMessage("testOmar");
        helloWorld.getMessage();
    }
}
