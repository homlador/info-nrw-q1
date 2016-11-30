package info.nrw.q1.suchbaum;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class HaeufigkeitsBaum extends JFrame {

	protected BinarySearchTree<StringItem> baum;

	private BinarySearchTreeView<StringItem> treeView;

	public HaeufigkeitsBaum(String title) {
		super(title);

		treeView = new BinarySearchTreeView<StringItem>(baum);
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

		JMenu integerMenu = new JMenu("String");
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

		JMenuItem integerItemSatzEinfuegen = new JMenuItem("Buchstaben aus Satz einfügen");
		integerMenu.add(integerItemSatzEinfuegen);
		integerItemSatzEinfuegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				buchstabenAusSatzEinfuegen();
			}
		});
		
		/*
		JMenuItem integerItemDateiEinfuegen = new JMenuItem("Von Datei einfügen");
		integerMenu.add(integerItemDateiEinfuegen);
		integerItemDateiEinfuegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				vonDateiEinfuegen();
			}
		});
		*/

		JMenu werkzeugeMenu = new JMenu("Werkzeuge");
		menuBar.add(werkzeugeMenu);

		JMenuItem werkzeugeItemHoehe = new JMenuItem("Höhe des Baumes");
		werkzeugeMenu.add(werkzeugeItemHoehe);
		werkzeugeItemHoehe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				JOptionPane.showMessageDialog(null, "Höhe:" + gibHoehe(baum), "Info", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		JMenuItem werkzeugeItemInOrder = new JMenuItem("InOrder Traversierung ausgeben");
		werkzeugeMenu.add(werkzeugeItemInOrder);
		werkzeugeItemInOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				List liste = new List();
				traverseInorderToList( baum, liste );
				listeAusgeben(liste, "InOrder Traversierung");
			}
		});

		JMenuItem werkzeugeItemSortierteListe = new JMenuItem("Nach Haufigkeit sortierte Liste ausgeben");
		werkzeugeMenu.add(werkzeugeItemSortierteListe);
		werkzeugeItemSortierteListe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				listeAusgeben( erstelleSortierteListe(baum), "Sortierte Liste");
			}
		});

		setVisible(true);
	}

	@Override
	public void repaint() {
		super.repaint();
		treeView.refresh();
	}

	private void neu() {
		baum = new BinarySearchTree<StringItem>();
		treeView.setTree(baum);
		repaint();
	}

	
	private void einfuegen() {
		String s = JOptionPane.showInputDialog("Einfügen", "");		
		itemMitHaeufigkeitEinfuegen(s);
		repaint();
	}

	/**
	 * TODO
	 * Ein Wort soll in den Suchbaum eingefügt werden.
	 * Falls es schon vorhanden ist, soll die Häufigkeit (Count) des
	 * existierenden Knotens erhöht werden.
	 * 
	 * @param s Das in den Suchbaum einzufügende Wort
	 */
	private void itemMitHaeufigkeitEinfuegen(String s) {
		StringItem item = new StringItem(s);
		
		// Tipp: StringItem old = (StringItem) baum. 
	
	}
		
	private void suchen() {
		String s = JOptionPane.showInputDialog(this, "Suchen", "");
		StringItem item = baum.search(new StringItem(s));
		if (item == null) {
			JOptionPane.showMessageDialog(this, "nicht gefunden");
		} else {
			JOptionPane.showMessageDialog(this, "gefunden: " + item);
		}
	}

	private void loeschen() {
		String s = JOptionPane.showInputDialog(this, "Was soll gelöscht werden?");
		baum.remove(new StringItem(s));
		repaint();
	}
	
	private void buchstabenAusSatzEinfuegen() {		
		String s = JOptionPane.showInputDialog("Satz eingeben", "");
		s = s.replaceAll(" ", "");
		s = s.toLowerCase();
		
		for (int i=0; i< s.length(); i++) {
			itemMitHaeufigkeitEinfuegen(""+ s.charAt(i));
		}
		
		repaint();
	}
	
	private void worteAusSatzEinfuegen() {		
		String s = JOptionPane.showInputDialog("Satz eingeben", "");	
		String[] words = inWorteTeilen(s);
		
		for (int i=0; i< words.length; i++) {
			itemMitHaeufigkeitEinfuegen(words[i]);
		}
		repaint();
	}
		
	private String[] inWorteTeilen(String s) {
		return s.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
	}

	/**
	 * TODO (Zusatzaufgabe)
	 * 
	 * Die Worte aus der Datei "text.txt" werden in den Suchbaum eingefügt
	 */
	private void vonDateiEinfuegen() {
		String s = "";
		BufferedReader bufferedReader = null;

		try {
			bufferedReader = new BufferedReader(new FileReader("text.txt"));

			while ((s = bufferedReader.readLine()) != null) {
				// Jede Zeit in Kleinbuchstaben umwandeln,
				// Sonderzeichen entfernen und in Worte aufteilen
				String[] words = inWorteTeilen(s);

				for (int i = 0; i < words.length; i++) {
					if (!words[i].equals("")) {
						itemMitHaeufigkeitEinfuegen(words[i]);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
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
	private void traverseInorderToList(BinarySearchTree b, List l) {
		// TODO
	}

	/**
	 * Hilfsmethode, welche eine Liste in einem Dialogfenster ausgibt
	 * 
	 * @param liste Liste zum ausgeben
	 * @param title Titel des Dialoges
	 */
	private void listeAusgeben(List liste, String title) {
		JTextArea textArea = new JTextArea();
		textArea.setSize(400, 200);	
		textArea.setLineWrap(true);
		
		JScrollPane scroll = new JScrollPane (textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(400, 200));
		
		liste.toFirst();
		while (liste.hasAccess()) {
			textArea.append(liste.getContent() + ",");
			liste.next();
		}

		JOptionPane.showMessageDialog(this, scroll, title, JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * TODO
	 * Der erstellte Baum soll genutzt werden, um eine sortierte Liste der häufigsten Wörter zu erhalten
	 * Nutze zum Sortieren einen BinärenSuchbaum, in welchen du CountedStringItems einfügst.
	 * 
	 * @return List Eine nach Häufigkeit der Worte sortierte Liste
	 */
	private List<CountedStringItem> erstelleSortierteListe(BinarySearchTree<StringItem> b) {
		List<StringItem> l = new List<StringItem>();
		traverseInorderToList(baum, l);	
		
		// Neuen Suchbaum anlegen
		BinarySearchTree<CountedStringItem> sortierterBaum = new BinarySearchTree<CountedStringItem>();
		
		// TODO: Suchbaum füllen
		
		// Neuen Scuhbaum anzeigen
		JFrame frame = new JFrame("Sortierter Baum");
		frame.setSize(800, 800);
		frame.add( new BinarySearchTreeView(sortierterBaum));
		frame.setVisible(true);
		
		// Die sortierte Liste kann nun durch eine InOrder-Traversierung erstellt werden
		List<CountedStringItem> sortierteListe = new List<CountedStringItem>();
		traverseInorderToList(sortierterBaum, sortierteListe);

		return sortierteListe;
	}
	
	/**
	 * TODO (Zusatzaufgabe)
	 * 
	 * @param wurzel Die Wurzel des Binärbaums
	 * 
	 * @return Die Höhe (Anzahl der Knoten auf dem längsten Pfad von der Wurzel)
	 */	
	@SuppressWarnings("rawtypes")
	private int gibHoehe(BinarySearchTree wurzel) {
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
	
	public static void main(String[] args) {
		new HaeufigkeitsBaum("Haeufigkeitsbaum");
	}
}
