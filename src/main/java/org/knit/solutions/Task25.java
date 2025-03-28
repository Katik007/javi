package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab2.n5.Restaraunt;

@TaskDescription(taskNumber = 3, taskDescription = "Задача «Ресторан: Повар и Официант»")
public class Task25 implements Solution{
    @Override
    public void execute() {
        Restaraunt restaraunt = new Restaraunt();
        Thread threadCooker = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                restaraunt.cook("Блюдо " + i);
            }
        });

        Thread threadWaiter = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                restaraunt.serve();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        threadCooker.start();
        threadWaiter.start();
    }
}
