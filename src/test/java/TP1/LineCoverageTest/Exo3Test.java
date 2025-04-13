package TP1.LineCoverageTest;

import static org.junit.jupiter.api.Assertions.*;

import TP1.BinarySearch;
import org.junit.jupiter.api.Test;

public class Exo3Test {

    @Test
    public void testElementFound() {
        int[] array = {1, 3, 5, 7, 9};
        assertEquals(2, BinarySearch.binarySearch(array, 5));
    }

    @Test
    public void testElementNotFound() {
        int[] array = {2, 4, 6, 8};
        assertEquals(-1, BinarySearch.binarySearch(array, 5));
    }

    @Test
    public void testEmptyArray() {
        int[] array = {};
        assertEquals(-1, BinarySearch.binarySearch(array, 10));
    }
}

