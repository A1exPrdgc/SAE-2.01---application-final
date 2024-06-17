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
				writer.println(mine.getX() + "," + mine.getY() + "," +mine.getNumMine() + "," + mine.getRegion().name().charAt(0));
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
/*
 * public void chargerDonnees() { try (BufferedReader reader = new
 * BufferedReader(new FileReader("ConstructeurMap/mines.txt"))) { String line;
 * boolean isReadingRoutes = false; while ((line = reader.readLine()) != null) {
 * if (line.equals("Mines:")) continue; String[] parts = line.split(","); if
 * (!isReadingRoutes) { // Créer une nouvelle mine et l'ajouter à la liste Mine
 * mine = new Mine(Integer.parseInt(parts[0]), parts[1],
 * Integer.parseInt(parts[2]), Integer.parseInt(parts[3])); lstMines.add(mine);
 * } else { // Créer une nouvelle route et l'ajouter à la liste Route route =
 * new Route(mines.get(Integer.parseInt(parts[0])),
 * mines.get(Integer.parseInt(parts[1])), Integer.parseInt(parts[2]));
 * lstRoutes.add(route); } } } catch (IOException e) { e.printStackTrace(); } }
 */
}