package info.nrw.q1.tierchor;

public class KampfHund extends Hund
{
    public KampfHund(String pName)
    {
        super(pName);
    }

    public String gibName()
    {
        return "Kampf" + super.gibName();    
    }

    public void gibLaut()
    {
        super.gibLaut();
        System.out.print("Grrrr");   
    }
}
