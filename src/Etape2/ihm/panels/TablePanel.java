package Etape2.ihm.panels;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import Etape2.Controleur;


public class TablePanel extends JPanel
{
    private JTable tableVille;
    private JScrollPane jScrollPaneVille;

    private JTable tableRoute;
    private JScrollPane jScrollPaneRoute;

    private Controleur ctrl; 
    private ModelTableauVille modelVille;
    private ModelTableauRoute modelRoute;

    public TablePanel(Controleur ctrl)
    {
        this.ctrl = ctrl;

        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        this.modelVille = new ModelTableauVille(this.ctrl);
        this.tableVille = new JTable(this.modelVille);

        this.modelRoute = new ModelTableauRoute(ctrl);
        this.tableRoute = new JTable(modelRoute);

        this.tableVille.setPreferredScrollableViewportSize(new Dimension(700,85));
        this.tableVille.setFillsViewportHeight(true);

        this.tableRoute.setPreferredScrollableViewportSize(new Dimension(700,85));
        this.tableRoute.setFillsViewportHeight(true);

        this.jScrollPaneVille = new JScrollPane(this.tableVille);
        this.add(this.jScrollPaneVille);

        this.jScrollPaneRoute = new JScrollPane(this.tableRoute);
        this.add(this.jScrollPaneRoute);
    }

    public void majTabInfo()
    {
        this.tableVille.setModel(new ModelTableauVille(this.ctrl));
        this.tableRoute.setModel(new ModelTableauRoute(this.ctrl));
    }
}