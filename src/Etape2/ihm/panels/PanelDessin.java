package Etape2.ihm.panels;

import Etape2.Controleur;
import Etape2.metier.Mine;
import Etape2.metier.Routes;

import javax.swing.*;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

public class PanelDessin extends JPanel
{
	private static final int TAILLE_CERCLE = 25;
	private static final int DECALAGE = 20;

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
			graphics2D.setColor(point.getRegion().getCoul());
			//graphics2D.drawOval(point.getX() - point.getTailleX() / 2, point.getY() - point.getTailleY() / 2, point.getTailleX(),point.getTailleY()); 
			graphics2D.fillOval(point.getX() - point.getTailleX() / 2, point.getY() - point.getTailleY() / 2, point.getTailleX(),point.getTailleY());
		}

		for (int i = 0; i < this.ctrl.getRoutes().size(); i++)
		{
			Routes trait = this.ctrl.getRoute(i);

			Mine villeDep = trait.getMineDep();
			Mine villeArr = trait.getMineArriv();
			graphics2D.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{0, 30, (float)getLongueur(villeDep, villeArr) - 60, 30, 0}, 0));  // Chiffres à réfléchirs

			graphics2D.setColor(Color.DARK_GRAY);
			graphics2D. drawLine(villeDep.getX(), villeDep.getY(), villeArr.getX(), villeArr.getY());
			graphics2D.fillOval(((villeDep.getX() + villeArr.getX()) / trait.getNbTroncon()) - TAILLE_CERCLE / 2, ((villeDep.getY() + villeArr.getY()) / trait.getNbTroncon()) - TAILLE_CERCLE / 2, TAILLE_CERCLE, TAILLE_CERCLE);
			/* 
			int radius = PanelDessin.TAILLE_CERCLE / 2;

			int x1 = villeDep.getX() - radius;
			int x2 = villeArr.getX() - radius;
			int y1 = villeDep.getY() - radius;
			int y2 = villeArr.getY() - radius;

            double angle = Math.atan2(y2 - y1, x2 - x1);

			if (x1 - x2 > 0)
			{
				x2 += DECALAGE;
				x1 += -DECALAGE;
			}
			
			if (y1 - y2 > 0 && y1 - y2 > DECALAGE || y1 - y2 < -DECALAGE)
			{
				y2 += DECALAGE;
				y1 += -DECALAGE;
			}

            int debutX = (int) (x1 + radius * Math.cos(angle));
            int debutY = (int) (y1 + radius * Math.sin(angle));
            int finX   = (int) (x2 - radius * Math.cos(angle));
            int finY   = (int) (y2 - radius * Math.sin(angle));

			graphics2D.fillOval(debutX, debutY, TAILLE_CERCLE, TAILLE_CERCLE);
			graphics2D.fillOval(finX, finY, TAILLE_CERCLE, TAILLE_CERCLE);*/

		}
		graphics2D.setStroke(new BasicStroke(0));
		this.ctrl.majTab();
	}

	private static double getLongueur(Mine v1, Mine v2)
	{
		return Math.sqrt(Math.pow(v2.getX() - v1.getX(), 2) + Math.pow(v2.getY() - v1.getY(), 2));
	}

	private class GererSouris extends MouseAdapter
	{
		private int x;
		private int y;
		private Mine v;

		@Override
		public void mousePressed(MouseEvent e) 
		{
			this.v = PanelDessin.this.ctrl.getMineTouche(e.getX(), e.getX());
			this.x = e.getX();
			this.y = e.getY();	
			System.out.println("cliqué : " + this.v);
		}

		@Override
		public void mouseDragged(MouseEvent e) 
		{
			System.out.println("dragged : " + this.v);

			if (this.v != null)
			{
				this.v.setX(this.x);
				this.v.setY(this.y);
				System.out.println(v.getX() + " : " + v.getY());

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