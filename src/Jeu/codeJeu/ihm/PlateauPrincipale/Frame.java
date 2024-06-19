package codeJeu.ihm.PlateauPrincipale;

import javax.swing.*;

import codeJeu.Controleur;
import codeJeu.ihm.PlateauPrincipale.panels.*;

import java.awt.event.*;
import java.awt.BorderLayout;


public class Frame extends JFrame /*implements ActionListener*/
{
	private Controleur ctrl;

	private PanelDessin afficheDessin;

	private JMenuItem     menuFichierOuvrir;
    
    public Frame(Controleur ctrl)
    {
		this.ctrl = ctrl;
	
        this.setSize(1090, 1000);
        this.setTitle("Plateau jeu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());


		//JMenuBar menuMaBarre = new JMenuBar();

		//JMenu menuFichier    = new JMenu("Fichier");
		
		//this.menuFichierOuvrir           = new JMenuItem("Ouvrir" );

		this.afficheDessin = new PanelDessin(this.ctrl);


		//menuFichier.add( this.menuFichierOuvrir );
		this.add(this.afficheDessin, BorderLayout.CENTER);
		//menuMaBarre.add( menuFichier );

		//this.setJMenuBar( menuMaBarre );

		//this.menuFichierOuvrir .addActionListener 		  ( this );

		this.setVisible( true );
	}

	/*public void actionPerformed ( ActionEvent e )
	{
		if ( e.getSource() == this.menuFichierOuvrir )
		{
			System.out.println ( "Ouvrir" );
			this.ctrl.charger();
			this.ctrl.majDessin();
		}
    }*/

	public void majDessin()
	{
		this.afficheDessin.majDessin();
	}
}