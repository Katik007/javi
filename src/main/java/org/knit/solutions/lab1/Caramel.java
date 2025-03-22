package org.knit.solutions.lab1;

class Caramel extends CoffeeDecorator {
    public Caramel(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 1.75;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", карамель";
    }

    @Override
    public int getCalories() {
        return coffee.getCalories() + 30;
    }
}
