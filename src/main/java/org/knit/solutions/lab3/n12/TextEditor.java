package org.knit.solutions.lab3.n12;

public class TextEditor {
    private String text;

    public TextEditor() {
        this.text = "";
    }

    public void type(String text) {
        this.text += text;
    }

    public String getText() {
        return text;
    }

    // Сохранение состояния в Memento
    public TextEditorMemento saveStateToMemento() {
        System.out.println("Сохранение состояния: " + text);
        return new TextEditorMemento(text);
    }

    // Восстановление состояния из Memento
    public void restoreStateFromMemento(TextEditorMemento memento) {
        this.text = memento.getText();
        System.out.println("Восстановление состояния: " + text);
    }
}
