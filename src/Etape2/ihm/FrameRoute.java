
package Etape2.ihm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Etape2.*;


public class FrameRoute extends JFrame implements ActionListener
{
	private JComboBox<String>  	ddlstVilleDepart;
	private JComboBox<String>  	ddlstVilleArriver;

	private JTextField          txtNbTroncons;
	private JPanel panelBtn;
	private JPanel panelTxt;
	private JPanel panelVilleDep , panelVilleArr;
	private JButton btnAjouter;

	private Controleur ctrl;

    public FrameRoute ( Controleur ctrl)
	{
		this.setTitle   ( "Les Routes");
		this.setSize    ( 300,400 );
		this.setLocation(  50, 50 );
        this.setLayout(new GridLayout(2,1));


		/*-------------------------*/
		/* Création des composants */
		/*-------------------------*/   

		this.setLayout(new GridLayout(4,1));
		this.ctrl 				= ctrl;
		this.panelBtn           = new JPanel();
		this.panelTxt           = new JPanel();
		this.panelVilleDep      = new JPanel();
		this.panelVilleArr      = new JPanel();

		this.txtNbTroncons      = new JTextField("",3);
		this.btnAjouter         = new JButton("Ajouter");

		String[] tabVilles      = new String[this.ctrl.getVilles().size()];

		for (int i = 0; i < this.ctrl.getVilles().size(); i++) 
		{
			tabVilles[i] = this.ctrl.getVilles().get(i).getNomVille();
			System.out.println(tabVilles[i]);
		}

		this.ddlstVilleDepart   = new JComboBox<String>(tabVilles);
		this.ddlstVilleArriver  = new JComboBox<String>(tabVilles);
		
		/*-------------------------*/
		/* POSITIONEMENT VILLE DEP */
		/*-------------------------*/
		this.add(this.panelVilleDep);
		this.panelVilleDep.add(new JLabel("Ville Départ : "));
		this.panelVilleDep.add(this.ddlstVilleDepart);


		/*-------------------------*/
		/* POSITIONEMENT VILLE ARR */
		/*-------------------------*/
		this.add(this.panelVilleArr);
		this.panelVilleArr.add(new JLabel("Ville Arriver : ") ,BorderLayout.CENTER);
		this.panelVilleArr.add(this.ddlstVilleArriver);

		this.add(this.panelTxt);
		this.panelTxt.add(new JLabel("Nb Tronçons : "));
		this.panelTxt.add(this.txtNbTroncons);

		this.add(this.panelBtn);
		
		this.panelBtn.add(this.btnAjouter);

		 /*----------------------------*/
		 /* Activation des Composants */
		 /*--------------------------*/

		this.txtNbTroncons.addActionListener(this);
		this.btnAjouter   .addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		this.ctrl.ajouterRoute(Integer.parseInt(this.txtNbTroncons.getText()),
												  this.ctrl.rechercherVilles((String)this.ddlstVilleDepart.getSelectedItem()),
												  this.ctrl.rechercherVilles((String)this.ddlstVilleArriver.getSelectedItem()));
		this.ctrl.majDessin();										  									  
		this.setVisible(false);
	}
}