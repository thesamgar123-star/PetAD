import java.util.ArrayList;

public class Shelter {
    private ArrayList<Pet> pets = new ArrayList<>();

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void showPets() {
        for (Pet p : pets) {
            System.out.println(p);
        }
    }

    public Pet findPetByName(String name) {
        for (Pet p : pets) {
            if (p.name.equalsIgnoreCase(name) && !p.isAdopted()) {
                return p;
            }
        }
        return null;
    }
}