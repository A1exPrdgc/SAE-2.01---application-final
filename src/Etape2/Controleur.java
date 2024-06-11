package Etape2;

import Etape2.metier.*;
import Etape2.metier.Mine;

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
		 System.out.println(this.lstMines.get(0));
	}

	public void ajouterRoute(int nbTroncon, Mine depart, Mine arrivee)
	{
		this.lstRoutes.add(new Routes(nbTroncon, depart, arrivee));
		System.out.println(this.lstRoutes.get(0));
	}

	public void supprimerVille(Mine mines)
	{
		this.lstMines.remove(mines);
	}

	public void supprimerRoute(Mine depart, Mine arrivee)
	{
		for (Routes route : this.lstRoutes)
		{
			if (route.getVilleDep().equals(depart) && route.getVilleArriv().equals(arrivee))
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

	public List<Mine> getVilles()
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
		Sauvegarde.LectureVilles(this.lstMines);
		System.out.println("Villes chargés");
		Sauvegarde.LectureRoutes(this.lstRoutes);
		System.out.println("Routes chargés");

		return this.lstMines;
	}

	public Mine rechercherVilles(String numMine)
	{
		for (Mine m : lstMines) {
			if(Integer.toString(m.getNumMine()).equals(numMine))
			{
				return m;
			}
		}
		return null;

	}

	public Routes rechercherRoutes(Mine villeDep , Mine villeArriv )
	{
		for (Routes r : lstRoutes)
		{
			if(r.getVilleArriv().equals(villeArriv) && r.getVilleDep().equals(villeDep))
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


	public void enregistrerSous()
	{
		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			File file = fileChooser.getSelectedFile();
			try (FileWriter writer = new FileWriter(file))
			{
				file.getAbsolutePath();
				// Passez le FileWriter à vos méthodes de sauvegarde
				Sauvegarde.enregistrerSous(this.lstMines);
				Sauvegarde.enregistrerSousRoute(this.lstRoutes);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	public void majDessin()
	{
		this.ihm.majDessin();
	}

	public Mine getVille(int i)
	{
		return this.lstMines.get(i);
	}

	public Routes getRoute(int i)
	{
		return this.lstRoutes.get(i);
	}

	public Mine getVilleTouche(int x, int y)
	{
		for (int i = 0; i < this.getVilles().size(); i++)
		{
			if (this.getVilles().get(i).possede(x, y))
			{
				return this.getVilles().get(i);
			}
		}
		return null;
	}
	
	public static void main(String[] args)
	{
		new Controleur();
	}

	
}