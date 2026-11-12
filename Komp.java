package org.yourcompany.yourproject;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Komp {
    private String ownerName;
    private final ArrayList<Component> components = new ArrayList<>();
    private static int amountKomp;

    public Komp() {
        ownerName = "Ilia";
        for (int i = 0; i < 3; i++)
            components.add(new Component("AMD", 2.0f, 2020, 100));
        amountKomp++;
    }

    public Komp(String ownerName, int count, String model, float weight, int year, double price) {
        this.ownerName = ownerName;
        for (int i = 0; i < count; i++)
            components.add(new Component(model, weight, year, price));
        amountKomp++;
    }

    public Komp(Komp source) {
        ownerName = source.ownerName;
        for (Component component : source.components)
            components.add(new Component(component));
        amountKomp++;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public static int getAmountKomp() {
        return amountKomp;
    }

    public void randomFill() {
        Random random = new Random();
        String[] models = { "AMD", "Intel", "NVIDIA", "ASUS", "MSI", "Gigabyte" };
        ownerName = "User" + random.nextInt(100);
        components.clear();
        for (int i = 0; i < 2 + random.nextInt(4); i++) {
            components.add(new Component(models[random.nextInt(models.length)],
                    1 + random.nextFloat() * 9, 2018 + random.nextInt(9), 50 + random.nextInt(951)));
        }
    }

    // Type 1: the error is processed directly here.
    private void inputOwnerName(Scanner scanner) {
        boolean flag;
        do {
            flag = false;
            try {
                System.out.print("Owner name: ");
                String value = scanner.nextLine().trim();
                if (value.isEmpty())
                    throw new KompException("Owner name cannot be empty.");
                ownerName = value;
            } catch (KompException exception) {
                flag = true;
                exception.handle();
            }
        } while (flag);
    }

    // Type 2: lazy method - the exception is declared and passed to the caller.
    private int inputComponentCount(Scanner scanner) throws KompException {
        System.out.print("Number of components (1-5): ");
        try {
            int count = Integer.parseInt(scanner.nextLine());
            if (count < 1 || count > 5)
                throw new KompException("The number must be from 1 to 5.");
            return count;
        } catch (NumberFormatException exception) {
            throw new KompException(exception);
        }
    }

    // Type 3: standard input errors are converted into KompException.
    private void inputComponents(Scanner scanner, int count) {
        components.clear();
        for (int i = 0; i < count; i++) {
            boolean flag;
            do {
                flag = false;
                try {
                    System.out.println("\nComponent " + (i + 1));
                    System.out.print("Model: ");
                    String model = scanner.nextLine().trim();
                    if (model.isEmpty())
                        throw new KompException("Model cannot be empty.");
                    System.out.print("Weight in kg (0.1-10): ");
                    float weight = Float.parseFloat(scanner.nextLine());
                    System.out.print("Production year (1995-2026): ");
                    int year = Integer.parseInt(scanner.nextLine());
                    System.out.print("Price (1-1000): ");
                    double price = Double.parseDouble(scanner.nextLine());
                    components.add(new Component(model, weight, year, price));
                } catch (NumberFormatException exception) {
                    flag = true;
                    new KompException(exception).handle();
                } catch (IllegalArgumentException exception) {
                    flag = true;
                    new KompException(exception).handle();
                } catch (KompException exception) {
                    flag = true;
                    exception.handle();
                }
            } while (flag);
        }
    }

    public void inputKomp(Scanner scanner) {
        inputOwnerName(scanner);
        boolean flag;
        int count = 0;
        do {
            flag = false;
            try {
                count = inputComponentCount(scanner);
            } catch (KompException exception) {
                flag = true;
                exception.handle();
            }
        } while (flag);
        inputComponents(scanner, count);
    }

    public double totalPrice() {
        double sum = 0;
        for (Component component : components)
            sum += component.getPrice();
        return sum;
    }

    public float totalWeight() {
        float sum = 0;
        for (Component component : components)
            sum += component.getWeight();
        return sum;
    }

    public double averageYear() {
        double sum = 0;
        for (Component component : components)
            sum += component.getYear();
        return components.isEmpty() ? 0 : sum / components.size();
    }

    public void printKomp() {
        System.out.println("Owner: " + ownerName + ", components: " + components.size());
        for (Component component : components)
            component.printComponent();
        System.out.printf("Total price: %.2f; total weight: %.2f kg; average year: %.1f%n",
                totalPrice(), totalWeight(), averageYear());
    }

    public static void compareWeight(Komp first, Komp second) {
        float difference = first.totalWeight() - second.totalWeight();
        if (difference > 0)
            System.out.println(first.ownerName + " is heavier by " + difference + " kg.");
        else if (difference < 0)
            System.out.println(second.ownerName + " is heavier by " + (-difference) + " kg.");
        else
            System.out.println("Both computers have the same weight.");
    }
}
