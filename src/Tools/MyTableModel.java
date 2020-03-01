/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Michail Sitmalidis
 */
public class MyTableModel extends DefaultTableModel {

    HashMap<Integer, Boolean> editableCellsMap = new HashMap();

//overrideing for all the columns except the column with CHECKBOXES to be uneditable, and all the rows that are not 'ready' also uneditable 
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 18) {
            return editableCellsMap.get(rowIndex);
        } else {
            return false;
        }
    }

    public void addRow(Object[] rowData, boolean status) {
        addRow(convertToVector(rowData));
        editableCellsMap.put(getRowCount() - 1, status);
    }

    @Override
    public Class getColumnClass(int column) {
        return getValueAt(0, column).getClass();
    }

}
