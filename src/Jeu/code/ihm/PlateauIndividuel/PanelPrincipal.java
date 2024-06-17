package code.ihm.PlateauIndividuel;

import java.awt.*;
import javax.swing.*;

import code.metier.*;

public class PanelPrincipal extends JPanel
{

	private Graphics2D g2;
	private Equipe equipe;
	private Jeton[][] tabJetons;
	private Image[][] tabImagesRessource;

	public PanelPrincipal(Equipe equipe)
	{
		this.equipe = equipe;

		this.tabJetons = new Jeton[4][8];
		this.tabImagesRessource = new Image[4][8];

		// Création des Image Ressources
		for (int i = 0; i < this.tabJetons.length; i++)
		{
			for (int j = 0; j < this.tabJetons[0].length; j++)
			{
				System.out.println("ressource");

				System.out.println("RESSOURCE");
				this.tabImagesRessource[i][j] = new ImageIcon("C:\\Users\\chant\\OneDrive\\Documents\\Cours_BUT\\SAE\\SAE 2.01\\appli_finale\\SAE-2.01---application-final\\src\\Jeu\\code\\images\\distrib_images_2\\ressources\\AG.png")
						.getImage(); // "../images/distrib_images_2/ressources/tabJetons[i][j].getType().getClass().getName().png"
				
			}
		}
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		g2 = (Graphics2D) g;

		// Affichage image de Fond
		g2.drawImage(this.getToolkit().getImage("C:\\Users\\chant\\OneDrive\\Documents\\Cours_BUT\\SAE\\SAE 2.01\\appli_finale\\SAE-2.01---application-final\\src\\Jeu\\code\\images\\distrib_images_2\\plateau_joueur_1.png"), 0, 0, this);

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
		for (int i = 0; i < 8; i++)
		{ // nb pieces
			Image pieceImage = new ImageIcon("C:\\Users\\chant\\OneDrive\\Documents\\Cours_BUT\\SAE\\SAE 2.01\\appli_finale\\SAE-2.01---application-final\\src\\Jeu\\code\\images\\distrib_images_2\\ressources\\NR.png").getImage();
			g2.drawImage(pieceImage, x+tmp, 328, this);
			tmp += x;
		}
	}
}