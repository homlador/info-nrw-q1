package info.nrw.q1.bahnhof;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * The test class StackTest.
 */
public class StackTest
{
    private Stack<String> stack;
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        stack = new Stack<String>();
    }

    @Test
    public void testEmpty() {
        assertTrue("Neuer Stack muss leer sein", stack.isEmpty());
    } 
           
    @Test
    public void testPushEmpty() {
        String foo = "Foo";
        
        stack.push(foo);
        assertFalse("Stack darf nicht leer sein, wenn Objekt gepusht", stack.isEmpty());
    } 
    
    @Test
    public void testPushPopEmpty() {
        String foo = "Foo";
        
        stack.push(foo);
        stack.pop();
        
        assertTrue("Stack muss leer sein, wenn alle Elemente gepopt", stack.isEmpty());
    }    
    
    @Test
    public void testPushTopEmpty() {
        String foo = "Foo";
  
        stack.push(foo);
        assertEquals("top() muss das oberste Element zurückgeben", foo, stack.top());
        assertFalse("top() darf das oberste Element nicht löschen", stack.isEmpty());
    }
}
