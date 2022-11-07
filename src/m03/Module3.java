package m03;

import edu.princeton.cs.algs4.BinarySearchST;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Random;

/**
 * Module 3 test classes.
 * For Fall 2022 CSIS 2420.
 * @author Rianna McIntyre
 */
public class Module3 {
    private static Random rand = new Random();

    /**
     * Creates an array containing strings of
     * 9 lowercase letters in each index.
     * @param size desired for the array
     * @return a string array cotaining random letter strings
     */
    private static String[] getRandomStrings(int size) {
        String[] strings = new String[size];


        for(int i = 0; i < size; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 9; j++) {
                sb.append((char) (('a') + rand.nextInt(26)));
            }
            strings[i] = sb.toString();
        }
        return strings;
    }

    /**
     * Creates a symbol table containing lower cast letters as keys
     * and a random string of 9 lowercase letters as the value
      * @return the described symbol table.
     */
    private static BinarySearchST<String, String> getSymbolTable(){
        String [] oneHundredKRandStrings = getRandomStrings(100_000);
        String [] lowerAlphaStrings = new String[26];

        /*
        Create a symbol table and add 26 strings
        that include one lower-case letter ("a", "b", "c", ... "z")
        as key
        */
        for (int i = 0; i < 26; i++) {
            lowerAlphaStrings[i] = String.valueOf((char)(('a') + i));
        }

        /*
        Associate each of the keys with an element from the array you just created as follows:
        * "a" is associated with the largest value in the random number array
        * "b" is associated with the second-largest value
        * "c" is associated with the third-largest value
        * and so on
        * "z" is associated with the twenty-sixth largest value
        */
        Arrays.sort(oneHundredKRandStrings);
        BinarySearchST<String,String> alphaRandTable = new BinarySearchST<>();
        int lowerAlphaIterator = 0;
        for (int i = oneHundredKRandStrings.length -1; i >= oneHundredKRandStrings.length - 26; i--) {
            alphaRandTable.put(lowerAlphaStrings[lowerAlphaIterator++],oneHundredKRandStrings[i]);
        }
        return alphaRandTable;
    }

    // = = = = = = TEST CLIENT = = = = = = //
    public static void main (String args []){

        /*
        * Print all keys and their corresponding values. Each key should
        * be listed in a separate line and followed by a colon,
        * a space, and the associated value as shown in the sample output.
        */
        System.out.println("Symbol Table:");
        BinarySearchST<String,String> st = getSymbolTable();
        for (String s : st.keys()) {
            StdOut.println(s + ": " + st.get(s));
        }

        /*
        * Use a method of class BinarySearchST to remove the smallest key from the
        * symbol table. Print a statement to inform the user that the smallest key
        * has been removed.
        */
        System.out.printf(
                "\nThe smallest key-value has been removed, %s: %s!\n",
                st.min(), st.get(st.min())
        );
        st.delete(st.min());

        /*
        * Use a method of class BinarySearchST to determine the number of key-value pairs
        * in the symbol table and print it.
        */
        System.out.printf("Number of key-value pairs: %d.\n", st.size());

        /*
        * Create a string variable called randomLetter;
        * randomly assign it (at runtime) one of the four letters d, e, f, or g, and print it.
        */
        String randomLetter = String.valueOf((char)(('d') + StdRandom.uniform(0,4)));
        System.out.println("random letter: " + randomLetter);
        System.out.printf("Number of keys smaller than %s: %d", randomLetter, st.rank(randomLetter));
    }
}
