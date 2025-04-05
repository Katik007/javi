package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab3.n13.*;

import java.util.ArrayList;
import java.util.List;

@TaskDescription(taskNumber = 11, taskDescription = "Задача про Паттерн Command (Команда) с дополнениями")
public class Task413 implements Solution{
    @Override
    public void execute() {
        Light livingRoomLight = new Light();
        TV livingRoomTV = new TV();
        Conditioner livingRoomConditioner = new Conditioner();

        LightOnCommand lightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand lightOff = new LightOffCommand(livingRoomLight);
        TVOnCommand tvOn = new TVOnCommand(livingRoomTV);
        TVOffCommand tvOff = new TVOffCommand(livingRoomTV);
        ConditionerOnCommand conditionerOn = new ConditionerOnCommand(livingRoomConditioner);
        ConditionerOffCommand conditionerOff = new ConditionerOffCommand(livingRoomConditioner);
        ConditionerSetTemperatureCommand setTemp = new ConditionerSetTemperatureCommand(livingRoomConditioner, 22);

        RemoteControl remote = new RemoteControl();

        System.out.println("**Управление светом");
        remote.setCommand(lightOn);
        remote.executeCommand(); // Включить свет
        System.out.println("Свет включен: " + livingRoomLight.isOn());

        remote.setCommand(lightOff);
        remote.executeCommand(); // Выключить свет
        System.out.println("Свет включен: " + livingRoomLight.isOn());

        System.out.println("**Управление телевизором");
        remote.setCommand(tvOn);
        remote.executeCommand(); // Включить телевизор
        System.out.println("Телевизор включен: " + livingRoomTV.isOn());

        remote.setCommand(tvOff);
        remote.executeCommand(); // Выключить телевизор
        System.out.println("Телевизор включен: " + livingRoomTV.isOn());

        System.out.println("**Отмена последней команды");
        remote.undoCommand(); // Отменить выключение телевизора
        System.out.println("Телевизор включен: " + livingRoomTV.isOn());

        remote.undoCommand(); // Отменить включение телевизора
        System.out.println("Свет включен: " + livingRoomLight.isOn()); // Should be on now because undo stack

        System.out.println("**Управление кондиционером");
        remote.setCommand(conditionerOn);
        remote.executeCommand(); // Включить кондиционер
        remote.setCommand(setTemp);
        remote.executeCommand(); // Установить температуру
        System.out.println("Кондиционер включен: " + livingRoomConditioner.isOn());

        remote.undoCommand(); // Отменить установку температуры
        System.out.println("Кондиционер включен: " + livingRoomConditioner.isOn());

        System.out.println("**Макрокоманда 'Спокойной ночи'");
        List<Command> nightCommands = new ArrayList<>();
        nightCommands.add(new LightOffCommand(livingRoomLight));
        nightCommands.add(new TVOffCommand(livingRoomTV));
        nightCommands.add(new ConditionerOffCommand(livingRoomConditioner));

        MacroCommand nightMacro = new MacroCommand(nightCommands);
        remote.setCommand(nightMacro);
        remote.executeCommand(); // Выполнить макрокоманду "Спокойной ночи"

        System.out.println("**Отмена макрокоманды 'Спокойной ночи'");
        remote.undoCommand(); // Отменить макрокоманду
        System.out.println("Свет включен: " + livingRoomLight.isOn());
        System.out.println("Телевизор включен: " + livingRoomTV.isOn());
        System.out.println("Кондиционер включен: " + livingRoomConditioner.isOn());
    }
}