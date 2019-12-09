/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Models.Item;
import Models.Report;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Michail Sitmalidis
 */
public class NewJPanel extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public NewJPanel(Report report) {
        initComponents();
        fillReport(report);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name_surname = new javax.swing.JTextField();
        district_street_num = new javax.swing.JTextField();
        name_on_bell = new javax.swing.JTextField();
        postal_code = new javax.swing.JTextField();
        floor = new javax.swing.JTextField();
        mobile_phone = new javax.swing.JTextField();
        landline_phone = new javax.swing.JTextField();
        report_id = new javax.swing.JTextField();
        total_sum = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 5));

        name_surname.setEditable(false);
        name_surname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        name_surname.setText("Name");

        district_street_num.setEditable(false);
        district_street_num.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        district_street_num.setText("District, Street, Numb");

        name_on_bell.setEditable(false);
        name_on_bell.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        name_on_bell.setText("NameOnBell");

        postal_code.setEditable(false);
        postal_code.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        postal_code.setText("PostalCode");

        floor.setEditable(false);
        floor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        floor.setText("Floor");

        mobile_phone.setEditable(false);
        mobile_phone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mobile_phone.setText("MobilePhone");

        landline_phone.setEditable(false);
        landline_phone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        landline_phone.setText("LandlinePhone");

        report_id.setEditable(false);
        report_id.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        report_id.setText("reportId");

        total_sum.setEditable(false);
        total_sum.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        total_sum.setText("TotalSum");

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ΠΕΡΙΓΡΑΦΗ", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setRowHeight(23);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("CancelReport");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(floor, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(name_on_bell, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(127, 127, 127)
                                .addComponent(total_sum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(report_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(district_street_num, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(postal_code, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(name_surname, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(landline_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mobile_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 309, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(landline_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mobile_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(district_street_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(postal_code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(report_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(total_sum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(floor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(name_on_bell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField district_street_num;
    private javax.swing.JTextField floor;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField landline_phone;
    private javax.swing.JTextField mobile_phone;
    private javax.swing.JTextField name_on_bell;
    private javax.swing.JTextField name_surname;
    private javax.swing.JTextField postal_code;
    private javax.swing.JTextField report_id;
    private javax.swing.JTextField total_sum;
    // End of variables declaration//GEN-END:variables

    private void fillReport(Report report) {
        name_surname.setText(report.getCustomer().getLastName() + " " + report.getCustomer().getFirstName());
        district_street_num.setText(report.getCustomer().getDistrict() + ", " + report.getCustomer().getStreet());
        postal_code.setText(report.getCustomer().getPostalCode());
        floor.setText(report.getCustomer().getFloor());
        name_on_bell.setText(report.getCustomer().getBellName());
        landline_phone.setText(report.getCustomer().getLandlinePhone());
        mobile_phone.setText(report.getCustomer().getMobilePhone());

        DefaultTableModel model = new DefaultTableModel();
        for (Item item : report.getItems()) {
             Object[] column = new Object[8];
            column[0]="Description";
            column[1]="ΚΩΔΙΚΟΣ";
            column[2]="ΧΡΩΝΙΑ";
            column[3]="ΜΗΚΟΣ";
            column[4]="ΠΛΑΤΟΣ";
            column[5]="";
            column[6]="";
            column[7]="";
          
            model.setColumnIdentifiers(column);
            
            String[] row = new String[8];
            row[0] = item.getDescription();
            row[1] = String.valueOf(item.getCode());
            row[2] = String.valueOf(item.getYear());
            row[3] = String.valueOf(item.getLength());
            row[4] = String.valueOf(item.getWidth());
            row[5] = String.valueOf(item.getCleaningCharge());
            row[6] = String.valueOf(item.getStoringCharge());
            row[7] = String.valueOf(item.getMendingCharge());
            model.addRow(row);
        }
       
        jTable1.setModel(model);
    }
}