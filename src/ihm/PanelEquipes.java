package ihm;
import javax.swing.*;

import ihm.PlateauIndividuel.FrameIndi;
import ConstructeurMap.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelEquipes extends JPanel implements ActionListener
{
	private JTextField corpSolaireField;
	private JTextField syndicatAstralField;
	private JButton confirmerButton;
	private JPanel panelBouton;

	public PanelEquipes()
	{
		setLayout(new GridLayout(3, 1));

		// Créer les champs de texte pour les équipes
		this.corpSolaireField = new JTextField();
		this.corpSolaireField.setMaximumSize(new Dimension(200, 40));
		this.corpSolaireField.setAlignmentX(CENTER_ALIGNMENT);
		this.syndicatAstralField = new JTextField();
		this.syndicatAstralField.setMaximumSize(new Dimension(200, 40));
		this.syndicatAstralField.setAlignmentX(CENTER_ALIGNMENT);

		// Créer les panels pour chaque ligne
		JPanel corpSolairePanel = new JPanel();
		corpSolairePanel.setLayout(new BoxLayout(corpSolairePanel, BoxLayout.X_AXIS));
		corpSolairePanel.add(new JLabel("Corporation Solaire: "));
		corpSolairePanel.setAlignmentX(CENTER_ALIGNMENT);
		corpSolairePanel.add(corpSolaireField);

		JPanel syndicatAstralPanel = new JPanel();
		syndicatAstralPanel.setLayout(new BoxLayout(syndicatAstralPanel, BoxLayout.X_AXIS));
		syndicatAstralPanel.add(new JLabel("Syndicat Astral:         "));
		syndicatAstralPanel.setAlignmentX(CENTER_ALIGNMENT);
		syndicatAstralPanel.add(syndicatAstralField);

		// Créer et ajouter le bouton Confirmer
		this.confirmerButton = new JButton("Confirmer");
		this.confirmerButton.setMaximumSize(new Dimension(70,40));
		
		this.panelBouton = new JPanel();
		this.panelBouton.add(confirmerButton);


		// Ajouter les panels et le bouton au panel principal
		this.add(corpSolairePanel);
		this.add(syndicatAstralPanel);
		this.add(panelBouton);

		// Ajouter l'écouteur d'événements
		this.confirmerButton.addActionListener(this);


	}


	public String getCorpSolaire()
	{
		return corpSolaireField.getText();
	}

	public String getSyndicatAstral()
	{
		return syndicatAstralField.getText();
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == this.confirmerButton)
		{
			String corpSolaire = getCorpSolaire();
			String syndicatAstral = getSyndicatAstral();
			System.out.println("Equipe 1: " + corpSolaire);
			System.out.println("Equipe 2: " + getSyndicatAstral());

			Frame frameIndi = new FrameIndi();
			Frame frameIndi2 = new FrameIndi();
			Frame FramePrincipale = new FramePrincipale(null);

			// Ajouter getCorpSolaire() au titre de la frame
			frameIndi.setTitle(corpSolaire);
			frameIndi2.setTitle(syndicatAstral);

			frameIndi.setVisible(true);
			frameIndi2.setVisible(true);
			FramePrincipale.setVisible(true);

			// Fermer la fenêtre actuelle
			JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
			topFrame.setVisible(false);
		}
	}
}