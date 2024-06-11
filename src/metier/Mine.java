package metier;

import java.util.ArrayList;
import java.util.List;

public class Mine 
{
	private int x ;
	private int y ; 
	private Ressource ressource;
	private int numero ;
	private char region;
	private List<Route> routes;

	public Mine(int x , int y , int numero, char region)
	{
		this.x =x;
		this.y=y;
		this.numero = numero;
		this.region = region;
		this.routes = new ArrayList<Route>();
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

	public int getX() { return this.x;}
	public int getY() { return this.y;}
	public int getNumMine() { return this.numero;}
	public char getRegion() { return this.region;}
	public ArrayList<Route> getListRoute() { return this.routes;}
}
