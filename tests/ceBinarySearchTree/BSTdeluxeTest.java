package ceBinarySearchTree;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * JUnit test cases for CE BST CODE.
 * This test class should not be modified.
 * 
 * @author CSIS 2420
 *
 */
class BSTdeluxeTest {
	private BSTdeluxe<Character, String> bst1 = new BSTdeluxe<>();
	private BSTdeluxe<Character, String> bstEmpty = new BSTdeluxe<>();
	private BSTdeluxe<Character, String> bst12 = new BSTdeluxe<>();
	private BSTdeluxe<Character, String> bst16 = new BSTdeluxe<>();	
	
	private BSTdeluxe<Integer, Integer> bstNumbers = new BSTdeluxe<>();
	
	public BSTdeluxeTest() {
		bst1.put('X', "");
		
		char[] bst12Keys = {'O', 'A', 'B', 'H', 'S', 'W', 'M', 'U', 'V', 'T', 'K', 'F'};
		initBSTdeluxe(bst12, bst12Keys);
		
		char[] bst16Keys = {'L', 'N', 'W', 'T', 'H', 'G', 'A', 'Z', 'I', 'S', 'V', 'P', 'X', 'O', 'E', 'U'};
		initBSTdeluxe(bst16, bst16Keys);
		
		int[] bstNumbersKeys = {76, 78, 65, 73, 84, 68, 80, 79, 67, 83};
		for(int key : bstNumbersKeys) {
			bstNumbers.put(key, 0);
		}
	}

	private void initBSTdeluxe(BSTdeluxe<Character, String> bst, char[] bstKeys) {
		for(char key : bstKeys) {
			bst.put(key, "");
		}
	}

	// = = = pre order = = = 
	@Test
	void preOrder_bstEmpty() {
		assertIterableEquals(
				List.of(),
				bstEmpty.preOrder());
	}
	
	@Test
	void preOrder_bst1() {
		assertIterableEquals(
				List.of('X'),
				bst1.preOrder());
	}

	@Test
	void preOrder_bst12() {
		assertIterableEquals(
				List.of('O', 'A', 'B', 'H', 'F', 'M', 'K', 'S', 'W', 'U', 'T', 'V'),
				bst12.preOrder());
	}
	
	@Test
	void preOrder_bst16() {
		assertIterableEquals(
				List.of('L', 'H', 'G', 'A', 'E', 'I', 'N', 'W', 'T', 'S', 'P', 'O', 'V', 'U', 'Z', 'X'),
				bst16.preOrder());
	}	
	
	@Test
	void preOrder_bstNumbers() {
		assertIterableEquals(
				List.of(76, 65, 73, 68, 67, 78, 84, 80, 79, 83),
				bstNumbers.preOrder());
	}

	// = = = in order = = = 
	@Test
	void inOrder_bstEmpty() {
		assertIterableEquals(
				List.of(),
				bstEmpty.inOrder());
	}
	
	@Test
	void inOrder_bst1() {
		assertIterableEquals(
				List.of('X'),
				bst1.inOrder());
	}
	
	@Test
	void inOrder_bst12() {
		assertIterableEquals(
				List.of('A', 'B', 'F', 'H', 'K', 'M', 'O', 'S', 'T', 'U', 'V', 'W'),
				bst12.inOrder());
	}
	
	@Test
	void inOrder_bst16() {
		assertIterableEquals(
				List.of('A', 'E', 'G', 'H', 'I', 'L', 'N', 'O', 'P', 'S', 'T', 'U', 'V', 'W', 'X', 'Z'),
				bst16.inOrder());
	}
	
	@Test
	void inOrder_bstNumbers() {
		assertIterableEquals(
				List.of(65, 67, 68, 73, 76, 78, 79, 80, 83, 84),
				bstNumbers.inOrder());
	}
	
	// = = = post order = = = 
	@Test
	void postOrder_bstEmptsty() {
		assertIterableEquals(
				List.of(),
				bstEmpty.postOrder());
	}
	
	@Test
	void postOrder_bst1() {
		assertIterableEquals(
				List.of('X'),
				bst1.postOrder());
	}
	
	@Test
	void postOrder_bst12() {
		assertIterableEquals(
				List.of('F', 'K', 'M', 'H', 'B', 'A', 'T', 'V', 'U', 'W', 'S', 'O'),
				bst12.postOrder());
	}
	
	@Test
	void postOrder_bst16() {
		assertIterableEquals(
				List.of('E', 'A', 'G', 'I', 'H', 'O', 'P', 'S', 'U', 'V', 'T', 'X', 'Z', 'W', 'N', 'L'),
				bst16.postOrder());
	}
	
	@Test
	void postOrder_bstNumbers() {
		assertIterableEquals(
				List.of(67, 68, 73, 65, 79, 83, 80, 84, 78, 76),
				bstNumbers.postOrder());
	}
}
