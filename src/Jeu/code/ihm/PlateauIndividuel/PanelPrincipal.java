package code.ihm.PlateauIndividuel;

import java.awt.*;
import javax.swing.*;

import code.metier.*;
import code.Controleur;

public class PanelPrincipal extends JPanel
{
	private Graphics2D g2;
	private Equipe equipe;
	private Jeton[][] tabJetons;
	private Image[][] tabImagesRessource;
	private Controleur ctrl;

	public PanelPrincipal(Equipe equipe, Controleur controleur)
	{
		this.equipe = equipe;
		this.ctrl = controleur;

		this.tabJetons = this.ctrl.getTabJetonEquipe();
		this.tabImagesRessource = new Image[4][8];

		// Création des Image Ressources
		for (int i = 0; i < this.tabJetons.length; i++)
		{
			for (int j = 0; j < this.tabJetons[0].length; j++)
			{
				if (this.tabJetons[i][j] != null)
				{
					this.tabImagesRessource[i][j] = new ImageIcon(
							"src\\Jeu\\code\\images\\distrib_images_2\\ressources\\" + tabJetons[i][j].getType() + ".png").getImage();
				}
			}
		}
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		g2 = (Graphics2D) g;

		// Affichage image de Fond
		g2.drawImage(this.getToolkit().getImage("src\\Jeu\\code\\images\\distrib_images_2\\plateau_joueur_1.png"), 0, 0, this);

		

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
			Image pieceImage = new ImageIcon("src\\Jeu\\code\\images\\distrib_images_2\\ressources\\NR.png").getImage();
			g2.drawImage(pieceImage, x+tmp, 328, this);
			tmp += x;
		}
	}
}