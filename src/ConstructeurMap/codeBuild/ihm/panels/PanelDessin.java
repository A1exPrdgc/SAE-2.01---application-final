package codeBuild.ihm.panels;

import javax.swing.*;

import codeBuild.Controleur;
import codeBuild.metier.Mine;
import codeBuild.metier.Routes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelDessin extends JPanel
{
	private static final int TAILLE_CERCLE = 25;

	private Controleur ctrl;
	private Graphics2D graphics2D;
	private GererSouris souris;

	public PanelDessin(Controleur ctrl)
	{
		this.ctrl = ctrl;

		this.souris = new GererSouris();
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

		graphics2D = (Graphics2D) g;

		for (int i = 0; i < this.ctrl.getMines().size(); i++)
		{
			Mine point = this.ctrl.getMine(i);
<<<<<<< HEAD:src/Jeu/code/ihm/PlateauPrincipale/panels/PanelDessin.java
			//graphics2D.fillOval(point.getX() - point.getTailleX() / 2, point.getY() - point.getTailleY() / 2, point.getTailleX(),point.getTailleY());
			Image temp = this.getToolkit().getImage("./code/images/distrib_images_2/transparent/Mine_" + point.getRegion().getNomCoul() + ".png");
			graphics2D.drawImage(temp, point.getX() - temp.getWidth(this) / 2 ,point.getY() - temp.getHeight(this) / 2, this);
			graphics2D.drawString(point.getNumMine() + "", point.getX() - 3, point.getY() - 15);
			if (point.getRessource() != null)
			{
				if (point.getRessource().getType() instanceof Minerai)
				{
					temp = this.getToolkit().getImage("./code/images/distrib_images_2/transparent/Mine_" + this.ctrl.rechercheMinerai(point.getRessource().getType()).name() + ".png");
				}
				if (point.getRessource().getType() instanceof Minerai)
				{
					temp = this.getToolkit().getImage("./code/images/distrib_images_2/transparent/Mine_NR.png");
				}
				graphics2D.drawImage(temp, point.getX(), point.getY(), this);
			}
=======
			graphics2D.setColor(point.getRegion().getCoul());
			graphics2D.fillOval(point.getX() - point.getTailleX() / 2, point.getY() - point.getTailleY() / 2, point.getTailleX(),point.getTailleY());
>>>>>>> 0d48cfe0de95970a040270d43d3a292bf3745677:src/ConstructeurMap/codeBuild/ihm/panels/PanelDessin.java
		}

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
		graphics2D.setStroke(new BasicStroke(0));
		this.ctrl.majTab();
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

		@Override
		public void mousePressed(MouseEvent e) 
		{
			this.v = PanelDessin.this.ctrl.getMineTouche(e.getX(), e.getY());
			this.x = e.getX();
			this.y = e.getY();	
			System.out.println("cliqué : " + this.v);
		}

		@Override
		public void mouseDragged(MouseEvent e) 
		{

			if (this.v != null)
			{
				this.v.setX(this.x);
				this.v.setY(this.y);

				this.x = e.getX();
				this.y = e.getY();

				PanelDessin.this.ctrl.majTab();
				PanelDessin.this.repaint();
			}
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			PanelDessin.this.souris = new GererSouris();
		}
	}
}