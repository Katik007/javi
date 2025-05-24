package org.knit.solutions.lab5.n14;

// Конкретный посетитель: Анализатор размера
public class SizeAnalyzer implements Visitor {
    private int totalSize = 0;

    @Override
    public void visitFile(File file) {
        totalSize += file.getSize();
    }

    @Override
    public void visitFolder(Folder folder) {
    }

    @Override
    public void visitLink(Link link) {
        System.out.println("Ссылка '" + link.getName() + "' не учитывается в размере.");
    }

    public int getTotalSize() {
        return totalSize;
    }
}
