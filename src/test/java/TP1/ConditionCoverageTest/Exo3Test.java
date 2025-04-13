package TP1.ConditionCoverageTest;

import static org.junit.jupiter.api.Assertions.*;

import TP1.BinarySearch;
import org.junit.jupiter.api.Test;

public class Exo3Test {

    @Test
    public void testSingleElementMatch() {
        int[] array = {5};
        assertEquals(0, BinarySearch.binarySearch(array, 5));
    }

    @Test
    public void testSingleElementNoMatch() {
        int[] array = {5};
        assertEquals(-1, BinarySearch.binarySearch(array, 3));
    }

    @Test
    public void testMultipleConditions() {
        int[] array = {10, 20, 30, 40, 50};
        assertEquals(4, BinarySearch.binarySearch(array, 50));
        assertEquals(-1, BinarySearch.binarySearch(array, 35));
    }
}

