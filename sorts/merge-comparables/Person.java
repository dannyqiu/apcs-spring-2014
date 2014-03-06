public class Person implements Comparable {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public int compareTo(Object other) {
        if (other instanceof Person) {
            return name.compareTo(((Person) other).toString());
        }
        else {
            return 0/0;
        }
    }

    public String toString() {
        return name;
    }
}
