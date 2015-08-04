package info.nrw.q1.baelle;

import java.awt.Color;

public class FarbBall extends Ball {

	private Color[] farben;
	
	private int aktuelleFarbe;
	
	public FarbBall(int xPos, int yPos, int balldurchmesser, Color ballfarbe, int bodenPosition, Canvas zeichengrund) {
		super(xPos, yPos, balldurchmesser, ballfarbe, bodenPosition, zeichengrund);		
		farben = new Color[3];
		farben[0] = farbe;
		farben[1] = Color.BLACK;
		farben[1] = Color.BLUE;
	}

	public void zeichnen() {	
		super.zeichnen();
		aendern();
	}
	
	public void aendern() {
		farbe = farben[aktuelleFarbe];
		aktuelleFarbe++;
		if (aktuelleFarbe == farben.length) {
			aktuelleFarbe = 0;
		}
	}	
	
}
