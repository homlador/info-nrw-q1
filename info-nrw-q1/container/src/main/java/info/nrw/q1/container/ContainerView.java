package info.nrw.q1.container;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class ContainerView {
	
	private Canvas leinwand;
	private ContainerController controller;
	private JMenuBar menu;
	protected ContainerSideView sideView;
	protected boolean displayTop;
	
	public static final int WIDTH = 900;
	public static final int HEIGHT = 400;
	
	private static int CONTAINER_WIDTH = 200;
	private static final int CONTAINER_HEIGHT = 80;	
	private static final int CONTAINER_Y = 200;	
	private static final int CONTAINER_TITLE_Y = CONTAINER_Y + CONTAINER_HEIGHT + 20;
	
	private static int CONTAINER_STAPEL1_X = 180;
	private static int CONTAINER_STAPEL2_X = CONTAINER_STAPEL1_X + CONTAINER_WIDTH + 50;
	private static int CONTAINER_STAPEL_HAFEN_X = CONTAINER_STAPEL2_X + CONTAINER_WIDTH + 50;
	
	public ContainerView(final ContainerController controller, boolean showSideView) {
        leinwand = new Canvas("Container View", WIDTH, HEIGHT);        
        this.controller = controller;        
        menu = new JMenuBar();          
              
        addStapelBefehle("Stapel1", CONTAINER_STAPEL1_X, controller.getStapel1());
        addStapelBefehle("Stapel2", CONTAINER_STAPEL2_X, controller.getStapel2());
        addStapelBefehle("Hafen", CONTAINER_STAPEL_HAFEN_X, controller.getStapelHafen());

        JMenuItem menuSetup = new JMenu("Setup");        
        JMenuItem menuSetup1 = new JMenuItem("Reset");
        menuSetup1.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				controller.reset();
				updateView();
			}
		});
        menuSetup.add(menuSetup1);
                
        JMenuItem menuSetup2 = new JMenuItem("Reset2");
        menuSetup2.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				controller.reset2();
				updateView();
			}
		});
        menuSetup.add(menuSetup2);
        menu.add(menuSetup);
               
        JMenuItem menuBefehle = new JMenu("Befehle");        
        JMenuItem menuEntladen = new JMenuItem("Alles entladen");
        menuEntladen.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				controller.schiffEntladen();
				updateView();
			}
		});
        menuBefehle.add(menuEntladen);
        
        JMenuItem menuEntladenCodeX = new JMenuItem("Rote Container entladen");
        menuEntladenCodeX.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				controller.schiffEntladenRot();
				updateView();
			}
		});
        menuBefehle.add(menuEntladenCodeX);
        
        JMenuItem menuEntladenNichtCodeX = new JMenuItem("Entladen außer rote Container");
        menuEntladenNichtCodeX.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				controller.schiffEntladenNichtRot();
				updateView();
			}
		});
        menuBefehle.add(menuEntladenNichtCodeX);
        
        JMenuItem menuEntladenSortiert = new JMenuItem("Sortiert entladen");
        menuEntladenSortiert.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				controller.schiffEntladenSortiert();
				updateView();
			}
		});
        menuBefehle.add(menuEntladenSortiert);
        
        menu.add(menuBefehle);        
        
        JMenuItem menuHelp = new JMenu("Hilfe");        
        JMenuItem menuTop = new JMenuItem("Top Element immer anzeigen");
        menuTop.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				displayTop = true;		
				updateView();
			}
		});
        menuHelp.add(menuTop);
        
        JMenuItem menuZeigen = new JMenuItem("Seitenansicht");
        menuZeigen.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				String s = JOptionPane.showInputDialog("Passwort?", "");				
				if (s.equals("stack")) {
					if (sideView == null) {
						sideView = new ContainerSideView(controller);
					}
				} else {
					JOptionPane.showMessageDialog(leinwand.getJFrame(), "Ahaha! You didn't say the magic word!");
					
				}			
			}
		});
        menuHelp.add(menuZeigen);
        menu.add(menuHelp);     
        leinwand.getJFrame().setJMenuBar(menu);        
        leinwand.setVisible(true);
                
        updateView();   
        
        if (showSideView) {
        	sideView = new ContainerSideView(controller);
        }
	}

	private void addStapelBefehle(final String titel, final int x, final Stack<Container> stapel) {        
        JMenuItem menuStapel = new JMenu(titel);    
        
        JMenuItem menuStapeltop = new JMenuItem("top");
        menuStapeltop.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				controller.top(stapel);				
				updateView();
				
				leinwand.setForegroundColor(Color.BLACK);
				leinwand.fillCircle(x+CONTAINER_WIDTH/2-10, CONTAINER_Y-30, 20);
			}
		});
        menuStapel.add(menuStapeltop);
  
        JMenuItem menuStapelpop = new JMenuItem("pop");
        menuStapelpop.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				controller.pop(stapel);		
				updateView();
			}
		});
        menuStapel.add(menuStapelpop);
        
        JMenuItem menuStapelPush= new JMenuItem("push");
        menuStapelPush.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				controller.push(stapel);	
				updateView();				
			}
		});
        menuStapel.add(menuStapelPush);
    
        JMenuItem menuStapelEmpty= new JMenuItem("isEmpty");
        menuStapelEmpty.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				controller.isEmpty(stapel);				
			}
		});
        menuStapel.add(menuStapelEmpty);
        
        menu.add(menuStapel);
	}

	public void updateView() {	
		leinwand.erase();
		leinwand.setForegroundColor(Color.BLACK);
		leinwand.drawString("Der Containerterminal von oben:", 200, 20);
		
		Rectangle ship = new Rectangle(CONTAINER_STAPEL1_X-10, CONTAINER_Y-60, 500, 200);
		leinwand.draw(ship);
		
		Rectangle dock = new Rectangle(CONTAINER_STAPEL_HAFEN_X-10, -10, 300, 800);
		leinwand.draw(dock);
		
		leinwand.drawLine(0, CONTAINER_Y+50, CONTAINER_STAPEL1_X-10, CONTAINER_Y-60);
		leinwand.drawLine(0, CONTAINER_Y+50, CONTAINER_STAPEL1_X-10, CONTAINER_Y+140);
		
		drawContainerStapel("Stapel 1", CONTAINER_STAPEL1_X, controller.getStapel1() );
		drawContainerStapel("Stapel 2", CONTAINER_STAPEL2_X, controller.getStapel2());
		drawContainerStapel("Hafen", CONTAINER_STAPEL_HAFEN_X, controller.getStapelHafen() );
		
		if (sideView != null) {
			sideView.updateView();
		}
	}
	
	private void drawContainerStapel(String titel, int x, Stack<Container> containerStapel) {
		leinwand.setForegroundColor(Color.BLACK);
		leinwand.drawString(titel, x+60, CONTAINER_TITLE_Y);
        
		Container oberster = containerStapel.top();
		
		if (!displayTop && controller.getSelectedContainer() != oberster) {
			return;
		}
			
		if (oberster != null) {
			leinwand.setForegroundColor(oberster.getFarbe());
			leinwand.fillRectangle(x, CONTAINER_Y, CONTAINER_WIDTH, CONTAINER_HEIGHT);
			leinwand.setForegroundColor(Color.BLACK);
			leinwand.drawString(Integer.toString(oberster.getCode()), x+90, CONTAINER_Y+40);
		} else {
			leinwand.setForegroundColor(Color.WHITE);
			leinwand.fillRectangle(x, CONTAINER_Y, CONTAINER_WIDTH, CONTAINER_HEIGHT);
			leinwand.setForegroundColor(Color.BLACK);
			leinwand.drawString("Stapel leer", x+60, CONTAINER_Y+40);
		}
	}

}
