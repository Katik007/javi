package org.knit.solutions.lab5.n14;

// Интерфейс посетителя
interface Visitor {
    void visitFile(File file);

    void visitFolder(Folder folder);

    void visitLink(Link link);
}
