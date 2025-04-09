package TP0;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testGetFullName() {
        Person p = new Person("Alice", "Dupont", 25);
        assertEquals("Alice Dupont", p.getFullName());
    }

    @Test
    public void testIsAdultWhenAdult() {
        Person p = new Person("Bob", "Martin", 20);
        assertTrue(p.isAdult());
    }

    @Test
    public void testIsAdultWhenMinor() {
        Person p = new Person("Charlie", "Durand", 16);
        assertFalse(p.isAdult());
    }
}

