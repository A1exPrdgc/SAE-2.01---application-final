package Etape2.ihm.panels;

import Etape2.Controleur;
import Etape2.metier.Routes;
import Etape2.metier.Villes;

import javax.swing.*;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelDessin extends JPanel
{

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

		for (int i = 0; i < this.ctrl.getVilles().size(); i++)
		{
			Villes point = this.ctrl.getVille(i);
			graphics2D.drawString(point.getNomVille(), point.getX() - 7 * point.getNomVille().length() / 2, point.getY() - 30);
			graphics2D.drawOval(point.getX() - point.getTailleX() / 2, point.getY() - point.getTailleY() / 2, point.getTailleX(),point.getTailleY()); 
		}

		for (int i = 0; i < this.ctrl.getRoutes().size(); i++)
		{
			Routes trait = this.ctrl.getRoute(i);

			Villes villeDep = trait.getVilleDep();
			Villes villeArr = trait.getVilleArriv();
			System.out.println(getLongueur(villeDep, villeArr) / trait.getNbTroncon());
			graphics2D.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{(float)getLongueur(villeDep, villeArr) / (trait.getNbTroncon() + trait.getNbTroncon() - 1)}, 2f));  // Chiffres à réfléchirs
			graphics2D. drawLine(villeDep.getX(), villeDep.getY(), villeArr.getX(), villeArr.getY());
		}
		graphics2D.setStroke(new BasicStroke(0));
		this.ctrl.majTab();
	}

	private static double getLongueur(Villes v1, Villes v2)
	{
		return Math.sqrt(Math.pow(v2.getX() - v1.getX(), 2) + Math.pow(v2.getY() - v1.getY(), 2));
	}

	private class GererSouris extends MouseAdapter
	{
		private int x;
		private int y;
		private Villes v;

		@Override
		public void mousePressed(MouseEvent e) 
		{
			this.v = PanelDessin.this.ctrl.getVilleTouche(e.getX(), e.getX());
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