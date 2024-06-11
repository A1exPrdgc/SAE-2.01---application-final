package Etape2.metier;

import src.metier.Jeton;

public class Mine 
{
	private int x ;
	private int y ; 
	private Jeton ressource;
	private int numero ;
	private char region;

	public Mine(int x , int y , int numero, char region)
	{
		this.x =x;
		this.y=y;
		this.numero = numero;
		this.region = region;
	}

	public boolean ajouterRessource(Jeton r)
	{
		if(this.ressource == null )
			{
				this.ressource = r ;
				return true;
			}
		return false;
	}

	public int getX() 						{ return this.x;	 }
	public int getY() 						{ return this.y;	 }
	public int getNumMine() 				{ return this.numero;}
	public char getRegion() 				{ return this.region;}
	public int getTailleX() 				{ return 50;		 }
	public int getTailleY() 				{ return 50;		 }

	public boolean possede(int x, int y)
	{

		int rayonX = this.getTailleX() / 2, rayonY = this.getTailleY() / 2;

		double pas = Math.PI / 32;

		for (double ang = 0; ang < Math.PI * 2; ang += pas)
		{
			double xBord = Math.cos(ang) * this.getTailleX() / 2;
			double yBord = Math.sin(ang) * this.getTailleY() / 2;

			double minX = Math.min(this.getX(), this.getX() + xBord);
			double maxX = Math.max(this.getX(), this.getX() + xBord);

			double minY = Math.min(this.getY(), this.getY() + yBord);
			double maxY = Math.max(this.getY(), this.getY() + yBord);

			if (x >= minX && x <= maxX && y >= minY && y <= maxY)
				return true;

		}

		return false;

	}
}
