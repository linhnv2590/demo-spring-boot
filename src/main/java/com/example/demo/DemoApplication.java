package com.example.demo;

import com.example.demo.beanDemo.Casual;
import com.example.demo.beanDemo.Dress;
import com.example.demo.beanDemo.Outfit;
import com.example.demo.beanDemo.WearService;
import com.example.demo.looselyCoupled.BubbleSortAlgorithm;
import com.example.demo.looselyCoupled.QuicksortAlgorithm;
import com.example.demo.looselyCoupled.SortAlgorithm;
import com.example.demo.looselyCoupled.SortService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        // LOOSELY COUPLED EXAMPLE
        // SortService sẽ không quan tâm tới việc thuật toán sắp xếp là gì nữa, mà chỉ cần tập trung vào nghiệp vụ.
        // Còn SortAlgorithm sẽ được đưa vào từ bên ngoài tùy theo nhu cầu sử dụng.
        SortAlgorithm bubbleSort = new BubbleSortAlgorithm();
        SortService sortService = new SortService(bubbleSort);
        sortService.run();

        SortAlgorithm quickSort = new QuicksortAlgorithm();
        SortService sortService1 = new SortService(quickSort);
        sortService1.run();
        // END LOOSELY COUPLED EXAMPLE

        // BEAN DEMO
        Outfit casual = context.getBean(Casual.class);
        WearService wearService = new WearService(casual);
        wearService.run();

        Outfit dress = context.getBean(Dress.class);
        WearService wearService1 = new WearService(dress);
        wearService1.run();
        // END BEAN DEMO
    }

}
