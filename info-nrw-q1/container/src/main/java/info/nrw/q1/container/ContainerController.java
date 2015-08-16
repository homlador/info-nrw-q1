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
		view = new ContainerView(this);
	}
	
	public void reset() {
		emptyStack(containerStapel1);
		
		containerStapel1.push(new Container(1, Color.RED));
		containerStapel1.push(new Container(2, Color.BLUE));
		
		emptyStack(containerStapel2);
		containerStapel2.push(new Container(3, Color.GREEN));
		containerStapel2.push(new Container(4, Color.YELLOW));	
		
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

	public void schiffEntladenCodeX() {
		// TODO Auto-generated method stub
		
	}

	public void schiffEntladenNichtCodeX() {
		// TODO Auto-generated method stub
		
	}

	public void schiffEntladenSortiert() {
		// TODO Auto-generated method stub
		
	}
}
