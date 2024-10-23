package Lesson1;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        FamilyTree familyTree = new FamilyTree();

        Person john = new Person("John", 1950);
        Person mary = new Person("Mary", 1955);
        Person susan = new Person("Susan", 1980);
        Person patrick = new Person("Patrick", 1981);

        susan.setMother(mary);
        susan.setFather(john);
        patrick.setMother(mary);
        patrick.setFather(john);
        john.addChild(susan);
        mary.addChild(susan);
        john.addChild(patrick);
        mary.addChild(patrick);


        familyTree.addPerson(john);
        familyTree.addPerson(mary);
        familyTree.addPerson(susan);
        familyTree.addPerson(patrick);

        List<Person> marysChildren = familyTree.getChildren(mary);

        for (Person child : marysChildren) {
            System.out.println("Mary's child:" + child.getName() + "--birthdays :" + child.getBirthYear());
        }



        }

    }


