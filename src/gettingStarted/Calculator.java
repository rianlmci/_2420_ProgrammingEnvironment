package gettingStarted;

/**
 * Simple calculator that can add and subtract whole numbers.
 * It can also calculate the absolute value.
 * 
 * @author CSIS Starter Code
 *
 */
public class Calculator {
	
	/**
	 * Adds the numbers <code>a</code> and <code>b</code>.
	 * 
	 * @param a first addend
	 * @param b second addend
	 * @return sum of a and b
	 */
	public static int add(int a, int b) {
		return a + b;
	}
	
	/**
	 * Subtracts the number <code>b</code> from the number <code>a</code>.
	 * 
	 * @param a minuend
	 * @param b subtrahend
	 * @return difference between a and b
	 */
	public static int subtract(int a, int b) {
		return a - b;
	}
	
	/**
	 * Determines the absolute value of the argument <code>n</code>.
	 * If <code>n</code> is negative, the negation of <code>n</code> is returned. 
	 * Otherwise, <code>n</code> is returned.
	 * 
	 * @param n number
	 * @return absolute value of n
	 */
	public static int abs(int n) {

		return (n < 0 ) ? -n : n;

	}
}
