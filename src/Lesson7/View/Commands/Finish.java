package Lesson7.View.Commands;

import Lesson7.View.Command;
import Lesson7.View.ConsoleUi;

public class Finish extends Command {
    public Finish(ConsoleUi consoleUi) {
        super(consoleUi);
        description = "Закончить работу";
    }

    public void execute() {
        ConsoleUi.finish();
    }
}

