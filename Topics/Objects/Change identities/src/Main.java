
class Person {
    String name;
    int age;
}

class MakingChanges {
    public static void changeIdentities(Person p1, Person p2) {
        // write your code here
        Person tempPerson = new Person();
        tempPerson.name = p1.name;
        tempPerson.age = p1.age;

        p1.name = p2.name;
        p1.age = p2.age;

        p2.name = tempPerson.name;
        p2.age = tempPerson.age;

    }

}
