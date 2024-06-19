package codeJeu.ihm.PlateauPrincipale.panels;

import javax.swing.*;

import codeJeu.Controleur;
import codeJeu.metier.Mine;
import codeJeu.metier.Routes;
import codeJeu.metier.Minerai;
import codeJeu.metier.Monnaie;
import codeJeu.metier.Region;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelDessin extends JPanel
{
	private static final int TAILLE_CERCLE = 25;

	
	private Controleur ctrl;
	private Graphics2D graphics2D;
	private GererSouris souris;
	private boolean aCliqueSurOui;

	public PanelDessin(Controleur ctrl)
	{
		this.ctrl = ctrl;

		this.souris = new GererSouris();
		this.aCliqueSurOui = false;
		this.addMouseListener(this.souris);
		this.addMouseMotionListener(this.souris);
	}

	public void majDessin()
	{
		this.repaint();
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		Image temp;
		graphics2D = (Graphics2D) g;

		graphics2D.drawImage(this.getToolkit().getImage("./codeJeu/images/distrib_images_2/Plateau_vierge.png"), 0, 0, this.getWidth(), this.getHeight(), this);


		for (int i = 0; i < this.ctrl.getRoutes().size(); i++)
		{
			Routes trait = this.ctrl.getRoute(i);

			Mine villeDep = trait.getMineDep();
			Mine villeArr = trait.getMineArriv();

			graphics2D.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{0, 30, (float)getLongueur(villeDep, villeArr) - 60, 30, 0}, 0));  // Chiffres à réfléchirs

			graphics2D.setColor(Color.DARK_GRAY);
			graphics2D. drawLine(villeDep.getX() + villeDep.getTailleX() / 2, villeDep.getY() + villeDep.getTailleY() / 2, villeArr.getX() + villeArr.getTailleX() / 2, villeArr.getY() + villeArr.getTailleY() / 2);
			
			if (trait.getNbTroncon() > 1)
			{
				graphics2D.fillOval(((villeDep.getX() + villeArr.getX()) / trait.getNbTroncon()) + TAILLE_CERCLE / 2, ((villeDep.getY() + villeArr.getY()) / trait.getNbTroncon()) + TAILLE_CERCLE / 2, TAILLE_CERCLE, TAILLE_CERCLE);
			}

		}

		for (int i = 0; i < this.ctrl.getMines().size(); i++)
		{
			Mine point = this.ctrl.getMine(i);
			// graphics2D.fillOval(point.getX() - point.getTailleX() / 2,
			// point.getY() - point.getTailleY() / 2,
			// point.getTailleX(),point.getTailleY());

			if (point.getRegion() != Region.VILLE)
			{
				temp = this.getToolkit().getImage("./codeJeu/images/distrib_images_2/transparent/Mine_"
						+ point.getRegion().getNomCoul() + ".png");
				graphics2D.drawImage(temp, point.getX(), point.getY(), this);
				graphics2D.drawString(point.getNumMine() + "", point.getX() + 21, point.getY() + 30);
			}
			else
			{
				temp = this.getToolkit().getImage("./codeJeu/images/distrib_images_2/NR.png");
				graphics2D.drawImage(temp, point.getX(), point.getY(), this);
			}
			if (point.getRessource() != null)
			{
				if (point.getRessource().getType() instanceof Minerai)
				{
					temp = this.getToolkit().getImage("./codeJeu/images/distrib_images_2/ressources/"
							+ this.ctrl.rechercheMinerai(point.getRessource().getType()).name() + ".png");
				}
				if (point.getRessource().getType() instanceof Monnaie)
				{
					temp = this.getToolkit().getImage("./code/images/distrib_images_2/transparent/Mine_NR.png");
				}
				graphics2D.drawImage(temp, point.getX() + 2, point.getY() + 40, 45, 40, this);
			}
		}
		graphics2D.setStroke(new BasicStroke(0));

		if(aCliqueSurOui)
		{
			Mine point = this.ctrl.getMineTouche(souris.x, souris.y);
		 	this.getToolkit().getImage("./codeJeu/images/distrib_images_2/transparent/Mine_" + point.getRegion().getNomCoul() + ".png");
		}

	}

	private static double getLongueur(Mine v1, Mine v2)
	{
		if (v2.getX() > v1.getX() || v2.getY() > v1.getY())
		{
			return Math.sqrt(Math.pow(v2.getX() - v1.getX(), 2) + Math.pow(v2.getY() - v1.getY(), 2));
		}
		else
		{
			return Math.sqrt(Math.pow(v1.getX() - v2.getX(), 2) + Math.pow(v1.getY() - v2.getY(), 2));
		}
	}

	private class GererSouris extends MouseAdapter
	{
		private int x;
		private int y;
		private Mine v;
		private Boolean choisie;

		public void mousePressed(MouseEvent e) 
		{
			this.v = PanelDessin.this.ctrl.getMineTouche(e.getX(), e.getY());
			this.x = e.getX();
			this.y = e.getY();	
			System.out.println("cliqué : " + this.v);
		}

		public void mouseClicked(MouseEvent e)
		{
			for (Mine mine : ctrl.getMines())
			{
				if (mine.possede(e.getX(), e.getY()))
				{
					int response = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir cette mine ?",
							"Confirmation", JOptionPane.YES_NO_OPTION);
					if (response == JOptionPane.YES_OPTION)
					{
						PanelDessin.this.aCliqueSurOui = true;
					}
				}
			}
		}
	}


}