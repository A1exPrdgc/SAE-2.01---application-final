package codeJeu.ihm.PlateauIndividuel;

import javax.swing.*;
import java.awt.*;

public class PanelPiece extends JPanel
{
	private JLabel piecePosImage;
	private JLabel nbPiecePos;

	public PanelPiece()
	{

		this.setLayout(new FlowLayout(FlowLayout.LEFT));

		this.piecePosImage = new JLabel();
		this.nbPiecePos = new JLabel("x4");
		this.nbPiecePos.setFont(new Font("7898", Font.PLAIN, 40));

		System.out.println("piecePos");
		this.piecePosImage.setIcon(new ImageIcon(
				"../../images/distrib_images_2/pion_joueur_1.png"));

		this.add(this.piecePosImage);
		this.add(this.nbPiecePos);
	}
}