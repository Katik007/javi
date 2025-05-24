package org.knit.solutions.lab5.n14;


public class File implements FileSystemElement {
    private String name;
    private int size; // Размер файла в байтах

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitFile(this);
    }

    @Override
    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}
