package ConstructeurMap;

import Etape2.metier.Routes;
import Etape2.metier.Mine;
import Etape2.metier.Region;

import java.io.BufferedReader;
import java.io.*;
import java.io.FileReader;
import java.util.*;
import Etape2.metier.*;
import Etape2.metier.Mine;

public class Controleur 
{
    private FramePrincipale plateau;
    private List<Routes> lstRoutes;
    private List<Mine>   lstMines;


    public Controleur()
    {
       
        this.plateau   = new FramePrincipale(this);
        this.lstMines  = new ArrayList<Mine>();
        this.lstRoutes = new ArrayList<Routes>();
        this.lectureGraphe();
        
    }

    public void lectureGraphe() 
    {
        try (BufferedReader lecture = new BufferedReader(new FileReader("ConstructeurMap/mines.txt"))) 
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
                   
                    
                   
                    Region region = Region.valueOf(parts[3].trim());

                    Mine mine = new Mine(Integer.parseInt(parts[0].trim()),Integer.parseInt(parts[1].trim()), Integer.parseInt(parts[2].trim()), region);
                    this.lstMines.add(mine);
                    System.out.println("-------------------");
                    System.out.println("Les Mines : " + region.name().toLowerCase());
                    System.out.println("-------------------");
                    for(Mine mines : lstMines)
                    {
                        System.out.println(mines.getNumMine() + " " +  mines.getX() +" "+  mines.getY() +" "+ String.valueOf(region));
                    }
                   
                } else if (routesSection) 
                {
                   
                   
                    Mine mineDep = getNumMine(Integer.parseInt(parts[1].trim()));
                    Mine mineArr = getNumMine(Integer.parseInt(parts[2].trim()));

                    if (mineDep != null && mineArr != null) 
                    {
                        Routes route = new Routes(Integer.parseInt(parts[0].trim()), mineDep, mineArr);
                        this.lstRoutes.add(route);
                    }

                    System.out.println("-------------------");
                    System.out.println("Les Routes entre mine : " + mineDep.getNumMine() + " et " + " mine " + mineArr.getNumMine());
                    System.out.println("-------------------");
                    for(Routes routes : this.lstRoutes)
                    {
                        System.out.println(routes.getNbTroncon() + "  " + routes.getMineDep().getNumMine() + "  "+ routes.getMineArriv().getNumMine());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    

    public List<Routes> getRoutes()
    {
        return this.lstRoutes;
    }

    public List<Mine> getMine()
    {
        return this.lstMines;
    }

    public Mine getNumMine(int num)
    {
        for(Mine mine : this.lstMines)
        {
            if(mine.getNumMine() == num)
            {
                return mine;
            }
        }
        return null;
    }



    
    public static void main(String[] args)
	{
        new Controleur();
	}
}
