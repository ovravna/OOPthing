package Person;

public class PersonMain {

    public static void main(String[] args) {
        Person person = new Person();
        person.setDateOfBirthday(14, 2, 95);
        person.setName("John Doe");
        person.setEmail("john.doe@kx5zl1zvwoz356ez80ldtx.no");
        person.setGender('M');
        person.setSNN("14029548383");

        System.out.println(person);
    }


}