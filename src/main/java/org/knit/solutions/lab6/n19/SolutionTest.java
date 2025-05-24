package org.knit.solutions.lab6.n19;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void testExample1() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        int[] expected = {1, 2, 2, 3, 5, 6};
        System.out.println("Массив 1: " + Arrays.toString(nums1));
        System.out.println("Массив 2: " + Arrays.toString(nums2));
        solution.merge(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
        System.out.println("Объединение: " + Arrays.toString(nums1));
        System.out.println("Правильный результат: " + Arrays.toString(expected));
    }

    @Test
    void testExample2_nums2Empty() {
        int[] nums1 = {1};
        int m = 1;
        int[] nums2 = {};
        int n = 0;
        int[] expected = {1};
        System.out.println("Массив 1: " + Arrays.toString(nums1));
        System.out.println("Массив 2: " + Arrays.toString(nums2));
        solution.merge(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
        System.out.println("Объединение: " + Arrays.toString(nums1));
        System.out.println("Правильный результат: " + Arrays.toString(expected));
    }

    @Test
    void testExample3_nums1EffectivelyEmpty() {
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;
        int[] expected = {1};
        System.out.println("Массив 1: " + Arrays.toString(nums1));
        System.out.println("Массив 2: " + Arrays.toString(nums2));
        solution.merge(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
        System.out.println("Объединение: " + Arrays.toString(nums1));
        System.out.println("Правильный результат: " + Arrays.toString(expected));
    }

    // --- Обычные случаи ---
    @Test
    void testMergeWithSomeOverlap() {
        int[] nums1 = {1, 5, 8, 0, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 3, 7, 9};
        int n = 4;
        int[] expected = {1, 2, 3, 5, 7, 8, 9};
        System.out.println("Массив 1: " + Arrays.toString(nums1));
        System.out.println("Массив 2: " + Arrays.toString(nums2));
        solution.merge(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
        System.out.println("Объединение: " + Arrays.toString(nums1));
        System.out.println("Правильный результат: " + Arrays.toString(expected));
    }

    @Test
    void testNums2ElementsAllSmaller() {
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int m = 3;
        int[] nums2 = {1, 2, 3};
        int n = 3;
        int[] expected = {1, 2, 3, 4, 5, 6};
        System.out.println("Массив 1: " + Arrays.toString(nums1));
        System.out.println("Массив 2: " + Arrays.toString(nums2));
        solution.merge(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
        System.out.println("Объединение: " + Arrays.toString(nums1));
        System.out.println("Правильный результат: " + Arrays.toString(expected));
    }

    @Test
    void testNums2ElementsAllLarger() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {4, 5, 6};
        int n = 3;
        int[] expected = {1, 2, 3, 4, 5, 6};
        System.out.println("Массив 1: " + Arrays.toString(nums1));
        System.out.println("Массив 2: " + Arrays.toString(nums2));
        solution.merge(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
        System.out.println("Объединение: " + Arrays.toString(nums1));
        System.out.println("Правильный результат: " + Arrays.toString(expected));
    }

    // --- Краевые случаи ---
    @Test
    void testBothEmpty_m0_n0() {
        int[] nums1 = {}; // m+n = 0
        int m = 0;
        int[] nums2 = {};
        int n = 0;
        int[] expected = {};
        System.out.println("Массив 1: " + Arrays.toString(nums1));
        System.out.println("Массив 2: " + Arrays.toString(nums2));
        solution.merge(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
        System.out.println("Объединение: " + Arrays.toString(nums1));
        System.out.println("Правильный результат: " + Arrays.toString(expected));
    }

    @Test
    void testBothEmpty_m0_n0_nums1HasSpace() {
        int[] nums1 = {0,0};
        int[] nums1_valid = {};
        int m_valid = 0;
        int[] nums2_valid = {};
        int n_valid = 0;
        int[] expected_valid = {};
        solution.merge(nums1_valid, m_valid, nums2_valid, n_valid);
        assertArrayEquals(expected_valid, nums1_valid);
        int[] nums1_edge = {0,0};
        int m_edge = 0;
        int[] nums2_edge = {};
        int n_edge = 0;
        int[] expected_edge = {0,0}; // Ожидаем, что массив не изменится
        solution.merge(nums1_edge, m_edge, nums2_edge, n_edge);
        assertArrayEquals(expected_edge, nums1_edge);
        System.out.println("Массив 1: " + Arrays.toString(nums1_edge));
        System.out.println("Массив 2: " + Arrays.toString(nums2_edge));
        solution.merge(nums1_edge, m_edge, nums2_edge, n_edge);
        assertArrayEquals(expected_edge, nums1_edge);
        System.out.println("Объединение: " + Arrays.toString(nums1_edge));
    }


    @Test
    void testNums1EmptyAndNums2HasData_m0_n_gt_0_nums1_len_n() {
        int[] nums1 = {0, 0, 0}; // nums1.length = m + n = 0 + 3 = 3
        int m = 0;
        int[] nums2 = {1, 2, 3};
        int n = 3;
        int[] expected = {1, 2, 3};
        System.out.println("Массив 1: " + Arrays.toString(nums1));
        System.out.println("Массив 2: " + Arrays.toString(nums2));
        solution.merge(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
        System.out.println("Объединение: " + Arrays.toString(nums1));
        System.out.println("Правильный результат: " + Arrays.toString(expected));
    }


    // --- Отрицательные числа и дубликаты ---
    @Test
    void testWithNegativeNumbers() {
        int[] nums1 = {-5, -2, 0, 0, 0, 0};
        int m = 2; // -5, -2
        int[] nums2 = {-7, -2, 1, 4};
        int n = 4;
        int[] expected = {-7, -5, -2, -2, 1, 4};
        System.out.println("Массив 1: " + Arrays.toString(nums1));
        System.out.println("Массив 2: " + Arrays.toString(nums2));
        solution.merge(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
        System.out.println("Объединение: " + Arrays.toString(nums1));
        System.out.println("Правильный результат: " + Arrays.toString(expected));
    }

    @Test
    void testWithDuplicates() {
        int[] nums1 = {1, 2, 2, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 2, 3};
        int n = 3;
        int[] expected = {1, 2, 2, 2, 2, 3};
        System.out.println("Массив 1: " + Arrays.toString(nums1));
        System.out.println("Массив 2: " + Arrays.toString(nums2));
        solution.merge(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
        System.out.println("Объединение: " + Arrays.toString(nums1));
        System.out.println("Правильный результат: " + Arrays.toString(expected));
    }

    @Test
    void testAllElementsSame() {
        int[] nums1 = {1, 1, 0, 0};
        int m = 2;
        int[] nums2 = {1, 1};
        int n = 2;
        int[] expected = {1, 1, 1, 1};
        System.out.println("Массив 1: " + Arrays.toString(nums1));
        System.out.println("Массив 2: " + Arrays.toString(nums2));
        solution.merge(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
        System.out.println("Объединение: " + Arrays.toString(nums1));
        System.out.println("Правильный результат: " + Arrays.toString(expected));
    }

    // --- Производительность ---
    @Test
    void testPerformanceLargeArrays() {
        int m_large = 100;
        int n_large = 100;
        int total_size = m_large + n_large;

        int[] nums1 = new int[total_size];
        int[] nums2 = new int[n_large];
        Random rand = new Random();

        for (int i = 0; i < m_large; i++) {
            nums1[i] = rand.nextInt(1000) - 500; // Случайные числа
        }
        Arrays.sort(nums1, 0, m_large); // Сортируем только значащую часть

        for (int i = 0; i < n_large; i++) {
            nums2[i] = rand.nextInt(1000) - 500;
        }
        Arrays.sort(nums2);

        // Создаем ожидаемый результат для проверки (не для самого алгоритма)
        int[] expected = new int[total_size];
        System.arraycopy(nums1, 0, expected, 0, m_large);
        System.arraycopy(nums2, 0, expected, m_large, n_large);
        Arrays.sort(expected);

        System.out.println("nums1 (первые m): " + Arrays.toString(Arrays.copyOfRange(nums1,0,m_large)));
        System.out.println("nums2: " + Arrays.toString(nums2));

        long startTime = System.nanoTime();
        solution.merge(nums1, m_large, nums2, n_large);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime); // наносекунды
        System.out.println("nums1 после: " + Arrays.toString(nums1));
        System.out.println("Рез: " + Arrays.toString(expected));
        System.out.println("Время: " + duration + " ns (" + (duration / 1_000_000.0) + " ms)");

        assertArrayEquals(expected, nums1, "Не удалось объединить большой массив");
        assertTrue(duration / 1_000_000.0 < 10, "Время выполнения для больших массивов слишком велико (ожидается < 10 мс)"); // Ожидаем очень быстрое выполнение

    }

     @Test
    void testMaxConstraints() {
        int m_large = 200;
        int n_large = 0; // nums2 пустой
        int total_size = m_large + n_large;

        int[] nums1 = new int[total_size];
        int[] nums2 = new int[n_large];

        for (int i = 0; i < m_large; i++) {
            nums1[i] = i; // Простой возрастающий массив
        }
        // nums2 пустой

        int[] expected = new int[total_size];
        System.arraycopy(nums1, 0, expected, 0, m_large);
        // Arrays.sort(expected); // Уже отсортирован

        long startTime = System.nanoTime();
        solution.merge(nums1, m_large, nums2, n_large);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Макс время выполнения: " + duration + "ns");
        assertArrayEquals(expected, nums1);

        // Случай когда nums1 пустой
        m_large = 0;
        n_large = 200;
        total_size = m_large + n_large;
        nums1 = new int[total_size]; // Заполнен нулями
        nums2 = new int[n_large];
         for (int i = 0; i < n_large; i++) {
            nums2[i] = i;
        }
        expected = new int[total_size];
        System.arraycopy(nums2, 0, expected, 0, n_large);

        startTime = System.nanoTime();
        solution.merge(nums1, m_large, nums2, n_large);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Макс время выполнения: " + duration+ "ns");
        assertArrayEquals(expected, nums1);
    }
}