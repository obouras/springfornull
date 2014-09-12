package com.springMvc.annotated.domain;

public class HelloWorld {
    private String message;

    public String getMessage() {
        //System.out.println("hello world message "+message);
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}