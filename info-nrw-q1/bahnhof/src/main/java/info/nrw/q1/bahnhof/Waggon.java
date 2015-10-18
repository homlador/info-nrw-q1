package info.nrw.q1.bahnhof;

public class Waggon {
	
	int nummer;
	
	public Waggon(int pNummer) {
		super();
		this.nummer = pNummer;
	}

	public int gibNummer() {
		return nummer;
	}
	
	public boolean istOK() {
		System.out.println(this + " Normaler Waggon: OK");
		return true;
	}
	
	public String toString() {
		return "Waggon Nr. " + nummer;
	}
}

