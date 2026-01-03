import java.util.Objects;

public class Pet extends Animal {
    private String type;
    private boolean adopted;

    public Pet(String name, int age, String type) {
        super(name, age);
        this.type = type;
        this.adopted = false;
    }

    public boolean isAdopted() {
        return adopted;
    }

    public void adopt() {
        adopted = true;
    }

    @Override
    public void makeSound() {
        System.out.println("Pet sound");
    }

    @Override
    public String toString() {
        return name + " (" + type + "), age " + age + ", adopted: " + adopted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet pet = (Pet) o;
        return name.equals(pet.name) && type.equals(pet.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
}