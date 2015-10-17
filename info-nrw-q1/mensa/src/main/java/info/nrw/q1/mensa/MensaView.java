package info.nrw.q1.mensa;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MensaView extends JFrame {

	private JLabel labelSchueler, laebelNaechster;
	private JTextField eingabeSchueler, anzeigeNaechster;
	private JButton buttonAnstellen, buttonBedienen, buttonAlleBedienen;
	private JPanel contentpane;

	public MensaView(ActionListener controller) {
		setTitle("MensaView");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentpane = new JPanel();
		setContentPane(contentpane);

		labelSchueler = new JLabel("Schüler:");
		contentpane.add(labelSchueler);
		
		eingabeSchueler = new JTextField("", 20);
		contentpane.add(eingabeSchueler);
				
		buttonAnstellen = new JButton("anstellen");
		buttonAnstellen.addActionListener(controller);
		contentpane.add(buttonAnstellen);
				
		laebelNaechster = new JLabel("Nächste(r):");
		contentpane.add(laebelNaechster);
		
		anzeigeNaechster = new JTextField("", 20);		
		contentpane.add(anzeigeNaechster);
		
		buttonBedienen = new JButton("bedienen");
		buttonBedienen.addActionListener(controller);
		contentpane.add(buttonBedienen);
		
		buttonAlleBedienen = new JButton("Alle bedienen");
		buttonAlleBedienen.addActionListener(controller);
		contentpane.add(buttonAlleBedienen);
		
		pack();
		setVisible(true);
	}

	public void setAnzeigeNaechster(Schueler s) {
		anzeigeNaechster.setText(s != null ? s.getName() : "");
	}

	public String getEingabeSchueler() {
		return eingabeSchueler.getText();
	}
}
