package codeJeu.ihm.PlateauIndividuel;

import java.util.List;

import java.awt.*;
import javax.swing.*;

import codeJeu.metier.*;
import codeJeu.Controleur;

public class PanelPrincipal extends JPanel
{
	private Graphics2D g2;
	private Equipe equipe;
	private Jeton[][] tabJetons;
	private Image[][] tabImagesRessource;
	private Controleur ctrl;
	private String type;
	private Image[] tabImageMine;
	private List<Mine> tabMine;
	private int[] tabNum;

	public PanelPrincipal(Equipe equipe, Controleur controleur, String type)
	{
		this.equipe = equipe;
		this.ctrl = controleur;
		this.type = type;
		this.tabImageMine = new Image[15];
		this.tabNum = new int[15];

		this.tabJetons = equipe.getRessources();
		this.tabImagesRessource = new Image[4][8];

		// Création des Image Ressources
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		g2 = (Graphics2D) g;

		// Affichage image de Fond
		if (this.type.equals("CS"))
		{
			g2.drawImage(this.getToolkit().getImage("./codeJeu/images/distrib_images_2/plateau_joueur_1.png"), 0, 0, this);
		}	
		else
		{
			g2.drawImage(this.getToolkit().getImage("./codeJeu/images/distrib_images_2/plateau_joueur_2.png"), 0, 0, this);
		}

		for (int i = 0; i < this.tabJetons.length; i++)
		{
			for (int j = 0; j < this.tabJetons[0].length; j++)
			{
				if (this.tabJetons[i][j] != null)
				{
					this.tabImagesRessource[i][j] = new ImageIcon(
							"./codeJeu/images/distrib_images_2/ressources/" + tabJetons[i][j].getType() + ".png").getImage();
				}
			}
		}

		// Affichage images Ressources
		for (int lig = 0; lig < tabJetons.length; lig++)
		{
			for (int col = 0; col < tabJetons[0].length; col++)
			{
				if (this.tabImagesRessource[lig][col] != null)
				{
					g2.drawImage(tabImagesRessource[lig][col], col * 53 + 66, lig * 55 + 55, 45, 45, this);
				}
			}
		}

		// Affichage images Pieces
		int tmp = 14;
		int x = 53;
		for (int i = 0; i < this.equipe.getNBPiece(); i++)
		{ // nb pieces
			Image pieceImage = new ImageIcon("./codeJeu/images/distrib_images_2/ressources/NR.png").getImage();
			g2.drawImage(pieceImage, x+tmp, 328, this);
			tmp += x;
		}

		
		this.tabMine = this.equipe.getMines();
		for (int i = 0; i < tabMine.size(); i++)
		{
			if (this.tabMine.get(i) != null)
			{
				this.tabImageMine[i] = new ImageIcon("./codeJeu/images/distrib_images_2/transparent/Mine_" + tabMine.get(i).getRegion().getNomCoul() + ".png").getImage(); 
				this.tabNum[i] = tabMine.get(i).getNumMine(); 
			}

		}

		// Affichage images Ressources
		for (int lig = 0; lig < 3; lig++)
		{
			for (int col = 0; col < 5; col++)
			{
				if (this.tabImageMine[(lig * 5) + col] != null)
				{
					g2.drawImage(this.tabImageMine[(lig * 5) + col], col * 50 + 565, lig * 85 + 20, 48, 83, this);
					Font fontChiffre = new Font("Arial", Font.BOLD, 18);
					g2.setFont(fontChiffre);
					g2.drawString(this.tabNum[(lig * 5) + col] + "", col * 50 + 565 + 20, lig * 85 + 20 + 30);
				}
			}
		}
	}
}