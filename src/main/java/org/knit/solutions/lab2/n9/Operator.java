package org.knit.solutions.lab2.n9;

import java.util.concurrent.BlockingQueue;
import java.util.Random;

public class Operator implements Runnable {
    private final double PROBABILITY_OF_FUCKED = 0.3;
    private final BlockingQueue<Detail> stampingQueue;
    private final BlockingQueue<Detail> reassemblingQueue;
    private final BlockingQueue<Detail> assemblingQueue;
    private final BlockingQueue<Detail> warehouseQueue;
    private final Factory factory;
    private final Random random = new Random();
    private final int MAX_STAMPER_DELAY = 2000;

    public Operator(
            BlockingQueue<Detail> stampingQueue,
            BlockingQueue<Detail> reassemblingQueue,
            BlockingQueue<Detail> assemblingQueue,
            BlockingQueue<Detail> warehouseQueue,
            Factory factory
    ) {
        this.stampingQueue = stampingQueue;
        this.reassemblingQueue = reassemblingQueue;
        this.assemblingQueue = assemblingQueue;
        this.warehouseQueue = warehouseQueue;
        this.factory = factory;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Detail detail = assemblingQueue.take();
                Thread.sleep(random.nextInt(MAX_STAMPER_DELAY));
                if (Math.random() > PROBABILITY_OF_FUCKED) {
                    warehouseQueue.put(detail);
                    System.out.println("Оператор проверил деталь " + detail.getId() + " и отправил ее на склад");

                    if (stampingQueue.isEmpty() && assemblingQueue.isEmpty()) {
                        factory.setWorkFinished(true);
                        System.out.println("Оператор ушел домой.");
                        break;
                    }
                } else {
                    reassemblingQueue.put(detail);
                    System.out.println("Оператор проверил деталь " + detail.getId() + " и отправил ее на доработку");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}