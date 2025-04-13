package TP1.LineCoverageTest;

import static org.junit.jupiter.api.Assertions.*;

import TP1.FizzBuzz;
import org.junit.jupiter.api.Test;

public class Exo6Test {

    @Test
    public void testExceptionThrown() {
        assertThrows(IllegalArgumentException.class, () -> {
            FizzBuzz.fizzBuzz(0);
        });
    }

    @Test
    public void testOnlyFizz() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(6)); // divisible by 3 only
    }

    @Test
    public void testOnlyBuzz() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(10)); // divisible by 5 only
    }

    @Test
    public void testFizzBuzzCase() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(30)); // divisible by both
    }

    @Test
    public void testNeither() {
        assertEquals("2", FizzBuzz.fizzBuzz(2));
    }
}

