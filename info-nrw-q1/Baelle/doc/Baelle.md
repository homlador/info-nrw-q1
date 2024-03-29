#### Informatik GK Q1: Wiederholung Grundlagen OOP

# Fallende und springende Bälle

**0.** Lade die Datei *baelle-0.1.jar* aus Moodle herunter.
Es handelt sich hierbei um ein Java-Archiv (JAR), das ein kompiliertes Java-Programm enthält.
Führe die Datei durch einen Doppelklick aus: So ähnlich soll dein fertiges Programm aussehen!  

**1.** Damit ein Java-Programm gestartet werden kann, braucht es genau eine Main-Methode als Einsteigspunkt in das Programm. Die Baelle-Anwendung hat die Methode mit dem Namen *main()* in der Klasse *BaelleStart*. Importiere das Archiv *baelle-0.1-VORLAGE-src.zip* als neues Projekt in deine Entwicklungsumgebung und starte das Programm über die Main-Methode (Siehe Video-Tutorial im Moodle).

**2.** Durch Ausführen des Programmes wird die Main-Methode aufgerufen. Die Main-Methode erstellt ein neues Exemplar der Klasse *BallSpringen* unter dem Namen *baelle*. Von dem Objekt *baelle* wird dann die Methode *springenLassen()* aufgerufen. Beschreibe wie in der Methode *springenLassen()* das Springen der Baelle umgesetzt wird! Gehe insbesondere darauf ein, welche Objekte erzeugt und welche Konstrollstrukturen verwendet werden!

**Dokumentation**
Erstelle ein OpenOffice Dokument mit dem Namen Baelle-vorname-nachname.odt, welches du im Verzeichnis doc deines Projektes abspeicherst und dokumentiere hier deine Arbeitsergebnisse.

**3.** Erstelle in der Klasse *BallSpringen* einen zweiten Ball mit dem Namen *ball2*, der eine andere Farbe, Größe und Position hat, aber ebenfalls springen soll.

**4.** Erstelle zu *ball1* und *ball2* Objektdiagramme. Falls du die Diagramme am PC erstellst, speichere sie unter doc/ als Bilddatei!

**5.** Erstelle ein Implementationsdiagramm der Klasse *Ball*.  Falls du das Diagramm am PC erstellst, speichere es unter doc/ als Bilddatei!

**6.** Erstelle eine Klasse *FarbBall* (siehe Video-Tutorial) mit folgendem Quelltext:

```java
package info.nrw.q1.baelle;

import java.awt.Color;

public class FarbBall extends Ball {

	private Color[] farben;
	
	private int aktuelleFarbe;
	
	public FarbBall(int xPos, int yPos, int balldurchmesser,
		Color ballfarbe, int bodenPosition, Canvas zeichengrund) {
		super(xPos, yPos, balldurchmesser, ballfarbe,
		bodenPosition, zeichengrund);		
		farben = new Color[3];
		farben[0] = ballfarbe;
		farben[1] = Color.BLACK;
		farben[2] = Color.BLUE;
	}
}
```

Die Klasse *FarbBall* ist eine Spezialisierung (Zu erkennen am Schlüsselwort *extends*) der Klasse *Ball* und erbt alle ihre Eigenschaften und Methoden. Sie muss über einen Konstruktor mit genau den gleichen Parametern wie ihre Oberklasse verfügen. Über das Schlüsselwort *super* wird hier der Konstruktor der Oberklasse aufgerufen. Danach wird ein Array vom Typ Color mit drei Plätzen angelegt und in diesem Array drei Color-Objekte gespeichert.

Füge nun die folgenden Methoden zu der Klasse hinzu. Die Klasse *FarbBall* überschreibt hier also die Methode *zeichnen()* der Oberklasse und erhält eine eigene Methode *aendern()*. Überlege, was also diesen *FarbBall* vom normalen *Ball* unterscheidet!

```java
	public void zeichnen() {	
		super.zeichnen();
		aendern();
	}
	
	public void aendern() {
		farbe = farben[aktuelleFarbe];
		aktuelleFarbe++;
		if (aktuelleFarbe == farben.length) {
			aktuelleFarbe = 0;
		}
	}	
```

Ändere den Typ von *ball2* in der Methode *springenLassen()* von *Ball* zu FarbBall und überprüfe deine Überlegungen. Erstelle eine passende Dokumentation für die Klasse FarbBall, bei der du auch auf die Vererbung eingehst!

**7.** Recherchiere, was die Schlüsselwörter *private* und *protected* bei den Objektvariablen *farbe* und *xPosition* in der Klasse *Ball* bedeuten und erkläre, warum hier was verwendet wurde! Erkläre auch warum alle Methoden der Klasse mit dem Schlüsselwort *public* gekennzeichnet sind.

**8.** Ändere die Methode *springenLassen()* so, dass 5 Bälle springen gelassen werden. Um nicht 5 mal den gleichen Code zu schreiben, benutze  dazu ein Array namens *baelle*, um alle Bälle zu verwalten. Fülle diese Array mit normalen Baellen und einem FarbBall. Tipp:

```java
		// Array initialisieren
		baelle = new Ball[5];
		
		// Array belegen
        baelle[0] = new Ball(35, 35, 25, Color.blue, boden, leinwand);
        
		// Array durchlaufen und alle Baelle zeichnen
        for (int i=0; i<baelle.length; i++) {
        	baelle[i].zeichnen();
        }
```

**Zusatzaufgabe**: Recherchiere, warum die main() Methode diese besondere Signatur hat und was die einzelnen Bestandteile (public, static, void, String[] args) bedeuten.

**Zusatzaufgabe**: Erzeuge mit dem Menüpunkt Export->Java->Jar eine ausführbare Datei deines Programmes, die durch einen Doppelklick gestartet werden kann. Achte darauf im letzten Fenster des Export-Dialogs auch eine Klasse mit der main()-Methode auszuwählen.

**Fortgeschrittene**: Ändere die Methode springenLassen() so, dass der Benutzer angeben kann, wie viele Bälle springen sollen. 

**Fortgeschrittene**: Zeiche einen Rahmen für die Leinwand, indem du ein Rechteckt mit 20 Bildschirmpunkten Abstand zum Fensterrand zeichnest. Implementiere diese Funktionalität in einer eigenen Mehtode zeichneRahmen() in der Klasse BallSpringen und rufe diese Methode in der main() Methode auf. 

**Zusatzaufgabe für Fortgeschrittene**: Verbessere dann die Methode zeichneRahmen(), so dass diese einem Rahmen in Abhängigkeit von der Groesse der Leinwand zeichnet. Lege die Größe der Leinwand also nicht mit dieser Methode fest. Dazu musst du herausfinden, wie man mit einem Objekt der Klasse Dimension umgeht.

**Non-Plus-Ultra-Aufgabe**: Schreibe eine Methode *springenInderSchachtel()*. Diese Methode zeichnet ein Rechteck (die Schachtel) und einen oder mehrere Bälle in dieser Schachtel. Benutze für die Bälle nicht die Klasse Ball, sondern legen Sie eine neue Klasse *SchachtelBall* an. Diese definiert Bälle, die sich in einer Schachtel bewegen und von deren Wänden abprallen. Die Anfangsposition und die Geschwindigkeit eines sollchen Balles sollen zufällig gewählt werden.

 **Abgabe**: Exportiere dein Eclipse-Projekt durch Rechtsklick->Export->General->Archive File.
 