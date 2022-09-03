package a01;

import ceLinearBinary.Search;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class A01Part1Test {

    @Test
    void everyOther_longerArrayReturnsShorterEven() {
        //assertArrayEquals(expected,actual);
        assertArrayEquals(
            new int[] {10, 30, 50},
            A01Part1.everyOther(new int[]{10, 20, 30, 40, 50, 60})
        );
    }

    @Test
    void everyOther_longerArrayReturnsShorterOdd() {
        assertArrayEquals(
            new int[] {10, 30, 50, 70},
            A01Part1.everyOther(new int[]{10, 20, 30, 40, 50, 60, 70})
        );
    }

    @Test
    void everyOther_oneReturnsOne() {
        assertArrayEquals(
            new int[] {10},
            A01Part1.everyOther(new int[]{10})
        );
    }

    @Test
    void everyOther_emptyReturnsEmpty() {
        assertArrayEquals(
            new int[] {},
            A01Part1.everyOther(new int[]{})
        );
    }

    @Test
    void everyOther_nullReturnsNull() {
        assertArrayEquals(
            null,
            A01Part1.everyOther(null)
        );
    }

    @Test
    void addSeparators_commasForMillion() {
        assertArrayEquals(
            new char[] {'7', ',', '6', '5', '4', ',', '3', '2', '1'}, /*Expected*/
            A01Part1.addSeparators(new char [] {'7', '6', '5', '4', '3', '2', '1'}) /*Actual*/
        );
    }

    @Test
    void addSeparators_threeOrLessDigits() {
        assertArrayEquals(
            new char[] {'5', '3', '6'}, /*Expected*/
            A01Part1.addSeparators(new char [] {'5', '3', '6'}) /*Actual*/
        );
    }

    @Test
    void addSeparators_emptyReturnsEmpty() {
        assertArrayEquals(
            new char[] {}, /*Expected*/
            A01Part1.addSeparators(new char [] {}) /*Actual*/
        );
    }

    @Test
    void addSeparators_nullReturnsNull() {
        assertArrayEquals(
            null, /*Expected*/
            A01Part1.addSeparators(null) /*Actual*/
        );
    }

    @Test
    void addSeparators_throwsIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () ->
            {A01Part1.addSeparators(new char [] {'a', '2', '3'});}
        );
    }

    @Test
    void isPalindrome_sameCasePalindromeReturnsTrue() {
        assertTrue(A01Part1.isPalindrome(new Character [] {'r', 'a', 'c','e','c','a','r'})); //why? generics cant be primitives
    }

    @Test
    void isPalindrome_differentCasePalindromeReturnsFalse() {
        assertFalse(A01Part1.isPalindrome(new Character [] {'D', 'a', 'd'}));
    }

    @Test
    void isPalindrome_falseNumberElementsReturnsFalse() {
        assertFalse(A01Part1.isPalindrome(new Integer [] {10,20}));
    }

    @Test
    void isPalindrome_oneElementReturnsTrue() {
        assertTrue(A01Part1.isPalindrome(new String [] {"hello"}));
    }

    @Test
    void isPalindrome_nullThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
            {A01Part1.isPalindrome(null);}
        );
    }

    @Test
    void isPalindrome_emptyThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
            {A01Part1.isPalindrome(new Integer[]{});}
        );
    }

}