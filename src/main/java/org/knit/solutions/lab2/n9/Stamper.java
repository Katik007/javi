package org.knit.solutions.lab2.n9;

import java.util.concurrent.BlockingQueue;
import java.util.Random;

public class Stamper implements Runnable {
    private final BlockingQueue<Detail> stampingQueue;
    private int lastDetailId = 0;
    private final Random random = new Random();
    private final int MAX_STAMPER_DELAY = 2000;

    public Stamper(BlockingQueue<Detail> blockingQueue) {
        this.stampingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (lastDetailId < 7) {
            try {
                stampingQueue.put(new Detail(++lastDetailId));
                System.out.println("Штамповщик сделал заготовку " + lastDetailId);
                Thread.sleep(random.nextInt(MAX_STAMPER_DELAY));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Штамповщик ушел домой.");
    }
}