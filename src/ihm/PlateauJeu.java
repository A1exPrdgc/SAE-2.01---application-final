package ihm;

import javax.swing.JFrame;

class PlateauJeu extends JFrame
{
	PlateauJeu()
	{
		this.setSize(800, 800); 
		this.setTitle("Mon Plateau"); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setVisible(true); 

		//Creation et ajout du Panel
		
	}

	public static void main(String[] args)
	{
		new PlateauJeu(); 
	}
}