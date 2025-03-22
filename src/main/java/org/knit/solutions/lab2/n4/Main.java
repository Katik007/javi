package org.knit.solutions.lab2.n4;

public class Main {
    public static void main(String[] args) {
        GasStation gasStation = new GasStation(2);
        for (int i = 0; i < 12; i++) {
            int finalI = i;
            new Thread(() -> {
                gasStation.Refuel(String.valueOf(finalI) + " машина");
            }).start();

        }
    }
}
