package Etape2.ihm;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import Etape2.Controleur; 

public class FrameFicheScore extends JFrame 
{
	private Controleur ctrl ;
	private JTable tableau ;

	public FrameFicheScore()//Controleur ctrl)
	{
		this.ctrl = ctrl; 
		this.setTitle("Fiche de Score");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.tableau = new JTable(30,3);

		this.setSize(500,500);

		tableau.setValueAt("Fiche de Score",0, 1);
		tableau.setValueAt("Corporation", 1, 1);
		tableau.setValueAt("Syndicat Astral", 1, 2);
		tableau.setValueAt("Points Route", 3, 0);
		tableau.setValueAt("Points des Mines", 5, 0);
		tableau.setValueAt( new ImageIcon("images/etoile.png"),6,0);
		tableau.setValueAt("S/Total", 14, 0);
		tableau.setValueAt("Plateau Individuel", 16, 0);
		tableau.setValueAt("Score Pieces", 17, 0);
		tableau.setValueAt("Score des Colonnes", 18, 0);
		tableau.setValueAt("Scores des Lignes", 19, 0);
		tableau.setValueAt("S/Total", 20, 0);
		tableau.setValueAt("Jetons Possesion restants", 22, 0);
		tableau.setValueAt("Bonus(10)", 23, 0);
		tableau.setValueAt("Total", 25, 0);

		this.add(tableau);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new FrameFicheScore();
	}
}
