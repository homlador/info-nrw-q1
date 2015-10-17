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
	
	public void sortiertRangieren() {
		// TODO
	}
	
	private void ausgabe() {
		ausgabe("GleisA: ", gleisA);
		ausgabe("GleisB: ", gleisB);
		ausgabe("GleisC: ", gleisC);
	}

	private void ausgabe(String s, Stack<Waggon> gleis) {
		System.out.print(s);
		
		Stack<Waggon> temp = new Stack<Waggon>();		
		while(gleis.isEmpty() == false) {
			temp.push(gleis.top());
			gleis.pop();
		}
		
		while(temp.isEmpty() == false) {
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
	}
}
