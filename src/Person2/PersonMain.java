package Person2;

//import java.util.*;

public class PersonMain {
    public static void main(String[] args) {
        Person ole = new Person("Ole", 'M');
        Person geir = new Person("Geir", 'M');
        ole.setFather(geir);

        ole.setFather(new Person("Øyvind", 'M'));
        ole.getFather().setFather(new Person("Karl", 'M'));
        ole.getFather().getFather().setFather(new Person("Bob", 'M'));

        System.out.println(ole.getFather().getFather().getFather());

    }
}
