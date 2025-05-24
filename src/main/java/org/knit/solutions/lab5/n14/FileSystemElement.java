package org.knit.solutions.lab5.n14;

interface FileSystemElement {
    void accept(Visitor visitor);

    String getName();
}
