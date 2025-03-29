package org.knit.solutions.lab3.n13;

public class ConditionerOnCommand implements Command {
    private final Conditioner conditioner;

    public ConditionerOnCommand(Conditioner conditioner) {
        this.conditioner = conditioner;
    }

    @Override
    public void execute() {
        conditioner.on();
    }

    @Override
    public void undo() {
        conditioner.off();
    }
}
