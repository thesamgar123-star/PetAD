import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Shelter shelter = new Shelter();
        shelter.addPet(new Pet("Buddy", 3, "Dog"));
        shelter.addPet(new Pet("Milo", 2, "Cat"));

        System.out.println("Available pets:");
        shelter.showPets();

        System.out.print("Enter pet name to adopt: ");
        String petName = sc.nextLine();

        Pet pet = shelter.findPetByName(petName);

        if (pet != null) {
            Adopter adopter = new Adopter("Alex");
            adopter.adoptPet(pet);
        } else {
            System.out.println("Pet not found or already adopted.");
        }
    }
}