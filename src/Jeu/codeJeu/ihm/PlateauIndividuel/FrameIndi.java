package codeJeu.ihm.PlateauIndividuel;

import javax.swing.*;
import java.awt.*;

import codeJeu.Controleur;
import codeJeu.metier.*;

public class FrameIndi extends JFrame
{
	private PanelMine panelMine;
	private PanelPrincipal panelPrincipal;
	private PanelPiece panelCptPiecePos;
	private Equipe equipe;
	private Controleur controleur;
	private String type;

	public FrameIndi(Controleur controleur, Equipe equipe, String type)
	{
		this.controleur = controleur;
		this.equipe = equipe;
		this.type = type;
		this.setTitle("Plateau Individuel");
		this.setLocation(50, 50);
		this.setSize(800, 500); // 553, 397
		this.setLayout(new BorderLayout());

		// CrÃ©ation des panels
		this.panelCptPiecePos = new PanelPiece(this.equipe, this.controleur, this.type);
		this.panelMine = new PanelMine(this.equipe, this.controleur, this.type);
		this.panelPrincipal = new PanelPrincipal(this.equipe, this.controleur, this.type);

		// Ajout des panels
		this.add(this.panelMine, BorderLayout.EAST);
		this.add(this.panelPrincipal, BorderLayout.CENTER);
		this.add(this.panelCptPiecePos, BorderLayout.SOUTH);

		this.setSize(1060, 598);
		this.setVisible(true);

	}
}