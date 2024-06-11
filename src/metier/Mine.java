package src.metier;

public class Mine 
{
	private int x ;
	private int y ; 
	private Ressource ressource;
	private int numero ;
	private char region;

	public Mine(int x , int y , int numero, char region)
	{
		this.x =x;
		this.y=y;
		this.numero = numero;
		this.region = region;
	}

	public boolean ajouterRessource(Ressource r)
	{
		if(this.ressource == null )
			{
				this.ressource = r ;
				return true;
			}
		return false;
	}
}
