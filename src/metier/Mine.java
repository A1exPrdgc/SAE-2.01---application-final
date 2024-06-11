package metier;

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
}
