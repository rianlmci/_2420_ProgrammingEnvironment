package m02;

import java.util.Arrays;

import ceStable.Song;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdRandom;

/**
 * CSIS 2420 Midterm2 Challenge - (Fall 2022)
 * 
 * @author CSIS Starter Code + Rianna McIntyre
 *
 */
public class Module2 {

	// = = = = TEST CLIENT = = = = //
	public static void main(String[] args) {
		measureTime();
		System.out.println();
		displayFriends();
	}

	/**
	 * Creates an array of the specified <code>size</code> that is filled with
	 * random 7-digit numbers that are
	 * [5 million, one billion) and <b>even</b>!
	 * @param size number of elements in the array.
	 * @return array of random 7-digit numbers.
	 */
	private static Integer[] getRandomNumberArray(int size)
	{
		final Integer FIVEMILLION = 5_000_000;
		final Integer ONEBILLION = 1_000_000_000;
		Integer[] numbers = new Integer[size];

		for (int i = 0; i < size; i++) {
			Integer newNum = 3;
			while(newNum % 2 != 0){ /*while newNum is ODD*/
				newNum = StdRandom.uniform(FIVEMILLION, ONEBILLION);
			}
			numbers[i] = newNum;
		}
		return numbers;
	}
	
	/**
	 * Prints info about this following test:
	 * Measures the time it takes to sort arrays of n size using
	 * the quicksort algorithm.
	 * Each test iteration doubles the number of elements.
	 */
	private static void measureTime() {
		int n = 3000;
		int BILLION = 1_000_000_000;
		System.out.println("Measure Time");
		System.out.println("------------");

		for (int i = 0; i < 10; i++) {
			int [] topFive = new int[5];
			int topFiveDecrementer = 4;
			Integer[] numbers = getRandomNumberArray(n);

			//Measure time to sort an array with n elements,
			//and then add those top 5 elements to an array
			long start = System.nanoTime();
			Quick.sort(numbers);
			for (int j = numbers.length - 5; j < numbers.length; j++) {
				topFive[topFiveDecrementer--] = numbers[j];
			}
			double elapsedTime = System.nanoTime() - start;
			System.out.printf("n: %7d %7.4f s %n", n, (elapsedTime / BILLION));
			n *= 2;
		}
	}
	/**
	 * ============================================================================================
	 * FROM THE DIRECTIONS:
	 * "State which of the following two categories best describes the time complexity of the task.
	 * (identifying the 5 largest numbers and storing them in the array)
	 * category A) quadratic time complexity // O(N²)
	 * category B) linear or linearithmic time complexity // O(N) or O(N log N)"
	 * ============================================================================================
	 * RIANNA'S ANSWER:
	 * The complexity of this task is category B) it behaves linearithmically, O(N log N), where the time more than
	 * doubles when the array size is doubled!
	 */

	/**
	 * Displays friends in different orders:
	 * It should be able to sort by Age
	 * and then by name.
	 * The age sort will be alpha AND numeric (stable sorted).
	 */
	private static void displayFriends() {
		Friend[] friends = {
				new Friend("Max", 26), new Friend("Gus", 24), new Friend("Kai", 22), 
				new Friend("Ben", 20), new Friend("Dan", 22), new Friend("Pia", 28), 
				new Friend("Eli", 24), new Friend("Zoe", 20), new Friend("Hye", 26), 
				new Friend("Ivy", 22), new Friend("Joy", 22), new Friend("Ann", 24), 
				new Friend("Sam", 22), new Friend("Rex", 28), new Friend("Leo", 20), 
		};
		
		System.out.println("Display Friends");
		System.out.println("---------------");
		
		System.out.println("Friends:");
		for (Friend f : friends) {
			System.out.print(f + " ");
		}
		System.out.println("\n");

		System.out.println("Friends sorted by name:");
		Arrays.sort(friends);
		for (Friend f : friends) {
			System.out.print(f + " ");
		}
		System.out.println("\n");

		System.out.println("Friends sorted by age:");
		Insertion.sort(friends, Friend.BY_AGE);
		for (Friend f : friends) {
			System.out.print(f + " ");
		}
		System.out.println();

	}
}
