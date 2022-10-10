public abstract class Human {

    protected final String Name;
    protected final Integer Age;

    public Human(String name, Integer age) {
        Name = name;
        Age = age;
    }

    @Override
    public String toString() {
        return Name + ", возраст: " + Age;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Human human) {
            return Name.equals(human.Name) && Age.equals(human.Age);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}