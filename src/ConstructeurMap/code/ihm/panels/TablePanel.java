package code.ihm.panels;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import code.Controleur;


public class TablePanel extends JPanel
{
    private JTable tableMine;
    private JScrollPane jScrollPaneVille;

    private JTable tableRoute;
    private JScrollPane jScrollPaneRoute;

    private Controleur ctrl; 
    private ModelTableauMine modelMine;
    private ModelTableauRoute modelRoute;

    public TablePanel(Controleur ctrl) 
    {
        this.ctrl = ctrl;

        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        this.modelMine = new ModelTableauMine(this.ctrl);
        this.tableMine = new JTable(this.modelMine);

        this.modelRoute = new ModelTableauRoute(ctrl);
        this.tableRoute = new JTable(modelRoute);

        this.tableMine.setPreferredScrollableViewportSize(new Dimension(700,85));
        this.tableMine.setFillsViewportHeight(true);

        this.tableRoute.setPreferredScrollableViewportSize(new Dimension(700,85));
        this.tableRoute.setFillsViewportHeight(true);

        this.jScrollPaneVille = new JScrollPane(this.tableMine);
        this.add(this.jScrollPaneVille);

        this.jScrollPaneRoute = new JScrollPane(this.tableRoute);
        this.add(this.jScrollPaneRoute);

        this.setOpaque(false);
    }

    public void majTabInfo()
    {
        this.tableMine.setModel(new ModelTableauMine(this.ctrl));
        this.tableRoute.setModel(new ModelTableauRoute(this.ctrl));
    }
}