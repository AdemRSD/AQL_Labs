package TP1.BranchCoverageTest;

import static org.junit.jupiter.api.Assertions.*;

import TP1.QuadraticEquation;
import org.junit.jupiter.api.Test;

public class Exo4Test {

    @Test
    public void testZeroCoefficientA() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuadraticEquation.solve(0, 2, 1);
        });
    }

    @Test
    public void testNegativeDiscriminant() {
        assertNull(QuadraticEquation.solve(2, 1, 5));
    }

    @Test
    public void testPositiveDiscriminant() {
        double[] result = QuadraticEquation.solve(1, 5, 6); // x² + 5x + 6 = 0
        assertArrayEquals(new double[]{-2.0, -3.0}, result, 0.0001);
    }
}

