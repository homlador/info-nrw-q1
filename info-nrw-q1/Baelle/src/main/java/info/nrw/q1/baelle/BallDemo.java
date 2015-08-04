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

public class BallDemo   
{
    private Canvas leinwand;

    /**
     * Erzeuge ein Exemplar von BallDemo.
     * Es wird ein frischer Canvas erzeugt und sichtbar gemacht.
     */
    public BallDemo()
    {
        leinwand = new Canvas("Ball Demo", 600, 500);
        leinwand.setVisible(true);
    }
 
    /**
     * Demonstriere einige der Zeichenoperationen, 
     * die von der Klasse Canvas angeboten werden.
     */
    public void zeichneDemo()
    {
        leinwand.setFont(new Font("helvetica", Font.BOLD, 14));
        leinwand.setForegroundColor(Color.red);

        leinwand.drawString("Wir können Text ausgeben, ...", 20, 30);
        leinwand.wait(1000);

        leinwand.setForegroundColor(Color.black);
        leinwand.drawString("...Linien zeichnen...", 60, 60);
        leinwand.wait(500);
        leinwand.setForegroundColor(Color.gray);
        leinwand.drawLine(200, 20, 300, 50);
        leinwand.wait(500);
        leinwand.setForegroundColor(Color.blue);
        leinwand.drawLine(220, 100, 370, 40);
        leinwand.wait(500);
        leinwand.setForegroundColor(Color.green);
        leinwand.drawLine(290, 10, 320, 120);
        leinwand.wait(1000);

        leinwand.setForegroundColor(Color.gray);
        leinwand.drawString("...und Figuren!", 110, 90);

        leinwand.setForegroundColor(Color.red);

        // Die Figur, die gezeichnet und bewegt werden soll.
        int xPos = 10;
        Rectangle rechteck = new Rectangle(xPos, 150, 30, 20);

        // Das Rechteck über den Bildschirm bewegen.
        for(int i = 0; i < 200; i ++) {
            leinwand.fill(rechteck);
            leinwand.wait(10);
            leinwand.erase(rechteck);
            xPos++;
            rechteck.setLocation(xPos, 150);
        }
        // Zum Schluss noch einmal zeichnen, damit es sichtbar bleibt.
        leinwand.fill(rechteck);
    }

    /**
     * Simuliere zwei springende Bälle.
     */
    public void springenLassen()
    {
        int boden = 400;   // Position der Bodenlinie

        leinwand.setVisible(true);

        // Den Boden zeichnen.
        leinwand.drawLine(50, boden, 550, boden);

        // Die Bälle erzeugen und anzeigen.
        Ball ball = new Ball(50, 50, 16, Color.blue, boden, leinwand);
        ball.zeichnen();
        // TODO ball2 hinzufügen
        FarbBall ball2 = new FarbBall(70, 80, 20, Color.red, boden, leinwand);
        ball2.zeichnen();         
        
        // Die Bälle springen lassen.
        boolean fertig =  false;
        while(!fertig) {
            leinwand.wait(50);           // kurze Pause
            ball.bewegen();
            ball2.bewegen();
            // Stoppen, wenn die Bälle weit genug gesprungen sind.
            if(ball.gibXPosition() >= 550 && ball2.gibXPosition() >= 550) {
                fertig = true;
            }
            
        }
        ball.loeschen();
        ball2.loeschen();
    }

}
