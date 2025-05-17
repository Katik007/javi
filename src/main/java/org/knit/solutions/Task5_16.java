package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab5.n16.CharacterFactory;
import org.knit.solutions.lab5.n16.CharacterFlyweight;


@TaskDescription(taskNumber = 16, taskDescription = "Задача 16 на паттерн Приспособленец (Flyweight)")
public class Task5_16 implements Solution{
    @Override
    public void execute() {
        CharacterFactory factory = new CharacterFactory();

        String textToRender = "Андрей мишин лучший.";
        int currentX = 0;
        int currentY = 10;
        String currentStyle = "Arial, 12pt, Black";
        System.out.println("Отображение первого текста");
        for (char c : textToRender.toCharArray()) {
            CharacterFlyweight character = factory.getCharacter(c);
            character.render(currentX, currentY, currentStyle);
            currentX += 10;
            if (currentX > 200) {
                currentX = 0;
                currentY += 20;
            }
        }
        System.out.println("Общее количество уникальных объектов символов: " + factory.getTotalCharactersCreated());

        String anotherText = "лучший";
        currentX = 50;
        currentY = 100;
        String anotherStyle = "Times New Roman, 10pt, Red";

        System.out.println("Отображение второго текста");
        for (char c : anotherText.toCharArray()) {
            CharacterFlyweight character = factory.getCharacter(c);
            character.render(currentX, currentY, anotherStyle);
            currentX += 8;
        }

        System.out.println("Общее количество уникальных объектов символов: " + factory.getTotalCharactersCreated());


        System.out.println("Отображение третьего текста");
        CharacterFlyweight newChar = factory.getCharacter('Z');
        newChar.render(0, 150, "Courier, 14pt, Blue");
        System.out.println("Общее количество уникальных объектов символов: " + factory.getTotalCharactersCreated());

    }

}