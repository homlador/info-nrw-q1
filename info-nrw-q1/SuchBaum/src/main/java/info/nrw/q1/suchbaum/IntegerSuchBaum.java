package info.nrw.q1.suchbaum;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class IntegerSuchBaum extends JFrame {

	protected BinarySearchTree<IntegerItem> baum;

	private BinarySearchTreeView<IntegerItem> treeView;

	public IntegerSuchBaum(String title) {
		super(title);

		treeView = new BinarySearchTreeView<IntegerItem>(baum);
		add(treeView);

		neu();
		
		setSize(800, 500);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu dateiMenu = new JMenu("Datei");
		menuBar.add(dateiMenu);

		JMenuItem dateiItemNeu = new JMenuItem("Neu");
		dateiMenu.add(dateiItemNeu);
		dateiItemNeu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				neu();
			}
		});

		JMenuItem dateiItemBeenden = new JMenuItem("Beenden");
		dateiMenu.add(dateiItemBeenden);
		dateiItemBeenden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				System.exit(0);
			}
		});

		JMenu integerMenu = new JMenu("Integer");
		menuBar.add(integerMenu);

		JMenuItem integerItemEinfuegen = new JMenuItem("Einfügen");
		integerMenu.add(integerItemEinfuegen);
		integerItemEinfuegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				einfuegen();
			}
		});

		JMenuItem integerItemLoeschen = new JMenuItem("Löschen");
		integerMenu.add(integerItemLoeschen);
		integerItemLoeschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				loeschen();
			}
		});

		JMenuItem integerItemSuchen = new JMenuItem("Suchen");
		integerMenu.add(integerItemSuchen);
		integerItemSuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				suchen();
			}
		});

		JMenuItem integerItemNEinfuegen = new JMenuItem("n IntegerItems einfügen");
		integerMenu.add(integerItemNEinfuegen);
		integerItemNEinfuegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				nEinfuegen();
			}
		});

		JMenuItem integerItemNLoeschen = new JMenuItem("n IntegerItems löschen");
		integerMenu.add(integerItemNLoeschen);
		integerItemNLoeschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				nLoeschen();
			}
		});

		JMenu werkzeugeMenu = new JMenu("Werkzeuge");
		menuBar.add(werkzeugeMenu);

		JMenuItem werkzeugeItemHoehe = new JMenuItem("Höhe des Baumes");
		werkzeugeMenu.add(werkzeugeItemHoehe);
		werkzeugeItemHoehe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				JOptionPane.showMessageDialog(null, "Höhe:" + gibHoehe(baum), "Info", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		JMenuItem werkzeugeItemSortierteListe = new JMenuItem("Sortierte Liste ausgeben");
		werkzeugeMenu.add(werkzeugeItemSortierteListe);
		werkzeugeItemSortierteListe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				sortierteListeAusgeben();
			}
		});
		

		JMenuItem werkzeugeItemTraversierungen = new JMenuItem("Traversierungen ausgeben");
		werkzeugeMenu.add(werkzeugeItemTraversierungen);
		werkzeugeItemTraversierungen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				traversierungenAusgeben();
			}
		});

		JMenuItem werkzeugeItemAusgleichen = new JMenuItem("Ausgleichen");
		werkzeugeMenu.add(werkzeugeItemAusgleichen);
		werkzeugeItemAusgleichen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				baumausgleich();
			}
		});

		setVisible(true);
	}

	@SuppressWarnings("rawtypes")
	protected int gibHoehe(BinarySearchTree wurzel) {
		if (wurzel == null || wurzel.isEmpty()) {
			return 0;
		} else {
			int l = gibHoehe(wurzel.getLeftTree());
			int r = gibHoehe(wurzel.getRightTree());
			if (l > r) {
				return 1 + l;
			} else {
				return 1 + r;
			}

			// Einfacher:
			// Math.max(heightOfBinarySearchTree(t.getLeftTree()),
			// heightOfBinarySearchTree(t.getRightTree()));
		}
	}

	@Override
	public void repaint() {
		super.repaint();
		treeView.refresh();
	}

	public void neu() {
		baum = new BinarySearchTree<IntegerItem>();
		treeView.setTree(baum);
		repaint();
	}

	protected void einfuegen() {
		int zahl = Integer.parseInt(JOptionPane.showInputDialog(this, "Einfügen", "" + (int) (Math.random() * 1000)));
		baum.insert(new IntegerItem(zahl));
		repaint();
	}

	protected void loeschen() {
		int zahl = Integer.parseInt(JOptionPane.showInputDialog(this, "Einfügen", "" + (int) (Math.random() * 1000)));
		baum.remove(new IntegerItem(zahl));
		repaint();
	}

	protected void suchen() {
		int zahl = Integer.parseInt(JOptionPane.showInputDialog(this, "Suchen", ""));
		if (baum.search(new IntegerItem(zahl)) == null) {
			JOptionPane.showConfirmDialog(this, "nicht gefunden");
		} else {
			JOptionPane.showConfirmDialog(this, "gefunden");
		}
	}

	protected void nEinfuegen() {
		int anzahl = Integer.parseInt(JOptionPane.showInputDialog(this, "wie viele einfügen?", "15"));
		int zahl;
		for (int i = 0; i < anzahl; i++) {
			do {
				zahl = (int) (Math.random() * 1000);
			} while (baum.search(new IntegerItem(zahl)) != null);
			baum.insert(new IntegerItem(zahl));
		}
		repaint();
	}

	protected void nLoeschen() {
		int anzahl = Integer.parseInt(JOptionPane.showInputDialog(this, "wie viele löschen?", "100"));
		int zahl;
		for (int i = 0; i < anzahl; i++) {
			do {
				zahl = (int) (Math.random() * 1000);
			} while (baum.search(new IntegerItem(zahl)) == null);
			baum.remove(new IntegerItem(zahl));
		}
		repaint();
	}

	/**
	 * Hilfsroutine, welche einen Baum inorder traversiert. 
	 * Die inOrder-Traversierung liefert bei einem Suchbaum dann eine sortierte Liste.
	 * 
	 * @param b
	 *            der zu durchlaufende BinarySearchTree
	 * @param l
	 *            die Liste, in der alle Elemente des Baums abgelegt werden.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void traverseInorderToList(BinarySearchTree b, List l) {
		if (b.isEmpty()) {
			// nichts zu tun, da Baum leer ist
		} else {
			traverseInorderToList(b.getLeftTree(), l);
			l.append(b.getContent());
			traverseInorderToList(b.getRightTree(), l);
		}
	}

	protected void traversePostOrderToList(BinarySearchTree b, List l) {
		if (b.isEmpty()) {
			// nichts zu tun, da Baum leer ist
		} else {
			traversePostOrderToList(b.getLeftTree(), l);
			traversePostOrderToList(b.getRightTree(), l);
			l.append(b.getContent());
		}
	}
	
	protected void traversePreOrderToList(BinarySearchTree b, List l) {
		if (b.isEmpty()) {
			// nichts zu tun, da Baum leer ist
		} else {
			l.append(b.getContent());
			traversePreOrderToList(b.getLeftTree(), l);
			traversePreOrderToList(b.getRightTree(), l);
		}
	}
	
	@SuppressWarnings("rawtypes")
	protected List erstelleSortierteListe(BinarySearchTree baum) {
		List l = new List();
		traverseInorderToList(baum, l);
		return l;
	}

	protected void traversierungenAusgeben() {
		JTextArea textArea = new JTextArea();
		textArea.setSize(400, 200);	
		textArea.setLineWrap(true);
		
		JScrollPane scroll = new JScrollPane (textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(400, 200));
		
		textArea.append("PreOrder: ");
		List preOrder = new List();
		traversePreOrderToList(baum, preOrder);
		preOrder.toFirst();
		while (preOrder.hasAccess()) {
			textArea.append(preOrder.getContent() + ",");
			preOrder.next();
		}
		textArea.append("\n");
		
		textArea.append("InOrder: ");
		List inOrder = new List();
		traverseInorderToList(baum, inOrder);
		inOrder.toFirst();
		while (inOrder.hasAccess()) {
			textArea.append(inOrder.getContent() + ",");
			inOrder.next();
		}
		textArea.append("\n");
		
		textArea.append("PostOrder: ");
		List postOrder = new List();
		traversePostOrderToList(baum, postOrder);
		postOrder.toFirst();
		while (postOrder.hasAccess()) {
			textArea.append(postOrder.getContent() + ",");
			postOrder.next();
		}
		
		textArea.append("\n");
		textArea.append("Max: " + max(baum));
		

		JOptionPane.showMessageDialog(this, scroll, "Traversierungen", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private IntegerItem max(BinarySearchTree<IntegerItem> b) {
		if (b.getRightTree().getContent() != null) {
			return max(b.getRightTree());
		} else {
			return b.getContent();
		}
	}

	@SuppressWarnings("rawtypes")
	protected void sortierteListeAusgeben() {
		List sortierteListe = erstelleSortierteListe(baum);
		
		JTextArea textArea = new JTextArea();
		textArea.setSize(400, 200);	
		textArea.setLineWrap(true);
		
		JScrollPane scroll = new JScrollPane (textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(400, 200));
		
		sortierteListe.toFirst();
		while (sortierteListe.hasAccess()) {
			textArea.append(sortierteListe.getContent() + ",");
			sortierteListe.next();
		}

		JOptionPane.showMessageDialog(this, scroll, "Sortierte Liste", JOptionPane.INFORMATION_MESSAGE);
	}

	protected void erstelleBaum(IntegerItem[] IntegerItems, int links, int rechts) {
		if (links <= rechts) {
			int mitte = (links + rechts) / 2;
			baum.insert(IntegerItems[mitte]);
			erstelleBaum(IntegerItems, links, mitte - 1);
			erstelleBaum(IntegerItems, mitte + 1, rechts);
		}
	}

	@SuppressWarnings("rawtypes")
	protected void baumausgleich() {
		List list = erstelleSortierteListe(baum);
		int count = 0;
		for (list.toFirst(); list.hasAccess(); list.next()) {
			count++;
		}
		IntegerItem[] IntegerItems = new IntegerItem[count];
		list.toFirst();
		for (int i = 0; i < count; i++) {
			IntegerItems[i] = (IntegerItem) list.getContent();
			list.next();
		}
		neu();
		erstelleBaum(IntegerItems, 0, count - 1);
		repaint();
	}

	public static void main(String[] args) {
		new IntegerSuchBaum("IntegerSuchBaum");
	}
}
