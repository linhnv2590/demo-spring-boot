package com.example.demo;

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

        Outfit outfit = context.getBean(Outfit.class);
        System.out.println("Instance: " + outfit);
        outfit.wear();

        // Do Outfit là interface nên ko thể tạo object từ đây
        // Container đã tìm trong context có bean là Dress implements Outfit
        // nên nó đã tự động tạo ra object của Dress để trả về
        // Instance: com.example.demo.Dress@15a30f06

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
    }

}
