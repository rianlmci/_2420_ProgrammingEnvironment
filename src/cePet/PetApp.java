package cePet;

import edu.princeton.cs.algs4.BinarySearchST;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Random;

public class PetApp {
    static BinarySearchST<Integer, Pet> st = new BinarySearchST<>();
    public static void main(String [] args){
        Random rand = new Random();

        //easy 10 to 30 exclusive
        st.put((StdRandom.uniform(10,30)), new Pet("Buddy",8,"dog"));

        addPet(st, new Pet("Bobo", 50, "tortise"));
        addPet(st, new Pet("Hazel", 4, "rat"));
        addPet(st, new Pet("Smokey", 5, "goldfish"));
        addPet(st, new Pet("Bella", 5, "cat"));
        addPet(st, new Pet("Leo", 9, "tortoise"));
        addPet(st, new Pet("Garfield", 6, "cat"));
        addPet(st, new Pet("Maddox", 2, "dog"));
        addPet(st, new Pet("Sylvester", 7, "cat"));
        addPet(st, new Pet("Wold", 9, "dog"));
        addPet(st, new Pet("Stolch", 3, "dog"));

        StdOut.print("= = = = = = = All pet names = = = = = = =\n|");
        for(Integer id : st.keys()){
            StdOut.printf(" %s ( %d ) |", st.get(id).getName(), id);
        }

        StdOut.println("\n\n= = = = = Testing Keys In Array = = = = =");
        StdOut.printf("10 is a key in the symbol table: %b \n", st.contains(10));
        StdOut.printf("17 is a key in the symbol table: %b \n", st.contains(17));
        StdOut.printf("23 is a key in the symbol table: %b \n", st.contains(23));

        StdOut.println("\n= = = = = Smallest Key In Array = = = = =");
        StdOut.printf("The smallest key is %d!\n", st.min());

        StdOut.println("\n= = = = Ceiling of 17 In Array = = = = =");
        StdOut.printf("Smallest key greater than 17 is %d!\n", st.ceiling(17));

        StdOut.println("\n= = = = Number of Pets In Array = = = = ");
        StdOut.printf("The number of pets in the array is %d!\n", st.size());

        //Add a 3-year-old dog named Waldi with pet ID 30 to the symbol table.
        st.put(30, new Pet("Waldi", 2, "dog"));

        StdOut.print("\n= = = = = Updated pet names = = = = = =\n|");
        for(Integer id : st.keys()){
            StdOut.printf(" %s ( %d ) |", st.get(id).getName(), id);
        }

        //"Find the number of pet IDs that are smaller than 25."
        StdOut.println("\n\n= = = = = Rank of 25 In Array = = = = =");
        StdOut.printf("Number of Pet-IDs that are smaller than 25: %d!\n", st.rank(25));

        //Print the pet with the pet ID 30.
        StdOut.println("\n= = = = Pet-ID 30 In The Array = = = = =");
        StdOut.printf("Pet-ID #30 is %s!\n", st.get(30).getName());

        //Find the second smallest pet ID and print the corresponding pet.
        StdOut.println("\n= = = 2nd Smallest Pet-ID In The Array = = =");
        StdOut.printf("The second smallest key is %d, %s!\n", st.select(1),st.get(st.select(1)).getName());

        //Change the pet that is associated with the pet ID 30.
        //It should no longer be called Waldi but Strolch instead.
        st.put(30, new Pet("Strolch", 2, "dog"));

        StdOut.println("\n= = = = New Pet-ID 30 In The Array = = = =");
        StdOut.printf("Pet-ID #30 is %s!\n\n", st.get(30).getName());
        StdOut.println(printPetTable());
    }
    public static void addPet(BinarySearchST st, Pet newPet){
        Integer newRandInt  = (StdRandom.uniform(10,30));
        while(st.contains(newRandInt)){
            newRandInt  = (StdRandom.uniform(10,30));
        }
        st.put(newRandInt, newPet);
    }

    public static String printPetTable(){
        StringBuilder sb = new StringBuilder();
        sb.append("|======================================| \n");
        sb.append("| Pet-ID |    Name    | Age |  Species |\n");
        sb.append("|--------------------------------------| \n");
        for (Integer id : st.keys()) {
            sb.append(String.format("|   %d   | %10s |  %02d | %8s | \n",
                    id, st.get(id).getName(), st.get(id).getAge(), st.get(id).getSpecies()));
        }
        return sb.toString();
    }
}
