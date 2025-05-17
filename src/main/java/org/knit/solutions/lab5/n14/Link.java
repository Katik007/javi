package org.knit.solutions.lab5.n14;

public class Link implements FileSystemElement {
    private String name;
    private FileSystemElement target;

    public Link(String name, FileSystemElement target) {
        this.name = name;
        this.target = target;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitLink(this);
    }

    @Override
    public String getName() {
        return name;
    }

    public FileSystemElement getTarget() {
        return target;
    }
}

