package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab2.n4.GasStation;

@TaskDescription(taskNumber = 2, taskDescription = "Задача «Автозаправочная станция»")
public class Task24 implements Solution{
    @Override
    public void execute() {
        GasStation gasStation = new GasStation(2);
        for (int i = 0; i < 12; i++) {
            int finalI = i;
            new Thread(() -> {
                gasStation.Refuel(String.valueOf(finalI) + " машина");
            }).start();
        }
    }
}

