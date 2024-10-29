package Lesson1.Servise;

import Lesson1.Model.FamilyTree;

import java.io.IOException;

public interface FileOperations<T> {

    void saveToFile(FamilyTree<T> familyTree, String fileName)
            throws IOException;

    FamilyTree<T> loadFromFile(String fileName)
            throws IOException, ClassNotFoundException;
}




