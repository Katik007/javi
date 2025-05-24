package org.knit.solutions.lab6.n18;

import org.junit.Test;
import org.junit.jupiter.api.Timeout;
import org.knit.solutions.lab6.n18.ZeroDuplicator;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class ZeroDuplicatorTest {

    private final ZeroDuplicator duplicator = new ZeroDuplicator();

    @Test
    public void testExample1() {
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        int[] expected = {1, 0, 0, 2, 3, 0, 0, 4};
        duplicator.duplicateZeros(arr);
        assertArrayEquals(expected, arr);
        System.out.println("Результат: " + Arrays.toString(arr));
        System.out.println("Правильный результат: " + Arrays.toString(expected));
    }

    @Test
    public void testExample2_NoZeros() {
        int[] arr = {1, 2, 3};
        int[] expected = {1, 2, 3};
        duplicator.duplicateZeros(arr);
        assertArrayEquals(expected, arr);
        System.out.println("Результат: " + Arrays.toString(arr));
        System.out.println("Правильный результат: " + Arrays.toString(expected));
    }

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        int[] expected = {};
        duplicator.duplicateZeros(arr);
        assertArrayEquals(expected, arr);
        System.out.println("Результат: " + Arrays.toString(arr));
        System.out.println("Правильный результат: " + Arrays.toString(expected));
    }

    @Test
    public void testNullArray() {
        assertDoesNotThrow(() -> duplicator.duplicateZeros(null));
    }


    @Test
    public void testSingleZero() {
        int[] arr = {0};
        int[] expected = {0};
        duplicator.duplicateZeros(arr);
        assertArrayEquals(expected, arr);
        System.out.println("Результат: " + Arrays.toString(arr));
        System.out.println("Правильный результат: " + Arrays.toString(expected));
    }

    @Test
    public void testSingleNonZero() {
        int[] arr = {1};
        int[] expected = {1};
        duplicator.duplicateZeros(arr);
        assertArrayEquals(expected, arr);
        System.out.println("Результат: " + Arrays.toString(arr));
        System.out.println("Правильный результат: " + Arrays.toString(expected));
    }

    @Test
    public void testAllZeros_FullDuplicatePossible() {
        int[] arr = {0, 0, 0};
        int[] expected = {0, 0, 0};
        duplicator.duplicateZeros(arr);
        assertArrayEquals(expected, arr);
        System.out.println("Результат: " + Arrays.toString(arr));
        System.out.println("Правильный результат: " + Arrays.toString(expected));
    }

    @Test
    public void testAllZeros_MoreThanFits() {
        int[] arr = {0, 0, 0, 0};
        int[] expected = {0, 0, 0, 0};
        duplicator.duplicateZeros(arr);
        assertArrayEquals(expected, arr);
        System.out.println("Результат: " + Arrays.toString(arr));
        System.out.println("Правильный результат: " + Arrays.toString(expected));
    }

    @Test
    public void testZerosAtStart() {
        int[] arr = {0, 0, 1, 2, 3};
        int[] expected = {0, 0, 0, 0, 1};
        duplicator.duplicateZeros(arr);
        assertArrayEquals(expected, arr);
        System.out.println("Результат: " + Arrays.toString(arr));
        System.out.println("Правильный результат: " + Arrays.toString(expected));
    }

    @Test
    public void testZerosAtEndNoSpaceForDuplicate() {
        int[] arr = {1, 2, 3, 0};
        int[] expected = {1, 2, 3, 0};
        duplicator.duplicateZeros(arr);
        assertArrayEquals(expected, arr);
        System.out.println("Результат: " + Arrays.toString(arr));
        System.out.println("Правильный результат: " + Arrays.toString(expected));
    }

    @Test
    public void testZerosAtEndWithSpaceForOneDuplicate() {
        int[] arr = {1, 2, 0, 0, 4};
        int[] expected = {1, 2, 0, 0, 0};
        duplicator.duplicateZeros(arr);
        assertArrayEquals(expected, arr);
        System.out.println("Результат: " + Arrays.toString(arr));
        System.out.println("Правильный результат: " + Arrays.toString(expected));
    }

    @Test
    public void testAlternatingZeros() {
        int[] arr = {0, 1, 0, 1, 0};
        int[] expected = {0, 0, 1, 0, 0};
        duplicator.duplicateZeros(arr);
        assertArrayEquals(expected, arr);
        System.out.println("Результат: " + Arrays.toString(arr));
        System.out.println("Правильный результат: " + Arrays.toString(expected));
    }

    @Test
    public void testAlmostFullOfZeros() {
        int[] arr = {0,0,0,0,0,0,0,1};
        int[] expected = {0,0,0,0,0,0,0,0};
        duplicator.duplicateZeros(arr);
        assertArrayEquals(expected, arr);
        System.out.println("Результат: " + Arrays.toString(arr));
        System.out.println("Правильный результат: " + Arrays.toString(expected));
    }

    @Test
    public void testOnlyOneSpaceLeftForZero() {
        // Этот тест проверяет случай, когда последний элемент, который поместится - это ноль, но его дубликат уже не помещается.
        int[] arr = {8,4,5,0,0,0,0,7}; // Длина 8
        int[] expected = {8,4,5,0,0,0,0,0}; // ЭТАЛОН для проверки
        duplicator.duplicateZeros(arr);
        assertArrayEquals(expected, arr);
        System.out.println("Результат: " + Arrays.toString(arr));
        System.out.println("Правильный результат: " + Arrays.toString(expected));
    }


    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void testPerformanceLargeArray() {
        int size = 10000;
        int[] arr = new int[size];
        Random random = new Random();
        int zeroCount = 0;
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(10) < 3 ? 0 : random.nextInt(9) + 1;
            if (arr[i] == 0) zeroCount++;
        }
        System.out.println("Тест: Размер массива = " + size + ", Количество нулей = " + zeroCount);

        long startTime = System.nanoTime();
        duplicator.duplicateZeros(arr);
        long endTime = System.nanoTime();
        long durationMs = (endTime - startTime) / 1_000_000;
        System.out.println("Тест: Время выполнения = " + durationMs + " мс");

        assertTrue(durationMs < 100, "Время выполнения превысило лимит для большого массива.");
        long finalZeroCount = Arrays.stream(arr).filter(val -> val == 0).count();
        assertTrue(finalZeroCount <= size && finalZeroCount >= zeroCount);

    }
}