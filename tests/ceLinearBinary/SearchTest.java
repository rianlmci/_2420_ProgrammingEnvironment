package ceLinearBinary;

import a01.A01Part1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Array;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {
    private String[] array = {"g","a","z","m","e","j"};

    @BeforeEach
    void setUp() throws Exception{
    }

    @Test
    void linear_keyIsFirstElement() {
        int expected = 0;
        int actual = Search.linear(array, "g");
        assertEquals(expected, actual); //remember expected is ALWAYS first with assertEquals
    }
    @Test
    void linear_keyIsLastElement() {assertEquals(5, Search.linear(array, "j"));}

    @Test
    void linear_keyNotInArray() {assertEquals(-1, Search.linear(array, "x"));}

    @Test
    void linear_keyOccursMultipleTimes() {
        assertEquals(
            1,
            Search.linear(
                new String [] {"x", "o", "l", "b", "o", "m", "o", "e"},
                "o"
            )
        );
    }

    @Test
    void linear_emptyArray() {
        assertEquals(-1, Search.linear(new String[] {}, "o"));
    }

    @Test
    void linear_isNull() {
        assertThrows(NullPointerException.class, () -> {Search.linear(null, "1");});
    }

    @Test
    void linear_IntegerArray() {
        assertEquals(
            2,
            Search.linear(
                new Integer [] {4, 2, 8, 5 ,1},
                8
            )
        );
    }
    //1
    @Test
    void binary_throwsExceptionIfKeyOrArrayAreNull() {
        assertThrows(NullPointerException.class, () ->
            {Search.binary(null, null);}
        );
    }
    //2
    @Test
    void binary_scrambledAlphabetLowercase() {
        assertEquals(
            3,
                Search.binary(
                    new String [] {"d","c","b","a"},
                    "d"
                )
        );
    }
    //3
    @Test
    void binary_scrambledNumbersAndLowercaseLetters() {
        assertEquals(
            0,
            Search.binary(
                new String [] {"4","c", "2", "a"},
                "2"
            )
        );
    }
    //4
    @Test
    void binary_scrambledNumbersAndMixedCaseLetters() {
        assertEquals(
            2,
            Search.binary(
                new String [] {"4","C", "2", "a"},
                "a"
            )
        );
    }
    //5
    @Test
    void binary_scrambledAlphabetLowercaseRepeats() {
        assertEquals(
            2,
            Search.binary(
                new String [] {"d","c","b","a","a","b"},
                "b"
            )
        );
    }
}