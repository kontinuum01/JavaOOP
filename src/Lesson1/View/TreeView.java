package Lesson1.View;

import Lesson1.Model.Person;
import Lesson1.Presenter.TreePresenter;
import java.util.List;

public interface TreeView extends MessageView, PersonView, InputView{


    void setPresenter(TreePresenter presenter);
}
