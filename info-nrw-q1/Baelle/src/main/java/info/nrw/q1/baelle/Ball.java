package info.nrw.q1.baelle;
import java.awt.Color;

/**
 * Die Klasse Ball implementiert grafisch Baelle, die der Schwerkraft
 * unterworfen sind. Ein Ball kann bewegt werden. Die Bedingungen der Bewegung
 * werden dabei vom Ball selbst kontrolliert. Er faellt abwaerts und beschleunigt
 * aufgrund der Schwerkraft. Er prallt ab, wenn er auf dem Boden auftrifft.
 * 
 * Diese Bewegung kann simuliert werden, indem wiederholt die Operation
 * "bewegen" aufgerufen wird.
 * 
 * @author Bruce Quig
 * @author Michael Kolling (mik)
 * @author David J. Barnes
 *
 * @version 2008.03.30
 */

public class Ball
{
    private static final int GRAVITATION = 3;  // Einfluss der Gravitation

    private int bremsfaktor = 2;  // simuliert den Luftwiderstand
    private Color farbe;
    private int durchmesser;
    private int xPosition;
    private int yPosition;
    private final int bodenhoehe;      // y-Position des Bodens
    private Canvas leinwand;
    private int yGeschwindigkeit = 1;   // anfängliche Abwärtsgeschwindigkeit

    /**
     * Konstruktor für Exemplare von Ball
     *
     * @param xPos  die horizontale Koordinate des Balles
     * @param yPos  die vertikale Koordinate des Balles
     * @param balldurchmesser  der Durchmesser des Balles (in Bildschirmpunkten)
     * @param ballfarbe  die Farbe des Balles
     * @param bodenPosition  die y-Position des Bodens (wo der Ball aufspringt)
     * @param zeichengrund die Leinwand, auf der dieser Ball gezeichnet wird
     */
    public Ball(int xPos, int yPos, int balldurchmesser, Color ballfarbe,
                        int bodenPosition, Canvas zeichengrund)
    {
        xPosition = xPos;
        yPosition = yPos;
        farbe = ballfarbe;
        durchmesser = balldurchmesser;
        bodenhoehe = bodenPosition;
        leinwand = zeichengrund;
    }

    /**
     * Zeichne diesen Ball an der aktuellen Position auf die Leinwand.
     **/
    public void zeichnen()
    {
        leinwand.setForegroundColor(farbe);
        leinwand.fillCircle(xPosition, yPosition, durchmesser);
    }

    /**
     * Losche diesen Ball an seiner aktuellen Position.
     **/
    public void loeschen()
    {
        leinwand.eraseCircle(xPosition, yPosition, durchmesser);
    }    

    /**
     * Bewege diesen Ball entsprechend seiner Position und 
     * Geschwindigkeit und zeichne ihn erneut.
     **/
    public void bewegen()
    {
        // An der aktuellen Position von der Leinwand entfernen.
        loeschen();
            
        // Neue Position berechnen.
        yGeschwindigkeit += GRAVITATION;
        yPosition += yGeschwindigkeit;
        xPosition +=2;

        // Prüfen, ob der Boden erreicht ist.
        if(yPosition >= (bodenhoehe - durchmesser) && yGeschwindigkeit > 0) {
            yPosition = (int)(bodenhoehe - durchmesser);
            yGeschwindigkeit = -yGeschwindigkeit + bremsfaktor; 
        }

        // An der neuen Position erneut zeichnen.
        zeichnen();
    }    

    /**
     * Liefere die horizontale Position dieses Balls.
     */
    public int gibXPosition()
    {
        return xPosition;
    }

    /**
     * Liefere die vertikale Position dieses Balls.
     */
    public int gibYPosition()
    {
        return yPosition;
    }
}
