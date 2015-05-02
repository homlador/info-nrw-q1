package info.nrw.q1.suchbaum;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
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

// TODO: 	public void baumausgleich() für Shannon-Fano-Kodierung
public class HaeufigkeitsBaum extends JFrame {

	protected BinarySearchTree<StringItem> baum;

	private BinarySearchTreeView<StringItem> treeView;

	public HaeufigkeitsBaum(final String title) {
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

		JMenuItem dateiItemInfo = new JMenuItem("Info");
		dateiMenu.add(dateiItemInfo);
		dateiItemInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JPanel panel = new JPanel();
				panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
								
				panel.add(new JLabel(Version.VERSION));
				panel.add(new JLabel("Autoren siehe README"));
				panel.add(new JLabel("Code, Arbeitsblätter, Lösungen unter:"));
				final String projektSeite = "https://homlador.github.io/informatik-nrw-q1";
				JButton b = new JButton(projektSeite);
				b.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						if (Desktop.isDesktopSupported()) {
							try {
								Desktop.getDesktop().browse(new URI(projektSeite));
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				});
				panel.add(b);
				JOptionPane.showMessageDialog(null, panel, "Info", JOptionPane.INFORMATION_MESSAGE);
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

		JMenuItem integerItemSatzEinfuegen = new JMenuItem("Satz einfügen");
		integerMenu.add(integerItemSatzEinfuegen);
		integerItemSatzEinfuegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				satzEinfuegen();
			}
		});
		
		JMenuItem integerItemDateiEinfuegen = new JMenuItem("Von Datei einfügen");
		integerMenu.add(integerItemDateiEinfuegen);
		integerItemDateiEinfuegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				vonDateiEinfuegen();
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

		setVisible(true);
	}

	@Override
	public void repaint() {
		super.repaint();
		treeView.refresh();
	}

	public void neu() {
		baum = new BinarySearchTree<StringItem>();
		treeView.setTree(baum);
		repaint();
	}

	
	protected void einfuegen() {
		String s = JOptionPane.showInputDialog("Einfügen", "");		
		wortMitHaeufigkeitEinfuegen(s);
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
	private void wortMitHaeufigkeitEinfuegen(String s) {
		StringItem item = new StringItem(s);
		
		StringItem old = (StringItem) baum.search(item);

		if (old != null) {
			old.setCount(old.getCount() + 1);
		} else {
			baum.insert(item);
		}
	}
		
	protected void suchen() {
		String s = JOptionPane.showInputDialog(this, "Suchen", "");
		StringItem item = baum.search(new StringItem(s));
		if (item == null) {
			JOptionPane.showMessageDialog(this, "nicht gefunden");
		} else {
			JOptionPane.showMessageDialog(this, "gefunden: " + item);
		}
	}


	protected void loeschen() {
		String s = JOptionPane.showInputDialog(this, "Einfügen");
		baum.remove(new StringItem(s));
		repaint();
	}
	

	private void satzEinfuegen() {		
		String s = JOptionPane.showInputDialog("Einfügen", "");	
		String[] words = inWorteTeilen(s);
		
		for (int i=0; i< words.length; i++) {
			wortMitHaeufigkeitEinfuegen(words[i]);
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
	protected void vonDateiEinfuegen() {
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
						wortMitHaeufigkeitEinfuegen(words[i]);
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
	protected void traverseInorderToList(BinarySearchTree b, List l) {
		if (b.isEmpty()) {
			// nichts zu tun, da Baum leer ist
		} else {
			traverseInorderToList(b.getLeftTree(), l);
			l.append(b.getContent());
			traverseInorderToList(b.getRightTree(), l);
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

	/**
	 * TODO
	 * Der erstellte Baum soll genutzt werden, um eine sortierte Liste der häufigsten Wörter zu erhalten
	 * Nutze zum Sortieren einen BinärenSuchbaum!
	 * 
	 * @return List Eine nach Häufigkeit der Worte sortierte Liste
	 */
	protected List<CountedStringItem> erstelleSortierteListe(BinarySearchTree<StringItem> b) {
		List<StringItem> l = new List<StringItem>();
		traverseInorderToList(baum, l);		
		BinarySearchTree<CountedStringItem> sortierterBaum = new BinarySearchTree<CountedStringItem>();
		
		l.toFirst();
		while (l.hasAccess()) {
			StringItem item = (StringItem) l.getContent();
			sortierterBaum.insert(new CountedStringItem(item.getContent(), item.getCount()));
			l.next();
		}
		
		JFrame frame = new JFrame("Sortierter Baum");
		frame.setSize(800, 800);
		frame.add( new BinarySearchTreeView<>(sortierterBaum));
		frame.setVisible(true);
		
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
	
	public static void main(String[] args) {
		new HaeufigkeitsBaum("Haeufigkeitsbaum");
	}
}
