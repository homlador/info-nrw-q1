package info.nrw.q1.kreismaler.actions;

import info.nrw.q1.kreismaler.Kreis;

/**
 * Aktion zum Ver�ndern der Breite eines Kreises
 */
public class WidthAction extends Action
{
    private int width;
    private int oldWidth;

    public WidthAction(Kreis pKreis, int pWidth) {
        super(pKreis);
        this.width = pWidth;
    }

    public void doAction() {
        // Der momentane Radius des Kreises wird gespeichert
        oldWidth = kreis.getWidth();
        // Der neue Radius des Kreises wird gesetzt
        kreis.setWidth(width);
    }

    public void undoAction() {
        // Der alte Radius des Kreises wird wieder hergestellt
        kreis.setWidth(oldWidth);  
    }

    public String toString() {
        return "Change width to " + width;
    }
}
