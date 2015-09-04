package info.nrw.q1.container;

import java.awt.Color;

import javax.swing.JOptionPane;

public class ContainerController {
	
	private Stack<Container> containerStapel1;
	private Stack<Container> containerStapel2;
	
	private Stack<Container> containerStapelHafen;
	
	private Container selectedContainer;
	
	ContainerView view;
	
	public ContainerController() {
		containerStapel1 = new Stack<Container>();
		containerStapel2 = new Stack<Container>();
		containerStapelHafen = new Stack<Container>();
		
		reset();		
		// FIXME: Seitenansicht per Default aus
		view = new ContainerView(this, true);
	}
	
	public void reset() {
		emptyStack(containerStapel1);
		
		containerStapel1.push(new Container(1, Color.RED));
		containerStapel1.push(new Container(2, Color.GRAY));
		containerStapel1.push(new Container(3, Color.ORANGE));
		containerStapel1.push(new Container(3, Color.RED));
		
		emptyStack(containerStapel2);
		containerStapel2.push(new Container(4, Color.GREEN));
		containerStapel2.push(new Container(5, Color.YELLOW));	
		
		emptyStack(containerStapelHafen);
		selectedContainer = null;
	}
	
	public void reset2() {
		emptyStack(containerStapel1);
				
		containerStapel1.push(new Container(7, Color.RED));
		containerStapel1.push(new Container(3, Color.GRAY));
		
		emptyStack(containerStapel2);
		containerStapel1.push(new Container(2, Color.ORANGE));
		containerStapel2.push(new Container(3, Color.GREEN));
		containerStapel2.push(new Container(9, Color.YELLOW));	
		containerStapel2.push(new Container(5, Color.RED));
		
		emptyStack(containerStapelHafen);
		selectedContainer = null;
	}
	
	private void emptyStack(Stack<Container> stapel) {
		while (!stapel.isEmpty()) {
			stapel.pop();
		}		
	}

	public Stack<Container> getStapel1() {
		return containerStapel1;
	}

	public Stack<Container> getStapel2() {
		return containerStapel2;
	}

	public Stack<Container> getStapelHafen() {
		return containerStapelHafen;
	}

	public Container getSelectedContainer() {
		return selectedContainer;		
	}
	
	public void pop(Stack<Container> stapel) {
		stapel.pop();
	}
	
	public void top(Stack<Container> stapel) {
		 selectedContainer = stapel.top();
	}

	public void push(Stack<Container> stapel) {
		stapel.push(selectedContainer);		
	}
	
	public void isEmpty(Stack<Container> stapel) {		
		JOptionPane.showMessageDialog(null, "isEmpty: " + stapel.isEmpty());
	}
	
	public void schiffEntladen() {
		while (containerStapel1.isEmpty() == false) {
			Container oberster = containerStapel1.top();
			containerStapelHafen.push(oberster);
			containerStapel1.pop();
		}
		
		// TODO: Entladen des zweiten Stapels ergänzen
		while (containerStapel2.isEmpty() == false) {
			Container oberster = containerStapel2.top();
			containerStapelHafen.push(oberster);
			containerStapel2.pop();
		}
	}

	public void schiffEntladenRot() {
		while (containerStapel1.isEmpty() == false) {
			Container oberster = containerStapel1.top();
			if (oberster.getFarbe() == Color.RED) {
				containerStapelHafen.push(oberster);
			} else {
				containerStapel2.push(oberster);
			}
			containerStapel1.pop();
		}
		
		while (containerStapel2.isEmpty() == false) {
			Container oberster = containerStapel2.top();
			if (oberster.getFarbe() == Color.RED) {
				containerStapelHafen.push(oberster);
			} else {
				containerStapel1.push(oberster);
			}
			containerStapel2.pop();
		}
	}

	public void schiffEntladenNichtRot() {
		while (containerStapel1.isEmpty() == false) {
			Container oberster = containerStapel1.top();
			if (oberster.getFarbe() != Color.RED) {
				containerStapelHafen.push(oberster);
			} else {
				containerStapel2.push(oberster);
			}
			containerStapel1.pop();
		}
		
		while (containerStapel2.isEmpty() == false) {
			Container oberster = containerStapel2.top();
			if (oberster.getFarbe() != Color.RED) {
				containerStapelHafen.push(oberster);
			} else {
				containerStapel1.push(oberster);
			}
			containerStapel2.pop();
		}
	}

	public void schiffEntladenSortiert() {
		allesAufStapel1();
		
		while (containerStapel1.isEmpty() == false) {			
			kleinsteVon1AufHafen();
			allesAufStapel1();			
		}		
	}
	
	private void kleinsteVon1AufHafen() {
		JOptionPane.showMessageDialog(null, "kleinsteVon1AufHafen...");
		
		// Der oberste wird als kleinste angenommen
		Container kleinste = containerStapel1.top();
		containerStapelHafen.push(kleinste);
		containerStapel1.pop();
		
		view.updateViewAndWait();
		
		while (containerStapel1.isEmpty() == false) {
			//JOptionPane.showMessageDialog(null, "kleinsteVon1AufHafen: Stapel1 nicht leer...");
			
			Container oberster = containerStapel1.top();
			if (oberster.getCode() < kleinste.getCode()) {
				containerStapel2.push(kleinste);
				containerStapelHafen.pop();
				containerStapelHafen.push(oberster);
				containerStapel1.pop();
				kleinste = oberster;
			} else {
				containerStapel2.push(oberster);
				containerStapel1.pop();
			}		
			// FIXME: Visualisation hakt
			view.updateViewAndWait();
		}		
	}

	private void allesAufStapel1() {
		JOptionPane.showMessageDialog(null, "allesAufStapel1...");
		
		while (containerStapel2.isEmpty() == false) {
			Container oberster = containerStapel2.top();
			containerStapel1.push(oberster);
			containerStapel2.pop();
		}
		
		view.updateView();
	}
}
