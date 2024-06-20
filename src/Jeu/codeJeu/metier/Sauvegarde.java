package codeJeu.metier;

import java.io.FileOutputStream;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import codeJeu.Controleur;

public class Sauvegarde
{
	private static int numTour = 1;

	public static void sauvegarderMine(List<Mine> mines)
	{
		try (PrintWriter writer = new PrintWriter(new FileOutputStream("Jeu/mines.txt")))
		{
			writer.println("Mines:");
			for (Mine mine : mines)
			{
				writer.println(mine.getX() + "," + mine.getY() + "," +mine.getNumMine() + "," + mine.getRegion().name().charAt(0) + ",");
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void sauvegarderRoutes(List<Routes> routes)
	{
		try (PrintWriter writer = new PrintWriter(new FileOutputStream("Jeu/mines.txt", true))) 
		{
			writer.println("\nRoutes:");
			for (Routes route : routes)
			{
				writer.println(route.getNbTroncon() + "," +route.getMineDep().getIdMine() + "," + route.getMineArriv().getIdMine() );
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void sauvegarderEquipe(Equipe equipe, Controleur ctrl)
	{
		String s = "";
		try (PrintWriter writer = new PrintWriter(new FileOutputStream("../save/mines.txt", true)))
		{
			if(numTour % 2 != 0)
			{
				writer.println("\n Tour: " + numTour);
			}
	
			s += (equipe.getNom() + "," + equipe.getNBPointPos());
			
			for (int i = 0; i < equipe.getRessources().length; i++) {
				for (int j = 0; j < equipe.getRessources()[0].length; j++)
				{
					System.out.println("Test2");
					if (equipe.getRessources()[i][j] != null) 
					{
						if (equipe.getRessources()[i][j].getType() instanceof Minerai)
						{
							System.out.println("Test1");
							s += "," + ctrl.rechercheMinerai(equipe.getRessources()[i][j].getType()).name();
						}
						if (equipe.getRessources()[i][j].getType() instanceof Monnaie)
						{
							System.out.println("Test3");
							s += ",NR";
						}
					}

				}
			}
			writer.println(s);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		numTour++;
	}
}