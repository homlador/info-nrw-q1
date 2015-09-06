# Übungsaufgabe „Polymorphie“:

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

2. Ermittle die Ausgabe der Methode tierChor() ohne das Programm auszuführen!

3. Überprüfe deine Ergebnisse aus 2, indem du das Programm ausführst.

4. Erstelle eine neues Tier: KampfKatze, welche nicht nur „Miau“ macht, sondern „Fauch Miau“

5. Erstelle ein neues Tier deiner Wahl!
