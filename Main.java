package org.yourcompany.yourproject;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Komp> computers = new ArrayList<>();

        computers.add(new Komp());

        computers.add(new Komp("Sanea", 4, "Intel", 2.5f, 2022, 500));

        Komp randomComputer = new Komp();
        randomComputer.randomFill();
        computers.add(randomComputer);

        System.out.println("Enter your computer:");
        Komp userComputer = new Komp();
        userComputer.inputKomp(scanner);
        computers.add(userComputer);

        System.out.println("\nAll computers:");

        for (Komp computer : computers) {
            System.out.println();
            computer.printKomp();
        }
        Komp mostExpensive = computers.get(0);
        for (int i = 1; i < computers.size(); i++)
            if (computers.get(i).totalPrice() > mostExpensive.totalPrice())
                mostExpensive = computers.get(i);
        System.out.println("\nMost expensive computer belongs to: " + mostExpensive.getOwnerName());
        Komp.compareWeight(computers.get(0), computers.get(1));
        System.out.println("Number of created computers: " + Komp.getAmountKomp());
        scanner.close();
    }
}
