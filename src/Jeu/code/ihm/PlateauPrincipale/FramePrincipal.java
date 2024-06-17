package code.ihm.PlateauPrincipale;


import javax.swing.JFrame;


import code.Controleur;
import Jeu.code.ihm.PlateauPrincipale.panels.PanelPrincipal;

public class FramePrincipal  extends JFrame
{
	private Controleur ctrl;
	private PanelPrincipal panel;

	public FramePrincipal()
	{
		this.setSize(1000, 1000);
		this.setTitle("Plateau jeu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		this.panel = new PanelPrincipal();
		this.add(this.panel);

		this.setVisible(true);
	}
}
