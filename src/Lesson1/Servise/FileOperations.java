package Lesson1.Servise;

import Lesson1.Model.FamilyTree;

import java.io.IOException;

public interface FileOperations {

    void saveToFile(FamilyTree familyTree, String fileName)
            throws IOException;

    FamilyTree loadFromFile(String fileName)
            throws IOException, ClassNotFoundException;
}




