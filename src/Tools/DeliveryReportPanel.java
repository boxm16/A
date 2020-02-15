/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Controllers.ReportController;
import GUI.DayRoutsFrame;
import Models.Item;
import Models.Report;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Michail Sitmalidis
 */
public class DeliveryReportPanel extends javax.swing.JPanel {

    ReportController reportController;
    DayRoutsFrame frame;

    public DeliveryReportPanel(DayRoutsFrame frame, Report report) {
        this.frame = frame;
        initComponents();
        init();
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

        jPanel1 = new javax.swing.JPanel();
        floor = new javax.swing.JTextField();
        name_on_bell = new javax.swing.JTextField();
        report_id = new javax.swing.JTextField();
        postal_code = new javax.swing.JTextField();
        district_street_num = new javax.swing.JTextField();
        name_surname = new javax.swing.JTextField();
        landline_phone = new javax.swing.JTextField();
        mobile_phone = new javax.swing.JTextField();
        deliveryReceiptPanel = new javax.swing.JPanel();
        deliveryReceiptNumber = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        totalSum = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        floor.setEditable(false);
        floor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        floor.setText("Floor");

        name_on_bell.setEditable(false);
        name_on_bell.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        name_on_bell.setText("NameOnBell");

        report_id.setEditable(false);
        report_id.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        report_id.setText("reportId");

        postal_code.setEditable(false);
        postal_code.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        postal_code.setText("PostalCode");

        district_street_num.setEditable(false);
        district_street_num.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        district_street_num.setText("District, Street, Numb");

        name_surname.setEditable(false);
        name_surname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        name_surname.setText("Name");
        name_surname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_surnameActionPerformed(evt);
            }
        });

        landline_phone.setEditable(false);
        landline_phone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        landline_phone.setText("LandlinePhone");

        mobile_phone.setEditable(false);
        mobile_phone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mobile_phone.setText("MobilePhone");

        deliveryReceiptNumber.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        deliveryReceiptNumber.setText("DeliveryReceipNumber");

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Delivered");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("ΑΚΥΡΩΣΗ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        totalSum.setEditable(false);
        totalSum.setBackground(new java.awt.Color(51, 255, 51));
        totalSum.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        totalSum.setText("TotalSum");

        javax.swing.GroupLayout deliveryReceiptPanelLayout = new javax.swing.GroupLayout(deliveryReceiptPanel);
        deliveryReceiptPanel.setLayout(deliveryReceiptPanelLayout);
        deliveryReceiptPanelLayout.setHorizontalGroup(
            deliveryReceiptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deliveryReceiptPanelLayout.createSequentialGroup()
                .addComponent(deliveryReceiptNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2))
            .addGroup(deliveryReceiptPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totalSum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1))
        );
        deliveryReceiptPanelLayout.setVerticalGroup(
            deliveryReceiptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deliveryReceiptPanelLayout.createSequentialGroup()
                .addGroup(deliveryReceiptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalSum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(deliveryReceiptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deliveryReceiptNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4))
        );

        jLabel1.setText("REPORT ID");

        jLabel2.setText("ΟΝΟΜΑΤΕΠΩΝΥΜΟ");

        jLabel3.setText("ΔΙΕΥΘΥΝΣΗ");

        jLabel4.setText("Τ:Κ");

        jLabel5.setText("ΟΡΟΦΟΣ");

        jLabel6.setText("ΟΝΟΜΑ ΣΤΟ ΚΟΥΔΟΥΝΙ");

        date.setEditable(false);
        date.setBackground(new java.awt.Color(255, 255, 51));
        date.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel7.setText("Σ.Τ.");

        jLabel8.setText("Κ.Τ.");

        jLabel9.setText("ΗΜ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(name_surname, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(landline_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8))
                            .addComponent(district_street_num)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(floor, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(name_on_bell, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(report_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 18, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(postal_code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(mobile_phone, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deliveryReceiptPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(name_surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(landline_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mobile_phone)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(district_street_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(postal_code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(name_on_bell)
                                .addComponent(jLabel1)
                                .addComponent(report_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(floor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(3, 3, 3))
                            .addComponent(date)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(221, 221, 221))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(deliveryReceiptPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(601, 601, 601))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void init() {
        reportController = new ReportController();

    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "ΕΙΣΑΙ ΣΙΓΟΥΡΟΣ ΟΤΙ ΘΕΛΕΙΣ ΑΚΥΡΩΣΕΙΣ DELIVERY REPORT???", "ΠΡΟΣΟΧΗ", dialogButton);
        if (dialogResult == 0) {
            reportController.cancelReport(report_id.getText());
            frame.loadReports();
        } else {
            //DO NOTHING
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void name_surnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_surnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_surnameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        reportController.deliverReport(report_id.getText(), deliveryReceiptNumber.getText());
        frame.loadReports();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField date;
    private javax.swing.JTextField deliveryReceiptNumber;
    private javax.swing.JPanel deliveryReceiptPanel;
    private javax.swing.JTextField district_street_num;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JTextField floor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField landline_phone;
    private javax.swing.JTextField mobile_phone;
    private javax.swing.JTextField name_on_bell;
    private javax.swing.JTextField name_surname;
    private javax.swing.JTextField postal_code;
    private javax.swing.JTextField report_id;
    private javax.swing.JTextField totalSum;
    // End of variables declaration//GEN-END:variables

    private void fillReport(Report report) {
        BigDecimal totalCharge = new BigDecimal(0);
        name_surname.setText(report.getCustomer().getLastName() + " " + report.getCustomer().getFirstName());
        district_street_num.setText(report.getCustomer().getDistrict() + ", " + report.getCustomer().getStreet());
        postal_code.setText(report.getCustomer().getPostalCode());
        floor.setText(report.getCustomer().getFloor());
        name_on_bell.setText(report.getCustomer().getDoorbellName());
        landline_phone.setText(report.getCustomer().getLandlinePhone());
        mobile_phone.setText(report.getCustomer().getMobilePhone());
        report_id.setText(String.valueOf(report.getId()));

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = dateFormat.format(report.getDate());
        date.setText(strDate);

        DefaultTableModel model = new DefaultTableModel();
        Object[] column = new Object[11];
        column[0] = "Description";
        column[1] = "ΘΕΣΗ";
        column[2] = "ΚΩΔΙΚΟΣ";
        column[3] = "ΧΡΩΝΙΑ";
        column[4] = "ΜΗΚΟΣ";
        column[5] = "ΠΛΑΤΟΣ";
        column[6] = "ΤΕΤΡΑΓΩΝΙΚΑ";
        column[7] = "ΚΑΘΑΡΙΣΜΑ";
        column[8] = "ΦΥΛΑΞΗ";
        column[9] = "ΕΠΙΔΙΟΡΘΩΣΗ";
        column[10] = "ΣΥΝΟΛΟ";
        model.setColumnIdentifiers(column);

        for (Item item : report.getItems()) {

            Object[] row = new Object[11];
            row[0] = item.getDescription();
            row[1] = item.getSpot();
            row[2] = String.valueOf(item.getCode());
            row[3] = String.valueOf(item.getYear());

            BigDecimal length, width, square;
            row[4] = length = item.getLength();
            row[5] = width = item.getWidth();
            row[6] = square = length.multiply(width).setScale(2, RoundingMode.HALF_EVEN);

            BigDecimal cleaningCharge, storingCharge, mendingCharge, itemCharge;
            if (item.isForCleaning()) {
                row[7] = cleaningCharge = item.getCleaningPrice().multiply(square).setScale(2, RoundingMode.HALF_EVEN);;
            } else {
                row[7] = cleaningCharge = new BigDecimal(0);
            }

            if (item.isForStoring()) {
                row[8] = storingCharge = item.getStoringPrice().multiply(square).setScale(2, RoundingMode.HALF_EVEN);
            } else {
                row[8] = storingCharge = new BigDecimal(0);
            }

            if (item.getMendingCharge() != null) {
                row[9] = mendingCharge = item.getMendingCharge().setScale(2, RoundingMode.HALF_EVEN);
            } else {
                row[9] = mendingCharge = new BigDecimal(0);
            }

            itemCharge = storingCharge.add(cleaningCharge).add(mendingCharge);
            row[10] = itemCharge;
            totalCharge = totalCharge.add(itemCharge);
            model.addRow(row);
        }

        JTable table = new JTable();
        table.setModel(model);

        totalSum.setText(totalCharge.toString());

        jPanel2.setLayout(new BorderLayout());
        jPanel2.add(table.getTableHeader(), BorderLayout.NORTH);
        jPanel2.add(table, BorderLayout.CENTER);

    }

    public void hideDeliveryReceiptPanel() {
        deliveryReceiptPanel.hide();
    }

}