package lesson1.task1;

public class TaskOne {
    public static void main(String[] args) {
        Person p = new Person.Builder()
                .addFirstName("Ivan")
                .addMiddleName("Ivanovich")
                .addLastName("Ivanov")
                .addGender("male")
                .addCountry("Russia")
                .addAddress("Moscow.Red Square 1")
                .addPhone("+7-999-999-99-99")
                .build();
        System.out.println(p);
    }
}
