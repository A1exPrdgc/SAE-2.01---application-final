package codeJeu.ihm.interfaceEquipe;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FrameEquipe extends JFrame
{
	private PanelEquipes panelEquipes	;
	private JButton confirmerButton;

	public FrameEquipe()
	{
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

	public static void main(String[] args)
	{
		new FrameEquipe();
	}
}
