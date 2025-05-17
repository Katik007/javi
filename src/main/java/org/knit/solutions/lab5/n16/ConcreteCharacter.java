package org.knit.solutions.lab5.n16;

class ConcreteCharacter implements CharacterFlyweight {
    private final char characterCode;

    public ConcreteCharacter(char characterCode) {
        this.characterCode = characterCode;
        System.out.println("Создан новый объект символа: " + characterCode);
    }

    @Override
    public void render(int x, int y, String style) {
        System.out.println("Символ '" + characterCode + "' отображен в (" + x + ", " + y + ") стилем: " + style);
    }

    public char getCharacterCode() {
        return characterCode;
    }
}
