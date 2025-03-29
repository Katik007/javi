package org.knit.solutions.lab3.n11;

public class EmailNotifier implements StockObserver {
    private String email;

    public EmailNotifier(String email) {
        this.email = email;
    }

    @Override
    public void update(Stock stock) {
        System.out.println("Email '" + email + "':  Акция " + stock.getCompanyName() +
                " - Цена изменилась на $" + stock.getPrice() + ".");
    }
}
