import java.awt.GridLayout;

import javax.swing.*;

public class PanelMine extends JPanel {
	public PanelMine() {
		this.setLayout(new GridLayout(3, 10, 0, 0));

		for (int i = 0; i < 15; i++) 
		{
			JLabel temp = new JLabel();
			temp.setIcon(new ImageIcon("./images/a.png"));
			this.add(temp);
		}
	}
}
