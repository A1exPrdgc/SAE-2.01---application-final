package code.ihm.PlateauIndividuel;

import javax.swing.*;
import java.awt.*;

import code.Controleur;
import code.metier.*;

public class FrameIndi extends JFrame
{
	private PanelMine panelMine;
	private PanelPrincipal panelPrincipal;
	private PanelPiece panelCptPiecePos;
	private Equipe equipe;
	private Controleur controleur;

	public FrameIndi(Controleur controleur)
	{
		this.controleur = controleur;
		this.equipe = new Equipe(controleur, "Test");
		this.setTitle("Plateau Individuel");
		this.setLocation(50, 50);
		this.setSize(800, 500); // 553, 397

		// CrÃ©ation des panels
		this.panelCptPiecePos = new PanelPiece();
		this.panelMine = new PanelMine(this.equipe);
		this.panelPrincipal = new PanelPrincipal(this.equipe);

		// Ajout des panels
		this.add(this.panelMine);
		this.add(this.panelCptPiecePos);
		this.add(this.panelPrincipal);

		this.setSize(1060, 598);
		this.setVisible(true);

	}

	public static void main(String[] args)
	{
		Controleur controleur = new Controleur();
		new FrameIndi(controleur);
		
	}
}