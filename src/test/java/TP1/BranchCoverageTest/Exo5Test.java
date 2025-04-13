package TP1.BranchCoverageTest;

import static org.junit.jupiter.api.Assertions.*;

import TP1.RomanNumeral;
import org.junit.jupiter.api.Test;

public class Exo5Test {

    @Test
    public void testThrowExceptionIfTooSmall() {
        assertThrows(IllegalArgumentException.class, () -> {
            RomanNumeral.toRoman(0);
        });
    }

    @Test
    public void testThrowExceptionIfTooBig() {
        assertThrows(IllegalArgumentException.class, () -> {
            RomanNumeral.toRoman(4000);
        });
    }

    @Test
    public void testAllBranches() {
        assertEquals("CDXLIV", RomanNumeral.toRoman(444)); // 400 + 40 + 4
    }
}

