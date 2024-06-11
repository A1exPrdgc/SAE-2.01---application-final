package Etape2.ihm.panels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Etape2.Controleur;
import Etape2.metier.Routes;


public class ModelTableauRoute extends AbstractTableModel
{
    private String[] colNames;
    private String[][]   data;
    private Controleur   ctrl;

    public ModelTableauRoute(Controleur ctrl)
    {
        this.ctrl = ctrl;

        this.data     = initTabInfoRoute(ctrl);
        this.colNames = new String[]{"id Route", "nom Route", "Route X", "Route Y"};
    }

    @Override
    public String getColumnName(int column) {
        return this.colNames[column];
    }

    public int getRowCount() {
        return data.length;
    }

    public int getColumnCount() {
        return data[0].length;
    }


    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }    

    public void setValueAt(Object value, int row, int col)
    {
        data[row][col] = (String) value;
    }

    private static String[][] initTabInfoRoute(Controleur ctrl)
    {
        String[][] s = new String[6 + ctrl.getRoutes().size()][3];
        List<Routes> lst = ctrl.getRoutes();

        for (int i = 0; i < lst.size(); i++)
        {
            s[i][0] = "" + lst.get(i).getVilleDep().getNomVille();    
            s[i][1] = "" + lst.get(i).getVilleArriv().getNomVille();
            s[i][2] = "" + lst.get(i).getNbTroncon();
        }
        return s;
    }
}
