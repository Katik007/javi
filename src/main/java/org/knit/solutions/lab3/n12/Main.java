package org.knit.solutions.lab3.n12;

public class Main {
    public static void main(String[] args) {
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

        // Попытка отменить еще раз, когда история пуста
        caretaker.undo(editor);
    }
}