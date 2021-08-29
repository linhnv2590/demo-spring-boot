package com.example.demo.beanDemo;

import org.springframework.stereotype.Component;

@Component
public class Casual implements Outfit{
    @Override
    public void wear() {
        System.out.println("Wearing casual");
    }
}
