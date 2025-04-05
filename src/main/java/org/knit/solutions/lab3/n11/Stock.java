package org.knit.solutions.lab3.n11;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private String companyName;
    private double price;
    private List<StockObserver> observers = new ArrayList<>();

    public Stock(String companyName, double initialPrice) {
        this.companyName = companyName;
        this.price = initialPrice;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
        notifyObservers();
    }

    public void addObserver(StockObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(StockObserver observer) {
        this.observers.remove(observer);
    }

    // Уведомление наблюдателей
    private void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.update(this);
        }
    }
}
