package stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class StackTest {

    @Test
    public void createInstanceOfStack() {
        Stack stack = new Stack();
    }

    @Test
    public void newStackIsEmpty() {
        Stack stack = new Stack();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void pushOneItemToStackIsEmptyReturnsFalse() {
        Stack stack = new Stack();
        stack.push(0);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void pushOneItemPopOneItemStackIsEmptyReturnsTrue() {
        Stack stack = new Stack();
        stack.push(0);
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void pushPushPopThenStackIsEmptyReturnsFalse(){
        Stack stack = new Stack();
        stack.push(0);
        stack.push(0);
        stack.pop();
        assertFalse(stack.isEmpty());
    }

    @Test
    public void popFromEmptyStackThrowsException()
    {
        Stack stack = new Stack();
        assertThrows(IllegalStateException.class,()->stack.pop());
    }

    @Test
    public void pushANumberThenPopReturnsThatNumber()
    {
        Stack stack = new Stack();
        stack.push(99);
        assertEquals(99,stack.pop());
    }

    @Test
    public void pushTwoNumbersThenPopNumbersAndGetSameValuesBack()
    {
        Stack stack = new Stack();
        stack.push(99);
        stack.push(88);
        assertEquals(88,stack.pop());
        assertEquals(99,stack.pop());  //Should this have been here? The test failed already on line 66...
    }
}
