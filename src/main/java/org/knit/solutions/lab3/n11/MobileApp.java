package org.knit.solutions.lab3.n11;

public class MobileApp implements StockObserver {
    private String observerName;

    public MobileApp(String observerName) {
        this.observerName = observerName;
    }

    @Override
    public void update(Stock stock) {
        System.out.println("Mobile App '" + observerName + "': Акция " + stock.getCompanyName() +
                " - Цена изменилась на $" + stock.getPrice());
    }
}
