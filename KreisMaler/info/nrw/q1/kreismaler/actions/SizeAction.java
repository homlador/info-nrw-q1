package info.nrw.q1.kreismaler.actions;

import info.nrw.q1.kreismaler.Kreis;

/**
 * Aktion zum Verändern der Größe des Kreises
 */
public class SizeAction extends Action
{
    private int radius;
    private int oldRadius;
    
    public SizeAction(Kreis pKreis, int pRadius) {
        super(pKreis);
        this.radius = pRadius;
    }
    
    public void doAction() {
        // Der momentane Radius des Kreises wird gespeichert
        oldRadius = kreis.getR();
        // Der neue Radius des Kreises wird gesetzt
        kreis.setR(radius);
    }
    
    public void undoAction() {
        // Der alte Radius des Kreises wird wieder hergestellt
        kreis.setR(oldRadius);  
    }
    
    public String toString() {
            return "Change size to " + radius;
    }
}
