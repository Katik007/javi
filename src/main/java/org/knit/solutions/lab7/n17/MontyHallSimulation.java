package org.knit.solutions.lab7.n17;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class MontyHallSimulation {

    private static final int NUM_DOORS = 3;
    private static Random random = new Random();

    public static boolean Game(boolean choice) {
        // Размещаем приз за одной из дверей
        int prizeDoor = random.nextInt(NUM_DOORS); // 0, 1, или 2

        // Игрок делает первоначальный выбор
        int playerInitialChoice = random.nextInt(NUM_DOORS);

        // Ведущий открывает одну из оставшихся дверей, за которой нет приза
        int hostOpenedDoor;
        List<Integer> doorsToOpen = new ArrayList<>();
        for (int i = 0; i < NUM_DOORS; i++) {
            // Ведущий не может открыть дверь, выбранную игроком, и не может открыть дверь с призом
            if (i != playerInitialChoice && i != prizeDoor) {
                doorsToOpen.add(i);
            }
        }

        hostOpenedDoor = doorsToOpen.get(random.nextInt(doorsToOpen.size()));

        // Игрок решает, сменить ли выбор
        int playerFinalChoice;
        if (choice) {
            // Игрок меняет выбор на оставшуюся закрытую дверь
            // Это дверь, которая не является первоначальным выбором игрока и не открыта ведущим
            for (int i = 0; i < NUM_DOORS; i++) {
                if (i != playerInitialChoice && i != hostOpenedDoor) {
                    playerFinalChoice = i;
                    return playerFinalChoice == prizeDoor; // Проверяем выигрыш
                }
            }

            return false; 
        } else {
            // Игрок остается при своем первоначальном выборе
            playerFinalChoice = playerInitialChoice;
            return playerFinalChoice == prizeDoor; // Проверяем выигрыш
        }
    }


}