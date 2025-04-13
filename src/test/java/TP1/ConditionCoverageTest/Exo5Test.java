package TP1.ConditionCoverageTest;

import static org.junit.jupiter.api.Assertions.*;

import TP1.RomanNumeral;
import org.junit.jupiter.api.Test;

public class Exo5Test {

    @Test
    public void testMinimumValid() {
        assertEquals("I", RomanNumeral.toRoman(1));
    }

    @Test
    public void testMaximumValid() {
        assertEquals("MMMCMXCIX", RomanNumeral.toRoman(3999));
    }

    @Test
    public void testValueEqualsSymbolValue() {
        assertEquals("IV", RomanNumeral.toRoman(4));
        assertEquals("IX", RomanNumeral.toRoman(9));
        assertEquals("XC", RomanNumeral.toRoman(90));
    }
}
