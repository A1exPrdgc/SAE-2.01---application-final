
package Etape2.ihm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Etape2.*;


public class FrameRoute extends JFrame implements ActionListener
{
	private JComboBox<String>  	ddlstMineDepart;
	private JComboBox<String>  	ddlstMineArriver;

	private JTextField          txtNbTroncons;
	private JPanel panelBtn;
	private JPanel panelTxt;
	private JPanel panelMineDep , panelMineArr;
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
		this.panelMineDep      = new JPanel();
		this.panelMineArr      = new JPanel();

		this.txtNbTroncons      = new JTextField("",3);
		this.btnAjouter         = new JButton("Ajouter");

		String[] tabMine      = new String[this.ctrl.getMines().size()];

		for (int i = 0; i < this.ctrl.getMines().size(); i++) 
		{
			tabMine[i] = this.ctrl.getMine(i).getRegion().name().charAt(0) + "" + this.ctrl.getMine(i).getNumMine() + "";
			System.out.println(tabMine[i]);
		}

		this.ddlstMineDepart   = new JComboBox<String>(tabMine);
		this.ddlstMineArriver  = new JComboBox<String>(tabMine);
		
		/*-------------------------*/
		/* POSITIONEMENT VILLE DEP */
		/*-------------------------*/
		this.add(this.panelMineDep);
		this.panelMineDep.add(new JLabel("Mine Départ : "));
		this.panelMineDep.add(this.ddlstMineDepart);


		/*-------------------------*/
		/* POSITIONEMENT VILLE ARR */
		/*-------------------------*/
		this.add(this.panelMineArr);
		this.panelMineArr.add(new JLabel("Mine Arriver : ") ,BorderLayout.CENTER);
		this.panelMineArr.add(this.ddlstMineArriver);

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
		String resMineArr = (String)(this.ddlstMineArriver.getSelectedItem());
		String resMineDep = (String)(this.ddlstMineDepart.getSelectedItem());

		String tempDep = resMineDep.charAt(1) + "";
		String tempArr = resMineArr.charAt(1) + "";

		System.out.println("*-------------------*");
		System.out.println(Integer.parseInt(this.txtNbTroncons.getText()));
		System.out.println("*-------------------*");


		System.out.println(this.ctrl.ajouterRoute(Integer.parseInt(this.txtNbTroncons.getText()),
												  this.ctrl.rechercherMine(resMineDep.charAt(0), Integer.parseInt(tempDep)),
												  this.ctrl.rechercherMine(resMineArr.charAt(0), Integer.parseInt(tempArr))));

		this.ctrl.majDessin();										  									  
		this.setVisible(false);
	}
}