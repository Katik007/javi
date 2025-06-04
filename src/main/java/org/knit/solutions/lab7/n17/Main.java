package org.knit.solutions.lab7.n17;

import static org.knit.solutions.lab7.n17.MontyHallSimulation.Game;

public class Main {
    public static void main(String[] args) {
        int n = 1000000; // Количество экспериментов

        int winsWith = 0;
        int winsWithout = 0;

        // МЕНЯЕТ выбор
        for (int i = 0; i < n; i++) {
            if (Game(true)) {
                winsWith++;
            }
        }

        // НЕ МЕНЯЕТ выбор
        for (int i = 0; i < n; i++) {
            if (Game(false)) {
                winsWithout++;
            }
        }

        double resWith = (double) winsWith / n * 100;
        double resWithout = (double) winsWithout / n * 100;

        System.out.println("Результаты game (" + n + " игр):");
        System.out.printf("Вероятность выигрыша при переключении: %.2f%%\n", resWith);
        System.out.printf("Вероятность выигрыша без переключения: %.2f%%\n", resWithout);

        if (resWith > resWithout) {
            System.out.println("Лучше менять выбор!");
        } else if (resWithout > resWith) {
            System.out.println("Лучше оставаться при своем выборе!");
        } else {
            System.out.println("Стратегии равнозначны");
        }
    }
}
