package org.knit.solutions.lab3.n12;

import java.util.Stack;

public class Caretaker {
    private final Stack<TextEditorMemento> history = new Stack<>();

    // Сохранение состояния редактора
    public void save(TextEditor editor) {
        history.push(editor.saveStateToMemento());
    }

    // Откат к предыдущему состоянию
    public void undo(TextEditor editor) {
        if (!history.isEmpty()) {
            System.out.println("Отмена действия...");
            editor.restoreStateFromMemento(history.pop());
        } else {
            System.out.println("Нечего отменять.");
        }
    }
}
