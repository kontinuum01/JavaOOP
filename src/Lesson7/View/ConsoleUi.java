package Lesson7.View;

import Lesson7.Presenter.NotebookPresenter;


import java.util.Scanner;

public class ConsoleUi implements View {

    private final Scanner scanner;
    private final NotebookPresenter presenter;
    private static boolean exit;
    private final Menu menu;

    public ConsoleUi(Scanner scanner, NotebookPresenter presenter, Menu menu) {
        this.scanner = scanner;
        this.presenter = presenter;
        this.menu = menu;
    }

    @Override
    public void start() {
        while (exit) {
            hello("Добрый день! Выберите одно из действий:");
            printMenu();
            execute();
        }
    }

    private static void hello(String x) {
        System.out.println(x);
    }

    private void printMenu() {
        printAnswer(menu.menu());
    }

    private void execute() {
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)) {
                menu.execute(numCommand);
                    }
                }
            }

    private boolean checkCommand(int numCommand) {
        if (numCommand <= menu.getSize()) {
            return true;
        } else {

            return false;
        }
    }
    private boolean checkTextForInt(String text) {
        return text.matches("[0-9]+");
    }
    public void showError(String x) {
        System.out.println(x);
    }
    public static void finish() {
        exit = false;
        System.out.println("Всего доброго!");
    }

    public void addNote() {
        presenter.addNote();
}
    public void showNotesForDay(){
        presenter.showNotesForDay();
}

    public void showNotesForWeek() {
        presenter.showNotesForWeek();
}
    public void saveNotes(){
      presenter.saveNotes();
}

    @Override
    public void printAnswer(String answer) {
        hello(answer);
    }

}


