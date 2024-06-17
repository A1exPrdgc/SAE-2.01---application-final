package code.ihm.PlateauPrincipale;

import javax.swing.*;


import code.Controleur;
import code.ihm.PlateauPrincipale.panels.*;

import java.awt.event.*;
import java.awt.BorderLayout;


public class Frame extends JFrame implements ActionListener
{
	private Controleur ctrl;

	private PanelDessin afficheDessin;

	private JMenuItem     menuFichierOuvrir;
    
    public Frame(Controleur ctrl)
    {
		this.ctrl = ctrl;
	
        this.setSize(300, 400);
        this.setTitle("GeoTerra");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

        //this.cartePanel

        /*-------------------------*/
		/* Création des composants */
		/*-------------------------*/

		JMenuBar menuMaBarre = new JMenuBar();

		JMenu menuFichier    = new JMenu("Fichier");
		
		this.menuFichierOuvrir           = new JMenuItem("Ouvrir" );

		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		this.afficheDessin = new PanelDessin(this.ctrl);


		menuFichier.add( this.menuFichierOuvrir );

		// ajouts des panels
		this.add(this.afficheDessin, BorderLayout.CENTER);

		// ajout du menu 'Fichier' a la barre de menu
		menuMaBarre.add( menuFichier );

		/*-------------------------------*/
		/* positionnement des composants */
		/*-------------------------------*/
		this.setJMenuBar( menuMaBarre );


		/*-------------------------------*/
		/* Activation des composants     */
		/*-------------------------------*/
		this.menuFichierOuvrir .addActionListener 		  ( this );

		this.setVisible( true );
	}

	public void actionPerformed ( ActionEvent e )
	{
		if ( e.getSource() == this.menuFichierOuvrir )
		{
			System.out.println ( "Ouvrir" );
			this.ctrl.charger();
			this.ctrl.majDessin();
		}
    }

	public void majDessin()
	{
		this.afficheDessin.majDessin();
	}
}