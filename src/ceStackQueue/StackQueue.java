package ceStackQueue;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;


/**
 * CE Stack Queue Part 2
 * Exercise to practice the use of stacks and queues.
 * 
 * @author CSIS 2420 Starter Code
 *
 */
public class StackQueue {
	/* Review: programming to an interface: (Inheritance, polymorphism)
	* List <String> myList = new ArrayList<>();
	* List <String> changeElementstoUpper(List<String> list)
	* How do I return a list? An arraylist IS a list!
	* List<String> upperCaseList = new ArrayList<>();
	* for loop to add to that array list
	* return upperCaseList!
	 */
	/**
	 * Performs the following transformations:
	 * Replaces the characters '1' with 'i'
	 * Removes characters that are not letters
	 * Removes upper-case letters
	 * 
	 * Example: [9 h ; e l # A l D 0 o . ] => [h e l l o ]
	 * 
	 * @param q
	 * @return transformed input
	 */
	private static Iterable<Character> transformationA(Queue<Character> q) {
		Queue<Character> returnQueue = new Queue<>();
		//stacks are very good at reversing things!
		for (Character oneQ : q) {
			if(Character.isLowerCase(oneQ)) {returnQueue.enqueue(oneQ);}
			else if(oneQ.compareTo('1') == 0){returnQueue.enqueue('i');}
		}
		return returnQueue; //(return a stack or a queue)
	}
	

	/**
	 * Performs the following transformations:
	 * Duplicate all slashes and backslashes ( / and  \ )
	 * Add the reversed (transformed) character sequence to the end. 
	 * 
	 * Example: [. / ^ \ ~ ] => [. / / ^ \ \ ~ ~ \ \ ^ / / . ]
	 * 
	 * @param q
	 * @return transformed input
	 */
	private static Iterable<Character> transformationB(Queue<Character> q) {
		Queue<Character> returnQueueNoFlip = new Queue<>();
		Stack<Character> returnStack = new Stack<>();
		for (Character oneQ: q) {
			if (oneQ == '/'){
				returnQueueNoFlip.enqueue('/');
				returnQueueNoFlip.enqueue('/');
			}
			else if (oneQ =='\\'){
				returnQueueNoFlip.enqueue('\\');
				returnQueueNoFlip.enqueue('\\');
			}
			else returnQueueNoFlip.enqueue(oneQ);
		}
		Queue<Character> returnQueue = returnQueueNoFlip;
		for (Character oneS: returnQueueNoFlip) {
			returnStack.push(oneS);
		}

		while(!returnStack.isEmpty()){
			returnQueue.enqueue(returnStack.pop());
		}
		return returnQueue;
	}
	
	public static void main(String[] args) {
		Queue<Character> inputQueue = new Queue<>();
		for(Character c : new Character[] {'9', 'h', ';', 'e', 'l', '#', 'A', 'l', 'D', '0', 'o', '.'}) {
			inputQueue.enqueue(c);
		}
		testTransformA(inputQueue);
		
		inputQueue = new Queue<>();
		for(Character c : new Character[] {'f', 'R', 'e', '!', 'P', 'l', '1', 'c', '1', 'D', '5', 't', ';', 'y'}) {
			inputQueue.enqueue(c);
		}
		testTransformA(inputQueue);
		
		Queue<Character> emptyQueue = new Queue<>();
		for(Character c : new Character[0]) {
			emptyQueue.enqueue(c);
		}
		testTransformA(emptyQueue);
		
		inputQueue = new Queue<>();
		for(Character c : new Character[] {'.', '/', '^', '\\', '~'}) {
			inputQueue.enqueue(c);
		}
		testTransformB(inputQueue);
		
		inputQueue = new Queue<>();
		for(Character c : new Character[] {'/', 'A', '|', 'A', '\\', 'o'}) {
			inputQueue.enqueue(c);
		}
		testTransformB(inputQueue);
		
		testTransformB(emptyQueue);
	}

	private static void testTransformA(Queue<Character> queue) {
		StdOut.println("TransformA (input: [" + queue + "])");
		StdOut.print("output: [");
		for (Character c : transformationA(queue)) {
			StdOut.print(c + " "); 
		}
		StdOut.println("]\n");
	}
	
	private static void testTransformB(Queue<Character> queue) {
		StdOut.println("TransformB (input: [" + queue + "])");
		StdOut.print("output: [");
		for (Character c : transformationB(queue)) {
			StdOut.print(c + " "); 
		}
		StdOut.println("]\n");
	}
}
