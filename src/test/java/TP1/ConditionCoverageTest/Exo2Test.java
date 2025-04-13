package TP1.ConditionCoverageTest;
import TP1.Anagram;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo2Test {

    @Test
    void testSpacesAndCasesIgnored() {
        assertTrue(Anagram.isAnagram("Chien  ", "  Niche"));
    }

    @Test
    void testMismatchByLetterCount() {
        assertFalse(Anagram.isAnagram("apple", "ppale"));
    }

    @Test
    void testEqualStringsAreAnagrams() {
        assertTrue(Anagram.isAnagram("Anagram", "Anagram"));
    }

    @Test
    void testEmptyStrings() {
        assertTrue(Anagram.isAnagram("", ""));
    }
}
