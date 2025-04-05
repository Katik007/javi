package org.knit.solutions.lab3.n13;

import java.util.Stack;

public class RemoteControl {
    private Command command;
    private final Stack<Command> history = new Stack<>();
    private Command lastCommand;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        if (command != null) {
            command.execute();
            history.push(command);
            lastCommand = command;
        } else {
            System.out.println("Нет команды для выполнения.");
        }
    }

    public void undoCommand() {
        if (!history.isEmpty()) {
            Command lastExecutedCommand = history.pop();
            System.out.println("Отмена последней команды...");
            lastExecutedCommand.undo();
            lastCommand = history.isEmpty() ? null : history.peek(); // Update lastCommand after undo
        } else {
            System.out.println("Нет команд для отмены.");
        }
    }

    public Command getLastCommand() {
        return lastCommand;
    }
}
