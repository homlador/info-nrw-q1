#### Informatik GK Q1: Lineare Datenstrukturen - Stack

Gegeben ist ein Güterbahnhof mit den Gleisen A, B und C. Auf Gleis A stehen nummerierte Waggons, die nach einer Überprüfung ob die Fracht noch in Ordnung ist so rangiert werden sollen, dass sie anschließend in einer gewünschten Reihenfolge auf Gleis C stehen sollen. Folgende Vorgaben müssen beachtet werden: 

* Von der Lok aus kann immer nur der vorderste Waggon auf den Gleisen betrachtet oder angekoppelt werden
* Die Lok kann immer nur einen Waggon ziehen.
* Gleis B (oder auch später A) können als Abstellgleis benutzt werden. 

Das Rangieren der Lok soll programmgesteuert erfolgen.

## Aufgaben

1. Zunächst sollen alle Waggons von Gleis A überprüft und wenn das Ergebnis der Prüfung mit der Methode istOK() true ergab auf Gleis B abgestellt werden, andernfalls auf Gleis C. Implementieren Sie die Methode alleWaggonsUeberpruefen() für die Klasse Lok.

2. Auf dem Güterbahnhof werden verschiedene Arten von Waggons angefertigt. Neben den normalen Waggons, 
die keiner besonderen Überprüfung bedürfen, gibt es noch Kühlwaggons, die eine bestimmte Temperatur halten müssen 
und Sicherheitswaggons, deren Schließmechanismus überprüft werden muss. Daneben gibt es noch Gefahrengut-Transporte, 
bei denen sowohl der Schließmechanismus in Ordnung sein muss, als auch der Druck innerhalb des Waggons
nicht unter einen Richtwert fallen darf.
	- a) Erläutern Sie, warum die von Ihnen in Aufgabe 1 entwickelte Methode durch Verwendung von Polymorphie auch mit verschiedenen Arten von Waggons verwendbar ist.
	- b) Entwickeln Sie ein Entwurfsdiagramm für die oben angegebenen Arten von Waggons, aus dem eine sinnvolle Klassenhierarchie sichtbar wird.
	- c) Implementieren Sie die oben angegebenen Klassen!

3. Kommentieren Sie die Methode sortiertRangieren() ausfuehrlich. Erklären Sie dabei inwiefern die Methode rekursiv arbeitet!

4. *Zusatzaufgabe*: Vervollständigen Sie den UnitTest in der Klasse *StackTest* um die Funktion der Klasse *Stack* zu überprüfen. 