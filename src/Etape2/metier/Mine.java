package Etape2.metier;


public class Mine 
{
	private int x ;
	private int y ; 
	private int numero ;
	private char region;

	public Mine(int x , int y , int numero, char region)
	{
		this.x = x;
		this.y = y;
		this.numero = numero;
		this.region = region;
	}


	public int getX() 						{ return this.x;	 }
	public int getY() 						{ return this.y;	 }
	public int getNumMine() 				{ return this.numero;}
	public char getRegion() 				{ return this.region;}
	public int getTailleX() 				{ return 50;		 }
	public int getTailleY() 				{ return 50;		 }

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
}
