// InMemoryRecyclingRepository.java
package com.example.infrastructure;

import com.example.domain.RecyclingItem;
import com.example.domain.RecyclingRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InMemoryRecyclingRepository implements RecyclingRepository {
    private List<RecyclingItem> items = new ArrayList<>();

    @Override
    public List<RecyclingItem> findAll() {
        return new ArrayList<>(items);
    }

    @Override
    public RecyclingItem findByType(String type) {
        for (RecyclingItem item : items) {
            if (item.getType().equalsIgnoreCase(type)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public void save(RecyclingItem item) {
        items.add(item);
    }

    @Override
    public void update(RecyclingItem item) {
        // In a real implementation, we would update the item in the database or other persistent storage.
        // Since this is an in-memory implementation, there's no need to update the item as it's already updated in memory.
    }

    @Override
    public void delete(RecyclingItem item) {
        Iterator<RecyclingItem> iterator = items.iterator();
        while (iterator.hasNext()) {
            RecyclingItem currentItem = iterator.next();
            if (currentItem == item) {
                iterator.remove();
                break;
            }
        }
    }
}
