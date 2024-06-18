package codeJeu.ihm.PlateauIndividuel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.*;

import codeJeu.Controleur;
import codeJeu.metier.Equipe;
import codeJeu.metier.Mine;

public class PanelMine extends JPanel
{
	private Graphics2D g2;
	private Mine[] tabMine;
	private Image[] tabImageMine;
	private Equipe equipe;

	public PanelMine(Equipe equipe)
	{
		this.equipe = equipe;
		this.tabImageMine = new Image[15];
		this.tabMine = equipe.getMines();

		System.out.println("mine");

		// CrÃ©ation des Image Mines
		for (int i = 0; i < tabMine.length; i++)
		{
			if (this.tabMine[i] != null)
			{
				this.tabImageMine[i] = new ImageIcon(
						"../../images/distrib_images_2/opaqueMines_" + tabMine[i].getRegion().getNomCoul() + ".png")
								.getImage(); // a revoir
			}

		}
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		g2 = (Graphics2D) g;

		// Affichage images Ressources
		for (int lig = 0; lig < 3; lig++)
		{
			for (int col = 0; col < 5; col++)
			{
				if (this.tabImageMine[lig + col] != null)
				{
					g2.drawImage(this.tabImageMine[lig + col], col * 50 + 80, lig * 85 + 20, 48, 83, this);
				}
			}
		}

	}
}
