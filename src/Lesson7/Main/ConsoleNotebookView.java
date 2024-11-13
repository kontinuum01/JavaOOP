package Lesson7.Main;

import Lesson7.Model.Note;
import Lesson7.View.NotebookView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ConsoleNotebookView implements NotebookView {

    private final Scanner scn = new Scanner(System.in);

    @Override
    public void showNotes(List<Note> notes) {
        if (notes.isEmpty()) {
            System.out.println("No notes found.");
        } else {
            for (Note note : notes) {
                System.out.println(note);
            }
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public LocalDateTime getDateTimeInput() {
        System.out.println("Enter date and time (yyyy-MM-dd'T'HH:mm):");
        String input = scn.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        return LocalDateTime.parse(input, formatter);
    }

    @Override
    public String getDescriptionInput() {
        System.out.println("Enter note description:");
        return scn.nextLine();
    }

    @Override
    public String getFileNameInput() {
        System.out.println("Enter file name:");
        return scn.nextLine();
    }
}
