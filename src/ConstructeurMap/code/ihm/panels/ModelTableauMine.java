package code.ihm.panels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import code.Controleur;
import code.metier.Mine;

public class ModelTableauMine extends AbstractTableModel
{
    private String[] colNames;
    private String[][]   data;
    private Controleur   ctrl;

    public ModelTableauMine(Controleur ctrl)
    {
        this.ctrl = ctrl;

        this.data     = initTabInfoMine(ctrl);
        this.colNames = new String[]{"val Mine", "Region", "Mine X", "Mine Y"};
    }

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

    private static String[][] initTabInfoMine(Controleur ctrl)
    {
        String[][] s = new String[6 + ctrl.getMines().size()][4];
        List<Mine> lst = ctrl.getMines();

        for (int i = 0; i < lst.size(); i++)
        {
            s[i][0] = "" + lst.get(i).getNumMine();    
            s[i][1] = "" + lst.get(i).getRegion();
            s[i][2] = "" + lst.get(i).getX();
            s[i][3] = "" + lst.get(i).getY();
            System.out.println(s[i][0] + ", " + s[i][1] + ", " + s[i][2] + ", " + s[i][3]);
        }
        return s;
    }
}
