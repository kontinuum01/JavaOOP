package Lesson1;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        FamilyTree familyTree = new FamilyTree();

        //Создаем людей
        Person john = new Person("John", 1950);
        Person mary = new Person("Mary", 1955);
        Person susan = new Person("Susan", 1980);
        Person patrick = new Person("Patrick", 1981);

        //Устанавливаем родительские связи
        susan.setMother(mary);
        susan.setFather(john);
        patrick.setMother(mary);
        patrick.setFather(john);
        john.addChild(susan);
        mary.addChild(susan);
        john.addChild(patrick);
        mary.addChild(patrick);

        //Добавляем людей в древо
        familyTree.addPerson(john);
        familyTree.addPerson(mary);
        familyTree.addPerson(susan);
        familyTree.addPerson(patrick);

        //Создаем объект для работы с файлами
        FileOperations fileOps = new FileOperationsImpl();

        //Пример получения всех детей
        List<Person> marysChildren = familyTree.getChildren(mary);

        for (Person child : marysChildren) {
            System.out.println("Mary's child:" + child.getName() + "--birthdays :" + child.getBirthYear());
        }

        //Сохраняем генеалогическое древо в файл
        try {
            fileOps.saveToFile(familyTree, "familyTree.dat");
            System.out.println("Family tree saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Загружаем генеалогическое древо из файла
        FamilyTree loadedFamilyTree = null;

        try {
            loadedFamilyTree =
                    fileOps.loadFromFile("familyTree.dat");

            System.out.println("Family tree loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //Проверяем,что древо загрузилось правильно
        if (loadedFamilyTree != null) {
            for (Person person :
                    loadedFamilyTree.getPeople()) {
                System.out.println("Loaded person:" +
                        person.getName() + ",born in" + person.getBirthYear());
            }

        }

    }
}


