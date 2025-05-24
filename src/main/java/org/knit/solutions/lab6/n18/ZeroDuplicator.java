package org.knit.solutions.lab6.n18;

public class ZeroDuplicator {

    public void duplicateZeros(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int possibleDups = 0;
        int effectiveLength = arr.length;

        // 1. Подсчет возможных дубликатов и обработка граничного нуля
        for (int left = 0; left < effectiveLength - possibleDups; left++) {
            if (arr[left] == 0) {
                if (left == effectiveLength - possibleDups - 1) { // Ноль помещается, его дубликат - нет
                    arr[effectiveLength - 1] = 0;
                    effectiveLength -= 1;
                    break;
                }
                possibleDups++;
            }
        }

        // 2. Копирование справа налево с учетом дубликатов
        int lastOriginalIdx = effectiveLength - 1 - possibleDups;

        for (int i = lastOriginalIdx; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + possibleDups] = 0;
                possibleDups--;
                arr[i + possibleDups] = 0;
            } else {
                arr[i + possibleDups] = arr[i];
            }
        }
    }
}