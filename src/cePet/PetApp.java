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

        for(Integer id : st.keys()){
            StdOut.println(id + " "+ st.get(id));
        }
    }
    public static void addPet(BinarySearchST st, Pet newPet){
        Integer newRandInt  = (StdRandom.uniform(10,30));
        while(st.contains(newRandInt)){
            newRandInt  = (StdRandom.uniform(10,30));
        }
        st.put(newRandInt, newPet);
    }
}
