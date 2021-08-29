package com.example.demo.looselyCoupled;

public class SortService {
    private final SortAlgorithm sortAlgorithm;

    public SortService(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public void run() {
        sortAlgorithm.sort();
    }
}
