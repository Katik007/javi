package org.knit.solutions.lab3.n13;

public class ConditionerOffCommand implements Command {
    private final Conditioner conditioner;

    public ConditionerOffCommand(Conditioner conditioner) {
        this.conditioner = conditioner;
    }

    @Override
    public void execute() {
        conditioner.off();
    }

    @Override
    public void undo() {
        conditioner.on();
    }
}
