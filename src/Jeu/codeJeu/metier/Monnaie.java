package codeJeu.metier;

public class Monnaie implements IRessources
{
    private int val;
    private String nom;

    public Monnaie()
    {
        this.nom = "NR";
        this.val = 1;
    }

    public int getVal()
    {
        return this.val;
    }

    public String getNom() {
        return nom;
    }
}