package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab1.*;
import org.knit.solutions.lab5.n14.*;

@TaskDescription(taskNumber = 14, taskDescription = "Задача на паттерн Визитер (Visitor)")
public class Task5_14 implements Solution{
    @Override
    public void execute() {
        File file1 = new File("document.txt", 1024);
        File file2 = new File("image.jpg", 2048);
        Folder folder1 = new Folder("Documents");
        folder1.addElement(file1);
        Link link1 = new Link("doc_link", file1);
        Folder rootFolder = new Folder("Root");
        rootFolder.addElement(folder1);
        rootFolder.addElement(file2);
        rootFolder.addElement(link1);

        VirusScanner virusScanner = new VirusScanner();
        System.out.println("--- Запуск сканирования на вирусы ---");
        rootFolder.accept(virusScanner);

        System.out.println("--- Запуск анализа размера ---");
        SizeAnalyzer sizeAnalyzer = new SizeAnalyzer();
        rootFolder.accept(sizeAnalyzer);
        System.out.println("Общий размер файлов: " + sizeAnalyzer.getTotalSize() + " байт");
    }
}
