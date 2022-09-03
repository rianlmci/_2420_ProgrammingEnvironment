package a01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Coding challenges for assignment A01 part1.
 * 
 * @author CSIS Starter Code + ....... (Rianna McIntyre)
 *
 */
public class A01Part1 {
	
	/**
	 * Returns a new array that includes every other number starting with the first.
	 * E.g., [10, 20, 30, 40, 50, 60] returns [10, 30, 50]
	 * E.g., [10] returns [10]
	 * <p>
	 * Boundary cases:
	 * If the array is empty, an empty array should be returned. 
	 * If the user passes null as an argument, the method should return null.
	 * 
	 * @param numbers original array of whole numbers
	 * @return array that includes every other number starting with the first
	 */
	public static int[] everyOther(int[] numbers) {
		if (numbers == null){return null;}

		else if(numbers.length <= 1){return numbers;}

		else{
			ArrayList <Integer> everyOtherNumberBuilder = new ArrayList <Integer>();
			for (int i = 0; i < numbers.length; i += 2){
				if (i == 0){everyOtherNumberBuilder.add(Integer.valueOf(numbers[i]));}

				else if (i < numbers.length){everyOtherNumberBuilder.add(Integer.valueOf(numbers[i]));}
			}

			/*
			* From:
			* https://stackoverflow.com/questions/718554/how-to-convert-an-arraylist-containing-integers-to-primitive-int-array
			*/

			return numbers = everyOtherNumberBuilder.stream().mapToInt(i -> i).toArray();
		}

	}
	
	/**
	 * Returns a new array that includes commas as thousands separators.
	 * E.g., ['7', '6', '5', '4', '3', '2', '1'] returns ['7', ',', 6, 5, 4, ',', 3, 2, 1] 
	 * E.g., ['5', '3', '6'] returns ['5', '3', '6']
	 * <p>
	 * Boundary cases:
	 * If the array is empty, an empty array should be returned. 
	 * If the user passes null as an argument, the method should return null.
	 * 
	 * @param digits original array of digits
	 * @return new array that includes commas as thousands separators.
	 * @throws IllegalArgumentException if the array <code>digits</code> includes
	 * any characters that are not digits.
	 */
	public static char[] addSeparators (char[] digits) {
		if (digits == null){return null;}

		for(int i= 0; i < digits.length; i++){
			if(!Character.isDigit(digits[i])){throw new IllegalArgumentException();}
		}

		if (digits.length <= 3){return digits;}

		else {
			ArrayList<Character> digitsArrayList = new ArrayList<Character>();

			for (int i = digits.length; i >= 0; i -= 3) {
				if(i <= 3) {
					switch(i){
						case 1:
							digitsArrayList.add(digits[i-1]);
							break;
						case 2:
							digitsArrayList.add(digits[i-1]);
							digitsArrayList.add(digits[i-2]);
							break;
						case 3:
							digitsArrayList.add(digits[i-1]);
							digitsArrayList.add(digits[i-2]);
							digitsArrayList.add(digits[i-3]);
							break;
					}
				}

				else if ((i - 3) < digits.length-1) {
					digitsArrayList.add(digits[i-1]);
					digitsArrayList.add(digits[i-2]);
					digitsArrayList.add(digits[i-3]);
					digitsArrayList.add(',');
				}
			}

			Collections.reverse(digitsArrayList);

			/*
			* From:
			* https://stackoverflow.com/questions/21346830/how-to-convert-an-arraylist-of-characters-to-an-array-of-chars
			*/

			digits = new char[digitsArrayList.size()];
			for(int i = 0; i < digitsArrayList.size(); i++) {
				digits[i] = digitsArrayList.get(i);
			}
		}
		return digits;
	}

	/**
	 * Determines whether the order of the elements in the array from front to back
	 * is the same as the order of the elements from back to front.
	 * E.g., ['r', 'a', 'c', 'e', 'c', 'a', 'r'] returns true
	 * E.g., ['D', 'a', 'd'] returns false (case matters)
	 * E.g., [10, 20] returns false
	 * E.g., ["hello"] returns true (a single element is a palindrome)
	 * 
	 * @param array
	 * @return true if the array is a palindrome and false otherwise
	 * @throws IllegalArgumentException if the array includes no elements or
	 * if the argument passed to the method is null.
	 */
	public static <T> boolean isPalindrome(T[] array) {
		if(array == null || array.length == 0){
			throw new IllegalArgumentException();
		}

		ArrayList<T> list = new ArrayList<> (Arrays.asList(array));
		ArrayList<T> reversedList = new ArrayList<>(Arrays.asList(array));
		Collections.reverse(reversedList);

		if(reversedList.equals(list)){
			return true;
		}
		return false;
	}

	//= = = TEST CLIENT = = =//
	public static void main(String[] args){
		System.out.println("Hello Friend");
	}
} 
