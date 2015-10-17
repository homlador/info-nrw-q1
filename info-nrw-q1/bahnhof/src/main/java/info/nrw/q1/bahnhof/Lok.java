package info.nrw.q1.bahnhof;

public class Lok {
	
	private Stack<Waggon> gleisA;
	private Stack<Waggon> gleisB;	
	private Stack<Waggon> gleisC;
	
	public Lok() {
		gleisA = new Stack<Waggon>();
		gleisB = new Stack<Waggon>();
		gleisC = new Stack<Waggon>();
	}	
}
