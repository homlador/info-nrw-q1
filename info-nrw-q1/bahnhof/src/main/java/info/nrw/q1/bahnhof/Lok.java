package info.nrw.q1.bahnhof;

public class Lok {

	private Stack<Waggon> gleisA;
	private Stack<Waggon> gleisB;
	private Stack<Waggon> gleisC;

	public Lok() {
		gleisA = new Stack<Waggon>();
		gleisB = new Stack<Waggon>();
		gleisC = new Stack<Waggon>();
		
		gleisA.push(new Waggon(6));
		gleisA.push(new Waggon(11));
		gleisA.push(new Waggon(15));
		gleisA.push(new Waggon(14));
	}
	
	public void alleWaggonsueberpruefen() {
		// TODO
	}

	public void sortiertRangieren(Stack<Waggon> herkunftsGleis, Stack<Waggon> hilfsGleis, Stack<Waggon> zielGleis) {
		
		while (herkunftsGleis.isEmpty() == false) {
			Waggon w = herkunftsGleis.top();
			
			if (zielGleis.isEmpty() || w.gibNummer() > zielGleis.top().gibNummer() ) { 
				zielGleis.push(w);
				herkunftsGleis.pop();
			} else {
				while (zielGleis.isEmpty() == false && zielGleis.top().gibNummer() > w.gibNummer()) {
					hilfsGleis.push(zielGleis.top());
					zielGleis.pop();
				}
			}
		}
		
		if (hilfsGleis.isEmpty() == false) {
			sortiertRangieren(hilfsGleis, herkunftsGleis, zielGleis);
		}
	}

	public void ausgabe() {
		ausgabe("GleisA: ", gleisA);
		ausgabe("GleisB: ", gleisB);
		ausgabe("GleisC: ", gleisC);
	}

	public void ausgabe(String s, Stack<Waggon> gleis) {
		System.out.print(s);

		Stack<Waggon> temp = new Stack<Waggon>();
		while (gleis.isEmpty() == false) {
			temp.push(gleis.top());
			gleis.pop();
		}

		while (temp.isEmpty() == false) {
			Waggon w = temp.top();
			System.out.print(w.gibNummer());
			gleis.push(w);
			temp.pop();
			if (temp.isEmpty() == false) {
				System.out.print(",");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Lok l = new Lok();
		l.ausgabe();
			
		l.alleWaggonsueberpruefen();
		// TODO: Die folgende Zeile einkommentieren um das Sortieren zu testen
		//l.sortiertRangieren(l.gleisA, l.gleisB, l.gleisC);
		
		l.ausgabe();
	}
}
