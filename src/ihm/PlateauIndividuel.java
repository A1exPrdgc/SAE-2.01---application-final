import javax.swing.*;

import metier.Equipe;
import src.metier.Jeton;

import java.awt.*;
import java.util.Deque;
import java.util.List;
import java.util.ArrayList;

public class PlateauIndividuel extends JPanel {

	private int imageWidthRessourceXY = 75; // Largeur/hauteur de l'image de l'épice
	private int imageWidthMineXY = 50;
	private int imageWidthPointPosXY = 50;
	private Jeton[][] tabRessources;
	private Image[][] tabImageRessource;
	private Jeton[][] tabMines;
	private Image[][] tabImageMine;

	private Equipe equipe;
	private Image plateauImage;
	private Image pointPosRestantImage;
	private int pointPosRestant;

	private final int pieceXOffset = 77; // Position initiale en x pour les pièces
	private final int pieceYOffset = 450; // Position initiale en y pour les pièces
	private final int pieceSpacing = 85; // Espacement entre les pièces


	// ajuster l'image du plateau en fonction du role du joueur (Corporation, Syndicat)
	// tabMines tableau simple a double 

	public PlateauIndividuel(Equipe equipe) {
		this.equipe = equipe;
		this.plateauImage = new ImageIcon("images/plateauIndividuel.png").getImage(); // à revoir

		this.pointPosRestantImage = new ImageIcon("images/jetonPossession.png") // à revoir ++
		this.pointPosRestant = equipe.getNBPointPos(); // à revoir
		// Créer un JLabel pour afficher le texte
		JLabel labelPointPosRestant = new JLabel("x25");
		labelPointPosRestant.setBounds(80, 550, 50, 50); // Positionner le label dans la fenêtre
		frame.add(labelPointPosRestant); // Ajouter le label à la fenêtre

		this.tabImageRessource = new Image[4][8];
		this.tabRessources = this.equipe.getRessources(); // à revoir

		this.tabImageMine = new Image[3][5];
		this.tabMines = this.equipe.getMines(); // à revoir


		for (int lig = 0; lig < tabRessources.length; lig++) 
		{
			for (int col = 0; col < tabRessources[0].length; col++) 
			{
				if (tabRessources[lig][col] != null) 
				{
					this.tabImageRessource[lig][col] = new ImageIcon("images/" + tabRessources[lig][col].getType().toString().toLowerCase() + ".png").getImage();
				}
			}
		}
		for (int lig = 0; lig < tabMines.length; lig++) 
		{
			for (int col = 0; col < tabMines[0].length; col++) 
			{
				if (tabMines[lig][col] != null) 
				{
					this.tabImageMine[lig][col] = new ImageIcon("images/" + tabMines[lig][col].getType().toString().toLowerCase() + ".png").getImage(); // à revoir
				}
			}
		}
	}


	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(plateauImage, 0, 0, 880, 500, this);
		g.drawImage(pointPosRestant, 20, 550, imageWidthPointPosXY, imageWidthPointPosXY, this);
		labelPointPosRestant.setText( "" + pointPosRestant);

		for (int lig = 0; lig < tabRessources.length; lig++) {
			for (int col = 0; col < tabRessources[0].length; col++) {
				if (this.tabImageRessource[lig][col] != null) {
					g.drawImage(tabImageRessource[lig][col], col*80*2+80, lig * 62*2+60, imageWidthRessourceXY, imageWidthRessourceXY, this);
				}
			}
		}

		for (int lig = 0; lig < tabMines.length; lig++) {
			for (int col = 0; col < tabMines[0].length; col++) {
				if (this.tabImageMine[lig][col] != null) {
					g.drawImage(tabImageMine[lig][col], col*80*2+800, lig * 80*2+80, imageWidthMineXY, imageWidthMineXY, this);
				}
			}
		}

		int tmp = 0;
		for (int i = 0; i < equipe.getNBPiece(); i++) { // à revoir
			Image pieceImage = new ImageIcon("images/bronze.png").getImage(); // à revoir
			g.drawImage(pieceImage, pieceXOffset + tmp, pieceYOffset, this);
			tmp += pieceSpacing;
		}
	}
	
	public static void main(String[] args) {
		// Créer une nouvelle fenêtre (JFrame)
		JFrame frame = new JFrame("Plateau individuel");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Equipe equipe = new Equipe();
		PlateauIndividuel plateauIndividuel = new PlateauIndividuel(equipe);

		// Ajouter le panel au cadre
		frame.add(plateauIndividuel);
		frame.setSize(1280, 600);

		// Rendre la fenêtre visible
		frame.setVisible(true);
	}
}

