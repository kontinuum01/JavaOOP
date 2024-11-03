package Lesson1.View;

import Lesson1.Model.Person;
import Lesson1.Presenter.TreePresenter;
import java.util.List;

public interface TreeView {

    void displayMessage(String message);
    void displayPersons(List<Person> persons);
    String getUserInput();
    void setPresenter(TreePresenter presenter);
}
