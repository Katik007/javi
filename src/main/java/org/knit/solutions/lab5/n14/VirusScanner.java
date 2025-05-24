package org.knit.solutions.lab5.n14;

// Конкретный посетитель: Сканер вирусов
public class VirusScanner implements Visitor {
    @Override
    public void visitFile(File file) {
        System.out.println("Сканирую файл на вирусы: " + file.getName());

        if (Math.random() < 0.2) {
            System.out.println("!!! Вирус обнаружен в файле: " + file.getName() + " !!!");
        } else {
            System.out.println("Файл чист: " + file.getName());
        }
    }

    @Override
    public void visitFolder(Folder folder) {
        System.out.println("Сканирую папку: " + folder.getName());
    }

    @Override
    public void visitLink(Link link) {
        System.out.println("Сканирую ссылку: " + link.getName());
        if (Math.random() < 0.4) {
            System.out.println("!!! Вирус обнаружен в файле: " + link.getName() + " !!!");
        } else {
            System.out.println("Файл чист: " + link.getName());
        }
    }
}
