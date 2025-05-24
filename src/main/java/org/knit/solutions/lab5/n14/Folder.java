package org.knit.solutions.lab5.n14;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemElement {
    private String name;
    private List<FileSystemElement> elements = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void addElement(FileSystemElement element) {
        this.elements.add(element);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitFolder(this);
        for (FileSystemElement element : elements) {
            element.accept(visitor);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    public List<FileSystemElement> getElements() {
        return elements;
    }
}
