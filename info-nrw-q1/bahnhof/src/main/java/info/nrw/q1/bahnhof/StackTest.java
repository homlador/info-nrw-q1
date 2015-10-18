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
         
    // TODO: Implementiere weitere Test Methoden
    // Orientiere dich an dem obigen Beispiel.
    // Benutze dazu die Methoden assertTrue(), assertFalse() und assertEquals()
}
