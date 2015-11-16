package info.nrw.q1.wartezimmer;

public class ArztpraxisMitBDController {
	
	private Arztpraxis2View praxisGUI;
	private Queue<Patient> wzimmer;
	private Queue<Patient> wbdmessung;
	private Patient wirdBehandelt;

	public ArztpraxisMitBDController() {
		praxisGUI = new Arztpraxis2View();
		wzimmer = new Queue<Patient>();
		wbdmessung = new Queue<Patient>();
		wirdBehandelt = null;
		praxisGUI.setzeArztpraxisController(this);
		praxisGUI.setVisible(true);
	}

	/**
	 * TODO
	 */
	public void bearbeiteAnmeldungSprechzimmer(String name, String kasse) {
		// TODO: Ein neuer Patient soll angemeldet werden
	}

	/**
	 * TODO
	 */
	public void bearbeiteNaechsterPatient() {
		
		// TODO: Der nächste Patien aus dem Wartezimmer soll in das Sprechzimmer gerufen werden.
		// Die folgenden Methoden stehen dir zur Lösung zur Verfügung:
		
		// praxisGUI.leereSprechzimmer();
		// praxisGUI.zeigeMeldung();
		// praxisGUI.setzeInsSprechzimmer();
	}

	/**
	 * TODO
	 */
	public void bearbeiteAnmeldungSprechzimmerUndBlutdruckmessung(String name, String kasse) {
		// TODO: Ein Patient soll für das Sprechzimmer und die Blutdruckmessung angemeldet werden
	}

	/**
	 * TODO
	 */
	public void bearbeiteNaechsteMessung() {
		if (wbdmessung.isEmpty()) {
			praxisGUI.zeigeMeldung("Es gibt keinen Patienten f??r die Blutdruckmessung.");
			return;
		}
		Patient dran = wbdmessung.front();
		wbdmessung.dequeue();
		if (dran == wirdBehandelt) {
			praxisGUI.zeigeMeldung("Der Patient " + wirdBehandelt.gibName() + " " + wirdBehandelt.gibKasse()
					+ " wird \ngerade behandelt. Die Blutdruckmessung erfolgt direkt im Anschluss.");
		} else {
			praxisGUI.zeigeMeldung(
					"Der Blutdruck des Patienten " + dran.gibName() + " " + dran.gibKasse() + " wurde gemessen");
		}
		praxisGUI.setzeNaechsterBD("-");
		if (!wbdmessung.isEmpty()) {
			praxisGUI.setzeNaechsterBD(wbdmessung.front().gibName() + " " + wbdmessung.front().gibKasse());
		}

	}

	// TODO: Alle am Tag behandelten Patienten sollen in umgekehrter Reihenfolge mit System.out.println() ausgegeben  werden 
	public void alleAktendurchgehen() {
		
	}

}
