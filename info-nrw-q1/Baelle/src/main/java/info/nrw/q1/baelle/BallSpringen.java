package info.nrw.q1.baelle;
import java.awt.Color;

/**
 * Die Klasse BallDemo bietet zwei kurze Demonstrationen, wie die
 * Klasse Canvas benutzt werden kann.
 *
 * @author Michael Koelling und David J. Barnes
 * @version 2008.03.30
 */

public class BallSpringen   
{
    private Canvas leinwand; // Das ist der Hintergrund, auf dem gezeichnet werden kann
    int boden = 400;   // Position der Bodenlinie
    
    private Ball ball1; // Ein Ball, der springt
     
    // TODO: ball2 deklarieren
    
    // TODO: Array baelle deklarieren
   
    
    /**
     * Erzeuge ein Exemplar von BallDemo.
     * Es wird ein frischer Canvas erzeugt und sichtbar gemacht.
     */
    public BallSpringen()
    {
        leinwand = new Canvas("Ball Demo", 600, 500);
        leinwand.setVisible(true);
    }

    /**
     * Simuliere zwei springende Bälle.
     */
    public void springenLassen()
    {
        leinwand.setVisible(true);

        // Den Boden zeichnen.
        leinwand.drawLine(50, boden, 550, boden);

        // Die Bälle erzeugen und anzeigen.
        ball1 = new Ball(50, 60, 16, Color.blue, boden, leinwand);
        ball1.zeichnen();
        
        // TODO: ball2 hinzufügen
       
        // TODO: Weitere 5 Baelle mit Hilfe eines Arrays hinzufügen
        
        leinwand.wait(1000);
        
        // Die Bälle springen lassen.
        boolean fertig =  false;
        while(!fertig) {
            leinwand.wait(50);           // kurze Pause
            ball1.bewegen();          
            
            // Stoppen, wenn die Bälle weit genug gesprungen sind.
            if(ball1.gibXPosition() >= 550) {
                fertig = true;
            }
            
        }
        ball1.loeschen();
    }

}
