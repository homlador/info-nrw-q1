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
		// TODO
		Schueler letzter = new Schueler(ui.getEingabeSchueler());
		warteschlange.enqueue(letzter);
	}

	private void bedienen() {
		// TODO
		Schueler naechster = warteschlange.front();
		System.out.println("Schueler wird bedient: " + naechster);
		warteschlange.dequeue();
	}

	private void alleBedienen() {
		// TODO
		while (warteschlange.isEmpty() == false) {
			bedienen();
		}
	}

	private void anzeigeAktualisieren() {
		ui.setAnzeigeNaechster(warteschlange.front());
	}
}
