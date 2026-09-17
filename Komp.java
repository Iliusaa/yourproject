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