package org.knit.solutions.lab5.n14;

// Пример использования
public class Main {
    public static void main(String[] args) {
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
        System.out.println("Запуск сканирования на вирусы");
        rootFolder.accept(virusScanner);

        System.out.println("Запуск анализа размера");
        SizeAnalyzer sizeAnalyzer = new SizeAnalyzer();
        rootFolder.accept(sizeAnalyzer);
        System.out.println("Общий размер файлов: " + sizeAnalyzer.getTotalSize() + " байт");
    }
}