package info.nrw.q1.kreismaler.actions;

import info.nrw.q1.kreismaler.Kreis;

/**
* Aktionen, die auf einem Kreis ausgeführt werden können
*/
public abstract class Action
{
    protected Kreis kreis;
    
    public Action(Kreis pKreis) {
        this.kreis = pKreis;
    }
    
    /**
     * Die Änderungen, die das Kommando durchführt
     */
    public abstract void doAction();
       
    /**
     * Die Änderungen, die das Kommando durchgeführt werden rückgängig gemacht
     */
    public abstract void undoAction();
}
