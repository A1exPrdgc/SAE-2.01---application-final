package codeBuild.metier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Sauvegarde
{
    public static void sauvegarderMine(List<Mine> mines)
    {
        List<String> lines = new ArrayList<>();
        for (Mine mine : mines)
        {
            String line = mine.getX() + "," + mine.getY() + "," + mine.getNumMine() + ","
                    + mine.getRegion().name().charAt(0) + "," + mine.getVisit() + "," + mine.getIdMine();
            lines.add(line);
        }
        Collections.reverse(lines);
        try (PrintWriter writer = new PrintWriter(new FileOutputStream("../save/mines.txt")))
        {
            writer.println("Mines:");
            for (String line : lines)
            {
                writer.println(line);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void sauvegarderRoutes(List<Routes> routes)
    {
        List<String> lines = new ArrayList<>();
        lines.add("\nRoutes:");
        for (Routes route : routes)
        {
            String line = route.getNbTroncon() + "," + route.getMineDep().getIdMine() + ","
                    + route.getMineArriv().getIdMine();
            lines.add(line);
        }
        try (PrintWriter writer = new PrintWriter(new FileOutputStream("../save/mines.txt", true)))
        {
            for (String line : lines)
            {
                writer.println(line);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}