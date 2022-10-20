package ceQuick;

import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.Selection;

import java.util.Random;

public class sortComparison {
    public static void main(String args[]){
        System.out.print(recursiveArrayTestPrinter(new StringBuilder(), 7, 0, 5).toString());
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
            //randArray[i] = (int)((Math.random()*10 + 1000000)); //our solution
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

        myBuilder.append("\n \n = = = Sorting Number #" + (doubleIncrement+1) + " = = =");
        myBuilder.append("\n\nSorting of " + randArray.length + " digit number...");

        //= = = = QUICK SORT INFO = = = =
        Integer qSortArray [] = randArray;
        long startTime = System.nanoTime(); //start time for QuickSort
        Quick.sort(qSortArray);
        myBuilder.append(String.format("\n \nQuick sorting time: %.4f seconds.",
                ((System.nanoTime()-startTime)/BILLION)));

        //= = = = SELECT SORT INFO = = = =
        Integer sSortArray [] = randArray;
        startTime = System.nanoTime(); //start time for QuickSort
        Selection.sort(sSortArray);
        myBuilder.append(String.format("\nSelect sorting time: %.4f seconds.",
                ((System.nanoTime()-startTime)/BILLION)));

        //Recursion calculation below ...
        doubleIncrement++;
        doubledArraySize = (doubledArraySize*2);
        return(recursiveArrayTestPrinter(myBuilder,doubledArraySize,doubleIncrement,doubleStop));
    }
}
