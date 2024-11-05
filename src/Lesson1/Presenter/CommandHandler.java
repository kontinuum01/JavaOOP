package Lesson1.Presenter;

import Lesson1.View.TreeView;

public class CommandHandler {

    private final TreePresenter presenter;
    private final TreeView view;

    public CommandHandler(TreePresenter presenter, TreeView view) {
        this.presenter = presenter;
        this.view = view;
    }

    public void handleUserInput(){
        while (true) {
            view.displayMessage("Enter command(add,list, sortByName,sortByBirthYear,save,load,exit):");
            String command = view.getUserInput();
            presenter.handleUserInput(command);
        }
    }
}

