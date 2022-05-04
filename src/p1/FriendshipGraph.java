package p1;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class FriendshipGraph{
    List<Person> personlist=new ArrayList<>();
    List<String> namelist=new ArrayList<>();

    public  void addVertex(Person person){
        if(namelist.contains(person.name))
        {
            System.out.println("名字重复出现,出错");
            System.exit(0);//直接结束程序
        }
        else{
            namelist.add(person.name);
            personlist.add(person);
        }
    }
    public void addEdge(Person person1,Person person2){
        if(person1.name==person2.name){
            System.out.println("他们是同一个人");

        }
        else if(person1.friendlist.contains(person2)){
            System.out.println("他们已经是朋友了");

        }
        else {
            person1.addfriend(person2);
            person2.addfriend(person1);
        }
    }
    public  int getDistance(Person person1, Person person2) {
        if(person1.name==person2.name)
            return 0;
        if(person1.friendlist.contains(person2))
            return 1;

        Queue<Person> queuelist=new LinkedList<>();
        Map<Person,Integer> personIntegerMap=new HashMap<>();
        List<Person> visitefriend=new ArrayList<>();

        queuelist.add(person1);
        personIntegerMap.put(person1,0);
        Person firstfriend;
        int distance,i,num;
        while(!queuelist.isEmpty()){
            firstfriend=queuelist.poll();
            visitefriend.add(firstfriend);
            distance=personIntegerMap.get(firstfriend);
            if(firstfriend.name==person2.name)
                return distance;
            num=firstfriend.friendlist.size();
            for(i=0;i<num;i++){
                distance=personIntegerMap.get(firstfriend);
                Person nextperson=firstfriend.friendlist.get(i);

                if(visitefriend.contains(nextperson))
                    continue;
                distance++;
                if(queuelist.contains(nextperson))
                    continue;
                queuelist.add(nextperson);
                personIntegerMap.put(nextperson,distance);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FriendshipGraph graph = new FriendshipGraph();
        Person rachel = new Person("Rachel");
        Person ross = new Person("Ross");
        Person ben = new Person("Ben");
        Person kramer = new Person("Kramer");
        graph.addVertex(rachel);
        graph.addVertex(ross);
        graph.addVertex(ben);
        graph.addVertex(kramer);
        graph.addEdge(rachel, ross);
        graph.addEdge(ross, rachel);
        graph.addEdge(ross, ben);
        graph.addEdge(ben, ross);
        System.out.println(graph.getDistance(rachel, ross));
//should print 1
        System.out.println(graph.getDistance(rachel, ben));
//should print 2
        System.out.println(graph.getDistance(rachel, rachel));
//should print 0
        System.out.println(graph.getDistance(rachel, kramer));
//should print -1
        System.out.println();
    }
}
