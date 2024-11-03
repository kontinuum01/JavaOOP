package Lesson1.Model;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Класс для работы с генеалогическим древом
public class FamilyTree<T> implements Serializable, Iterable<T> {

    @Serial
    private static final long serialVersionUID = 1L;
    private final List<T> members;

    public FamilyTree() {

        this.members = new ArrayList<>();

    }

    public void addMember(T member) {
        this.members.add(member);
    }

    public List<Person> getChildren(Person parent) {
        return parent.getChildren();
    }

//    public Person findPersonByName(String name){
//        for(Person person : person){
//            if(person.getName().equals(name)){
//                return person;
//            }
//        }
//        return null;
//}

    public List<T> getMembers() {
        return members;
    }

    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }

    public void sortByName() {
        members.sort((p1, p2) ->
                p1.toString().compareTo(p2.toString()));
    }

    public void sortByBirthYear() {
        if (members.getFirst() instanceof Person){
            members.sort((p1, p2) ->
                    Integer.compare(((Person) p1).getBirthYear(), ((Person)
                            p2).getBirthYear()));
        }
    }
}
