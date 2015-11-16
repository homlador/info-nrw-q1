#### Informatik GK Q1: Lineare Datenstrukturen - Stack und Queue

# KreisMaler

Das Programm KreisMaler demonstriert beispielhaft die Verwendung von Stacks und Queues in Anwendungsprogrammen am Beispiel einer Funktion zum Rückgängig machen und Wiederherstellen von Aktionen (Undo/Redo) und einer Druckerwarteschlange. 

Das Programm ist die Grundversion eines vektorbasierten Zeichenprogramms: Es kann eine geometrische Figur (einen Kreis) darstellen und diese kann in einigen EIgenschaften verändert werden. 

## Teil I: Implementation

### Pflichtaufgaben:

* Aktionen sollen rückgängig gemacht werden können
* Hinzufügen und Löschen von Druckaufträgen

### Wahlaufgaben (mindestens zwei):

* Redo: Rückgängig gemachte Funktionen sollen erneut durchgeführt werden können
* JUnit Test um die Funktionalität des Stack zu testen
* Weitere Aktionen (z.B. WidthAction)
* Eine alternative grafische Form soll gezeichnet werden (z.B. Rechteck)
* Alternative View mit anderer Anordnung der Elemente

Achtet darauf, euren Code zu kommentieren, d.h. jede mit TODO markierte Klasse und Methode muss durch JavaDoc-Kommentare kurz beschrieben werden (inkl. Parameter und Rückgabewert). Besondere Stellen in einzelnen Methoden sollten zusätzlich erläutert werden.

## Teil II: Dokumentation
    
* Erkläre anhand der Klasse Kreis das „Geheimnisprinzip“ (Kapselung)!
         
* Erkläre die Klassenhierarchie von Action, SizeAction und WidthAction! Welche Rolle spielt Polymorphie in dem Programm?
         
* Erkläre die Zeile „private Stack<Action> undoStack;“ in der Klasse KreisMaler: Objekte welchen Typs kann der Stack verwalten? Welche Rolle spielt generische Programmierung dabei?

* *Fortgeschrittene:* Action ist eine "abstrakte Klasse", was bedeutet das? Warum wurde diese Lösung gewählt? Erkläre den Konstruktor der Klasse SizeAction, insbesondere die Zeile „super(pKreis);“.

* *Fortgeschrittene:* Die Klasse KreisMaler implementiert das Interface ActionListener. Was ist ein Interface? Schau in der Dokumentation nach: Welche Methoden definiert das Interface? Wo werden sie genutzt und wozu?

## Abgabe

Bis Di, 15.12. per Moodle als Eclipse-Projekt ("Export->Archive File") mit digitaler Dokumentation als OpenOffice-Datei im Verzeichnis "doc". 
