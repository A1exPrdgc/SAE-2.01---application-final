package codeJeu.ihm.PlateauIndividuel;

import javax.swing.*;
import java.awt.*;

import codeJeu.Controleur;
import codeJeu.metier.*;

public class PanelPiece extends JPanel
{
	private JLabel piecePosImage;
	private JLabel nbPiecePos;
	private Controleur controleur;
	private Equipe equipe;
	private Graphics2D g2;
	private String type;

	public PanelPiece(Equipe equipe, Controleur controleur, String type)
	{
		this.controleur = controleur;
		this.equipe = equipe;
		this.type = type;

		this.setLayout(new FlowLayout(FlowLayout.LEFT));

		this.piecePosImage = new JLabel();
		this.nbPiecePos = new JLabel("X" + equipe.getNBPointPos());
		this.nbPiecePos.setFont(new Font("7898", Font.PLAIN, 35));

		System.out.println("piecePos");

		if (this.type.equals("CS"))
		{
			this.piecePosImage.setIcon(new ImageIcon(
				"./codeJeu/images/distrib_images_2/pion_joueur_1.png"));
		}
		else
		{
			this.piecePosImage.setIcon(new ImageIcon(
				"./codeJeu/images/distrib_images_2/pion_joueur_2.png"));
		}

		this.add(this.piecePosImage);
		this.add(this.nbPiecePos);
	}
}