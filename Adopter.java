public class Adopter {
    private String name;

    public Adopter(String name) {
        this.name = name;
    }

    public void adoptPet(Pet pet) {
        pet.adopt();
        System.out.println(name + " adopted " + pet);
    }
}