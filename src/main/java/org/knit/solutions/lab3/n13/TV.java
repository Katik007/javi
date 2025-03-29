package org.knit.solutions.lab3.n13;

public class TV {
    private boolean isOn = false;

    public void on() {
        isOn = true;
        System.out.println("Телевизор включен");
    }

    public void off() {
        isOn = false;
        System.out.println("Телевизор выключен");
    }

    public boolean isOn() {
        return isOn;
    }
}
