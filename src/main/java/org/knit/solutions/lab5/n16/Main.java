package org.knit.solutions.lab5.n16;

public class Main {
    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();

        String textToRender = "ABRACADABRA! Это тест приспособленца.";
        int currentX = 0;
        int currentY = 10;
        String currentStyle = "Arial, 12pt, Black";

        System.out.println("Отображение текста первый раз");
        for (char c : textToRender.toCharArray()) {
            CharacterFlyweight character = factory.getCharacter(c);
            character.render(currentX, currentY, currentStyle);
            currentX += 10; // Смещаем X для следующего символа
            if (currentX > 200) { // Простой перенос строки
                currentX = 0;
                currentY += 20;
            }
        }
        System.out.println("Общее количество УНИКАЛЬНЫХ объектов символов создано: " + factory.getTotalCharactersCreated());

        String anotherText = "ABRA";
        currentX = 50;
        currentY = 100;
        String anotherStyle = "Times New Roman, 10pt, Red";

        System.out.println("Отображение другого текста/стиля");
        for (char c : anotherText.toCharArray()) {
            CharacterFlyweight character = factory.getCharacter(c);
            character.render(currentX, currentY, anotherStyle);
            currentX += 8;
        }

        System.out.println("Общее количество УНИКАЛЬНЫХ объектов символов создано (после второго отображения): " + factory.getTotalCharactersCreated());


        System.out.println("Отображение с новым символом");
        CharacterFlyweight newChar = factory.getCharacter('Z');
        newChar.render(0, 150, "Courier, 14pt, Blue");
        System.out.println("Общее количество УНИКАЛЬНЫХ объектов символов создано (после добавления Z): " + factory.getTotalCharactersCreated());
    }
}