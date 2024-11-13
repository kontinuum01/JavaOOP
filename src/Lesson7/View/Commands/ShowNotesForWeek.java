package Lesson7.View.Commands;

import Lesson7.View.Command;
import Lesson7.View.ConsoleUi;

public class ShowNotesForWeek extends Command {

    public ShowNotesForWeek(ConsoleUi consoleUi) {
        super(consoleUi);
        description = "Вывести записи для недели";
    }

    @Override
    public void execute() {
        ConsoleUi.showNotesForWeek;
    }
}