package info.nrw.q1.container;

import java.awt.Color;

public class ContainerSideView {

	private ContainerController controller;
	private Canvas leinwand;
	
	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;
	private static final int CONTAINER_HEIGHT = 20;
	private static final int CONTAINER_WIDTH = 100;
	
	private static int CONTAINER_STAPEL1_X = 20;
	private static int CONTAINER_STAPEL2_X = CONTAINER_STAPEL1_X * 2 + CONTAINER_WIDTH;
	private static int CONTAINER_STAPEL_HAFEN_X = CONTAINER_STAPEL2_X + CONTAINER_STAPEL2_X + 50;
	
	public ContainerSideView(ContainerController controller) {
		this.controller = controller;
		leinwand = new Canvas("SideView", WIDTH, HEIGHT);        
		leinwand.setVisible(true);
		updateView();
	}

	private void updateView(int x, Stack<Container> stapel) {
		int y = HEIGHT-CONTAINER_HEIGHT;
		Stack<Container> temp = new Stack<Container>();
		
		while(stapel.isEmpty() == false) {
			temp.push(stapel.top());
			stapel.pop();
		}
		
		while(temp.isEmpty() == false) {
			Container c = temp.top();
			
			leinwand.setForegroundColor(c.getFarbe());
			leinwand.fillRectangle(x, y, CONTAINER_WIDTH, CONTAINER_HEIGHT);
			leinwand.setForegroundColor(Color.BLACK);
			leinwand.drawString(Integer.toString(c.getCode()), x+45, y+15);
			y = y - CONTAINER_HEIGHT;
			
			stapel.push(c);
			temp.pop();
		}
	}

	public void updateView() {
		leinwand.erase();
		updateView(CONTAINER_STAPEL1_X, controller.getStapel1());
		updateView(CONTAINER_STAPEL2_X, controller.getStapel2());
		updateView(CONTAINER_STAPEL_HAFEN_X, controller.getStapelHafen());		
	}

}
