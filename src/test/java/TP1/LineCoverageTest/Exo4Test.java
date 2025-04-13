package TP1.LineCoverageTest;

import static org.junit.jupiter.api.Assertions.*;

import TP1.QuadraticEquation;
import org.junit.jupiter.api.Test;

public class Exo4Test {

    @Test
    public void testTwoRealRoots() {
        double[] result = QuadraticEquation.solve(1, -3, 2); // x² - 3x + 2 = 0
        assertArrayEquals(new double[]{2.0, 1.0}, result, 0.0001);
    }

    @Test
    public void testOneRealRoot() {
        double[] result = QuadraticEquation.solve(1, -2, 1); // x² - 2x + 1 = 0
        assertArrayEquals(new double[]{1.0}, result, 0.0001);
    }

    @Test
    public void testNoRealRoot() {
        assertNull(QuadraticEquation.solve(1, 0, 1)); // x² + 1 = 0
    }
}

