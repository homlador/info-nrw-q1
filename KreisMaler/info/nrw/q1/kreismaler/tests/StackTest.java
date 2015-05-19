package info.nrw.q1.kreismaler.tests;
import static org.junit.Assert.*;
import info.nrw.q1.kreismaler.Stack;

import org.junit.Test;

public class StackTest
{
    private Stack<String> stack;
    
    @Test
    public void testStack() {
        stack = new Stack<String>();
        assertTrue("Ein neuer Stack muss leer sein", stack.isEmpty());
        
        String foo = new String("Foo");
        String bar = new String("Bar");
 
        stack.push(foo);
        assertFalse("Nach einem push() darf der Stack nicht leer sein", stack.isEmpty());
        assertEquals("top() muss das zu letzt gepushte Element zurückgeben", foo, stack.top());
        assertFalse("top() darf das oberste Element nicht löschen", stack.isEmpty());
                
        stack.push(bar);
        assertEquals("top() muss das zu letzt gepushte Element zurückgeben", bar, stack.top());

        stack.pop();
        assertEquals("pop() muss das oberste Element entfernen", foo, stack.top());
        
        stack.pop();
        assertTrue("Der Stack muss durch pop() leer werden", stack.isEmpty());        
    }
}
