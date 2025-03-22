package org.knit.solutions.lab2.n4;

import java.util.concurrent.Semaphore;

public class GasStation {
    private final Semaphore semaphore;

    public GasStation(int count) {
        this.semaphore = new Semaphore(count);
    }

    public void Refuel(String carName) {
        try {
            System.out.println(carName + " ждет, все колонки заняты");
            semaphore.acquire();
            System.out.println(carName + " заправляется");
            Thread.sleep(2000);
            System.out.println(carName + " заправилась и уехала");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }
}
