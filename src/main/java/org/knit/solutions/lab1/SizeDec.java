package org.knit.solutions.lab1;

class SizeDec extends CoffeeDecorator {
    private String size;

    public SizeDec(Coffee coffee, String size) {
        super(coffee);
        this.size = size;
    }

    @Override
    public double getCost() {
        double cost = coffee.getCost();
        switch (size.toLowerCase()) {
            case "small":
                cost += 0.0;
                break;
            case "medium":
                cost += 1.5;
                break;
            case "large":
                cost += 3.0;
                break;
        }
        return cost;
    }

    @Override
    public String getDescription() {
        return size.toUpperCase() + " " + coffee.getDescription();
    }

    @Override
    public int getCalories() {
        int calories = coffee.getCalories();
        switch (size.toLowerCase()) {
            case "small":
                calories += 10;
                break;
            case "medium":
                calories += 20;
                break;
            case "large":
                calories += 30;
                break;
        }
        return calories;
    }
}
