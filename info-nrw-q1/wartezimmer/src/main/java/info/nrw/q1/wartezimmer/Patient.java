package info.nrw.q1.wartezimmer;

public class Patient {
	private String name;
	private String kasse;

	/**
	 * Erzeugt einen Patienten mit Namen und Kasse.
	 * 
	 * @param pName
	 * @param pKasse
	 */
	public Patient(String pName, String pKasse) {
		name = pName;
		kasse = pKasse;
	}

	/**
	 * @return liefert name
	 */
	public String gibName() {
		return name;
	}

	/**
	 * @param name
	 *            setzt name
	 */
	public void setzeName(String name) {
		this.name = name;
	}

	/**
	 * @return liefert kasse
	 */
	public String gibKasse() {
		return kasse;
	}

	/**
	 * @param kasse
	 *            setzt kasse
	 */
	public void setzeKasse(String kasse) {
		this.kasse = kasse;
	}

}
