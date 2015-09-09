# Übungsaufgabe „Polymorphie“

```java
public class TierHeim
{
    private Tier alleTiere[];

    public TierHeim()
    {
        alleTiere = new Tier[6];
        alleTiere[0] = new Katze("Tom");
        alleTiere[1] = new Hund("Pluto");
        alleTiere[2] = new Maus("Jerry");
        alleTiere[3] = new KampfHund("Bruno");
        alleTiere[4] = new Katze("Casimir");
        alleTiere[5] = new Hund("Lassie");
    }

    public void tierChor()
    {   
        System.out.println("Der TierChor singt...");
        for (int i=0; i< alleTiere.length; i++)
        {
            System.out.print(alleTiere[i].gibName() + ": " );
            alleTiere[i].gibLaut();
            System.out.println(); // Neue Zeile nach jedem Tier
        }
    }
}

public class Tier
{
    private String zName;
    
    public Tier(String pName)
    {
        zName = pName;
    }

    public String gibName()
    {
        return zName;    
    }
     
    public void gibLaut()
    {
    }
}

public class Hund extends Tier
{
    public Hund(String pName)
    {
        super(pName);
    }

    public void gibLaut()
    {
        System.out.print("Wuff");   
    }
}
```

Hinweis: Der Dienst „System.out.print()“ gibt seine Parameter auf der Konsole aus. „println()“, beginnt danach zusätzlich eine neue Zeile. Mit dem Operator „+“ werden Zeichenketten verbunden.  „bla“ + „ fasel“ ergibt also „bla fasel“.

## Arbeitsanweisungen

1. Erstelle ein Diagramm aller Klassen, um die Ist-Beziehungen zu visualisieren und dir einen Überblick zu verschaffen.

2. Ermittle die Ausgabe der Methode tierChor() ohne das Programm auszuführen und schreibe das von dir erwartete Ergebnis auf (7 Zeilen).

3. Überprüfe deine Ergebnisse aus 2, indem du das Programm ausführst.

4. Erstelle eine neues Tier: KampfKatze, welche nicht nur „Miau“ macht, sondern „Fauch Miau“

5. Erstelle ein neues Tier deiner Wahl!

6. Ergänze die Katze um eine Methode *tanzen()*, welche die Ausgabe "\*tanz\*" erzeugt. Bearbeite die Methode *tierChor()* in TierHeim.java so, dass alle Katzen nach dem Singen auch tanzen. Achtung: Nicht jedes Tier kann tanzen! Recherchiere daher die Verwendung des Operators *instanceof*.

7. Zusatzaufgabe: Die Hunde können nicht tanzen, können aber mit dem Schwanz wedeln, was sie zu dem Lied nun auch tun wollen. Implementiere dies, analog zur Aufgabe 6!

*Fortgeschrittene*

8. Langsam wird es kompliziert: Komischerweise haben die Hunde das Wedeln mit dem Schwanz auch den Mäusen beigebracht. Nun gibt es zwei verschiedene Tiere, die aber eine ähnliche Fähigkeit haben. Um eine wiederholte Abfrage mit *instanceof* zu vermeiden, soll hier Vererbung genutzt werden. Die beiden Klassen sind jedoch schon Erben der Klasse Tier und in Java kann eine Klasse aber immer nur eine Oberklasse haben, da Mehrfachvererbung viele Probleme bereiten kann. Um die neue Fähigkeit verwalten zu können, soll das *Interface* KannWedeln erstellt werden, das die Methode *wedeln()* definiert:

```java
package info.nrw.q1.tierchor;

public interface KannWedeln {
	public void wedeln();
}
```
Ergänze die Klasse Hund, um zu zeigen, dass der Hund die Methoden des Interface KannWedeln implementiert. 

```java
public class Hund extends Tier implements KannWedeln
```

Lasse nun auch die Klasse Maus das Interface implementieren und bearbeite dann die Methode *tierChor()* in TierHeim analog zu Aufgabe 6 so, dass alle Tiere, welche eine Instanz von KannWedeln sind auch wedeln.
