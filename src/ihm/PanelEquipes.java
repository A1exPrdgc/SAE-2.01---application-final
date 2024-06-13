package ihm;
import javax.swing.*;
import java.awt.*;

public class PanelEquipes extends JPanel
{
	private JTextField corpSolaireField;
	private JTextField syndicatAstralField;
	private JButton confirmerButton;

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
		corpSolairePanel.add(new JLabel("Corporation Solaire:"));
		corpSolairePanel.setAlignmentX(CENTER_ALIGNMENT);
		corpSolairePanel.add(corpSolaireField);

		JPanel syndicatAstralPanel = new JPanel();
		syndicatAstralPanel.setLayout(new BoxLayout(syndicatAstralPanel, BoxLayout.X_AXIS));
		syndicatAstralPanel.add(new JLabel("Syndicat Astral:        "));
		syndicatAstralPanel.setAlignmentX(CENTER_ALIGNMENT);
		syndicatAstralPanel.add(syndicatAstralField);

		// Créer et ajouter le bouton Confirmer
		this.confirmerButton = new JButton("Confirmer");

		// Ajouter les panels et le bouton au panel principal
		this.add(corpSolairePanel);
		this.add(syndicatAstralPanel);
		this.add(confirmerButton);
	}

	public String getCorpSolaire()
	{
		return corpSolaireField.getText();
	}

	public String getSyndicatAstral()
	{
		return syndicatAstralField.getText();
	}
}