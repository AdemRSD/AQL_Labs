package TP1.BranchCoverageTest;
import TP1.Anagram;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo2Test {

    @Test
    void testNullInput() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "test"));
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram("test", null));
    }

    @Test
    void testDifferentLength() {
        assertFalse(Anagram.isAnagram("abc", "ab"));
    }

    @Test
    void testValidAnagram() {
        assertTrue(Anagram.isAnagram("listen", "silent"));
    }

    @Test
    void testInvalidAnagramWithSameLength() {
        assertFalse(Anagram.isAnagram("test", "tess"));
    }
}
