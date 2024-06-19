package codeJeu;

import codeJeu.Controleur;
import codeJeu.metier.*;
import codeJeu.ihm.PlateauIndividuel.FrameIndi;
import codeJeu.ihm.PlateauPrincipale.Frame;
import codeJeu.ihm.interfaceEquipe.FrameEquipe;

import java.util.ArrayList;
import java.util.List;

public class Controleur 
{	
	private Frame ihm;
	private FrameIndi platIndiv;
	private FrameEquipe frameEquipe;

	private Equipe equipeCS;
	private Equipe equipeSA;

	private FrameIndi frameCS;
	private FrameIndi frameSA;

	private Lecture lecture;
	private List<Mine> lstMines;
	private List<Routes> lstRoutes; 

	private String sauvegarde;
	private List<Jeton> jetonsRessources;
	private Jeton[][] tabJetonEquipe;

	private int tour;

	public Controleur(String nomSave)
	{
		//this.initList();
		
		this.tour = 0;
		this.sauvegarde = nomSave;
		this.lecture   = new Lecture(this);
		this.lstMines  = new ArrayList<Mine>();
		this.lstRoutes = new ArrayList<Routes>();
		this.frameEquipe = new FrameEquipe(this);
		this.ihm       = new Frame(this);
		this.charger();
		this.majDessin();
	}

	public void tourSuivant()
	{
		this.tour ++;
	}

	public void ouvrirCS(String nom)
	{
		this.equipeCS = new Equipe(this, nom);
		this.frameCS = new FrameIndi(this, this.equipeCS, "CS");
	}

	public void ouvrirSA(String nom)
	{
		this.equipeSA = new Equipe(this, nom);
		this.frameSA = new FrameIndi(this, this.equipeSA, "SA");
	}

	public void ajouterMine(int x, int y, int numero, Region region )
	{
		 this.lstMines.add(0,new Mine(x, y, numero, region));
		 this.lstMines.get(0);
		 this.ihm.majDessin();
	}

	public boolean ajouterRoute(int nbTroncon, Mine depart, Mine arrivee)
	{
		boolean worked = this.lstRoutes.add(new Routes(nbTroncon, depart, arrivee));
		System.out.println(this.lstRoutes.get(0).getNbTroncon());
		return worked;
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

	public Minerai rechercheMinerai(IRessources val) // attention au nom 
	{
		for (Minerai m : Minerai.values())
		{
			if (m == val)
			{
				return m;
			}
		}
		return null;
	}

	public void supprimerMine(Mine mines)
	{
		this.lstMines.remove(mines);
	}

	public void supprimerRoute(Mine depart, Mine arrivee)
	{
		for (Routes route : this.lstRoutes)
		{
			if (route.getMineDep().equals(depart) && route.getMineArriv().equals(arrivee))
			{
				this.lstRoutes.remove(route);
				break;
			}
		}
	}

	public List<Routes> getRoutes()
	{
		return this.lstRoutes;
	}

	public String getSauvegarde() {
		return this.sauvegarde;
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


		for (Mine m : this.getMines())
		{

			System.out.println("Souris : (" + x + ";" + y + ") && mine : (" + m.getX() + ";" + m.getY() + ") " + m.getRegion().name() + " " + m.getNumMine());

			if (m.possede(x, y))
			{
				System.out.println("OK");
				return m;
			}

		}

		return null;
	}

	public boolean obtenirMine(Mine m)
	{
		for (Routes r : this.lstRoutes) 
		{
			if (r.getMineDep() == m && r.getMineArriv().getVisit())
			{
				return true;
			}	

			if (r.getMineArriv() == m && r.getMineDep().getVisit())
			{
				return true;
			}
		}
		return false;
	}
	


	public static void main(String[] args)
	{
		new Controleur(args[0]);
	}
}