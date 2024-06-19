package codeJeu.ihm.PlateauIndividuel;

import javax.swing.*;
import java.awt.*;

import codeJeu.Controleur;
import codeJeu.metier.*;

public class FrameIndi extends JFrame
{
	private PanelPrincipal panelPrincipal;
	private PanelPiece panelCptPiecePos;
	private Equipe equipe;
	private Controleur controleur;
	private String type;

	public FrameIndi(Controleur controleur, Equipe equipe, String type, String nom)
	{
		this.controleur = controleur;
		this.equipe = equipe;
		this.type = type;
		this.setTitle("Plateau de " + nom);
		this.setLocation(50, 50);
		this.setSize(850, 500); // 553, 397
		this.setLayout(new BorderLayout());

		// CrÃ©ation des panels
		this.panelCptPiecePos = new PanelPiece(this.equipe, this.controleur, this.type);
		this.panelPrincipal = new PanelPrincipal(this.equipe, this.controleur, this.type);

		// Ajout des panels
		this.add(this.panelPrincipal, BorderLayout.CENTER);
		this.add(this.panelCptPiecePos, BorderLayout.SOUTH);

		this.setVisible(true);

	}

	public void majDessinRessource()
	{
		this.panelPrincipal.repaint();
	}
}