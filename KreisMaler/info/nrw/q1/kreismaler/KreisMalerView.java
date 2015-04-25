package info.nrw.q1.kreismaler;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

/**
 * Verwendung eines Stacks um Undo und Redo Funktionalit�t umzusetzen:
 * Der Kreis kann durch Aktionen ver�ndert werden.
 * Diese Aktionen k�nnen r�ckg�ngig gemacht werden.
 */
public class KreisMalerView extends JFrame
{
    private Kreis kreis;

    private CanvasPanel canvas;

    private JButton sizeButton;
    private JSpinner sizeField;

    private JButton widthButton;
    private JSpinner widthField;
    
    private JButton undoButton;
    
    private JButton printButton;

	private JLabel printStatus;

    class CanvasPanel extends JPanel {

        public CanvasPanel() {
            setPreferredSize(new Dimension(300, 300));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
                        
            kreis.paint(g2d);
        }
    }

    public KreisMalerView(Kreis pKreis, ActionListener controller) {
        super();
        this.kreis = pKreis;

        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setSize(350,500);

        JPanel panel = new JPanel();
        setContentPane(panel);        

        sizeButton = new JButton("size");
        sizeButton.addActionListener(controller);
        add(sizeButton);

        sizeField = new JSpinner();
        sizeField.setValue(60);
        add(sizeField);

        widthButton = new JButton("width");
        widthButton.addActionListener(controller);
        add(widthButton);

        widthField = new JSpinner();
        widthField.setValue(10);
        add(widthField);
                
        canvas = new CanvasPanel();
        add(canvas);

        undoButton = new JButton("Nothing to undo");
        undoButton.setActionCommand("undo");
        undoButton.addActionListener(controller);
        add(undoButton);

        printButton = new JButton("drucken");
        printButton.addActionListener(controller);
        add(printButton);
        
        printStatus = new JLabel ("Drucker Warteschlange");
        add(printStatus);
        
        setVisible(true);
    }

    public int getSizeArgument() {
        return (Integer) sizeField.getValue();
    }

    public int getWidthArgument() {
        return (Integer) widthField.getValue();
    }
    
    public void setUndoButtonText(String s) {
        undoButton.setText(s);
    }
    
    public void setPrintStatus(String pStatus) {
    	printStatus.setText(pStatus);
    }
}
