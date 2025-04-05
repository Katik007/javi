package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab2.n7.Warehouse;

@TaskDescription(taskNumber = 5, taskDescription = "Задача «Производитель-Потребитель с ограничением»")
public class Task27 implements Solution{
    @Override
    public void execute() {
        Warehouse warehouse = new Warehouse();

        Thread threadManufacturer = new Thread(() -> {
            for (int i = 1; i <= 15; i++) {
                warehouse.addProduct(String.valueOf(i));
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread threadBuyer = new Thread(() -> {
            for (int i = 1; i <= 15; i++) {
                warehouse.buyProduct();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        threadManufacturer.start();
        threadBuyer.start();
    }
}
