package Lesson7.View;

import Lesson7.View.Commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    List<Command> commandList;

    public Menu(ConsoleUi consoleUi){
        commandList = new ArrayList<>();
        commandList.add(new AddNote(consoleUi));
        commandList.add(new ShowNotesForDay(consoleUi));
        commandList.add(new ShowNotesForWeek(consoleUi));
        commandList.add(new SaveNotes(consoleUi));
        commandList.add(new Finish(consoleUi));
    }

    String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }
}
