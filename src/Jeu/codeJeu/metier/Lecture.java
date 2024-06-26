package codeJeu.metier;

import java.io.BufferedReader;
import java.io.*;
import java.io.FileReader;
import java.util.*;

import codeJeu.Controleur;
import codeJeu.metier.*;

public class Lecture 
{
    private List<Routes> lstRoutes;
    private List<Mine>   lstMines;
    private Controleur   ctrl;

    public Lecture(Controleur   ctrl)
    {
        this.ctrl      = ctrl;
        this.lstMines  = this.ctrl.getMines();
        this.lstRoutes = this.ctrl.getRoutes();
    }

    public void lectureGraphe() 
    {
        try (BufferedReader lecture = new BufferedReader(new FileReader("../save/" + this.ctrl.getSauvegarde()))) 
        {
            String line;
            boolean minesSection = false;
            boolean routesSection = false;

            while ((line = lecture.readLine()) != null) 
            {
 
                if (line.trim().isEmpty()) continue;

                if (line.equals("Mines:")) 
                {
                    minesSection = true;
                    routesSection = false;
                    continue;
                } else if (line.equals("Routes:")) 
                {
                    minesSection = false;
                    routesSection = true;
                    continue;
                }

                String[] parts = line.split(",");
                if (minesSection) 
                {
                   
                    char charRegion = parts[3].charAt(0);
                   
                    Region region = Lecture.getRegionChar0(charRegion);
                 
					Mine mine = this.getNumMine(Integer.parseInt(parts[0].trim()));
					
						this.ctrl.ajouterMine(Integer.parseInt(parts[0].trim()), Integer.parseInt(parts[1].trim()),
								Integer.parseInt(parts[2].trim()), region);

                } else if (routesSection) 
                {
                   
                   
                    Mine mineDep = getNumMine(Integer.parseInt(parts[1].trim()));
                    Mine mineArr = getNumMine(Integer.parseInt(parts[2].trim()));

                    if (mineDep != null && mineArr != null) 
                    {
                        this.ctrl.ajouterRoute(Integer.parseInt(parts[0].trim()), mineDep, mineArr);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Mine getNumMine(int num)
    {
        for(Mine mine : this.lstMines)
        {
            if(mine.getIdMine() == num)
            {
                return mine;
            }
        }
        return null;
    }

    public static Region getRegionChar0(char c)
    {
        for (Region r : Region.values()) 
        {
            if(r.name().charAt(0) == c)
            {
                return r;
            }    
        }
        return null;
    }
}
