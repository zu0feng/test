package p1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Person {
    public String name;
    public List<Person> friendlist=new ArrayList<>();
    public Person(String name){
        this.name=name;
    }
    public void addfriend(Person a){
        friendlist.add(a);
    }
}
