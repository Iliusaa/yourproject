package org.yourcompany.yourproject;

import java.util.Scanner;
import java.util.Random;

public class Komp {

    String namePerson;
    byte components;
    String partModel[];
    float weight[];
    float year[];
    double price[];

    static int ammountKomp = 0;

    Komp() {

        namePerson = "Ilia";
        components = 3;

        partModel = new String[components];
        weight = new float[components];
        year = new float[components];
        price = new double[components];

        for (int i = 0; i < components; i++) {
            partModel[i] = "AMD";
            weight[i] = 2.0f;
            year[i] = 2020;
            price[i] = 100;
        }

        ammountKomp++;
    }


    Komp(String namePerson, byte components) {

        this.namePerson = namePerson;
        this.components = components;

        partModel = new String[components];
        weight = new float[components];
        year = new float[components];
        price = new double[components];

        for (int i = 0; i < components; i++) {
            partModel[i] = "Unknown";
            weight[i] = 0;
            year[i] = 0;
            price[i] = 0;
        }

        ammountKomp++;
    }


    Komp(String namePerson, byte components, String model, float weight, float year, double price) {

        this.namePerson = namePerson;
        this.components = components;

        partModel = new String[components];
        this.weight = new float[components];
        this.year = new float[components];
        this.price = new double[components];

        for (int i = 0; i < components; i++) {
            partModel[i] = model;
            this.weight[i] = weight;
            this.year[i] = year;
            this.price[i] = price;
        }

        ammountKomp++;
    }


    Komp(Komp Clone) {

        namePerson = Clone.namePerson;
        components = Clone.components;

        partModel = new String[Clone.partModel.length];

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



    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getNamePerson() {
        return namePerson;
    }


    public void setComponents(byte components) {

        this.components = components;

        partModel = new String[components];
        weight = new float[components];
        year = new float[components];
        price = new double[components];
    }

    public byte getComponents() {
        return components;
    }

    public void setPartModel(int index, String model) {
        partModel[index] = model;
    }

    public String getPartModel(int index) {
        return partModel[index];
    }


    public void setWeight(int index, float weight) {
        this.weight[index] = weight;
    }

    public float getWeight(int index) {
        return weight[index];
    }


    public void setYear(int index, float year) {
        this.year[index] = year;
    }

    public float getYear(int index) {
        return year[index];
    }


    public void setPrice(int index, double price) {
        this.price[index] = price;
    }

    public double getPrice(int index) {
        return price[index];
    }


    public void println(String print) {
        System.out.println(print);
    }


    public void printKomp() {
        println("Person's name is " + namePerson);
        println("There are these many components in Komp: " + components);

        System.out.print("Parts used are: ");
        for (int i = 0; i < partModel.length; i++) {
            System.out.print(partModel[i] + " ");
        }
        println("");
        System.out.print("Weights of components are: ");

        for (int i = 0; i < weight.length; i++) {
            System.out.print(weight[i] + " ");
        }
        println("");
        System.out.print("Years are: ");
        for (int i = 0; i < year.length; i++) {
            System.out.print(year[i] + " ");
        }
        println("");
        System.out.print("Prices are: ");
        for (int i = 0; i < price.length; i++) {
            System.out.print(price[i] + " ");
        }

        println("");
        println("Total price: " + totalPrice());
        println("Total weight: " + totalWeight());
        println("Average year: " + averageYear());
    }

    public void inputKomp() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter owner's name: ");
        namePerson = scanner.nextLine();

        System.out.print("Enter number of components: ");
        components = scanner.nextByte();

        scanner.nextLine();

        partModel = new String[components];
        weight = new float[components];
        year = new float[components];
        price = new double[components];

        for (int i = 0; i < components; i++) {

            System.out.println();
            System.out.println("Component " + (i + 1));

            System.out.print("Enter model/manufacturer: ");
            partModel[i] = scanner.nextLine();

            System.out.print("Enter weight: ");
            weight[i] = scanner.nextFloat();

            System.out.print("Enter year: ");
            year[i] = scanner.nextFloat();

            System.out.print("Enter price: ");
            price[i] = scanner.nextDouble();

            scanner.nextLine();
        }
    }

    public void randomFill() {

        Random random = new Random();
        String models[] = {
                "AMD",
                "Intel",
                "NVIDIA",
                "ASUS",
                "MSI",
                "Gigabyte"
        };

        namePerson = "User" + random.nextInt(100);

        components = (byte)(2 + random.nextInt(5));

        partModel = new String[components];
        weight = new float[components];
        year = new float[components];
        price = new double[components];

        for (int i = 0; i < components; i++) {

            partModel[i] = models[random.nextInt(models.length)];

            weight[i] = 1 + random.nextInt(10);

            year[i] = 2018 + random.nextInt(9);

            price[i] = 50 + random.nextInt(951);
        }
    }

    public double totalPrice() {

        double sum = 0;

        for (int i = 0; i < price.length; i++) {
            sum = sum + price[i];
        }

        return sum;
    }

    public float totalWeight() {

        float sum = 0;

        for (int i = 0; i < weight.length; i++) {
            sum = sum + weight[i];
        }

        return sum;
    }

    public float averageYear() {

        float sum = 0;

        for (int i = 0; i < year.length; i++) {
            sum = sum + year[i];
        }

        return sum / year.length;
    }

    public void compareActuality(Komp other) {
        System.out.println("First Komp owner: " + namePerson);
        System.out.println("Average year: " + averageYear());
        System.out.println();
        System.out.println("Second Komp owner: " + other.namePerson);
        System.out.println("Average year: " + other.averageYear());
        System.out.println();
        if (averageYear() < other.averageYear()) {

            System.out.println("The first Komp is older.");
            System.out.println("Upgrading first Komp...");

            System.out.println();
            System.out.println("BEFORE UPGRADE:");
            printKomp();

            for (int i = 0; i < components; i++) {
                setYear(i, other.year[i]);
                setPrice(i, other.price[i]);
                setPartModel(i, other.partModel[i]);
            }

            System.out.println();
            System.out.println("AFTER UPGRADE:");
            printKomp();

        } else if (averageYear() > other.averageYear()) {

            System.out.println("The second Komp is older.");
            System.out.println("Upgrading second Komp...");

            System.out.println();
            System.out.println("BEFORE UPGRADE:");
            other.printKomp();

            for (int i = 0; i < other.components; i++) {
                other.setYear(i, year[i]);
                other.setPrice(i, price[i]);
                other.setPartModel(i, partModel[i]);
            }

            System.out.println();
            System.out.println("AFTER UPGRADE:");
            other.printKomp();

        } else {

            System.out.println("Both Komps have the same average year.");
        }
    }

    public static void compareWeight(Komp first, Komp second) {
        System.out.println();
        float firstWeight = first.totalWeight();
        float secondWeight = second.totalWeight();

        System.out.println(first.namePerson + "'s komp weight: " + firstWeight);
        System.out.println(second.namePerson + "'s komp weight: " + secondWeight);

        if (firstWeight > secondWeight) {
            System.out.println(first.namePerson + " is heavier by "+ (firstWeight - secondWeight));
        } else if (firstWeight < secondWeight) {
            System.out.println( second.namePerson + " is heavier by "+ (secondWeight - firstWeight));
        } else {
            System.out.println("Both Komps have the same weight.");
        }
    }

    public static void main(String[] args) {
        Komp Pervii = new Komp();

        System.out.println("Komp 1:");
        Pervii.printKomp();

        Komp Vtoroi = new Komp("Sanea", (byte)4);

        Vtoroi.setPartModel(0, "Intel");
        Vtoroi.setPartModel(1, "NVIDIA");
        Vtoroi.setPartModel(2, "ASUS");
        Vtoroi.setPartModel(3, "MSI");

        Vtoroi.setWeight(0, 2);
        Vtoroi.setWeight(1, 3);
        Vtoroi.setWeight(2, 4);
        Vtoroi.setWeight(3, 2);

        Vtoroi.setYear(0, 2020);
        Vtoroi.setYear(1, 2021);
        Vtoroi.setYear(2, 2022);
        Vtoroi.setYear(3, 2023);

        Vtoroi.setPrice(0, 500);
        Vtoroi.setPrice(1, 700);
        Vtoroi.setPrice(2, 300);
        Vtoroi.setPrice(3, 200);

        System.out.println();
        System.out.println("Komp 2:");
        Vtoroi.printKomp();


        Komp Tretii = new Komp("Dima",(byte)3,"AMD",5,2019,400);
        System.out.println("Komp 3:");
        Tretii.printKomp();


        Komp Klon = new Komp(Vtoroi);
        Klon.setNamePerson("Copy Sanea");
        System.out.println();
        System.out.println("Komp 4 Klon:");
        Klon.printKomp();

        Komp Piatii = new Komp();
        Piatii.randomFill();
        System.out.println("Random Komp):");
        Piatii.printKomp();



        Komp[] set = new Komp[5];
        set[0] = Pervii;
        set[1] = Vtoroi;
        set[2] = Tretii;
        set[3] = Klon;
        set[4] = Piatii;

        for (int i = 0; i < set.length; i++) {

            System.out.println();
            System.out.println("kol-vo kompov v sisteme:" + (i + 1));

            set[i].printKomp();
        }

        Pervii.compareActuality(Vtoroi);

        Tretii.compareActuality(Piatii);


        compareWeight(Pervii, Vtoroi);

        compareWeight(Tretii, Piatii);

        Komp expensive = set[0];

        for (int i = 1; i < set.length; i++) {

            if (set[i].totalPrice() > expensive.totalPrice()) {
                expensive = set[i];
            }
        }

        System.out.println("Owner: " + expensive.getNamePerson());

        System.out.println("Total price: " + expensive.totalPrice());

        System.out.println();
        System.out.println("Number of created Komps: " + ammountKomp);
    }
}