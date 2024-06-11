package src.metier;

import src.Controleur;
import src.metier.Jeton;
<<<<<<< HEAD
import src.Etape2.metier.Mine;
=======
import src.metier.Mine;
import src.metier.Minerai;
>>>>>>> 3a4600c6692564de393bf96341a3a85aba447c75

public class Equipe 
{
    private static final int NB_PIECE_MAX = 8;

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
        IRessources ressource = r.getType();
		if (ressource instanceof Monnaie) 
        {
            this.nbPiece++;
		} 
        else if (ressource instanceof Minerai) {
			Minerai minerai = (Minerai) ressource;
			for (int j = 0; j < this.getTailleCol(); j++) {
				if (colonneAccepteMinerai(j, minerai)) {
					for (int i = this.getTailleLig() - 1; i >= 0; i--) {
						if (tabJetons[i][j] == null) {
							tabJetons[i][j] = r;
							return true;
						}
					}
					break;  // Colonne pleine, ne pas chercher plus loin
				}
			}
		}
		return false;
    }

    private boolean colonneAccepteMinerai(int col, Minerai Minerai) {
		for (int i = 0; i < this.getTailleLig(); i++) {
			if (tabJetons[i][col] != null) {
				if (tabJetons[i][col].getType() != Minerai) {
					return false;  // Colonne contient une autre épice
				}
			}
		}
		return true;  // Colonne vide ou contient la même épice
	}

    public int getTailleLig() { return this.tabJetons   .length ;}
	public int getTailleCol() { return this.tabJetons[0].length ;}

    public int getNBPointPos()
    {
        return this.nbJetonPossession;
    }

    public Jeton[][] getRessources()
    {
        return this.tabJetons;
    }

    public Mine[] getMines()
    {
        return this.tabMine;
    }

    public int getNBPiece()
    {
        return this.nbPiece;
    }
}
