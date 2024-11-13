package Lesson7.View.Commands;

import Lesson7.View.Command;
import Lesson7.View.ConsoleUi;

public class SaveNotes extends Command {

    public SaveNotes(ConsoleUi consoleUi){
        super(consoleUi);
        description = "Сохранить запись";

    }
    @Override
    public void execute(){
        ConsoleUi.saveNote;
    }
}
