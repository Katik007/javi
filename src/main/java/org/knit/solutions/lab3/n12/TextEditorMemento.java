package org.knit.solutions.lab3.n12;

// Memento - Хранитель
class TextEditorMemento {
    private final String text;

    public TextEditorMemento(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
