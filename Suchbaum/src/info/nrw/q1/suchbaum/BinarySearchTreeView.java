package info.nrw.q1.suchbaum;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;


/*
 * A Viewer for Binary Trees.
 */
class BinarySearchTreeView<ContentType extends ComparableContent<ContentType>> extends JPanel {

    /* The tree currently being display */
    protected BinarySearchTree<ContentType> tree;
    
    /* The node to be highlighted */
    protected BinarySearchTree<ContentType> nodeToHighlight;

    /* The max. height of any tree drawn so far.  This
       is used to avoid the tree jumping around when nodes
       are removed from the tree. */
    protected int maxHeight;

    /* The font for the tree nodes. */
    protected Font font = new Font("Roman", 0, 14);
    
    /* 
     * Create a new window with the given width and height 
     * that is showing the given tree.
     */
    public BinarySearchTreeView(BinarySearchTree<ContentType> tree) {

        //Initialize drawing colors, border, opacity.
        setBackground(Color.white);
        setForeground(Color.black);
        
        // install initial tree.
        setTree(tree);
    }

    private int heightOfBinarySearchTree(BinarySearchTree<ContentType> t)
    {
        if (t == null || t.isEmpty())
        {
            return 0;
        }
        else
        {
            return 1 +
            Math.max(heightOfBinarySearchTree(t.getLeftTree()),
            		heightOfBinarySearchTree(t.getRightTree()));
        }
    }
    /*
     * Set the display to show the given tree.
     */ 
    public void setTree(BinarySearchTree<ContentType> t) {
        tree = t;
        maxHeight = heightOfBinarySearchTree(t);
    }

    /*
     * Invoke this method whenever you would like the window
     * to be refreshed, such as after updating the tree in some
     * way.
     */
    public void refresh() {
        paintImmediately(0,0, getWidth(), getHeight());
    }

    /*
     * Invoke this method whenever you would like the window
     * to be refreshed, such as after updating the tree in some
     * way.
     * 
     * @param n A node of the tree to be highlighted
     */
    public void refresh(BinarySearchTree<ContentType> n) {
    	nodeToHighlight = n;
    	refresh();
    }

    /*
     * Draw the contents of the tree into the given Graphics
     * context.
     * It will place all info between minX and maxX in the x-direction,
     * starting at location y in the y-direction.  Levels of the tree
     * will be separated by yStep pixels.
     */
    protected void drawTree(Graphics g, int minX, int maxX, 
                            int y, int yStep, BinarySearchTree<ContentType> tree) {
        
        g.setFont(font);
        FontMetrics fm = g.getFontMetrics();
        int width = 0;
        int height = fm.getHeight();

        int xSep = Math.min((maxX - minX)/8, 10);

        if ( tree != null && tree.getContent() != null) {
        	String s = tree.getContent().toString();
        	width = fm.stringWidth(s);
        
        	if (nodeToHighlight != null && tree.getContent() == nodeToHighlight.getContent()) {
        		g.setColor(Color.RED);
	        }
	        g.drawString(s, (minX + maxX)/2 - width/2, y + yStep/2);
	        g.setColor(Color.BLACK);
        }
        
        if (tree != null && tree.getLeftTree() != null && !tree.getLeftTree().isEmpty()) {
            // if left tree not empty, draw line to it and recursively
            // draw that tree
            g.drawLine((minX + maxX)/2 - xSep, y + yStep/2 + 5,
                       (minX + (minX + maxX)/2) / 2, 
                       y + yStep + yStep/2 - height);
            drawTree(g, minX, (minX + maxX)/2, y + yStep, yStep, tree.getLeftTree());
        }
        if (tree != null && tree.getRightTree() != null && !tree.getRightTree().isEmpty()) {
            // same thing for right subtree.
            g.drawLine((minX + maxX)/2 + xSep, y + yStep/2 + 5,
                       (maxX + (minX + maxX)/2) / 2, 
                       y + yStep + yStep/2 - height);
            drawTree(g, (minX + maxX)/2, maxX, y + yStep, yStep, tree.getRightTree());
        }
    }


    /*
     * paint method unherited from the Swing library.  Just
     * calls drawTree whenever the window needs to be repainted.
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);      //clears the background
        int width = getWidth();
        int height = getHeight();
        maxHeight = Math.max(heightOfBinarySearchTree(tree), maxHeight);
        int treeHeight = maxHeight;

        drawTree(g, 0, width, 0, height / (treeHeight + 1), tree);
    } 

}
