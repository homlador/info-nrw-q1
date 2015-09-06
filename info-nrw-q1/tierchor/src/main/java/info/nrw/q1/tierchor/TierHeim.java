package info.nrw.q1.tierchor;

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