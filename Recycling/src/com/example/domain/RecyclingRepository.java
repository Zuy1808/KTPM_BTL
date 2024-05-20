// RecyclingRepository.java
package com.example.domain;

import java.util.List;

public interface RecyclingRepository {
    List<RecyclingItem> findAll();
    RecyclingItem findByType(String type);
    void save(RecyclingItem item);
    void update(RecyclingItem item);
    void delete(RecyclingItem item);
}
