package org.knit.solutions.lab3.n13;

public class Light {
    private boolean isOn = false;

    public void on() {
        isOn = true;
        System.out.println("Свет включен");
    }

    public void off() {
        isOn = false;
        System.out.println("Свет выключен");
    }

    public boolean isOn() {
        return isOn;
    }
}
