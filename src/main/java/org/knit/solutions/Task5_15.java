package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab5.n15.Image;
import org.knit.solutions.lab5.n15.ImageProxy;

@TaskDescription(taskNumber = 15, taskDescription = "Задача 15 на паттерн Прокси (Proxy)")
public class Task5_15 implements Solution{
    @Override
    public void execute() {
        Image image1 = new ImageProxy("image1.jpg");
        Image image2 = new ImageProxy("image2.png");

        System.out.println("Первое отображение image1:");
        image1.display();
        System.out.println("Второе отображение image1 (без повторной загрузки):");
        image1.display();

        System.out.println("Отображение image2:");
        image2.display();
    }

}

