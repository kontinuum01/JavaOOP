package Lesson7.Main;

import Lesson7.Model.Notebook;
import Lesson7.Presenter.NotebookPresenter;

import Lesson7.View.ConsoleUi;
import Lesson7.View.NotebookView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Notebook model = new Notebook();
        NotebookView view = new ConsoleNotebookView();
        NotebookPresenter presenter = new NotebookPresenter(model, view);
        Scanner scn = new Scanner(System.in);

        ConsoleUi consoleUi = new ConsoleUi();
        consoleUi.start();

        while (true) {
            System.out.println("1.Add Note");
            System.out.println("2.Show Notes for Day");
            System.out.println("3.Show Notes for Week");
            System.out.println("4.Save Notes");
            System.out.println("5.Load Notes");
            System.out.println("6.Exit");

            int choice = scn.nextInt();

            scn.nextLine();

            switch (choice) {
                case 1:
                presenter.addNote();
                break;
                case 2:
                presenter.showNotesForDay();
                break;
                case 3:
                presenter.showNotesForWeek();
                break;
                case 4:
                presenter.saveNotes();
                break;
                case 5:
                presenter.loadNotes();
                break;
                case 6:
                return;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }
}


