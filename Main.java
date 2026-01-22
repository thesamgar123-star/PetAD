public class Main {
    public static void main(String[] args) {
        DatabaseHandler db = new DatabaseHandler();

        // WRITE
        db.addPet("Актос", "Dog", 3);

        // READ + SORT
        db.showSortedPets();

        // UPDATE
        db.updatePetAge(1, 6);

        // DELETE
        db.deletePet(2);
    }
}