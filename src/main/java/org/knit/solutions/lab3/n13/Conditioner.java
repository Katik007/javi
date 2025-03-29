package org.knit.solutions.lab3.n13;

public class Conditioner {
    private boolean isOn = false;
    private int temperature = 25;

    public void on() {
        isOn = true;
        System.out.println("Кондиционер включен");
    }

    public void off() {
        isOn = false;
        System.out.println("Кондиционер выключен");
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Температура кондиционера установлена на " + temperature + " градусов");
    }

    public boolean isOn() {
        return isOn;
    }
}
