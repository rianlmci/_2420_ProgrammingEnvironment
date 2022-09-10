package a01;
/**
 * Coding challenges for assignment A01 part2.
 * 
 * @author CSIS Starter Code + ....... (Rianna McIntyre)
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

		//if argument is empty or null, return 0;

		if(array == null || array.length == 0){
			return 0;
		}

		//If array has any elements less than zero, throw exception.

		for (int i = 0; i < array.length; i++) {
			if(array[i] < 0){
				throw new IllegalArgumentException("Numbers passed to this function need to be positive");
			}
		}

		//if array is only one number and equal to goal, return 1;
		if(array[0] == sum){
			return 1;
		}

		//Checking Valid Sequence:
		int sumCount = 0;
		int sequenceCountLowest = (array.length + 1);
		int currentSequenceCount = 0;
		for(int i = 0; i < array.length; i++){
			//System.out.println("Counting from " + array[i]);
			sumCount = 0;
			currentSequenceCount = 0;
			for(int j = i; j < array.length; j++){
				if (sumCount != sum) {
					/*System.out.println(
							"adding value of j: " + array[j] +
							" and the current sum: " + sumCount +
							" gives us " + (array[j] + sumCount));
					*/
					sumCount = array[j] + sumCount;
					currentSequenceCount += 1;
				}

				else if(sumCount == sum){
					/*System.out.println("A sum match has been found! " +
							"It was from " + array[i] + " to " + array[j] +
							" and the sequence length was " + currentSequenceCount +".");
					 */
					j = array.length;
					if (currentSequenceCount < sequenceCountLowest)
					//System.out.println("It was a new record low!");
					sequenceCountLowest = currentSequenceCount;
				}
			}
		}
		if (sequenceCountLowest == (array.length + 1) ){
			sequenceCountLowest = 0;
		}
		return sequenceCountLowest;
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
	public static int[][] doubleValues(int[][] array2d) {

		//Check if array2d is empty
		if (array2d.length == 0){
			throw new IllegalArgumentException("This array must not be empty!");
		}

		//Multiplying valid array.
		for (int i = 0; i < array2d.length; i++) {
			for(int j = 0; j < array2d[i].length; j++){
				array2d[i][j] = (2 * array2d[i][j]);
			}
		}
	return array2d;
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
		//Checking if matrix is empty or null
		if(matrix == null || matrix.length == 0){return false;}

		//Checking if matrix is rectangular...
		int properElementLength = matrix[0].length;
		for (int i = 0; i < matrix.length; i++) {
			int elementCounter = 0;
			for (int j = 0; j < matrix[i].length; j++) {elementCounter += 1;}
			if(elementCounter != properElementLength){
				throw new IllegalArgumentException("This array is not rectangular");
			}
		}

		//Checking for the golden ticket!
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				//finding the first G...
				if(matrix[i][j] == 'G'){
					//checking the next G, if it exists
					if((j+1) < matrix[i].length){
						if(matrix[i][j+1] == 'G'){
							//Checking the next two rows for double Gs,
							//first check if we go out of bounds looking down..
							if((i + 2) < matrix.length){
								//Finally, Check the next two rows for double Gs at the index locations..
								if(matrix[i+1][j] == 'G' && matrix[i+1][j+1] == 'G'
										&& matrix[i+2][j] == 'G' && matrix[i+2][j+1] =='G'
								){
									return true;
								}
							}
						}
					}
				}
			}

		}
		return false;
	}

	//= = = TEST CLIENT = = =//
	public static void main(String[] args){

		//TESTS FOR minNumberOfAddends()

		/*
		System.out.println("Min number of addends for array {2, 10, 4, 8, 1, 22, 5, 16, 2} with sum of 23 returns "
				+ minNumberOfAddends(new int[] {2, 10, 4, 8, 1, 22, 5, 16, 2}, 23) + ".");
		 */

		/*
		System.out.println("Min number of addends for array {1, 7, 4, 0} with sum of 5 returns "
				+ minNumberOfAddends(new int[] {1, 7, 4, 0}, 5) + ".");
		 */

		/*
		System.out.println("Min number of addends for array {} with sum of 1 returns "
				+ minNumberOfAddends(new int[] {}, 1) + ".");
		 */

		/*
		System.out.println("Min number of addends for null array with sum of 1 returns "
				+ minNumberOfAddends(null, 1) + ".");
		 */

		/*
		System.out.println("Min number of addends for an array with negative numbers and a sum of 1 returns "
				+ minNumberOfAddends(new int[] {1, 7, -4, 0}, 1) + ".");
		 */

		//TESTS FOR doubleValues()
		/*
		int [] [] testArray = {{3,4,1},{6,8,2}};
		System.out.println("Sending in " + Arrays.deepToString(testArray)+ " returns " + Arrays.deepToString(doubleValues(testArray)) + ".");
		 */

		/*
		int [] [] testArray = {{},{}};
		doubleValues(testArray);
		 */

		/*
		doubleValues(null);
		 */
		//TESTS FOR goldenTicket()

		/*
		char [] [] testArray= {};
		goldenTicket(testArray);
		 */

		/*
		char [] [] testArray= null;
		goldenTicket(testArray);
		*/

		/*
		char [] [] testArray= {
				{'G','G'},
				{'G','G'},
				{'G','G'}
		};
		System.out.println("Golden ticket status returns... " + goldenTicket(testArray) + "!");
		 */

		/*
		char [] [] testArray= {
				{'A', 'b', '-', '-', 'C','d', 'm'},
				{'-', 'G', 'G', 'Z', 'G', 'G', '-'},
				{'H', 'o', '-', 'r', 'G', 'G', 'D'},
				{'H', 'o', '-', 'r', 'G', 'G', 'D'}
		};
		System.out.println("Golden ticket status returns... " + goldenTicket(testArray) + "!");
		 */

		/*
		char [] [] testArray= {
				{'R', 'g', 'G', '-', 'C','d', 'm', 'W'},
				{'-', 'G', 'G', 'Z', 'G', 'G', '-', 'r'},
				{'o', 'G', 'G', 'G', 'r', 'G', 'G','D'},
				{'S', 't', 'C', '-', 'G', 'G', 'a', '-'}
		};
		System.out.println("Golden ticket status returns... " + goldenTicket(testArray) + "!");
		 */

		//FAILED TESTS TO FIX
		/* = = = 1 = = = */

		/*
		char [] [] testArray= {
				{'R', 'G', 'G',},
				{'-', 'G', 'G'}
		};
		System.out.println("Golden ticket status returns... " + goldenTicket(testArray) + "!");
		 */

		/* = = = 2 = = = */
		/*
		char [] [] testArray = null;
		System.out.println("Golden ticket status returns... " + goldenTicket(testArray) + "!");
		 */

		/* = = = 3 = = = */
		/*
		char [] [] testArray = {};
		System.out.println("Golden ticket status returns... " + goldenTicket(testArray) + "!");
		 */

		/* = = = 4 = = = */
		/*System.out.println("Min number of addends for array {5} with sum of 5 returns "
				+ minNumberOfAddends(new int[] {5}, 5) + ".");
		 */
	}

} 
