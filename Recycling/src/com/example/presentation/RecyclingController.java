// RecyclingController.java
package com.example.presentation;

import com.example.application.RecyclingService;
import com.example.domain.RecyclingItem;

import java.util.List;
import java.util.Scanner;

public class RecyclingController {
    private RecyclingService recyclingService;

    public RecyclingController(RecyclingService recyclingService) {
        this.recyclingService = recyclingService;
    }

    public void displayAllItems() {
        List<RecyclingItem> items = recyclingService.getAllItems();
        for (RecyclingItem item : items) {
            System.out.println(item);
        }
    }

    public void addRecyclingItem(String type, double weight) {
        recyclingService.addItem(type, weight);
        System.out.println("Item added: " + type + ", weight: " + weight);
    }

    public void processRecyclingItem(String type) {
        boolean success = recyclingService.processItem(type);
        if (success) {
            System.out.println("Item processed: " + type);
        } else {
            System.out.println("Item not found: " + type);
        }
    }

    public void deleteRecyclingItem(String type) {
        boolean success = recyclingService.deleteItem(type);
        if (success) {
            System.out.println("Item deleted: " + type);
        } else {
            System.out.println("Item not found: " + type);
        }
    }

    public void updateRecyclingItem(String type, double newWeight) {
        boolean success = recyclingService.updateItem(type, newWeight);
        if (success) {
            System.out.println("Item updated: " + type + ", new weight: " + newWeight);
        } else {
            System.out.println("Item not found: " + type);
        }
    }

    public void classifyItems() {
        List<RecyclingItem> items = recyclingService.getAllItems();
        System.out.println("Classified Items:");
        for (RecyclingItem item : items) {
            String category = classifyItem(item);
            System.out.println(item + " - Category: " + category);
        }
    }

    private String classifyItem(RecyclingItem item) {
        switch (item.getType().toLowerCase()) {
            case "plastic":
                return "Recyclable - Plastic";
            case "glass":
                return "Recyclable - Glass";
            case "metal":
                return "Recyclable - Metal";
            case "paper":
                return "Recyclable - Paper";
            default:
                return "Non-Recyclable";
        }
    }

    public void displayMenu() {
        System.out.println("\n=== Recycling Management System ===");
        System.out.println("1. Add Recycling Item");
        System.out.println("2. Display All Items");
        System.out.println("3. Process Recycling Item");
        System.out.println("4. Delete Recycling Item");
        System.out.println("5. Update Recycling Item");
        System.out.println("6. Classify Items");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    public void performAction(int choice) {
        Scanner scanner = new Scanner(System.in);

        switch (choice) {
            case 1:
                System.out.print("Enter item type: ");
                String type = scanner.nextLine();
                System.out.print("Enter item weight: ");
                double weight = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                addRecyclingItem(type, weight);
                break;
            case 2:
                displayAllItems();
                break;
            case 3:
                System.out.print("Enter item type to process: ");
                String processType = scanner.nextLine();
                processRecyclingItem(processType);
                break;
            case 4:
                System.out.print("Enter item type to delete: ");
                String deleteType = scanner.nextLine();
                deleteRecyclingItem(deleteType);
                break;
            case 5:
                System.out.print("Enter item type to update: ");
                String updateType = scanner.nextLine();
                System.out.print("Enter new weight: ");
                double newWeight = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                updateRecyclingItem(updateType, newWeight);
                break;
            case 6:
                classifyItems();
                break;
            case 7:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 7.");
        }
    }

    public void runMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            performAction(choice);
        } while (choice != 7);
        scanner.close();
    }
}
