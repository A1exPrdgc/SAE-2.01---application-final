package src.Etape2.ihm;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTable;

import src.Etape2.Controleur; 

public class FrameFicheScore extends JFrame 
{
	private Controleur ctrl ;
	private JTable tableau ;
	private Object[][] data;

	public FrameFicheScore()//Controleur ctrl)
	{
		this.ctrl = ctrl; 
		this.setTitle("Fiche de Score");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.tableau = new JTable(30,3);

		this.setSize(500,500);

		data = new Object[30][3];

		data[0][1] = "Fiche de Score";
		data[1][1] = "Corporation";
		data[1][2] = "Syndicat Astral";
		data[3][0] = "Points Route";
		data[5][0] = "Points des Mines";
		data[6][0] =  new ImageIcon("images/etoile.png");
		data[7][0] =  new ImageIcon("images/etoile_bleu.png");
		data[8][0] =  new ImageIcon("images/losange.png");
		data[9][0] =  new ImageIcon("images/vert.png");
		data[10][0] =  new ImageIcon("images/tuile.png");
		data[11][0] =  new ImageIcon("images/marron.png");
		data[12][0] = "S/Total";
		data[14][0] = "Plateau Individuel";
		data[16][0] = "Score Pieces";
		data[17][0] = "Scores des Colonnes";
		data[18][0] = "Scores des Lignes";
		data[19][0] = "S/Total";
		data[21][0] = "Jetons Possession restants";
		data[22][0] = "Bonus";
		data[24][0] = "Total";

		tableau = new JTable(data, new String[] {"", "", ""});

		this.add(tableau);


		

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new FrameFicheScore();
	}
}
