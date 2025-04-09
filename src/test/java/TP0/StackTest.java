package TP0;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void testPushAndPeek() {
        Stack stack = new Stack();
        stack.push(42);
        assertEquals(42, stack.peek());
    }

    @Test
    void testPop() {
        Stack stack = new Stack();
        stack.push(10);
        int popped = stack.pop();
        assertEquals(10, popped);
        assertTrue(stack.isEmpty());
    }

    @Test
    void testSize() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.size());
    }

    @Test
    void testIsEmpty() {
        Stack stack = new Stack();
        assertTrue(stack.isEmpty());
        stack.push(5);
        assertFalse(stack.isEmpty());
    }

    @Test
    void testExpandArray() {
        Stack stack = new Stack();
        for (int i = 0; i < 20; i++) {
            stack.push(i);
        }
        assertEquals(20, stack.size());
        assertEquals(19, stack.peek());
    }

    @Test
    void testPopOnEmptyThrows() {
        Stack stack = new Stack();
        assertThrows(IllegalStateException.class, stack::pop);
    }

    @Test
    void testPeekOnEmptyThrows() {
        Stack stack = new Stack();
        assertThrows(IllegalStateException.class, stack::peek);
    }
}

