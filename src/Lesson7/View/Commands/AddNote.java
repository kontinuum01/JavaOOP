package Lesson7.View.Commands;

import Lesson7.View.Command;
import Lesson7.View.ConsoleUi;

public class AddNote extends Command {

    public AddNote(ConsoleUi consoleUi) {
        super(consoleUi);
        description = "Добавить запись";
    }

    @Override
    public void execute (){
        ConsoleUi.addNote;
    }
}
