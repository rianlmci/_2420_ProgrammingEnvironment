package ceLinearBinary;

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
    void linear_keyIsLastElement() {
        assertEquals(5, Search.linear(array, "j"));
    }

    @Test
    void linear_keyNotInArray() {
        assertEquals(-1, Search.linear(array, "x"));
    }

    @Test
    void linear_keyOccursMultipleTimes() {
        String[] myArray = {"x", "o", "l", "b", "o", "m", "o", "e"};
        assertEquals(1, Search.linear(myArray, "o"));
    }

    @Test
    void linear_emptyArray() {
        String[] myArray = {};
        assertEquals(-1, Search.linear(myArray, "o"));
    }

    @Test
    void linear_isNull() {
        String[] myArray = null;
        assertThrows(NullPointerException.class, () -> {Search.linear(myArray, "1");});
    }

    @Test
    void linear_IntegerArray() {
        Integer[] myArray = {4, 2, 8, 5 ,1};
        assertEquals(2, Search.linear(myArray, 8));
    }

    @Test
    void testBinary() {
        fail("Not Yet Implemented"); //TODO
    }


}