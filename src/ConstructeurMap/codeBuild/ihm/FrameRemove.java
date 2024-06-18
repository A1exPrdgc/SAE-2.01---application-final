package codeBuild.ihm;

import javax.swing.*;

import codeBuild.Controleur;

import java.awt.event.*;
import java.awt.GridLayout;

public class FrameRemove extends JFrame implements ActionListener 
{

	private Controleur ctrl;

	private JComboBox<String> listeVilles;
	private JComboBox<String> listeRoutes;

	private JPanel panelVille;
	private JPanel panelRoute;
	private JButton btnAnnuler;
    private JButton btnSupprimer;


	public FrameRemove(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setTitle("suppression");
		this.setSize(300, 400);
		this.setLayout(new GridLayout(2,1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String[] tabVilles = new String[this.ctrl.getMines().size()];

		for (int i = 0; i < this.ctrl.getMines().size(); i++) 
		{
			tabVilles[i] = this.ctrl.getMine(i).getNumMine() + "_" + this.ctrl.getMine(i).getRegion().name() + " - id" + this.ctrl.getMine(i).getIdMine();
		}

		// création des composants
		this.panelVille = new JPanel();
		this.listeVilles = new JComboBox<String>(tabVilles);
		
		//this.panelRoute = new JPanel();
		//this.listeRoutes = new JComboBox<String>();

		this.btnSupprimer = new JButton("Supprimer");
		this.btnAnnuler = new JButton("Annuler");

		// ajout des composants au panelVille
		this.panelVille.add(new JLabel("Quelle ville voulez-vous supprimer ?"));
		this.panelVille.add(this.listeVilles);
		this.panelVille.add(this.btnSupprimer);
		this.panelVille.add(this.btnAnnuler);

         
		/*this.panelRoute.add(new JLabel("Quelle route voulez-vous supprimer ?"));
		this.panelRoute.add(this.listeRoutes);
		this.panelRoute.add(this.btnSupprimer);
		this.panelRoute.add(this.btnAnnuler);*/

		this.add(this.panelVille);
		//this.add(this.panelRoute);

		// ajout des listeners
		this.btnSupprimer.addActionListener(this);
		this.btnAnnuler.addActionListener(this);

	}

    @Override
    public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == this.btnSupprimer)
		{
			String mine = (String) this.listeVilles.getSelectedItem();

			String temp = mine.charAt(0) + "";
			this.ctrl.supprimerMine(this.ctrl.rechercherMine(mine.charAt(2), Integer.parseInt(temp)));

			this.ctrl.majDessin();
			this.ctrl.majTab();
			this.setVisible(false);
		}

		if(e.getSource() == this.btnAnnuler)
		{
            this.setVisible(false);
		}
    }

}