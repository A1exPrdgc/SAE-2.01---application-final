package codeJeu.metier;

import codeJeu.metier.Mine;
import codeJeu.metier.Region;

public class Mine 
{
	private int x ;
	private int y ; 
	private int numero ;
	private Region region;
	private boolean isVisited;
	private Jeton ressource;

	private static int nbMine = 0;
	private int idMine;

	public Mine(int x , int y , int numero, Region region)
	{
		this.x = x;
		this.y = y;
		this.numero = numero;
		this.region = region;
		this.isVisited = false;
		this.idMine = ++nbMine;
	}


	public int getX() 						{ return this.x;	    }
	public int getY() 						{ return this.y;	    }
	public int getNumMine() 				{ return this.numero;   }
	public Region getRegion() 				{ return this.region;   }
	public int getTailleX() 				{ return 50;		    }
	public int getTailleY() 				{ return 50;		    }
	public boolean getVisit()				{ return this.isVisited;}
	public int getIdMine()                  { return idMine;        }

	public boolean possede( int x, int y )
    {
		return 	x >= this.x && x <= this.x + this.getTailleX() &&
				y >= this.y && y <= this.y + this.getTailleY();

    }


	public void setX(int x2)
	{
		this.x = x2;
	}


	public void setY(int y2)
	{
		this.y = y2;
	}

	public void visiteMine()
	{
		if (!this.isVisited){this.isVisited = true;}
	}

	public void desincrement()
	{
		Mine.nbMine--;
	}

	public String toString()
	{
		return this.getIdMine() + " -> " + this.getNumMine() + "_" + this.getRegion().name() + " (" + this.getX() + " : " + this.getY() + ") : " + this.getVisit();
	}

	public boolean ajouterRessource(Jeton j)
	{
		if (this.ressource == null)
		{
			this.ressource = j;
			return true;
		}
		return false;
	}


	public Jeton getRessource() {
		return this.ressource;
	}
}
