package codeJeu.ihm.PlateauIndividuel;

import java.awt.*;
import javax.swing.*;

import codeJeu.metier.*;
import codeJeu.Controleur;

public class PanelMine extends JPanel
{
	private Graphics2D g2;
	private Mine[] tabMine;
	private Image[] tabImageMine;
	private Equipe equipe;
	private Controleur controleur;
	private String type;

	public PanelMine(Equipe equipe, Controleur controleur, String type)
	{
		this.type = type;
		this.controleur = controleur;
		this.equipe = equipe;

		this.tabImageMine = new Image[15];
		this.tabMine = equipe.getMines();

		// CrÃ©ation des Image Mines
		for (int i = 0; i < tabMine.length; i++)
		{
			if (this.tabMine[i] != null)
			{
				this.tabImageMine[i] = new ImageIcon(
						"./codeJeu/images/distrib_images_2/transparent/Mine_" + tabMine[i].getRegion().getNomCoul() + ".png").getImage(); 
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
