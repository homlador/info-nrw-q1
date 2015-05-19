package info.nrw.q1.kreismaler;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Grafische Darstellung eines Kreises auf einer Graphics2D
 */
public class Kreis
{
    private int x;
    private int y;
    private int r;

    private int width;

    /**
     * @param px X-Koordinate
     * @param py Y-Koordinate
     * @param pr Radius
     */
    public Kreis(int px, int py, int pr)
    {
        this.x = px;
        this.y = py;
        this.r = pr;
        width = 5;
    }

    public void setR(int pNewRadius) {
        r = pNewRadius;
    }

    public int getR() {        
        return r;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int pWidth) {
        this.width = pWidth;
    }

    public String toString() {
    	return "Kreis (r=" + r + ")";
    }
    
    /**
     * Zeichnet den Kreis
     * 
     * @param g2d Graphics2D Objekt, auf dem der Kreis sich zeichnen soll
     */
    public void paint(Graphics2D g2d) {
        g2d.setStroke(new BasicStroke( width ));              
        g2d.setColor(Color.BLACK);
        Ellipse2D.Double ellipse = new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        g2d.draw(ellipse);
    }
}
