public abstract class Dog {

    protected final String Name;
    protected final String Breed;
    protected final Integer Age;

    public Dog(String name, String breed, Integer age) {
        Name = name;
        Breed = breed;
        Age = age;
    }

    @Override
    public String toString() {
        return Name + ": " + Breed + ", возраст: " + Age;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Dog dog) {
            return Name.equals(dog.Name) && Breed.equals(dog.Breed) && Age.equals(dog.Age);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}