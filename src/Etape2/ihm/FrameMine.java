package Etape2.ihm;

import Etape2.Controleur;
import Etape2.metier.Region;

import java.awt.*;
import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class FrameMine extends JFrame implements ActionListener
{
	private Controleur ctrl;
	private JPanel     panel;   
    private JPanel     panel2;
    private JPanel     panel3;
	private JComboBox<String> txtnumero;
    private JComboBox<String> txtRegion;
    private JTextField txtX;
    private JTextField txtY;

    private JButton btnAjouter;

	
	public FrameMine ( Controleur ctrl )
	{
		this.setTitle   ( "Les Mines");
		this.setSize    ( 300,300 );
		this.setLocation(  50, 50 );
		this.setLayout(new GridLayout(2,1));

        List<String> forme = new ArrayList<String>();

        for (Region r : Region.values()) 
        {
            forme.add(0, r.name());
        }

        String[] tabInt = new String[8];

        for (int i = 0; i < tabInt.length; i++) 
        {
            tabInt[i] = i + 1 + "";    
        }

		this.ctrl = ctrl;
		this.panel  = new JPanel();
        this.panel2 = new JPanel();
        this.panel3 = new JPanel();
        this.txtRegion = new JComboBox<String>(FrameMine.listToTab(forme));
		this.txtnumero = new JComboBox<String>(tabInt);
        this.txtX = new JTextField  ("" , 3);
        this.txtY = new JTextField  ("" , 3);
        this.btnAjouter = new JButton("Ajouter");

        this.setLayout(new GridLayout(3,1));

        this.add(this.panel );
        this.panel.add(new JLabel(" région :"));
        this.panel.add(this.txtRegion);

		this.panel.add(new JLabel("numero :"));
		this.panel.add(this.txtnumero);

        this.add(this.panel2);
        this.panel2.add(new JLabel("X :"));
        this.panel2.add(this.txtX);
        this.panel2.add(new JLabel("Y :"));
        this.panel2.add(this.txtY);

        this.add(this.panel3);
        this.panel3.add(this.btnAjouter);

        this.txtRegion.addActionListener(this);
		this.txtnumero.addActionListener(this);
        this.txtX.addActionListener  (this);
        this.txtY.addActionListener  (this); 
        this.btnAjouter.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btnAjouter)
		{
			this.ctrl.ajouterMine(Integer.parseInt(this.txtX.getText()), Integer.parseInt(this.txtY.getText()), Integer.parseInt((String)this.txtnumero.getSelectedItem()), this.ctrl.rechercherRegion((String)this.txtRegion.getSelectedItem()));
            this.ctrl.majDessin();
            this.setVisible(false);
		}
	}

    private static String[] listToTab(List<String> lst)
    {
        String[] tab = new String[lst.size()];

        for (int i = 0; i < lst.size(); i++) 
        {
            tab[i] = lst.get(i);
        }
        return tab;
    }
}