package info.nrw.q1.kreismaler;
import info.nrw.q1.kreismaler.actions.Action;
import info.nrw.q1.kreismaler.actions.SizeAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO
 */
public class KreisMaler implements ActionListener
{
	private KreisMalerView kmv;
    private Kreis kreis;
	
    private Stack<Action> undoStack;    
    private Queue<PrintJob> printQueue;

    public KreisMaler()
    {
        kreis = new Kreis(150, 150, 50);
        kmv = new KreisMalerView(kreis, this);
        undoStack = new Stack<Action>();    
        printQueue = new Queue<PrintJob>();
        
        // Thread starten, der die PrinterQueue regelmässig überprüft
        new Thread( new PrinterCheck() ).start();        
    }

    /**
     * TODO
     */
    public void actionPerformed(ActionEvent e) {        
        if (e.getActionCommand().equals("size")) {
            SizeAction sizeAction = new SizeAction(kreis, kmv.getSizeArgument() );
            doAction(sizeAction);
        } else if (e.getActionCommand().equals("undo")) {
            undoLastAction();
        }  else if (e.getActionCommand().equals("drucken")) {
            addToPrinter();
        }
    }

    /**
     * TODO
     */
    public void doAction(Action a) {
    	a.doAction();
    	
    	// TODO: Aktion soll gespeichert werden
        
        updateStatus();
    }
    
    /**
     * Eine Hilfsmethode, welche die Benutzeroberfloche aktualisiert und anzeigt, welche
     * Aktionen rückgängig gemacht werden können und welche Dokumente auf den Druck warten
     */
    private void updateStatus() {
        if (undoStack.isEmpty() == false) {
            kmv.setUndoButtonText("Undo: " + undoStack.top());
        } else {
            kmv.setUndoButtonText("Nothing to undo");
        }
        
		if (printQueue.isEmpty()) {
			kmv.setPrintStatus("nichts zu drucken");
		} else {
			kmv.setPrintStatus(printQueue.front().toString());
		}
		
        kmv.repaint();
	}

    /**
     * TODO
     */
    public void undoLastAction() {
    	// TODO: Letzte Aktion soll rückgängig gemacht werden

    	updateStatus();
    }
     
    /**
     * TODO
     */
    private void addToPrinter() {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    	PrintJob printJob = new PrintJob( dateFormat.format(new Date()) + " " + kreis );
    	
    	// TODO: Printjob der Druckwarteschlange hinzufügen
	
		updateStatus();
    }

	/**
     * Methode wird automatisch aufgerufen, wenn der (simulierte) Drucker
     * gedruckt hat. 
     */
    private void printingDone() {
    	// TODO: Der PrintJob muss aus der Warteschlange entfernt werden.
		
    	
		updateStatus();
    }
    
    /**
     * Eine Hilfsklasse, die den Drucker simuliert.
     * Alle 8 Sekunden wird printingDone() aufgerufen.
     */   
    class PrinterCheck implements Runnable {    	
    	public void run() {
    		while (true) {
    			try {
    				// 8 Sekunden schlafen
    				Thread.sleep(8000);				
    			} catch (InterruptedException e) {    				
    				// ignorieren
    			}
    			printingDone();
    		}
    	}
    }
}
