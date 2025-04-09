package TP1.ConditionCoverageTest;

import TP1.Palindrome;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo1Test {

    // Condition s == null → TRUE
    @Test
    void testNullInputCondition() {
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null));
    }

    // Condition i < j → TRUE et FALSE (string pair)
    @Test
    void testEvenLengthPalindrome() {
        assertTrue(Palindrome.isPalindrome("abba"));
    }

    // Condition i < j → FALSE directement
    @Test
    void testShortOneLetter() {
        assertTrue(Palindrome.isPalindrome("x"));
    }

    // Condition s.charAt(i) != s.charAt(j) → TRUE
    @Test
    void testNotMatchingChars() {
        assertFalse(Palindrome.isPalindrome("hello"));
    }

    // Condition s.charAt(i) != s.charAt(j) → FALSE
    @Test
    void testMatchingChars() {
        assertTrue(Palindrome.isPalindrome("deified"));
    }
}
