package code.ihm.PlateauIndividuel;

import javax.swing.*;
import java.awt.*;

import code.Controleur;
import code.metier.*;

public class PanelPiece extends JPanel
{
	private JLabel piecePosImage;
	private JLabel nbPiecePos;
	private Controleur controleur;
	private Equipe equipe;
	private Graphics2D g2;

	public PanelPiece(Equipe equipe, Controleur controleur)
	{
		this.controleur = controleur;
		this.equipe = controleur.getEquipe();

		this.setLayout(new BorderLayout());

		this.piecePosImage = new JLabel();
		this.nbPiecePos = new JLabel("X" + equipe.getNBPointPos());
		this.nbPiecePos.setFont(new Font("7898", Font.PLAIN, 35));

		System.out.println("piecePos");
		this.piecePosImage.setIcon(new ImageIcon(
				"src\\Jeu\\code\\images\\distrib_images_2\\pion_joueur1.png"));

		this.add(this.piecePosImage, BorderLayout.WEST);
		this.add(this.nbPiecePos);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		g2 = (Graphics2D) g;

		// Affichage image de Fond
		g2.drawImage(this.getToolkit().getImage("src\\Jeu\\code\\images\\distrib_images_2\\pion_joueur_1.png"), 0, 0, this);
	
	}
}