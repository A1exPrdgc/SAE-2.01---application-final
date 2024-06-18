package codeJeu.metier;

import java.io.FileOutputStream;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import codeJeu.metier.Mine;
import codeJeu.metier.Routes;

public class Sauvegarde
{
	public static void sauvegarderMine(List<Mine> mines)
	{
		try (PrintWriter writer = new PrintWriter(new FileOutputStream("ConstructeurMap/mines.txt")))
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
		try (PrintWriter writer = new PrintWriter(new FileOutputStream("ConstructeurMap/mines.txt", true))) 
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
}