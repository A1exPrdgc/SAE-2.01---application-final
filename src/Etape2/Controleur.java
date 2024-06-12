package Etape2;

import Etape2.metier.*;
import Etape2.metier.Mine;

import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import Etape2.ihm.Frame;

public class Controleur 
{
	private Frame ihm;

	private List<Mine> lstMines;
	private List<Routes> lstRoutes; 

	public Controleur()
	{
		this.lstMines = new ArrayList<Mine>();
		this.lstRoutes = new ArrayList<Routes>();
		this.ihm = new Frame(this);
	}

	public void ajouterMine(int x, int y, int numero, char region )
	{
		 this.lstMines.add(0,new Mine(x, y, numero, region));
	}

	public boolean ajouterRoute(int nbTroncon, Mine depart, Mine arrivee)
	{
		boolean worked = this.lstRoutes.add(new Routes(nbTroncon, depart, arrivee));
		System.out.println(this.lstRoutes.get(0).getNbTroncon());
		return worked;
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

	public List<Mine> charger()
	{
		//Sauvegarde.LectureMine(this.lstMines);
		System.out.println("Villes chargés");
		//Sauvegarde.LectureRoutes(this.lstRoutes);
		System.out.println("Routes chargés");

		return this.lstMines;
	}

	public Mine rechercherMine(char nomMine, int numMine)
	{
		for (Mine m : this.lstMines) {

			if(m.getNumMine() == numMine && m.getRegion() == nomMine)
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