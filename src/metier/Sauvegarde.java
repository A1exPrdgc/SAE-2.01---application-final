package metier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;

import src.metier.Route;

public class Sauvegarde
{

	public static void sauvegarderVilles(List<Mine> mines)
	{
		try (PrintWriter writer = new PrintWriter(new FileOutputStream("mines.txt")))
		{
			for (int i = 0; i < mines.size(); i++)
			{
				writer.println(mines.get(i).getNumMine() + "," + mines.get(i).getRegion() + "," + mines.get(i).getX() + "," + mines.get(i).getY());
			}
			writer.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void enregistrerSous(List<Mine> mines)
	{
		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			File file = fileChooser.getSelectedFile();
			try (PrintWriter writer = new PrintWriter(file.getAbsolutePath())) // Change the type to PrintWriter
			{
				for (int i = 0; i < mines.size(); i++)
				{
					writer.println(mines.get(i).getNumMine() + "," + mines.get(i).getRegion() + "," + mines.get(i).getX() + "," + mines.get(i).getY());
				}
				writer.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	public static List<Mine> LectureVilles(List<Mine> mines)
	{
		try
		{
			Scanner sc = new Scanner(new FileInputStream("villes.txt"));

			while (sc.hasNextLine()) {
				String[] ville = sc.nextLine().split(",");
				int x = Integer.parseInt(ville[2]);
				int y = Integer.parseInt(ville[3]);
				int numero = Integer.parseInt(ville[0]);
				char region = ville[1].charAt(0);
			

				mines.add(new Mine(x, y, numero, region));
			}
			sc.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return mines;
	}

	public static void sauvegarderRoutes(List<Route> routes)
	{
		try (PrintWriter writer = new PrintWriter(new FileOutputStream("routes.txt")))
		{
			for (Route route : routes)
			{
				writer.println(route.getNbTroncons() + "," + route.getMineDep().toString() + ","
						+ route.getMineArr().toString());
			}
			writer.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void enregistrerSousRoute( List<Route> routes)
	{
		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			File file = fileChooser.getSelectedFile();
			try (PrintWriter writer = new PrintWriter(file.getAbsolutePath())) 
			{
				for (Route route : routes)
				{
					writer.println(route.getNbTroncons() + "," + route.getMineDep().toString() + ","
							+ route.getMineArr().toString());
				}
				writer.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	public static void LectureRoutes(List<Route> routes)
	{
		try
		{
			Scanner sc = new Scanner(new FileInputStream("routes.txt"));

			while (sc.hasNextLine()) {
				String[] route = sc.nextLine().split(",");
				int nbTroncon = Integer.parseInt(route[0]);
				String villeDep = route[1];
				String villeArriv = route[2];

			//	routes.add(new Routes(nbTroncon, villeDep, villeArriv));
			}
			sc.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

