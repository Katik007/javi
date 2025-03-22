package org.knit.solutions.lab2.n8;


public class Main {
    public static void main(String[] args) {        TrafficLight trafficLight = new TrafficLight();

        Thread threadTrafficLight = new Thread(() -> {
            while (true) {
                trafficLight.changeColor();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread threadCar = new Thread(() -> {
            for (int i = 1; i <= 20; i++) {
                Car car = new Car(String.valueOf(i));
                car.pass(trafficLight);
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        threadTrafficLight.start();
        threadCar.start();
    }
}
