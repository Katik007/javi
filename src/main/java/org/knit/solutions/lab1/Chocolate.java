package org.knit.solutions.lab1;

class Chocolate extends CoffeeDecorator {
    public Chocolate(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 2.0;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", шоколад";
    }

    @Override
    public int getCalories() {
        return coffee.getCalories() + 45;
    }
}
