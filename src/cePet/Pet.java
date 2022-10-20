package cePet;

/**
 * Creates a simple representation of a pet,
 * using their name, age, and species.
 * @author Rianna McIntyre
 */
public class Pet {
    private String name;
    private int age;
    private String species;

    /**
     * @param name of the pet
     * @param age of the pet
     * @param species of the pet
     */
    Pet(String name, int age, String species){
        this.name = name;
        this.age = age;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSpecies() {
        return species;
    }

    @Override
    public String toString() {
        return species + " " + name + " (" + age + ")";
    }
}
