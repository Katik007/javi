package org.knit.solutions.lab3.n10;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Race {
    private final int runnersCount;
    private final ExecutorService executor;
    private final CyclicBarrier startBarrier;
    private final CyclicBarrier finishBarrier;
    private final AtomicBoolean raceCancelled = new AtomicBoolean(false); // Флаг отмены гонки
    private final ConcurrentLinkedQueue<Integer> finishOrder = new ConcurrentLinkedQueue<>(); // Очередь финишировавших

    public Race(int runnersCount) {
        this.runnersCount = runnersCount;
        this.executor = Executors.newFixedThreadPool(runnersCount);

        this.startBarrier = new CyclicBarrier(runnersCount,
                () -> System.out.println("Все бегуны готовы. На старт! Внимание! Марш!"));

        this.finishBarrier = new CyclicBarrier(runnersCount, this::announceResults);
    }

    public void startRace() {
        for (int i = 1; i <= runnersCount; i++) {
            executor.execute(new Runner(i, startBarrier, finishBarrier, raceCancelled, this));
        }
        executor.shutdown();
    }

    public void cancelRace() {
        if (raceCancelled.compareAndSet(false, true)) {
            System.out.println("Гонка прервана из-за травмы!");
            executor.shutdownNow();
        }
    }

    public void addFinish(int runnerId) {
        finishOrder.add(runnerId);
    }

    private void announceResults() {
        if (raceCancelled.get()) return; // Если гонка отменена, не объявляем результаты

        System.out.println("Гонка завершена!");
        int place = 1;
        for (Integer runnerId : finishOrder) {
            if (place == 1) {
                System.out.println("1 место: Бегун " + runnerId);
            } else if (place == 2) {
                System.out.println("2 место: Бегун " + runnerId);
            } else if (place == 3) {
                System.out.println("3 место: Бегун " + runnerId);
            }
            place++;
            if (place > 3) break; // Достаточно первых трёх мест
        }
    }
}
