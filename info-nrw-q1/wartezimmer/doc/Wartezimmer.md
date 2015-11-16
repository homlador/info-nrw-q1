#### Informatik GK Q1: Lineare Datenstrukturen - Queue

# Wartezimmer
 
Im Laufe eines Tages kommen zu zufälligen Zeiten Patienten zur Behandlung in eine Arztpraxis. Sobald ein Patient eintrifft werden sein Name und seine Krankenkasse erfasst. Die Patienten werden in der Reihenfolge ihres Eintreffens in das Wartezimmer gesetzt und in dieser Reihenfolge behandelt.

Manche Patienten verbinden den Arztbesuch mit einer Blutdruckmessung. Diese Patienten werden somit sowohl in einer Warteschlange für die Sprechstunde als auch in einer Warteschlange für die Blutdruckmessung geführt. Sollte ein Patient gerade in der Sprechstunde weilen, während er zur Blutdruckmessung gerufen wird, wird er aus der Warteschlange für die Blutdruckmessungen entfernt. Die Messung erfolgt unmittelbar im Anschluss an den Arztbesuch und wird der Einfachheit halber in der Simulation nicht gesondert berücksichtigt. Es wird davon ausgegangen, dass die Blutdruckmessung selbst so wenig Zeit in Anspruch nimmt, dass der Fall, dass ein Patient während einer Blutdruckmessung ins Sprechzimmer gerufen wird, nicht berücksichtigt werden muss.

Nachdem ein Patient behandelt wurde, wird seine Akte auf einen Stapel gelegt. Am Ende eines Tages wird dieser Stapel zur Abrechnung bearbeitet und alle Patienten in umgekehrter Reihenfolge ausgegeben. 

## Teil I: Implementation

### Aufgaben

Entwickelt ein Simulationsprogramm für diese Patientenverwaltung unter Verwendung der generischen Klasse Queue<ContentType>.

Achtet darauf, euren Code zu kommentieren, d.h. jede mit TODO markierte Klasse und Methode muss durch JavaDoc-Kommentare kurz beschrieben werden (inkl. Parameter und Rückgabewert). Besondere Stellen in einzelnen Methoden sollten zusätzlich erläutert werden.

## Teil II: Dokumentation

* Erstellt ein Implementationsdiagramm (Abgabe als Bilddatei im Verzeichnis "doc")

* Erkläre anhand der Klasse Patient das „Geheimnisprinzip“ (Kapselung)!

* Erkläre die Zeile „Queue<Patient> wzimmer“ in der Klasse ArztpraxisMitBDController: Objekte welchen Typs kann die Queue verwalten? Welchen Vorteil bietet generische Programmierung?

## Abgabe

Bis Di, 15.12. per Moodle als Eclipse-Projekt ("Export->Archive File") mit digitaler Dokumentation als OpenOffice-Datei im Verzeichnis "doc". 
