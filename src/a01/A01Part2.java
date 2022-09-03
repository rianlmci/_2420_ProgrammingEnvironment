package a01;

/**
 * Coding challenges for assignment A01 part2.
 * 
 * @author CSIS Starter Code + ....... (add your name here)
 *
 */
public class A01Part2 {
	
	/**
	 * Finds the shortest sequence of consecutive array elements that add up to 
	 * the specified sum and returns the length of that sequence. 
	 * If no such sequence is found, the method returns 0.    
	 * <p>
	 * E.g., [2, 10, 4, 8, 1, 22, 5, 16, 2] and sum = 23 returns 2
	 * This example has three sequences that add up to 23: 10_4_8_1, 1_22, and 5_16_2.
	 * Since 1_22 is the shortest sequence, the method returns 2.
	 * E.g., [1, 7, 4, 0] and sum = 5 returns 0 because no sequence 
	 * of consecutive array elements adds up to 5.
	 * <p>
	 * All array elements need to be positive or zero. If the array includes a negative number,
	 * an IllegalArgumentException should be thrown.
	 * <p>
	 * Special cases:
	 * If the array is empty or if the user passes null as the first argument, the 
	 * method should return 0.       
	 * 
	 * @param array
	 * @param sum 
	 * @return the minimum number of consecutive addends to calculate the specified sum. 
	 * @throws IllegalArgumentException if the array includes one or more negative numbers.
	 */
	public static int minNumberOfAddends(int[] array, int sum) {
		return 0;  // TODO
	}

	/**
	 * Changes the two-dimensional array by multiplying each value with 2.
	 * E.g., [3, 4, 1]                 [6, 8, 2]
	 *       [4, 0, 2, -2] changes to  [8, 0, 4, -4]
	 *       [1, 4]                    [2, 8]
	 * <p>
	 * Special cases:
	 * If the two-dimensional array is empty, an IllegalArgumentException should be thrown. 
	 * If the user passes null as an argument, a NullPointerException should be thrown. 
	 * 	 
	 * @param array2d
	 * @throws IllegalArgumentException if the array is empty.
	 * @throws NullPointerException if the argument is null.
	 */
	public static void doubleValues(int[][] array2d) {
		// TODO
	}
	
	/**
	 * Determines whether the matrix includes a golden ticket. 
	 * A golden ticket consists of 6 upper-case 'G' where three pairs of 'G's are aligned 
	 * above each other as shown below. 
	 * Note that the example leaves out the single quotes for easier readability.
	 * 
	 * G G
	 * G G
	 * G G
	 * <p>
	 * E.g., [A b - - C d m]  
	 *       [- G G Z G G -] 
	 *       [H o - r G G D]   this matrix returns true
	 *       [H o - r G G D]
	 *       
	 * E.g., [R g G - C d m W]  
	 *       [- G G Z G G - r]   this matrix returns false
	 *       [o G G G r G G D]   because the 'G's are not in the specified position
	 *       [S t C - G G a -]   relative to each other. Lower-case 'g's don't count.
	 * <p>
	 * The matrix should be 'rectangular', which means, all rows should have 
	 * the same number of elements. If that is not the case, an IllegalArgumentException 
	 * should be thrown.
	 * <p>
	 * Boundary cases:
	 * If the two-dimensional array is empty or the user passes null as an argument, the
	 * method should return false. 
	 * 
	 * @param matrix
	 * @throws IllegalArgumentException if the rows vary in length.
	 */
	public static boolean goldenTicket(char[][] matrix) {
		return false;  // TODO
	}

} 
