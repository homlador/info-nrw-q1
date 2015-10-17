package info.nrw.q1.mensa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MensaController implements ActionListener {

	private Queue<Schueler> warteschlange;
	private MensaView ui;

	public MensaController() {
		ui = new MensaView(this);
		warteschlange = new Queue<Schueler>();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("anstellen")) {
			anstellen();
		} else if (e.getActionCommand().equals("bedienen")) {
			bedienen();
		} else if (e.getActionCommand().equals("Alle bedienen")) {
			alleBedienen();
		}
		anzeigeAktualisieren();
	}

	private void anstellen() {
		// TODO: Ein neuer Schüler soll sich hinten in der Schlane anstellen
		// TIPP: Schueler letzter = new Schueler(ui.getEingabeSchueler());
		
	}

	private void bedienen() {
		// TODO: Der erste Schüler der Warteschlange soll bedient werden
		// Dazu soll sein Name auf der Konsole ausgegeben werden
		// und danach soll er aus der Warteschlange entfernt werden
		// TIPP: Schueler naechster = wartesch // TODO
	}

	private void alleBedienen() {
		// TODO: Alle Schueler in der Schlange sollen bedient werden
		// TIPP: Benutze deine Teillösung um einzelne Schüler zu bedienen
	}

	private void anzeigeAktualisieren() {
		ui.setAnzeigeNaechster(warteschlange.front());
	}
}
