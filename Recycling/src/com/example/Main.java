// Main.java
package com.example;

import com.example.application.RecyclingService;
import com.example.infrastructure.InMemoryRecyclingRepository;
import com.example.presentation.RecyclingController;

public class Main {
    public static void main(String[] args) {
        InMemoryRecyclingRepository recyclingRepository = new InMemoryRecyclingRepository();
        RecyclingService recyclingService = new RecyclingService(recyclingRepository);
        RecyclingController recyclingController = new RecyclingController(recyclingService);

        recyclingController.runMenu();
    }
}
