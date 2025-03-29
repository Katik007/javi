package org.knit.solutions.lab3.n13;

public class ConditionerSetTemperatureCommand implements Command {
    private final Conditioner conditioner;
    private final int temperature;
    private int previousTemperature;

    public ConditionerSetTemperatureCommand(Conditioner conditioner, int temperature) {
        this.conditioner = conditioner;
        this.temperature = temperature;
    }

    @Override
    public void execute() {
        this.previousTemperature = 25;
        conditioner.setTemperature(temperature);
    }

    @Override
    public void undo() {
        conditioner.setTemperature(previousTemperature);
    }
}
