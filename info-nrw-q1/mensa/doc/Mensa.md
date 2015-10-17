#### Informatik GK Q1: Lineare Datenstrukturen - Queue

# Warteschlange in der Mensa

Das Programm simuliert einen Containerhafen: Ein Schiff legt zum be- und entladen an. Auf dem Schiff sind zwei Stapel mit Containern.
Der Hafen verfügt über einen Stapel und einen Kran, mit dem die Container bewegt werden können. Der Kranführer sieht aber immer nur den obersten Container
eines Stapels und kann auch nur diesen obersten Container auf einen anderen Stapel bewegen.

Mit jedem Aufruf von top() setzt du den Kran auf den obersten Container des jeweiligen Stapels. Der Container wird dadurch sichtbar.
Danach kannst du ihn mit dem Aufruf von push() auf einen anderen Stapel setzen. Mit pop() wird der oberste Container eines Stapels entfernt. Ob noch Container afu dem Stapel vorhanden sind, kannst du mit isEmpty() abfragen.

## Aufgaben

*Fortgeschrittene*: Implementiere die Klasse Queue.
Teste deine Implementation mit dem UnitTest QueueTest.

1. Lies die Dokumentation zur Abi NRW Klasse Queue. und erstelle ein Objektdiagramm mit den Klassen Queue und QueueNode, inkl. Beziehungen zwischen den Objekten für die folgende Situation:

2. Implementiere die fehlenden Methoden in der Klasse MensaController.

3. Beschreibe, wie das Programm die MVC-Architektur umsetzt.

