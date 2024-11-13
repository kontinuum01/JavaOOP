package Lesson7.View;

import Lesson7.Model.Note;

import java.time.LocalDateTime;
import java.util.List;

public interface NotebookView {

    void showNotes(List<Note> notes);
    void showMessage(String message);
    LocalDateTime getDateTimeInput();
    String getDescriptionInput();
    String getFileNameInput();
}
