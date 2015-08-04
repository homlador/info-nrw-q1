package info.nrw.q1.baelle;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

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
    private Ball ball2;
    
    private Ball[] baelle;
    
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
        
        // TODO ball2 hinzufügen
        ball2 = new FarbBall(70, 80, 20, Color.red, boden, leinwand);
        ball2.zeichnen();        
        
        baelle = new Ball[5];
        baelle[0] = new Ball(35, 35, 25, Color.blue, boden, leinwand);
        baelle[1] = new Ball(10, 10, 10, Color.red, boden, leinwand);
        baelle[2] = new FarbBall(130, 35, 15, Color.yellow, boden, leinwand);
        baelle[3] = new Ball(80, 120, 50, Color.black, boden, leinwand);
        baelle[4] = new Ball(0, 70, 40, Color.green, boden, leinwand);
        
        for (int i=0; i<baelle.length; i++) {
        	baelle[i].zeichnen();
        }
        
        leinwand.wait(1000);
        
        // Die Bälle springen lassen.
        boolean fertig =  false;
        while(!fertig) {
            leinwand.wait(50);           // kurze Pause
            ball1.bewegen();
            ball2.bewegen();
            
            for (int i=0; i<baelle.length; i++) {
            	baelle[i].bewegen();
            }            
            
            // Stoppen, wenn die Bälle weit genug gesprungen sind.
            if(ball1.gibXPosition() >= 550 && ball2.gibXPosition() >= 550) {
                fertig = true;
            }
            
        }
        ball1.loeschen();
        ball2.loeschen();
    }

}
