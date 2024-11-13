package Lesson7.View.Commands;

import Lesson7.View.Command;
import Lesson7.View.ConsoleUi;

public class ShowNotesForDay extends Command {

    public ShowNotesForDay(ConsoleUi consoleUi) {
        super(consoleUi);
        description = "Вывести записи на день";

    }

    @Override
    public void execute() {
        ConsoleUi.showNotesForDay;
    }
}
