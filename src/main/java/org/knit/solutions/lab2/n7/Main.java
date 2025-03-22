package org.knit.solutions.lab2.n7;


public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        Thread threadManufacturer = new Thread(() -> {
            for (int i = 1; i <= 15; i++) {
                warehouse.addProduct(String.valueOf(i));
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread threadBuyer = new Thread(() -> {
            for (int i = 1; i <= 15; i++) {
                warehouse.buyProduct();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        threadManufacturer.start();
        threadBuyer.start();
    }
}
