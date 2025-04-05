package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab2.n6.Railway;

@TaskDescription(taskNumber = 4, taskDescription = "Задача «Железнодорожный переезд»")
public class Task26 implements Solution{
    @Override
    public void execute() {
        Railway railway = new Railway();
        Thread threadCars = new Thread(() -> {
            for (int i = 1; i <= 50; i++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                railway.passCar(i + " машина");
            }
        });

        Thread threadTrain = new Thread(() -> {
            try {
                Thread.sleep(2000);
                railway.trainIsPassing();
                Thread.sleep(2000);
                railway.trainPassed();
                Thread.sleep(2000);
                railway.trainIsPassing();
                Thread.sleep(2000);
                railway.trainPassed();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threadCars.start();
        threadTrain.start();
    }
}
