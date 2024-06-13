package src.metier;

import src.Controleur;
import src.metier.Jeton;
import src.Etape2.metier.Mine;
import src.metier.Minerai;

public class Equipe 
{
    private static final int NB_PIECE_MAX = 8;

    private Controleur ctrl;

    private int nbJetonPossession;
    private int nbMine;
    private Etape2.metier.Mine[] tabMine;
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

	public int getScorePLateauIndividuel()
	{
		return getScorePiece() 
			 + getScoreColonnes() 
			 + getScoreLignes();
	}
	
	public int getScorePiece()
	{
		return (this.nbPiece == 1 || this.nbPiece == 0) ? 0 : this.nbPiece * this.nbPiece;
	}

	public int getScore()
	{
		int score = 0;
		for (int cpt = 0; cpt < getTailleCol(); cpt++)
		{
			score += calculerScoreColonne(cpt);
		}
		for (int cpt = 0; cpt < getTailleLig(); cpt++)
		{
			score += calculerScoreLigne(cpt);
		}
		if (nbPiece != 1)
			score += nbPiece * nbPiece;
		return score;
	}

	private int calculerScoreColonne(int col)
	{
		int nbCasesRemplies = 0;
		for (int i = 0; i < getTailleLig(); i++)
		{
			if (tabJetons[i][col] != null)
			{
				nbCasesRemplies++;
			}
		}
		switch (nbCasesRemplies)
		{
		case 0:
			return 0;
		case 1:
			return 0;
		case 2:
			return 2;
		case 3:
			return 10;
		default:
			return 20;
		}
	}

	private int calculerScoreLigne(int ligne)
	{
		int nbCasesRemplies = 0;
		for (int j = 0; j < getTailleCol(); j++)
		{
			if (tabJetons[ligne][j] != null)
			{
				nbCasesRemplies++;
			}
		}
		switch (nbCasesRemplies)
		{
		case 0:
			return 0;
		case 1:
			return 0;
		case 2:
			return 2;
		case 3:
			return 5;
		case 4:
			return 9;
		case 5:
			return 14;
		case 6:
			return 20;
		case 7:
			return 32;
		default:
			return 46;
		}
	}

	public int getScoreColonnes() 
	{
		int scoreCol = 0;
		for (int i = 0; i < getTailleLig(); i++) {
			scoreCol += calculerScoreColonne(i);
		}
		return scoreCol;
	}

	public int getScoreLignes()
	{
		int scoreLig = 0;
		for (int i = 0; i < getTailleCol(); i++)
		{
			scoreLig += calculerScoreLigne(i);
		}
		return scoreLig;
	}

	public int getScoreJetonPossRestants() {return getNBPointPos();}

	public int getScoreBonus(Equipe autreEquipe) 
	{
		return (getNBPointPos() >= autreEquipe.getNBPointPos()) ? 10 : 0;
	}

	public String[] getScoreMines() 
	{
		int scoreMine = 0;
		String[] tabTypeMines = new String [] { "j0", "b0", "g0", "v0", "r0", "m0", };

		for (int i = 0; i < this.tabMine.length; i++) {
			switch (tabMine[i].getRegion()) {
				case 'j':
					if ( this.tabMine[i].getNumMine() > Integer.parseInt(tabTypeMines[0].substring(1))) 
					{
						tabTypeMines[0] = "j" + this.tabMine[i].getNumMine();
					}
					break;
				case 'b':
					if (this.tabMine[i].getNumMine() > Integer.parseInt(tabTypeMines[1].substring(1)))
					{
						tabTypeMines[1] = "b" + this.tabMine[i].getNumMine();
					}
					break;
				case 'g':
					if (this.tabMine[i].getNumMine() > Integer.parseInt(tabTypeMines[2].substring(1)))
					{
						tabTypeMines[2] = "g" + this.tabMine[i].getNumMine();
					}
					break;
				case 'v':
					if (this.tabMine[i].getNumMine() > Integer.parseInt(tabTypeMines[3].substring(1)))
					{
						tabTypeMines[3] = "v" + this.tabMine[i].getNumMine();
					}
					break;
				case 'r':
					if (this.tabMine[i].getNumMine() > Integer.parseInt(tabTypeMines[4].substring(1)))
					{
						tabTypeMines[4] = "r" + this.tabMine[i].getNumMine();
					}
					break;
				default:
					if (this.tabMine[i].getNumMine() > Integer.parseInt(tabTypeMines[5].substring(1)))
					{
						tabTypeMines[5] = "m" + this.tabMine[i].getNumMine();
					}
					break;
			}
		}
		return tabTypeMines;
	}

	public String ficheScore(Equipe autre)
	{
		String sRet = "";

		// a revoir la recup
		int totMine = 0;
		int totMineAutre = 0;

		int totFinal = totMine + this.getScorePLateauIndividuel() + getScoreBonus(this);
		int totFinalAutre = totMineAutre + autre.getScorePLateauIndividuel() + getScoreBonus(autre);

		sRet += "------------------------------------------------------------\n" + "|" + 
		String.format("%30s", "Fiche de Score") +
		String.format("%30s","|") + "\n"+
		"------------------------------------------------------------\n"  + "|" + 
		String.format("%20s", " ")+ "|"+
		String.format("%5s", "Corporation Solaire") + "|" +
		String.format("%10s", "Syndicat Astral") + "   |\n" + 
		"------------------------------------------------------------\n"  + "|" +
		String.format("%20s", "|") +  
		String.format("%20s", "|") +
		String.format("%20s", "|") +"\n" +
		"------------------------------------------------------------\n"  + "|   " +
		"Points Route   " + " |" + String.format("%20s", "|") + "\n" +
		"------------------------------------------------------------\n"  + "|"+
		String.format("%20s", "|") +
		//
		String.format("%20s", "|") +
		String.format("%20s", "|") + "\n" +
		"------------------------------------------------------------\n"  + "|" +
		"Points des Mines  " + " |" + String.format("%20s", "|") + "\n" +
		"------------------------------------------------------------\n"  + "|"+
		String.format("%10s","Jaune") +
		String.format("%10s", "|") + 
		//String.format("", ) + 
		String.format("%20s", "|") +
		String.format("%20s", "|") + "\n" +
		"------------------------------------------------------------\n" + "|"+
		String.format("%10s","Fleur") +
		String.format("%10s", "|") + 
		//String.format("", ) + 
		String.format("%20s", "|") +
		String.format("%20s", "|") + "\n" +
		"------------------------------------------------------------\n"  + "|"+
		String.format("%10s","Losange") +
		String.format("%10s", "|") +
		//String.format("", ) + 
		String.format("%20s", "|") +
		String.format("%20s", "|") + "\n" +
		"------------------------------------------------------------\n"  + "|"+
		String.format("%10s","Carre") +
		String.format("%10s", "|") +
		//String.format("", ) + 
		String.format("%20s", "|") +
		String.format("%20s", "|") + "\n" +
		"------------------------------------------------------------\n"  + "|"+
		String.format("%10s","Hexagone") +
		String.format("%10s", "|") + 
		//String.format("", ) + 
		String.format("%20s", "|") +
		String.format("%20s", "|") + "\n" +
		"------------------------------------------------------------\n"  + "|"+
		String.format("%10s","S/Total") +
		String.format("%10s", "|") + 
		totMine + String.format("%10s", "|") +
		totMineAutre + String.format("%10s", "|") + "\n" +
		"------------------------------------------------------------\n"  + "|" +
		String.format("%20s", "|") +  
		String.format("%20s", "|") +
		String.format("%20s", "|") +"\n" +
		"------------------------------------------------------------\n"  + "|"+
		"Plateau Individuel" + "|" +  
		String.format("%10s", "|") +
		String.format("%10s", "|") + "\n" +
		"------------------------------------------------------------\n"  + "|"+
		"Score Pièces" +"      |" + this.getScorePiece() + 
		String.format("%10s", "|") + autre.getScorePiece() + 
		String.format("%10s", "|") + "\n" +
		"------------------------------------------------------------\n"  + "|"+
		"Score des Colonnes" + "  |" + this.getScoreColonnes() + 
		String.format("%10s", "|") + autre.getScoreColonnes() + 
		String.format("%10s", "|") + "\n" +
		"------------------------------------------------------------\n"  + "|"+
		"Score des Lignes" + "  |" + this.getScoreLignes() + 
		String.format("%10s", "|") + autre.getScoreLignes() + 
		String.format("%10s", "|") + "\n" +
		"------------------------------------------------------------\n"  + "|"+
		String.format("%20s", "|") +
		String.format("%20s", "|") +
		String.format("%20s", "|") + "\n" +
		"------------------------------------------------------------\n" + "|"+
		String.format("%10s","S/Total") +
		String.format("%10s", "|") +
		this.getScorePLateauIndividuel() + String.format("%10s", "|") +
		+ autre.getScorePLateauIndividuel() + String.format("%10s", "|") + "\n" +
		"------------------------------------------------------------\n"+
		"Jeton Possession restants" + "  |" + this.getScoreJetonPossRestants() + 
		String.format("%15s", "|") + autre.getScoreJetonPossRestants() + 
		String.format("%15s", "     |") + "\n" +
		"------------------------------------------------------------\n"  + "|"+
		"Bonus"+ String.format("%15s",  "|") + 
		getScoreBonus(this) + String.format("%10s", "|") +
		getScoreBonus(autre) + String.format("%10s", "|") + "\n" +
		"------------------------------------------------------------\n"  + "|"+
		String.format("%20s", "|") +
		String.format("%20s", "|") +
		String.format("%20s", "|") + "\n" +
		"------------------------------------------------------------\n"  + "|"+
		String.format("%10s","S/Total") +
		String.format("%10s", "|") + 
		totFinal + String.format("%10s", "|") +
		totFinalAutre + String.format("%10s", "|") + "\n" +
		"------------------------------------------------------------\n";
		
		return sRet;

	}
}
