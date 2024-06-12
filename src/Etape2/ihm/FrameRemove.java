package Etape2.ihm;

import Etape2.Controleur;
import Etape2.metier.*;

import javax.swing.*;
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

		for (int i = 0; i < this.ctrl.getMines().size(); i++) {
			tabVilles[i] = this.ctrl.getMines().get(i).toString();
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
			this.ctrl.supprimerMine(this.ctrl.rechercherMine(mine));
		}
		if(e.getSource() == this.btnAnnuler)
		{
			this.dispose(); // quitter la fenêtre
            this.setVisible(false);
		}
    }

}