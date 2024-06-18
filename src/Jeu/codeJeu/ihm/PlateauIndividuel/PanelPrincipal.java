package codeJeu.ihm.PlateauIndividuel;
import java.awt.*;
import javax.swing.*;

public class PanelPrincipal extends JPanel {

    private static final int ESPACE_COTE_D_R = 80;
    private static final int ESPACE_COTE_G_R = 123;
    private static final int ESPACE_DESSUS_R = 65;
    private static final int ESPACE_DESSOUS_R = 16;

    private static final int ESPACE_COTE_D_P = 80;
    private static final int ESPACE_COTE_G_P = 123;
    private static final int ESPACE_DESSUS_P = 0;
    private static final int ESPACE_DESSOUS_P = 50;

    private Graphics2D g2;
    private JPanel panelRessources;
    private JPanel panelInterieurR;
    private JPanel panelInterieurP;
    private JPanel panelPiece;

    private Image imgFond;
    private JLabel espaceCoteD_R;
    private JLabel espaceCoteG_R;
    private JLabel espaceDessus_R;
    private JLabel espaceDessous_R;

    private JLabel espaceCoteD_P;
    private JLabel espaceCoteG_P;
    private JLabel espaceDessus_P;
    private JLabel espaceDessous_P;

    public PanelPrincipal() {
        this.setLayout(new BorderLayout(50, 50));

        this.panelPiece = new JPanel();
        this.panelRessources = new JPanel();
        this.panelInterieurR = new JPanel();
        this.panelInterieurP = new JPanel();

        this.espaceCoteD_R = new JLabel();
        this.espaceCoteG_R = new JLabel();
        this.espaceDessus_R = new JLabel();
        this.espaceDessous_R = new JLabel();

        this.espaceCoteD_P = new JLabel();
        this.espaceCoteG_P = new JLabel();
        this.espaceDessus_P = new JLabel();
        this.espaceDessous_P = new JLabel();

        this.panelPiece.setOpaque(false);
        this.panelInterieurP.setOpaque(false);
        this.panelInterieurR.setOpaque(false);
        this.panelRessources.setOpaque(false);

        this.espaceCoteD_R.setOpaque(false);
        this.espaceCoteG_R.setOpaque(false);
        this.espaceDessus_R.setOpaque(false);
        this.espaceDessous_R.setOpaque(false);

        this.espaceCoteD_P.setOpaque(false);
        this.espaceCoteG_P.setOpaque(false);
        this.espaceDessus_P.setOpaque(false);
        this.espaceDessous_P.setOpaque(false);

        this.imgFond = getToolkit().getImage("./images/plateauIndividuel.png");

        this.panelInterieurR.setLayout(new GridLayout(4, 8));
        this.panelInterieurP.setLayout(new GridLayout(1, 8));
        this.panelPiece.setLayout(new BorderLayout());
        this.panelRessources.setLayout(new BorderLayout());

        this.espaceDessus_P.setPreferredSize(new Dimension(10, ESPACE_DESSUS_P));
        this.espaceCoteD_P.setPreferredSize(new Dimension(ESPACE_COTE_D_P, 10));
        this.espaceCoteG_P.setPreferredSize(new Dimension(ESPACE_COTE_G_P, 10));
        this.espaceDessous_P.setPreferredSize(new Dimension(10, ESPACE_DESSOUS_P));

        this.espaceDessus_R.setPreferredSize(new Dimension(10, ESPACE_DESSUS_R));
        this.espaceCoteD_R.setPreferredSize(new Dimension(ESPACE_COTE_D_R, 10));
        this.espaceCoteG_R.setPreferredSize(new Dimension(ESPACE_COTE_G_R, 10));
        this.espaceDessous_R.setPreferredSize(new Dimension(10, ESPACE_DESSOUS_R));

        //this.panelRessources.setPreferredSize(new Dimension (this.imgFond.getHeight(panelRessources), this.imgFond.getWidth(panelRessources)));

        this.panelRessources.add(this.panelInterieurR);
        this.panelPiece.add(this.panelInterieurP);

        this.add(this.panelRessources, BorderLayout.CENTER);
        this.add(this.panelPiece, BorderLayout.SOUTH);

        this.panelPiece.add(this.espaceCoteG_P, BorderLayout.EAST);
        this.panelPiece.add(this.espaceCoteD_P, BorderLayout.WEST);
        this.panelPiece.add(this.espaceDessus_P, BorderLayout.NORTH);
        this.panelPiece.add(this.espaceDessous_P, BorderLayout.SOUTH);

        this.panelRessources.add(this.espaceCoteG_R, BorderLayout.EAST);
        this.panelRessources.add(this.espaceCoteD_R, BorderLayout.WEST);
        this.panelRessources.add(this.espaceDessus_R, BorderLayout.NORTH);
        this.panelRessources.add(this.espaceDessous_R, BorderLayout.SOUTH);

        for (int i = 0; i < 8; i++) 
        {
            for (int j = 0; j < 4; j++) 
            {
                JLabel temp = new JLabel();
                temp.setIcon(new ImageIcon("./images/jetonTest.png"));
                temp.setPreferredSize(new Dimension(temp.getIcon().getIconWidth(), temp.getIcon().getIconHeight()));
                this.panelInterieurR.add(temp);    
            }    
        }

        for (int i = 0; i < 8; i++) 
        {
            JLabel temp = new JLabel();
            temp.setIcon(new ImageIcon("./images/jetonTest.png"));
            temp.setPreferredSize(new Dimension(temp.getIcon().getIconWidth(), temp.getIcon().getIconHeight()));
            this.panelInterieurP.add(temp);    
        }
        this.repaint();
    }

    public void paintComponent(Graphics g)
	{
        super.paintComponent(g);

        g2 = (Graphics2D) g;

        if(this.imgFond != null) g2.drawImage(this.imgFond, 0, 0, this.panelRessources);
	}
}
