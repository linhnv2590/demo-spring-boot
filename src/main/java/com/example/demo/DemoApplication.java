package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        Outfit outfit = context.getBean(Outfit.class);
        System.out.println("Instance: " + outfit);
        outfit.wear();

        // Do Outfit là interface nên ko thể tạo object từ đây
        // Container đã tìm trong context có bean là Dress implements Outfit
        // nên nó đã tự động tạo ra object của Dress để trả về
        // Instance: com.example.demo.Dress@15a30f06
    }

}
