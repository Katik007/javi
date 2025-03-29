package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab3.n10.Race;

@TaskDescription(taskNumber = 8, taskDescription = "Задача про бегунов со всеми дополнениями заданиями")
public class Task310 implements Solution{
    @Override
    public void execute() {
        int runnersCount = 10;
        Race race = new Race(runnersCount);
        race.startRace();
        }
}