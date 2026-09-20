package org.yourcompany.yourproject;

public class Komp{
    String namePerson;
    byte components;
    String partModel[];
    float weight[];
    float year[];
    double price[];
    static int ammountKomp;
    
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
        ammountKomp++;
    }

    Komp(String namePerson, byte components) {
        this.namePerson = namePerson;
        this.components = components;
        partModel=new String[1];
        ammountKomp++;
    }
     Komp(Komp Clone) {
        namePerson=Clone.namePerson;
        components = Clone.components;
        partModel=new String[Clone.partModel.length];
        for (int i = 0; i < Clone.partModel.length; i++) {
        partModel[i] = Clone.partModel[i];
        }
        weight = new float[Clone.weight.length];
        for (int i = 0; i < Clone.weight.length; i++) {
        weight[i] = Clone.weight[i];
        }
        year = new float[Clone.year.length];
        for (int i = 0; i < Clone.year.length; i++) {
        year[i] = Clone.year[i];
        }
        price = new double[Clone.price.length];
        for (int i = 0; i < Clone.price.length; i++) {
        price[i] = Clone.price[i];
        }
        ammountKomp++;
    }
    

    public void println(String print){
        System.out.println(print);
    }

      public void printKomp(){
        println("Person's name is " + namePerson);
        println("There are these many components in Komp " + components);
        System.out.print("parts used are:");
        for(int i=0;i<partModel.length;i++){
            System.out.print(" "+partModel[i]);
        }
        println("");
       System.out.print("weights of components are:");
        for(int i=0;i<weight.length;i++){
           System.out.print(" "+weight[i]);
        }
        println("");
        System.out.print("years are: ");
        for(int i=0;i<year.length;i++){
           System.out.print(" "+year[i]);
        }
        println("");
        System.out.print("prices are: ");
        for(int i=0;i<price.length;i++){
            System.out.print(" "+price[i]);
        }
    }
    public static void main(String[] args) {
        Komp Pervii=new Komp();
        Pervii.printKomp();
    }
}