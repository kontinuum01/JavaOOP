package Lesson1.Main;

import Lesson1.Model.FamilyTree;
import Lesson1.Model.Person;
import Lesson1.Presenter.CommandHandler;
import Lesson1.Presenter.TreePresenter;
import Lesson1.Servise.FileOperations;
import Lesson1.Servise.FileOperationsImpl;
import Lesson1.View.ConsoleTreeView;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        FamilyTree<Person> familyTree = new FamilyTree<>();
        ConsoleTreeView view = new ConsoleTreeView();
        FileOperationsImpl<Person> fileOperations = new FileOperationsImpl<>();
        TreePresenter presenter = new TreePresenter(familyTree, view,view,view, fileOperations);
        CommandHandler commandHandler = new CommandHandler(presenter, view);
        commandHandler.handleUserInput();

        //Создаем людей
//        Person john = new Person("John", 1950);
//        Person mary = new Person("Mary", 1955);
//        Person susan = new Person("Susan", 1980);
//        Person patrick = new Person("Patrick", 1981);

        //Устанавливаем родительские связи
//        susan.setMother(mary);
//        susan.setFather(john);
//        patrick.setMother(mary);
//        patrick.setFather(john);
//        john.addChild(susan);
//        mary.addChild(susan);
//        john.addChild(patrick);
//        mary.addChild(patrick);

        //Добавляем людей в древо
//        familyTree.addMember(john);
//        familyTree.addMember(mary);
//        familyTree.addMember(susan);
//        familyTree.addMember(patrick);

        //Сортируем по имени
        System.out.println("Сортировка по имени:");
        familyTree.sortByName();
        for (Person person : familyTree) {
            System.out.println(person.getName() + "-" +
                    person.getBirthYear());
        }

        //Сортируем по дате рождения
        System.out.println("\nСортировка по дате рождения:");
        familyTree.sortByBirthYear();
        for (Person person : familyTree) {
            System.out.println(person.getName() + "-" +
                    person.getBirthYear());
        }

        //Создаем объект для работы с файлами
        FileOperations<Person> fileOps = new FileOperationsImpl<>();

        //Пример получения всех детей
//        List<Person> marysChildren = familyTree.getChildren(mary);

//        for (Person child : marysChildren) {
//            System.out.println("Mary's child:" + child.getName() + "--birthdays :" + child.getBirthYear());
//        }

        //Сохраняем генеалогическое древо в файл
        try {
            fileOps.saveToFile(familyTree, "familyTree.dat");
            System.out.println("Family tree saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Загружаем генеалогическое древо из файла
        FamilyTree<Person> loadedFamilyTree = null;

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
                    loadedFamilyTree) {
                System.out.println("Loaded person:" +
                        person.getName() + ",born in" + person.getBirthYear());
            }

        }

    }
}


