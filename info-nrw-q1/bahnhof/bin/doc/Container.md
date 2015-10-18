#### Informatik GK Q1: Lineare Datenstrukturen - Stack

# Container Stapel

Das Programm simuliert einen Containerhafen: Ein Schiff legt zum be- und entladen an. Auf dem Schiff sind zwei Stapel mit Containern.
Der Hafen verfügt über einen Stapel und einen Kran, mit dem die Container bewegt werden können. Der Kranführer sieht aber immer nur den obersten Container
eines Stapels und kann auch nur diesen obersten Container auf einen anderen Stapel bewegen.

Mit jedem Aufruf von top() setzt du den Kran auf den obersten Container des jeweiligen Stapels. Der Container wird dadurch sichtbar.
Danach kannst du ihn mit dem Aufruf von push() auf einen anderen Stapel setzen. Mit pop() wird der oberste Container eines Stapels entfernt. Ob noch Container afu dem Stapel vorhanden sind, kannst du mit isEmpty() abfragen.

## Aufgaben

1. Benutze die Menupunkte um das Schiff zu entladen.

2. Visualisiere das Entladen des Schiffes, indem du die Seitenansicht schrittweise zeichnest, in der sichbar wird, welche Container auf welchem Stapel liegen. Benutze den Menupunkt "Hilfe" um mit der Seitenansicht dein Ergebnis zu überprüfen.

3. Formuliere einen Algorithmus für das Entladen des Schiffes in Pseudocode. Z.B.:
*solange Stapel1 nicht leer
usw.*

4. Betrachte zunächst den Konstruktor ContainerController(), um zu sehen, wie die Stacks initialisiert werden. Implementiere dann die Punkte aus dem Menu *Befehle*, indem du die folgendenden Methoden der Klasse ContainerController schreibst:
a) *schiffEntladen()*
b) *schiffEntladenRot()*
c) *schiffEntladenNichtRot()*
d) *schiffEntladenSortiert()*

5. Das Programm ist nach dem Model-View-Controller Architekturmuster aufgebaut. Recherchiere und erkläre das Muster anhand des vorliegenden Programmes!

6. Erkläre wie in der Klasse *Stack* eine Verkettung von Objekten (*StackNode*) zur Umsetzung des Stapels benutzt wird.