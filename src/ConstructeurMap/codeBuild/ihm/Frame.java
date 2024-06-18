package codeBuild.ihm;

import javax.swing.*;

import codeBuild.Controleur;
import codeBuild.ihm.Frame;
import codeBuild.ihm.FrameMine;
import codeBuild.ihm.FrameRemove;
import codeBuild.ihm.FrameRoute;
import codeBuild.ihm.panels.*;

import java.awt.event.*;
import java.awt.BorderLayout;


public class Frame extends JFrame implements ActionListener
{
	private Controleur ctrl;

	private FrameMine afficheVille;
	private FrameRoute afficheRoute;
	private FrameRemove supprime;

	private PanelDessin afficheDessin;

	private TablePanel    tablePanel;


    private JMenuItem     menuFichierNouveau;
	private JMenuItem     menuFichierOuvrir;
	private JMenuItem     menuFichierEnregistrer;
	private JMenuItem     menuFichierEnregistrerSous;
	private JMenuItem     menuFichierQuitter;

	private JMenuItem     menuAjouterCreerMine ;
	private JMenuItem     menuAjouterCreerRoute ;

	private JMenuItem     menuSupprime;
	
    
    public Frame(Controleur ctrl)
    {
		this.ctrl = ctrl;
	
        this.setSize(1000, 1000);
        this.setTitle("GeoTerra");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

        //this.cartePanel

        /*-------------------------*/
		/* Création des composants */
		/*-------------------------*/

		// l'ensemble du menu
		JMenuBar menuMaBarre = new JMenuBar();

		// un element de la barre de menu
		JMenu menuFichier    = new JMenu("Fichier");
		JMenu menuAjouter    = new JMenu("Ajouter");
		JMenu menuSupprimer  = new JMenu("Supprimer");
		

		// les items du menu fichier
		this.menuFichierNouveau          = new JMenuItem("Nouveau");
		this.menuFichierOuvrir           = new JMenuItem("Ouvrir" );
		this.menuFichierEnregistrer      = new JMenuItem("Enregistrer");
		this.menuFichierEnregistrerSous  = new JMenuItem("Enregistrer Sous");
		this.menuFichierQuitter     = new JMenuItem("Quitter");

		// les items du menu ajouter
		this.menuAjouterCreerMine      = new JMenuItem("Creer Mine");
		this.menuAjouterCreerRoute      = new JMenuItem("Creer Route");

		// les items du menu supprimer
		this.menuSupprime = new JMenuItem("Supprimer");

		// l'ensemble des frames
		this.afficheVille = new FrameMine(this.ctrl);
		this.afficheRoute = new FrameRoute(this.ctrl);
		this.supprime = new FrameRemove(this.ctrl);

		//l'ensemble des panels
		this.tablePanel = new TablePanel(this.ctrl);
		this.afficheDessin = new PanelDessin(this.ctrl);


		// ajouts des items au menu correspondant
		menuFichier.add( this.menuFichierNouveau );
		menuFichier.add( this.menuFichierOuvrir );
		menuFichier.addSeparator();
		menuFichier.add( this.menuFichierEnregistrer );
		menuFichier.add( this.menuFichierEnregistrerSous );
		menuFichier.addSeparator();
		menuFichier.add( this.menuFichierQuitter );

		menuAjouter.add(this.menuAjouterCreerMine);
		menuAjouter.add(this.menuAjouterCreerRoute);

		menuSupprimer.add(this.menuSupprime);
		

		// ajouts des panels
		this.add(this.tablePanel, BorderLayout.SOUTH);
		this.add(this.afficheDessin, BorderLayout.CENTER);

		// ajout du menu 'Fichier' a la barre de menu
		menuMaBarre.add( menuFichier );
		menuMaBarre.add( menuAjouter );
		menuMaBarre.add( menuSupprimer );

		/*-------------------------------*/
		/* positionnement des composants */
		/*-------------------------------*/
		this.setJMenuBar( menuMaBarre );


		/*-------------------------------*/
		/* Activation des composants     */
		/*-------------------------------*/
		this.menuFichierNouveau.addActionListener 		  ( this );
		this.menuFichierOuvrir .addActionListener 		  ( this );
		this.menuFichierQuitter.addActionListener 		  ( this );
		this.menuFichierEnregistrer.addActionListener 	  ( this );
		this.menuFichierEnregistrerSous.addActionListener ( this );

		this.menuAjouterCreerMine.addActionListener(this);
		this.menuAjouterCreerRoute.addActionListener(this);

		this.menuSupprime.addActionListener(this);


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

		if (e.getSource() == this.menuFichierEnregistrer)
		{
			System.out.println("Enregistrer");
			this.ctrl.sauvegarder(this.ctrl.getMines(), this.ctrl.getRoutes());
		}

		if(e.getSource() == this.menuFichierEnregistrerSous)
		{
			System.out.println("Enregistrer Sous");
		}

		if(e.getSource() == this.menuFichierNouveau)
		{
			System.out.println("Nouveau");
			this.ctrl.reset(); //reset les données de ville.txt et route.txt
			this.dispose(); // détruit la frame
			new Frame(this.ctrl).setVisible(true); // creer une nouvelle fenetre
		}

		if ( e.getSource() == this.menuFichierQuitter )
		{
			System.out.println ( "Quitter" );
			this.dispose(); // détruit la frame 
		}

		if(e.getSource() == this.menuAjouterCreerMine)
		{
			this.afficheVille = new FrameMine(ctrl);
			this.afficheVille.setVisible(true);
		}

		if(e.getSource() == this.menuAjouterCreerRoute)
		{
			this.afficheRoute = new FrameRoute(ctrl);
			this.afficheRoute.setVisible(true);
		}

		if(e.getSource() == this.menuSupprime)
		{
			this.supprime = new FrameRemove(ctrl);
			this.supprime.setVisible(true);
		}
    }

	public void majTab()
	{
		this.tablePanel.majTabInfo();
	}

	public void majDessin()
	{
		this.afficheDessin.majDessin();
	}
}