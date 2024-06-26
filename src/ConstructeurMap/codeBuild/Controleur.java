package codeBuild;
import java.util.ArrayList;
import java.util.List;

import codeBuild.Controleur;
import codeBuild.ihm.Frame;
import codeBuild.metier.Lecture;
import codeBuild.metier.Mine;
import codeBuild.metier.Region;
import codeBuild.metier.Routes;
import codeBuild.metier.Sauvegarde;

public class Controleur 
{
	private Frame ihm;

	private Lecture lecture;
	private List<Mine> lstMines;
	private List<Routes> lstRoutes; 

	public Controleur()
	{
		this.lecture = new Lecture(this);
		this.lstMines = new ArrayList<Mine>();
		this.lstRoutes = new ArrayList<Routes>();
		this.ihm = new Frame(this);
	}

	public void ajouterMine(int x, int y, int numero, Region region )
	{
		 this.lstMines.add(0,new Mine(x, y, numero, region));
	}

	public boolean ajouterRoute(int nbTroncon, Mine depart, Mine arrivee)
	{
		for (Routes r : lstRoutes) 
		{
			if (depart == r.getMineDep() && arrivee == r.getMineArriv() ||
				depart == r.getMineArriv() && arrivee == r.getMineDep())
			{
				return false;
			}		
		}

		if (depart.getIdMine() != arrivee.getIdMine())
		{
			boolean worked = this.lstRoutes.add(new Routes(nbTroncon, depart, arrivee));
			return worked;
		}
		return false;
	}

	public Region rechercherRegion(String nomRegion)
	{
		for (Region r : Region.values()) 
		{
			if (r.name() == nomRegion)
			{
				return r;
			}
		}
		return null;
	}

	public void supprimerMine(Mine mines)
	{
		mines.desincrement();
		this.supprimerRoute(mines);
		this.lstMines.remove(mines);
		this.majTab();
	}

	public void supprimerRoute(Mine mine)
	{
		Routes[] tabRoute = new Routes[this.lstRoutes.size()];

		for (int i = 0; i < tabRoute.length; i++) {
			tabRoute[i] = this.lstRoutes.get(i);
		}

		for (Routes r : tabRoute)
		{
			if(r.getMineArriv().equals(mine) || r.getMineDep().equals(mine))
			{
				this.lstRoutes.remove(r);
			}	
		}
	}

	public List<Routes> getRoutes()
	{
		return this.lstRoutes;
	}


	public List<Mine> getMines()
	{
		return this.lstMines;
	}

	public void sauvegarder(List<Mine> mines, List<Routes> routes)
	{
		Sauvegarde.sauvegarderMine(mines);
		System.out.println("Villes sauvegardés");
		Sauvegarde.sauvegarderRoutes(routes);
		System.out.println("Routes Sauvegarder");
	}

	public void charger()
	{
		this.lecture = new Lecture(this);
		if (this.getMines().isEmpty())
			this.lecture.lectureGraphe();
	}

	public Mine rechercherMine(char nomMine, int numMine)
	{
		for (Mine m : this.lstMines) {

			if(m.getNumMine() == numMine && m.getRegion().name().charAt(0) == nomMine)
			{
				return m;
			}
		}
		return null;

	}

	public Routes rechercherRoutes(Mine mineDep , Mine mineArriv )
	{
		for (Routes r : lstRoutes)
		{
			if(r.getMineArriv().equals(mineArriv) && r.getMineDep().equals(mineDep))
			{
				return r;
			}
		}
		return null;
	}

	public void majTab()
	{
		this.ihm.majTab();
	}

	public void reset()
	{
		this.lstMines.clear();
		this.lstRoutes.clear();
	}


	public void majDessin()
	{
		this.ihm.majDessin();
	}

	public Mine getMine(int i)
	{
		return this.lstMines.get(i);
	}

	public Routes getRoute(int i)
	{
		return this.lstRoutes.get(i);
	}

	public Mine getMineTouche(int x, int y)
	{
		for (int i = 0; i < this.getMines().size(); i++)
		{
			if (this.getMines().get(i).possede(x, y))
			{
				return this.getMines().get(i);
			}
		}
		return null;
	}

	public static void main(String[] args)
	{
		new Controleur();
	}

	
}