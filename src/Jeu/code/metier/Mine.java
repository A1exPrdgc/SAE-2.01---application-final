package code.metier;

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
	public Jeton getRessource()             { return ressource;     }
		
	

	public boolean possede(int x, int y)
	{
		int rayon = getTailleX() / 2;
        double distanceCarree = Math.pow(x - this.x, 2) + Math.pow(y - this.x, 2);
        return distanceCarree <= rayon * rayon;
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

	public boolean ajouterRessource(Jeton r)
	{
		if (this.ressource == null)
		{
			this.ressource = r;
			return true;
		}
		return false;
	}
}
