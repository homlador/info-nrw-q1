#### Informatik GK Q1: Rekursive Datenstrukturen - Binärbäume

# Suchbäume

Binäre Bäume können auch genutzt werden, um Daten geordnet zu speichern. Dabei ist ein Element um so kleiner, je weiter links es steht. Solche Bäume werden häufig Suchbäume genannt, da sie im Vergleich zur Suche in Listen eine effektive Suche eines Elements ermöglichen. Denn wenn ein Element gesucht wird, genügt ein Vergleich mit der Wurzel, um zu entscheiden, ob der linke oder der rechte Teilbaum weiter durchsucht werden muss, wenn die Wurzel nicht schon das gesuchte Element enthält. Es muss maximal einer der Teilbäume geprüft werden. Den anderen Teilbaum braucht man nicht mehr zu berücksichtigen.

Zum Beispiel könnten Kunden nach ihrer Kundennummer geordnet in einem binären Suchbaum gespeichert werden.

![Ein Suchbaum mit Integer Zahlen](img/IntegerSuchBaum.png)

## Aufgaben

1. Erstellen Sie die Suchbäume, die entstehen, wenn die folgenden Daten in der angegebenen Reihenfolge eingefügt werden:
a) 23, 5, 12, 42, 73, 2, 1, 3
b) 1, 2, 3, 4, 5, 6

2. Welche Traversierung eines Suchbaumes ergibt eine sortierte Liste?

3. Der maximale Aufwand für das Suchen, ist proportional zur Baumhöhe. Ein extrem ungünstiger Baum ist zu einer Liste degeneriert. Ein balancierter Baum hat eine möglichst geringe Höhe. Gegenüber einer Liste ist der durchschnittliche Aufwand zum Finden eines Elements dann nicht mehr O(n) (linear) sondern O(log n) logarithmisch.
Erstellen Sie einen Suchbaum für die Zahlen von 1-15, mit der eine Zahl möglichst schnell gefunden wird.

4. Suchbäume  können genutzt werden, um die Häufigkeiten von Zeichen in Texten zu ermitteln. Zum Beispiel ist es sinnvoll für Kodierungen und Komprimierungsverfahren zu wissen, welche Zeichen häufig verwendet werden. Wenn die Kodierung der Übermittlung und nicht um Geheimhaltung dient, sollten Buchstaben, die häufig vorkommen einen einfachen Code erhalten (Siehe z.B. https://de.wikipedia.org/wiki/Shannon-Fano-Kodierung). 

Schreiben Sie für die Anwendung Haeufigkeitsbaeume die Methode ```wortMitHaeufigkeitEinfuegen()```, mit der die Häufigkeit eines Wortes im Häufigkeitsbaum angepasst wird. Beachten Sie, dass der Buchstabe im Baum evtl. noch gar nicht gespeichert wurde. Sie müssten außerdem die Klasse ```StringItem``` bearbeiten: Um die Ordnungsrelation zu vervollständigen muss das Interface ComparableContent implementiert werden!

5. Untersuchen Sie mit Hilfe der Anwendung Haeufigkeitsbaum die meistverwendeten Worte der Rapper Sido und Cro im Vergleich.
Erstellen Sie dazu eine Text Datei mit Liedtexten jedes Interpreten. Bearbeiten Sie dann die Methode ```vonDateiEinfuegen()``` und benutzen Sie den folgenden Code um die Datei zu öffnen:
```java
 bufferedReader = new BufferedReader(new FileReader("text.txt")); 
```
Sie sollten im weiteren Verlauf die Methoden ```inWorteTeilen()``` und ```wortMitHaeufigkeitEinfuegen()``` verwenden, um alle Worte zum Baum hinzuzufügen.
Um den Baum auszuwerten müssen Sie nun die Methoden ```traverseInorderToList()``` und  ```erstelleSortierteListe()``` implementieren.
