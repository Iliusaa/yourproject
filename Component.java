package org.yourcompany.yourproject;

import java.util.Random;

public class Component {
    private String model;
    private float weight;
    private int year;
    private double price;

    public Component() {
        String[] models = {"AMD", "Intel", "NVIDIA", "ASUS", "MSI"};
        Random random = new Random();
        model = models[random.nextInt(models.length)];
        weight = 0.1f + random.nextFloat() * 9.9f;
        year = 1995 + random.nextInt(32);
        price = 1 + random.nextInt(1000);
    }

    public Component(String model, float weight, int year, double price) {
        if (weight < 0.1f || weight > 10) throw new IllegalArgumentException("Weight must be from 0.1 to 10 kg.");
        if (year < 1995 || year > 2026) throw new IllegalArgumentException("Year must be from 1995 to 2026.");
        if (price < 1 || price > 1000) throw new IllegalArgumentException("Price must be from 1 to 1000.");
        this.model = model; this.weight = weight; this.year = year; this.price = price;
    }

    public Component(Component source) { this(source.model, source.weight, source.year, source.price); }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public float getWeight() { return weight; }
    public void setWeight(float weight) { this.weight = weight; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public void printComponent() { System.out.printf("  %s: %.2f kg, %d, %.2f%n", model, weight, year, price); }
}
