package metier;

import src.Controleur;
import src.metier.Jeton;
import src.Etape2.metier.Mine;

public class Equipe 
{
    private Controleur ctrl;

    private int nbJetonPossession;
    private int nbMine;
    private Mine[] tabMine;
    private String nom;
    private Jeton[][] tabJetons;
    private int nbPiece;

    public Equipe(Controleur ctrl, String nom)
    {
        this.ctrl = ctrl;

        this.nom = nom;

        this.nbMine  = 0;
        this.nbPiece = 0;

        this.tabMine   = new Mine [ 15 ];
        this.tabJetons = new Jeton[3][5];
    }    

    public boolean ajouterRessource(Jeton r)
    {
        
    }

    public int getTailleLig() { return this.tabJetons   .length ;}
	public int getTailleCol() { return this.tabJetons[0].length ;}
}
