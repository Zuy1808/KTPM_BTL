// RecyclingService.java
package com.example.application;

import com.example.domain.RecyclingItem;
import com.example.domain.RecyclingRepository;

import java.util.List;

public class RecyclingService {
    private RecyclingRepository recyclingRepository;

    public RecyclingService(RecyclingRepository recyclingRepository) {
        this.recyclingRepository = recyclingRepository;
    }

    public List<RecyclingItem> getAllItems() {
        return recyclingRepository.findAll();
    }

    public void addItem(String type, double weight) {
        RecyclingItem item = new RecyclingItem(type, weight);
        recyclingRepository.save(item);
    }

    public boolean processItem(String type) {
        RecyclingItem item = recyclingRepository.findByType(type);
        if (item != null) {
            item.process();
            recyclingRepository.update(item);
            return true;
        }
        return false;
    }

    public boolean deleteItem(String type) {
        RecyclingItem item = recyclingRepository.findByType(type);
        if (item != null) {
            recyclingRepository.delete(item);
            return true;
        }
        return false;
    }

    public boolean updateItem(String type, double newWeight) {
        RecyclingItem item = recyclingRepository.findByType(type);
        if (item != null) {
            item.setWeight(newWeight);
            recyclingRepository.update(item);
            return true;
        }
        return false;
    }
}
