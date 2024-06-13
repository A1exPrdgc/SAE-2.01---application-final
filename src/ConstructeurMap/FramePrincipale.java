package ConstructeurMap;

import javax.swing.JFrame;



public class FramePrincipale extends JFrame
{
    private PanelPrincipale panelPrincipale;
    private Controleur ctrl;
    
    public FramePrincipale(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.setSize(1000, 1000); 
		this.setTitle("Plateau jeu"); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setVisible(true); 

		this.add(new PanelPrincipale(this.ctrl));
		
	}
   
	public static void main(String[] args)
	{
		new FramePrincipale(new Controleur());
	}

	
}
