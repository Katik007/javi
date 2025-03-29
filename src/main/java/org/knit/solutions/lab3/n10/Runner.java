package org.knit.solutions.lab3.n10;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Runner implements Runnable {
    private final int id;
    private final CyclicBarrier startBarrier;
    private final CyclicBarrier finishBarrier;
    private final AtomicBoolean raceCancelled;
    private final Race race;

    public Runner(int id, CyclicBarrier startBarrier, CyclicBarrier finishBarrier, AtomicBoolean raceCancelled, Race race) {
        this.id = id;
        this.startBarrier = startBarrier;
        this.finishBarrier = finishBarrier;
        this.raceCancelled = raceCancelled;
        this.race = race;
    }

    @Override
    public void run() {
        try {
            System.out.println("Бегун " + id + " готовится...");
            Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));

            System.out.println("Бегун " + id + " на старте.");
            startBarrier.await();

            if (ThreadLocalRandom.current().nextInt(1, 101) <= 5) {
                System.out.println("Бегун " + id + " травмировался и выбыл!");
                race.cancelRace();
                return;
            }

            int runTime = ThreadLocalRandom.current().nextInt(500, 3500);
            Thread.sleep(runTime);
            System.out.println("Бегун " + id + " финишировал за " + runTime + " мс.");

            race.addFinish(id);
            finishBarrier.await();

        } catch (InterruptedException | BrokenBarrierException e) {
            System.out.println("Бегун " + id + " сошел с дистанции.");
        }
    }
}