package TP1.LineCoverageTest;



import TP1.Palindrome;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo1Test {

    // Cas nominal
    @Test
    void testSimplePalindrome() {
        assertTrue(Palindrome.isPalindrome("kayak"));
    }

    // Cas non-palindrome
    @Test
    void testNonPalindrome() {
        assertFalse(Palindrome.isPalindrome("bonjour"));
    }

    // Cas vide
    @Test
    void testEmptyString() {
        assertTrue(Palindrome.isPalindrome(""));
    }

    // Cas d’un caractère
    @Test
    void testSingleCharacter() {
        assertTrue(Palindrome.isPalindrome("a"));
    }

    @Test
    void testNullString() {
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null));
    }

}

