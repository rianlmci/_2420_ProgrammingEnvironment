package ceLinearBinary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * //TODO
 */
public class Search {
    /**
     * Determines the index of the first occurrence of the key
     * If the key is not in array, method returns -1
     * If array or key are null, NullPointerException
     * should be thrown.
     * @param array
     * @param key element to find in array
     * @return index of the first occurance of the key
     * or -1 is not in the array
     * @throws NullPointerException if array or key are null
     * (SCHOOL TIP: check if null is thrown w/o you coding it in first U Professors get mad)
     */
    //recall <T> is wildcard
    public static <T> int linear(T[] array, T key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(key)) return i;
        }
        return -1;
    }

    /**
     * Determines the index of the first occurrence of the key
     * If the key is not in array, method returns -1
     * @param array sorted array
     * @param key element to find in array
     * @return index of the first occurance of the key
     * or -1 is not in the array
     * @throws NullPointerException if array or key are null
     * (SCHOOL TIP: check if null is thrown w/o you coding it in first U Professors get mad)
     */
    public static int binary(String[] array, String key) {

        /*
        * I knew about collections.sort and .contains
        * I googled "search through collection java" ...
        * I just wanted to see if there were search methods already existing.
        * and I think I learned a little more than I should have for the point of this exercise.
        * that's how I found out a binary search method already exists. Oops.
        * I also learned that arrays can do a lot of methods that lists can.
        * And figured it would be cleaner to cast the variable rather than declare a new list.
        * I also figured it would be more efficient than using a loop.
        * I'm sorry.
        */

        Arrays.sort(array);
        if(Arrays.asList(array).contains(key)) {
            return Arrays.binarySearch(array, key);
        }
    return -1;
    }

    //= = = TEST CLIENT = = =//
    public static void main(String[] args){
        String [] binaryTest = new String[] {"d","c","b","a"};
        System.out.println("Binary test values: " + Arrays.toString(binaryTest));
        System.out.println("Searching for key d..");
        System.out.println("Expected: 3");
        System.out.println("Actual: " + binary(binaryTest, "d"));

        binaryTest = new String [] {"4","c", "2", "a"};
        System.out.println("- - - -");
        System.out.println("Binary test values: " + Arrays.toString(binaryTest));
        System.out.println("Searching for key 2..");
        System.out.println("Expected: 0");
        System.out.println("Actual: " + binary(binaryTest, "2"));
    }
}
