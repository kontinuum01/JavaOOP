package Lesson1.Presenter;

import Lesson1.Servise.FileOperations;
import Lesson1.Model.FamilyTree;
import Lesson1.Model.Person;
import Lesson1.View.InputView;
import Lesson1.View.MessageView;
import Lesson1.View.PersonView;

import java.io.IOException;

public class TreePresenter {

    private FamilyTree<Person> familyTree;
    private MessageView messageView;
    private PersonView personView;
    private InputView inputView;
    private final FileOperations<Person> fileOperations;

    public TreePresenter(FamilyTree<Person> familyTree, MessageView
            messageView, PersonView personView,InputView inputView
            , FileOperations<Person> fileOperations) {

        this.familyTree = familyTree;
        this.messageView = messageView;
        this.personView = personView;
        this.inputView = inputView;
        this.fileOperations = fileOperations;

    }

    public void addPerson(String name, int birthYear) {
        Person person = new Person(name, birthYear);
        familyTree.addMember(person);
        messageView.displayMessage("Person added :" + name);
    }

    public void showAllPersons() {
        personView.displayPersons(familyTree.getMembers());
    }

    public void sortPersonsByName() {
        familyTree.sortByName();
        messageView.displayMessage("Persons sorted by name :");
        showAllPersons();
    }

    public void sortPersonsByBirthYear() {
        familyTree.sortByBirthYear();
        messageView.displayMessage("Persons sorted by birthyear  :");
        showAllPersons();
    }

    public void saveTree(String fileName) {
        try {
            fileOperations.saveToFile(familyTree, fileName);
            messageView.displayMessage("Family tree saved to" + fileName);
        } catch (IOException e) {
            messageView.displayMessage("Error saving family tree:" +
                    e.getMessage());
        }
    }

    public void loadTree(String fileName) {
        try {
            familyTree = fileOperations.loadFromFile(fileName);
            messageView.displayMessage("Family tree loaded from" +
                    fileName);
        } catch (IOException | ClassNotFoundException e) {
            messageView.displayMessage("Error loading family tree:" +
                    e.getMessage());
        }
    }

    public void handleUserInput(String command){

        switch(command){
                case"add":
                    messageView.displayMessage("Enter" + " name:");
                    String name = inputView.getUserInput();
                    messageView.displayMessage("Enter birth year:");
                    int birthYear = Integer.parseInt(inputView.getUserInput());
                    addPerson(name, birthYear);
                    break;
                case"list":
                    showAllPersons();
                    break;
                case"sortByName":
                    sortPersonsByName();
                    break;
                case"sortByBirthYear":
                    sortPersonsByBirthYear();
                    break;
                case"save":
                    messageView.displayMessage("Enter filename:");
                    saveTree(inputView.getUserInput());
                    break;
                case"load":
                    messageView.displayMessage("Enter filename:");
                    loadTree(inputView.getUserInput());
                    break;
                case"exit":
                    System.exit(0);
                default:
                    messageView.displayMessage("Unknown command");
            }
        }
    }

