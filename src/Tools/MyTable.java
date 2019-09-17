/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Michail Sitmalidis
 */
public class MyTable extends JTable {

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component c = super.prepareRenderer(renderer, row, column);

        //  Color row based on a cell value
        if (!isRowSelected(row)) {
            c.setBackground(getBackground());
            int modelRow = convertRowIndexToModel(row);
            String status = (String) getModel().getValueAt(modelRow, 16);
            boolean ready = (boolean) getModel().getValueAt(modelRow, 17);

            if (!"ready".equals(status)) {
                //model.setValueAt(false, modelRow, 17);
                c.setBackground(Color.RED);
            }

            if (ready) {
                c.setBackground(Color.GREEN);
            }

        }

        if (isRowSelected(row)) {
            //   c.setBackground(getBackground());
            int modelRow = convertRowIndexToModel(row);
            String status = (String) getModel().getValueAt(modelRow, 16);
            if (!"ready".equals(status)) {
                // model.setValueAt(false, modelRow, 17);
                c.setBackground(Color.PINK);

            }

        }

        return c;
    }

}
