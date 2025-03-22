package org.knit.solutions.lab1;

class Milk extends CoffeeDecorator {
    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 1.85;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", молоко";
    }

    @Override
    public int getCalories() {
        return coffee.getCalories() + 20;
    }
}

