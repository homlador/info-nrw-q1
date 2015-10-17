package info.nrw.q1.mensa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Dies ist ein Unit-Test für die Klasse Queue.
 * Die mit @Test markierten Methoden testen die Klasse Queue auf ihre Funktion.
 */
public class QueueTest
{
    private Queue<String> queue;
    
    /**
     * Bevor eine Test-Methode ausgeführt wird, wird diese Methode ausgeführt.
     */
    @Before
    public void setUp()
    {
    	queue = new Queue<String>();
    }

    @Test
    public void testEmpty() {
        assertTrue("Neue Queue muss leer sein", queue.isEmpty());
        assertNull("Leere Queue muss null bei front() zurückgeben", queue.front() );
    } 
           
    @Test
    public void testEnqueueDequeue() {
        String foo = "foo";
        
        queue.enqueue(foo);
        assertFalse("Queue darf nicht leer sein, wenn Objekt enqueued", queue.isEmpty());
        assertEquals("Element muss nach anstellen wieder zurückgegeben werden", foo, queue.front());
        
        queue.dequeue();
        assertTrue("Queue muss leer sein, wenn nur 1 Element und dann dequeue", queue.isEmpty());
    } 
    
    @Test
    public void testEnqueueDequeueFront() {
        String foo = "foo";
        String bar = "bar";
        
        queue.enqueue(foo);
        queue.enqueue(bar);
        
        assertEquals("Zuerst enqueutes Element muss vorne sein", foo, queue.front());
        
        queue.dequeue();
        
        assertEquals("Letztes Element muss entfernt worden sein", bar, queue.front());
        
        queue.dequeue();
        
        assertTrue("Queue muss leer sein, wenn 2 Elemente und dann 2 mal dequeue", queue.isEmpty());
    }
}
