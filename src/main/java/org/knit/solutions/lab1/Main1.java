package org.knit.solutions.lab1;

public class Main1 {
    public static void main(String[] args) {
        System.out.println("=== Эспрессо ===");
        Coffee coffee = new Espresso();
        printOrder(coffee);
        coffee = new SizeDec(coffee, "medium");
        printOrder(coffee);
        coffee = new Milk(coffee);
        printOrder(coffee);
        coffee = new Caramel(coffee);
        printOrder(coffee);
        coffee = new Chocolate(coffee);
        printOrder(coffee);
        System.out.println("=== Капучино ===");
        Coffee cappuccino = new Cappuccino();
        cappuccino = new SizeDec(cappuccino, "large");
        cappuccino = new Caramel(cappuccino);
        cappuccino = new Chocolate(cappuccino);
        printOrder(cappuccino);
        System.out.println("=== Американо ===");
        Coffee americano = new Americano();
        americano = new SizeDec(americano, "small");
        americano = new Milk(americano);
        printOrder(americano);
    }

    private static void printOrder(Coffee coffee) {
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() + " | Калорийность: " + coffee.getCalories() + " ккал");
    }
}
