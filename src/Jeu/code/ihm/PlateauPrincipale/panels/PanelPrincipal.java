package code.ihm.PlateauPrincipale.panels;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PanelPrincipal extends JPanel
{
	public PanelPrincipal()
	{
		ImageIcon imageIcon = new ImageIcon(getClass().getResource("/path/to/your/image.jpg"));
		JLabel backgroundLabel = new JLabel(imageIcon);
		add(backgroundLabel);
	}
}