package ConstructeurMap;
import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.BufferedReader;
import java.util.List;
import java.util.ArrayList;

public class PanelPrincipale extends JPanel
{
	private Image imgFond;
	private Controleur ctrl;
	private Graphics2D g2;
	private int posX, posY;
	private JPanel panel;

	/* private List<Routes> lstSectionRoutes; */

	public PanelPrincipale(Controleur ctrl)
	{
		this.ctrl = ctrl;

		this.imgFond = getToolkit().getImage("../images/PlateauPrincipale.png");

		/* this.lstSectionRoutes = new ArrayList<Routes>(); */

	}

	public void majDessin()
	{
		this.repaint();
	}

	public void dessinerAretes(Graphics g)
	{

	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g2 = (Graphics2D) g;

		if (imgFond != null)
		{
			g2.drawImage(imgFond, 0, 0, this.getWidth(), this.getHeight(), this);
		}

	}
}