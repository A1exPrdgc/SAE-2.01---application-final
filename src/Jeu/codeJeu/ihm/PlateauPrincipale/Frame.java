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

		this.afficheDessin = new PanelDessin(this.ctrl);

		this.add(this.afficheDessin, BorderLayout.CENTER);

		this.setVisible( true );
	}

	public void majDessin()
	{
		this.afficheDessin.majDessin();
	}
}