public class Person implements Comparable<Person> {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person other) {
        return name.compareTo(other.toString());
    }

    public String toString() {
        return name;
    }
}
