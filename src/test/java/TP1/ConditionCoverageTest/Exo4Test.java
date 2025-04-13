package TP1.ConditionCoverageTest;

import static org.junit.jupiter.api.Assertions.*;

import TP1.QuadraticEquation;
import org.junit.jupiter.api.Test;

public class Exo4Test {

    @Test
    public void testAllConditionsMet_PositiveDelta() {
        double[] result = QuadraticEquation.solve(1, 0, -4); // x² - 4 = 0
        assertArrayEquals(new double[]{2.0, -2.0}, result, 0.0001);
    }

    @Test
    public void testAllConditionsMet_ZeroDelta() {
        double[] result = QuadraticEquation.solve(1, 2, 1); // x² + 2x + 1 = 0
        assertArrayEquals(new double[]{-1.0}, result, 0.0001);
    }

    @Test
    public void testAllConditionsMet_NegativeDelta() {
        assertNull(QuadraticEquation.solve(3, 1, 2)); // 3x² + x + 2 = 0
    }
}

