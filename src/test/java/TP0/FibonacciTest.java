package TP0;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void testBaseCases() {
        assertEquals(0, Fibonacci.fibonacci(0));
        assertEquals(1, Fibonacci.fibonacci(1));
    }

    @Test
    void testFibonacciValues() {
        assertEquals(1, Fibonacci.fibonacci(2));
        assertEquals(2, Fibonacci.fibonacci(3));
        assertEquals(3, Fibonacci.fibonacci(4));
        assertEquals(5, Fibonacci.fibonacci(5));
        assertEquals(8, Fibonacci.fibonacci(6));
        assertEquals(13, Fibonacci.fibonacci(7));
    }

    @Test
    void testNegativeInputThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Fibonacci.fibonacci(-1));
    }
}

