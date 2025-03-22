package org.knit.solutions.lab2.n6;

public class Railway {
    private volatile boolean isClosed = false;

    public synchronized void trainIsPassing() {
        System.out.println("Поезд приближается, шлагбаум закрывается. Машины ждут");
        isClosed = true;
    }

    public synchronized void trainPassed() {
        System.out.println("Поезд уехал, шлагбаум открывается. Машины едут");
        isClosed = false;
        notifyAll();
    }

    public synchronized void passCar(String carName) {
        while (isClosed) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(carName + " проехала переезд");
    }
}
