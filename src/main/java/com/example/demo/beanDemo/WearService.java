package com.example.demo.beanDemo;

public class WearService {
    private final Outfit outfit;

    public WearService(Outfit outfit) {
        this.outfit = outfit;
    }

    public void run() {
        outfit.wear();
    }
}
