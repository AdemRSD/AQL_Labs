package TP0;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {

    @Test
    void testKnownPrimes() {
        assertTrue(Prime.isPrime(2));
        assertTrue(Prime.isPrime(3));
        assertTrue(Prime.isPrime(5));
        assertTrue(Prime.isPrime(7));
        assertTrue(Prime.isPrime(13));
        assertTrue(Prime.isPrime(17));
    }

    @Test
    void testNonPrimes() {
        assertFalse(Prime.isPrime(0));
        assertFalse(Prime.isPrime(1));
        assertFalse(Prime.isPrime(4));
        assertFalse(Prime.isPrime(6));
        assertFalse(Prime.isPrime(9));
        assertFalse(Prime.isPrime(15));
    }

    @Test
    void testNegativeNumbers() {
        assertFalse(Prime.isPrime(-1));
        assertFalse(Prime.isPrime(-7));
        assertFalse(Prime.isPrime(-13));
    }
}

