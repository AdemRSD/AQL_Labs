package TP1.BranchCoverageTest;

import static org.junit.jupiter.api.Assertions.*;

import TP1.BinarySearch;
import org.junit.jupiter.api.Test;

public class Exo3Test {

    @Test
    public void testElementAtBeginning() {
        int[] array = {1, 2, 3};
        assertEquals(0, BinarySearch.binarySearch(array, 1));
    }

    @Test
    public void testElementAtEnd() {
        int[] array = {1, 2, 3};
        assertEquals(2, BinarySearch.binarySearch(array, 3));
    }

    @Test
    public void testNullArrayThrowsException() {
        assertThrows(NullPointerException.class, () -> BinarySearch.binarySearch(null, 1));
    }
}

