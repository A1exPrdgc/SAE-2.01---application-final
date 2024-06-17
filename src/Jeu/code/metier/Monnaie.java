package code.metier;

public class Monnaie implements IRessources
{
    private int val;

    public Monnaie()
    {
        this.val = 1;
    }

    public int getVal()
    {
        return this.val;
    }
}