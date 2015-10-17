package info.nrw.q1.mensa;

class Schueler {
	private String name;

	public Schueler(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "Schuler '" + name + "'";
	}
}