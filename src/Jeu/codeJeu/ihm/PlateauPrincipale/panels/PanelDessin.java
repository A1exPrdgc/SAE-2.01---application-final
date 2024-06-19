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
import java.awt.Font;
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
				if (!point.getVisit())
				{
					temp = this.getToolkit().getImage("./codeJeu/images/distrib_images_2/opaque/Mine_" + point.getRegion().getNomCoul() + ".png");
					graphics2D.drawImage(temp, point.getX(), point.getY(), this);
					Font fontChiffre = new Font("Arial", Font.BOLD, 18);
                	graphics2D.setFont(fontChiffre);
					graphics2D.drawString(point.getNumMine() + "", point.getX() + 18, point.getY() + 31);
				}
				else
				{
					temp = this.getToolkit().getImage("./codeJeu/images/distrib_images_2/transparent/Mine_" + point.getRegion().getNomCoul() + ".png");
					graphics2D.drawImage(temp, point.getX(), point.getY(), this);
					Font fontChiffre = new Font("Arial", Font.BOLD, 18);
					graphics2D.setFont(fontChiffre);
					graphics2D.drawString(point.getNumMine() + "", point.getX() + 18, point.getY() + 31);
				}
			}
			else
			{
				temp = this.getToolkit().getImage("./codeJeu/images/distrib_images_2/NR.png");
				graphics2D.drawImage(temp, point.getX(), point.getY(), this);
			}

			if (point.getRessource() != null)
			{
				if (!point.getVisit())
				{
					if (point.getRessource().getType() instanceof Minerai)
					{
						temp = this.getToolkit().getImage("./codeJeu/images/distrib_images_2/ressources/"
								+ this.ctrl.rechercheMinerai(point.getRessource().getType()).name() + ".png");
					}
					if (point.getRessource().getType() instanceof Monnaie)
					{
						temp = this.getToolkit().getImage("./codeJeu/images/distrib_images_2/ressources/NR.png");
					}
					graphics2D.drawImage(temp, point.getX() + 2, point.getY() + 40, 45, 40, this);
				}
			}
		}
		graphics2D.setStroke(new BasicStroke(0));

		/* 
		if(aCliqueSurOui)
		{
			Mine point = this.ctrl.getMineTouche(souris.x, souris.y);
			System.out.println(point);
		 	this.getToolkit().getImage("./codeJeu/images/distrib_images_2/transparent/Mine_" + point.getRegion().getNomCoul() + ".png");
		}*/

		if (this.ctrl.getTour() % 2 == 0)
		{
			temp = this.getToolkit().getImage("./codeJeu/images/distrib_images_2/pion_joueur_1.png");
		}
		else
		{
			temp = this.getToolkit().getImage("./codeJeu/images/distrib_images_2/pion_joueur_2.png");
		}
		graphics2D.drawImage(temp, 15, 15, this);

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
		public void mouseClicked(MouseEvent e)
		{
			for (Mine mine : ctrl.getMines())
			{
				if (mine.possede(e.getX(), e.getY()) && !mine.getVisit() && mine.getRegion() != Region.VILLE && PanelDessin.this.ctrl.canObtain(mine) && PanelDessin.this.ctrl.getInscrit())
				{
					int response = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir cette mine ?","Confirmation", JOptionPane.YES_NO_OPTION);

					if (response == JOptionPane.YES_OPTION)
					{
						PanelDessin.this.aCliqueSurOui = true;
						if (PanelDessin.this.ctrl.getTour() % 2 == 0)
						{
							PanelDessin.this.ctrl.getEquipeCS().ajouterRessource(mine.getRessource());
							PanelDessin.this.ctrl.getEquipeCS().ajouterMine(mine);
							PanelDessin.this.ctrl.getFrameCS().majDessinRessource();
							mine.visiteMine();

							PanelDessin.this.ctrl.tourSuivant();
						}
						else
						{
							PanelDessin.this.ctrl.getEquipeSA().ajouterRessource(mine.getRessource());
							PanelDessin.this.ctrl.getEquipeSA().ajouterMine(mine);
							PanelDessin.this.ctrl.getFrameSA().majDessinRessource();
							mine.visiteMine();

							PanelDessin.this.ctrl.tourSuivant();
							
						}
					}
				}
			}
			PanelDessin.this.ctrl.majDessin();

			if (PanelDessin.this.ctrl.hasWin())
			{
				int reponse = JOptionPane.showInternalConfirmDialog(null, "La partie est terminé", "fin", JOptionPane.OK_OPTION);

				if (reponse == JOptionPane.OK_OPTION)
				{
					System.exit(reponse);
				}
			}
		}
	}


}