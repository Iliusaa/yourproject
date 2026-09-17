package org.yourcompany.yourproject;

public class Komp{
    String namePerson;
    byte components;
    String partModel[];
    float weight[];
    float year[];
    double price[];
    
    Komp(){
        namePerson = "Ilia";
        components = 10;
        partModel = new String[1];
        for (int i = 0; i < partModel.length; i++) {
            partModel[i]="amd";
        }
        weight = new float[1];
        for (int i = 0; i < weight.length; i++) {
            weight[i]=6f;
        }
        year = new float[1];
        for (int i = 0; i < year.length; i++) {
            year[i]=3f;
        }
        price = new double[1];
        for (int i = 0; i < price.length; i++) {
            price[i]=3;
        }
    }

    Komp(byte components, String namePerson) {
        this.components = components;
        this.namePerson = namePerson;
    }

    public void println(String print){
        System.out.println(print);
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}