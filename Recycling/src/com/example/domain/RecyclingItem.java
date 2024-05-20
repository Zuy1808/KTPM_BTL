// RecyclingItem.java
package com.example.domain;

public class RecyclingItem {
    private String type;
    private double weight;

    public RecyclingItem(String type, double weight) {
        this.type = type;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void process() {
        // Implementation of processing logic here
    }

    @Override
    public String toString() {
        return "Type: " + type + ", Weight: " + weight;
    }
}
