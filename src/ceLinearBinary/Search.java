package ceLinearBinary;

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
        return 0; //TODO
    }
}
