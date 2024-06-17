package code.metier;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import code.*;
import code.metier.Mine;

public class Sauvegarde
{
	public static void sauvegarderMine(List<Mine> mines)
	{
		try (PrintWriter writer = new PrintWriter(new FileOutputStream("../save/mines.txt")))
		{
			writer.println("Mines:");
			for (Mine mine : mines)
			{
				writer.println(mine.getX() + "," + mine.getY() + "," +mine.getNumMine() + "," + mine.getRegion().name().charAt(0) + "," + mine.getVisit());

				if(mine.getRessource().getType() instanceof Minerai)
				{
					writer.println(((Minerai) mine.getRessource().getType()).name());
				}
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void sauvegarderRoutes(List<Routes> routes)
	{
		try (PrintWriter writer = new PrintWriter(new FileOutputStream("../save/mines.txt", true))) 
		{
			writer.println("\nRoutes:");
			for (Routes route : routes)
			{
				writer.println(route.getNbTroncon() + "," +route.getMineDep().getNumMine() + "," + route.getMineArriv().getNumMine() );
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}