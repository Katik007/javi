package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab3.n12.Caretaker;
import org.knit.solutions.lab3.n12.TextEditor;

@TaskDescription(taskNumber = 10, taskDescription = "Задача про Паттерн Memento (Хранитель) с дополнениями")
public class Task412 implements Solution{
    @Override
    public void execute() {
        TextEditor editor = new TextEditor();
        Caretaker caretaker = new Caretaker();

        // Вводим текст и сохраняем состояние
        editor.type("Hello, world!");
        caretaker.save(editor);
        System.out.println("Текущий текст: " + editor.getText());

        // Добавляем еще текст и сохраняем состояние
        editor.type(" How are you?");
        caretaker.save(editor);
        System.out.println("Текущий текст: " + editor.getText());

        // Отменяем последнее действие
        caretaker.undo(editor);
        System.out.println("Текущий текст после отмены: " + editor.getText());

        // Отменяем еще раз
        caretaker.undo(editor);
        System.out.println("Текущий текст после второй отмены: " + editor.getText());

        caretaker.undo(editor); // Сообщение "Нечего отменять."
    }
}