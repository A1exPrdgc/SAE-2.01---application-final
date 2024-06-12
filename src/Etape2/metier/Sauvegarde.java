package Etape2.metier;

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

import Etape2.metier.Mine;

public class Sauvegarde
{

	public static void sauvegarderMine(List<Mine> mines)
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

	public static List<Mine> LectureVilles( List<Mine> mines)
	{
		try
		{
			Scanner sc = new Scanner(new FileInputStream("mines.txt"));

			while (sc.hasNextLine()) {
				String[] mine = sc.nextLine().split(",");
				int nummero = Integer.parseInt(mine[0]);
				char region = mine[1].charAt(0);
				int x = Integer.parseInt(mine[2]);
				int y = Integer.parseInt(mine[3]);
				String nomVille = mine[1];

				mines.add(new Mine(x,y,nummero,region));
			}
			sc.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return mines;
	}

	public static void sauvegarderRoutes(List<Routes> routes)
	{
		try (PrintWriter writer = new PrintWriter(new FileOutputStream("mines.txt")))
		{
			for (Routes route : routes)
			{
				writer.println(route.getNbTroncon() + "," + route.getVilleDep().toString() + ","
						+ route.getVilleArriv().toString());
			}
			writer.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void enregistrerSousRoute(List<Routes> routes)
	{
		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			File file = fileChooser.getSelectedFile();
			try (PrintWriter writer = new PrintWriter(file.getAbsolutePath())) 
			{
				for (Routes route : routes)
				{
					writer.println(route.getNbTroncon() + "," + route.getVilleDep().toString() + ","
							+ route.getVilleArriv().toString());
				}
				writer.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	public static void LectureRoutes(List<Routes> routes)
	{
		try
		{
			Scanner sc = new Scanner(new FileInputStream("mines.txt"));

			while (sc.hasNextLine())
				System.out.println(sc.nextLine());

			sc.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}