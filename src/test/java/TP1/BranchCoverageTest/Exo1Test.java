package TP1.BranchCoverageTest;


import TP1.Palindrome;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo1Test {

    // ✅ Branche where s == null
    @Test
    void testNullInputThrows() {
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null));
    }

    // ✅ Branche où la condition de la boucle échoue au premier tour
    @Test
    void testShortNonPalindrome() {
        assertFalse(Palindrome.isPalindrome("ab"));
    }

    // ✅ Branche de succès avec espaces/casse
    @Test
    void testPalindromeWithSpacesAndCases() {
        assertTrue(Palindrome.isPalindrome("Esope reste ici et se repose"));
    }

    // ✅ Cas sans déclenchement de return false
    @Test
    void testPerfectMatch() {
        assertTrue(Palindrome.isPalindrome("radar"));
    }

}

