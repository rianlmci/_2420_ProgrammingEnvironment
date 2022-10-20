package ceQuick;

import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.Selection;

import java.util.Random;

/**
 * Shows timing comparisons of how long it takes different sorting
 * algorithms to sort random number arrays of different sizes.
 * @author Rianna McIntyre
 */
public class sortComparison {
    public static void main(String args[]){
        System.out.println("||= = = = = = = = = = TIMING TESTS = = = = = = = = = ||");
        System.out.println("|| Elements:   QuickSort Time:   SelectionSort Time: ||");
        System.out.print(  "||---------------------------------------------------||");
        System.out.print(recursiveArrayTestPrinter(new StringBuilder(), 150, 0, 10).toString());
        //for github.
    }

    /**
     * Creates an array of the specified <code>size</code>
     * that is filled with a random 7-digit number.
     * @param size
     * @return
     */
    private static Integer[] getRandomNumberArray(int size){
        Random myRandom = new Random();
        Integer[] randArray = new Integer[size];
        for (int i = 0; i < size; i++) {
            randArray[i] = myRandom.nextInt(9_000_000) + 1_000_000; //margret's solution
        }
        return randArray;
    }

    /**
     * Builds information to display to the user about how much time a sort will take if we double it.
     * @param myBuilder string we build.
     * @param doubledArraySize size of the random number array.
     * @param doubleIncrement counter of how many times we doubled so far (start with 0).
     * @param doubleStop how many times we want to double the size of the initial random number array.
     * @return Information about time taken to sort & contents of each number array.
     */
    public static StringBuilder recursiveArrayTestPrinter(StringBuilder myBuilder, int doubledArraySize, int doubleIncrement,int doubleStop){
        Integer randArray [] = getRandomNumberArray(doubledArraySize);
        double BILLION = 1_000_000_000; //underscores = commas!

        //base case
        if(doubleIncrement == doubleStop + 1){
            return myBuilder;
        }

        //= = = = QUICK SORT CALCULATION = = = =
        Integer qSortArray [] = randArray;
        long qStartTime = System.nanoTime(); //start time for QuickSort
        Quick.sort(qSortArray);
        long qEndTime = System.nanoTime(); //end time for QuickSort


        //= = = = SELECT SORT CALCULATION = = = =
        Integer sSortArray [] = randArray;
        long sStartTime = System.nanoTime(); //start time for SelectionSort
        Selection.sort(sSortArray);
        long sEndTime = System.nanoTime(); //end time for SelectionSort

        //= = = = INFO PRINTING = = = =
        myBuilder.append(String.format("\n|| %9d |  %8.4f seconds |  %8.4f seconds ||",
                doubledArraySize,
                (qEndTime- qStartTime)/BILLION,
                (sEndTime- sStartTime)/BILLION)
        );

        //Recursion calculation below ...
        doubleIncrement++;
        doubledArraySize = (doubledArraySize*2);
        return(recursiveArrayTestPrinter(myBuilder,doubledArraySize,doubleIncrement,doubleStop));
    }
}
