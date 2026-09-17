package org.yourcompany.yourproject;

public class Komp{
    String name;
    byte components;
    String []partmodel;
    float []weight;
    float []year;
    double []price;
    
    public Komp(){
        
    }

    public Komp(byte components, String name, String[] partmodel, double[] price, float[] weight, float[] year) {
        this.components = components;
        this.name = name;
        this.partmodel = partmodel;
        this.price = price;
        this.weight = weight;
        this.year = year;
    }
}