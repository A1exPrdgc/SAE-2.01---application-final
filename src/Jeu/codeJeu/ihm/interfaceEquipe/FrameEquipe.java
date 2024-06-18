package codeJeu.ihm.interfaceEquipe;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import codeJeu.Controleur;

public class FrameEquipe extends JFrame
{
	private PanelEquipes panelEquipes	;
	private JButton confirmerButton;
	private Controleur ctrl;


	public FrameEquipe(Controleur ctrl)
	{	
		this.ctrl = ctrl;
		this.setTitle("Choix des équipes");
		this.setLayout(new BorderLayout());
		this.setSize(500, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Créer le panel de jeu
		PanelEquipes panelEquipes = new PanelEquipes();
		panelEquipes.setAlignmentX(CENTER_ALIGNMENT);
		panelEquipes.setAlignmentY(CENTER_ALIGNMENT);

		// Ajouter le panel de jeu à la fenêtre	
		this.add(panelEquipes);

		// Afficher la fenêtre
		this.setVisible(true);
	}
}
