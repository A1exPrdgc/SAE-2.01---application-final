package Etape2.ihm.panels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Etape2.Controleur;
import Etape2.metier.Villes;

public class ModelTableauVille extends AbstractTableModel
{
    private String[] colNames;
    private String[][]   data;
    private Controleur   ctrl;

    public ModelTableauVille(Controleur ctrl)
    {
        this.ctrl = ctrl;

        this.data     = initTabInfoVille(ctrl);
        this.colNames = new String[]{"id Ville", "nom Villes", "Ville X", "Ville Y"};
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

    private static String[][] initTabInfoVille(Controleur ctrl)
    {
        String[][] s = new String[6 + ctrl.getVilles().size()][4];
        List<Villes> lst = ctrl.getVilles();

        for (int i = 0; i < lst.size(); i++)
        {
            s[i][0] = "" + lst.get(i).getNumVille();    
            s[i][1] = "" + lst.get(i).getNomVille();
            s[i][2] = "" + lst.get(i).getX();
            s[i][3] = "" + lst.get(i).getY();
            System.out.println(s[i][0] + ", " + s[i][1] + ", " + s[i][2] + ", " + s[i][3]);
        }
        return s;
    }
}
