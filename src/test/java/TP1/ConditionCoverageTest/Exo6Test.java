package TP1.ConditionCoverageTest;

import static org.junit.jupiter.api.Assertions.*;

import TP1.FizzBuzz;
import org.junit.jupiter.api.Test;

public class Exo6Test {

    @Test
    public void testDivisibleBy3And5() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(45));
    }

    @Test
    public void testDivisibleBy3Not5() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(9));
    }

    @Test
    public void testDivisibleBy5Not3() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(20));
    }

    @Test
    public void testNotDivisibleBy3Or5() {
        assertEquals("8", FizzBuzz.fizzBuzz(8));
    }

    @Test
    public void testMinimumValid() {
        assertEquals("1", FizzBuzz.fizzBuzz(1));
    }
}

