/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controllers.CustomerController;
import Controllers.ItemController;
import Controllers.AddressController;
import Controllers.ReportController;
import Controllers.RouteController;
import Dao.ConnectionsDispatcher;
import Models.Customer;
import Models.Item;
import Models.Report;
import Models.Route;
import Tools.MyTableModel;
import Tools.ScheduledPickUpPanel;
import Tools.Scheduler;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.EventListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Set;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Michail Sitmalidis
 */
public class MainFrame extends javax.swing.JFrame {

    private HashMap<String, ArrayList> districtsList;//String-for district name, Array-for postal_codes
    //ArrayList-for postalcodes of this district
    private Scheduler scheduler;

    private CustomerController customerController;
    private ItemController itemController;
    private ReportController reportController;
    private AddressController addressController;
    private RouteController routeController;

    private JTableHeader pickUpItemsTableHeader;
    private DefaultTableModel pickUpItemsTableModel;
    private JTextField pickUpDatePickerTextField;
    private Color focusInColor;
    private Color focusOutColor;

    private ItemListener districtFieldItemSelectionListener;
    private ItemListener postalCodeFieldItemSelectionListener;

    private DefaultComboBoxModel availableRoutsModel;
    private DefaultComboBoxModel availableRoutsModel_pickUp;
    private MyTableModel cardTableModel;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();

        scheduler = new Scheduler(this);
        scheduler.startEmailCheckerScheduler();
        myInitialization();

        /*  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height-35);
         */
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        RootPanel = new javax.swing.JPanel();
        customerCardsTabbedPane = new javax.swing.JTabbedPane();
        customerCardTab = new javax.swing.JPanel();
        customerCardPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        calculationDisplayPanel = new javax.swing.JPanel();
        processButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        availableRoutsList = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        totalSum = new javax.swing.JLabel();
        subTotalSum = new javax.swing.JLabel();
        fpaLabel = new javax.swing.JLabel();
        fpaSum = new javax.swing.JLabel();
        subTotalLabel = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        totalSum1 = new javax.swing.JLabel();
        subTotalSum1 = new javax.swing.JLabel();
        fpaLabel1 = new javax.swing.JLabel();
        fpaSum1 = new javax.swing.JLabel();
        subTotalLabel1 = new javax.swing.JLabel();
        totalLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        pickUpPanel = new javax.swing.JPanel();
        newPickUpOrdredPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        availableRoutsList_pickUp = new javax.swing.JComboBox<>();
        savePickUpOrderButton = new javax.swing.JButton();
        pickUpButtonLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        scheduledPickUpPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        newPickUp = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pickUpReportNumberField = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        addItemButton = new javax.swing.JButton();
        savePickUpReportButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        schedulePickUpDisplayPanel = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        scheduledPickUpLabel = new javax.swing.JLabel();
        scheduledPickUpIdLabel = new javax.swing.JLabel();
        nonScheduledPickUpPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pickUpDatePicker = new com.toedter.calendar.JDateChooser();
        jButton3 = new javax.swing.JButton();
        pickUpItemsPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pickUpItemsTable = new javax.swing.JTable();
        customerArchiveTab = new javax.swing.JPanel();
        HeadPanel = new javax.swing.JPanel();
        CombinedPanel = new javax.swing.JPanel();
        lastlNameLabel = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        firstNameLabel = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        landLineLabel = new javax.swing.JLabel();
        mobileLabel = new javax.swing.JLabel();
        landLineField = new javax.swing.JFormattedTextField();
        mobileField = new javax.swing.JFormattedTextField();
        buttonsPanel = new javax.swing.JPanel();
        newCustomerEditCustomerPanel = new javax.swing.JPanel();
        newCustomerButton = new javax.swing.JButton();
        editCustomerButton = new javax.swing.JButton();
        saveCancelPanel = new javax.swing.JPanel();
        saveNewCustomerButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        customerIdField = new javax.swing.JTextField();
        findButton = new javax.swing.JButton();
        addressPanel = new javax.swing.JPanel();
        alternativeAddressLabel3 = new javax.swing.JLabel();
        districtLabel = new javax.swing.JLabel();
        alternativeStreetLabel3 = new javax.swing.JLabel();
        districtPanel = new javax.swing.JPanel();
        dontChangePanel = new javax.swing.JPanel();
        districtField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        postalCodeField = new javax.swing.JTextField();
        changePanel = new javax.swing.JPanel();
        changeDistrictField = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        changePostalCodeField = new javax.swing.JComboBox<>();
        addressChangeButtonsPanel = new javax.swing.JPanel();
        changeButton = new javax.swing.JButton();
        dontChangeButton = new javax.swing.JButton();
        streetField = new javax.swing.JTextField();
        alternativeFloorLabel3 = new javax.swing.JLabel();
        alternativeBellNameLabel1 = new javax.swing.JLabel();
        doorbellNameField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        noteField = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        floorField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        emailStatusField = new javax.swing.JTextField();
        menuPanel = new javax.swing.JPanel();
        measurementButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        connectionButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        RootPanel.setPreferredSize(new java.awt.Dimension(1280, 1024));

        customerCardsTabbedPane.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        customerCardPanel.setBackground(new java.awt.Color(0, 255, 0));
        customerCardPanel.setMaximumSize(new java.awt.Dimension(600, 600));
        customerCardPanel.setPreferredSize(new java.awt.Dimension(1000, 191));

        javax.swing.GroupLayout customerCardPanelLayout = new javax.swing.GroupLayout(customerCardPanel);
        customerCardPanel.setLayout(customerCardPanelLayout);
        customerCardPanelLayout.setHorizontalGroup(
            customerCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        customerCardPanelLayout.setVerticalGroup(
            customerCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 353, Short.MAX_VALUE)
        );

        jPanel3.setLayout(new java.awt.CardLayout());

        processButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        processButton.setText("PROCESS");
        processButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processButtonActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("ΔΙΑΛΕΞΕ ΔΡΟΜΟΛΟΓΙΟ");

        availableRoutsList.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(availableRoutsList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(availableRoutsList)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        totalSum.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        totalSum.setText("0.0");

        subTotalSum.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        subTotalSum.setText("0.0");

        fpaLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        fpaLabel.setText("ΦΠΑ:");

        fpaSum.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        fpaSum.setText("0.0");

        subTotalLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        subTotalLabel.setText("ΜΕΡΙΚΟ ΣΥΝΟΛΟ:");

        totalLabel.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        totalLabel.setText("ΤΕΛΙΚΟ ΣΥΝΟΛΟ:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(subTotalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(subTotalSum, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(fpaLabel)
                .addGap(18, 18, 18)
                .addComponent(fpaSum, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(totalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalSum, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(totalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
            .addComponent(totalSum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(subTotalLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(subTotalSum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(fpaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(fpaSum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout calculationDisplayPanelLayout = new javax.swing.GroupLayout(calculationDisplayPanel);
        calculationDisplayPanel.setLayout(calculationDisplayPanelLayout);
        calculationDisplayPanelLayout.setHorizontalGroup(
            calculationDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calculationDisplayPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(calculationDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addComponent(processButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        calculationDisplayPanelLayout.setVerticalGroup(
            calculationDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calculationDisplayPanelLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(processButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.add(calculationDisplayPanel, "card2");

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        totalSum1.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        totalSum1.setText("0.0");

        subTotalSum1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        subTotalSum1.setText("0.0");

        fpaLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        fpaLabel1.setText("ΦΠΑ:");

        fpaSum1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        fpaSum1.setText("0.0");

        subTotalLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        subTotalLabel1.setText("ΜΕΡΙΚΟ ΣΥΝΟΛΟ:");

        totalLabel1.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        totalLabel1.setText("ΤΕΛΙΚΟ ΣΥΝΟΛΟ:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(subTotalLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(subTotalSum1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(fpaLabel1)
                .addGap(18, 18, 18)
                .addComponent(fpaSum1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(totalLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalSum1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(subTotalLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(totalSum1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(totalLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(fpaSum1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fpaLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(subTotalSum1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel11.setText("jLabel11");

        jLabel12.setText("ΕΠΙΤΡΕΠΕΤΑΙ ΜΟΝΟ ΕΝΑ ΡΑΝΤΕΒΟΥ, ΓΙΑ ΝΑ ΚΛΕΙΣΕΙΣ ΑΛΛΟ ΡΑΝΤΕΒΟΥ, ΠΡΕΠΕΙ ΝΑ ΑΚΥΡΩΣΕΙΣ ΗΔΗ ΥΠΑΡΧΟΝ ΡΑΝΤΕΒΟΥ");

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton7.setText("<html><center>ΑΚΥΡΩΣΕ ΤΗΝ<br>ΠΑΡΑΓΓΕΛΙΑ</center></html>");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 1006, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 224, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jButton7)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 67, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel7, "card3");

        javax.swing.GroupLayout customerCardTabLayout = new javax.swing.GroupLayout(customerCardTab);
        customerCardTab.setLayout(customerCardTabLayout);
        customerCardTabLayout.setHorizontalGroup(
            customerCardTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerCardTabLayout.createSequentialGroup()
                .addGroup(customerCardTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerCardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1231, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        customerCardTabLayout.setVerticalGroup(
            customerCardTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerCardTabLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customerCardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE))
        );

        customerCardsTabbedPane.addTab("ΚΑΡΤΕΛΑ", customerCardTab);

        newPickUpOrdredPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("ΚΑΝΟΝΙΣΕ  ΕΠΙΣΚΕΨΗ ΓΙΑ PICK-UP");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("ΔΙΑΛΕΞΕ ΔΡΟΜΟΛΟΓΙΟ");

        availableRoutsList_pickUp.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N

        savePickUpOrderButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        savePickUpOrderButton.setText("ΑΠΟΘΗΚΕΥΣΗ");
        savePickUpOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePickUpOrderButtonActionPerformed(evt);
            }
        });

        pickUpButtonLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pickUpButtonLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pickUpButtonLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout newPickUpOrdredPanelLayout = new javax.swing.GroupLayout(newPickUpOrdredPanel);
        newPickUpOrdredPanel.setLayout(newPickUpOrdredPanelLayout);
        newPickUpOrdredPanelLayout.setHorizontalGroup(
            newPickUpOrdredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newPickUpOrdredPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newPickUpOrdredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pickUpButtonLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, newPickUpOrdredPanelLayout.createSequentialGroup()
                        .addGroup(newPickUpOrdredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, newPickUpOrdredPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(availableRoutsList_pickUp, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(newPickUpOrdredPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(savePickUpOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4))
        );
        newPickUpOrdredPanelLayout.setVerticalGroup(
            newPickUpOrdredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newPickUpOrdredPanelLayout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newPickUpOrdredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(savePickUpOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(newPickUpOrdredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(availableRoutsList_pickUp, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pickUpButtonLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addGap(58, 58, 58))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        scheduledPickUpPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scheduledPickUpPanel.setMaximumSize(new java.awt.Dimension(850, 280));
        scheduledPickUpPanel.setPreferredSize(new java.awt.Dimension(850, 280));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("ΠΡΟΓΡΑΜΜΑΤΙΣΜΕΗ ΕΠΙΣΚΕΨΗ");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(scheduledPickUpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scheduledPickUpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pickUpPanelLayout = new javax.swing.GroupLayout(pickUpPanel);
        pickUpPanel.setLayout(pickUpPanelLayout);
        pickUpPanelLayout.setHorizontalGroup(
            pickUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pickUpPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pickUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newPickUpOrdredPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pickUpPanelLayout.setVerticalGroup(
            pickUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pickUpPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(newPickUpOrdredPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        customerCardsTabbedPane.addTab("ΚΑΝΟΝΙΣΕ PICK-UP", pickUpPanel);

        try {
            pickUpReportNumberField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        pickUpReportNumberField.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        pickUpReportNumberField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pickUpReportNumberFieldKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("ΑΡΙΘΜΟΣ ΔΕΛΤΙΟΥ");

        addItemButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        addItemButton.setText("ΠΡΟΣΘΕΣΗ ΤΕΜΑΧΙΟΥ");
        addItemButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                addItemButtonItemStateChanged(evt);
            }
        });
        addItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemButtonActionPerformed(evt);
            }
        });
        addItemButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addItemButtonKeyPressed(evt);
            }
        });

        savePickUpReportButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        savePickUpReportButton.setText("ΑΠΟΘΗΚΕΥΣΗ ΔΕΛΤΙΟΥ");
        savePickUpReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePickUpReportButtonActionPerformed(evt);
            }
        });

        jPanel4.setLayout(new java.awt.CardLayout());

        jButton4.setText("<html><center>ΠΑΤΗΣΕ ΓΙΑ<br> ΑΠΥΘΕΙΑΣ ΠΑΡΑΛΑΒΗ</center></html>");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        scheduledPickUpLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        scheduledPickUpIdLabel.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        scheduledPickUpIdLabel.setForeground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout schedulePickUpDisplayPanelLayout = new javax.swing.GroupLayout(schedulePickUpDisplayPanel);
        schedulePickUpDisplayPanel.setLayout(schedulePickUpDisplayPanelLayout);
        schedulePickUpDisplayPanelLayout.setHorizontalGroup(
            schedulePickUpDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(schedulePickUpDisplayPanelLayout.createSequentialGroup()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scheduledPickUpIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scheduledPickUpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        schedulePickUpDisplayPanelLayout.setVerticalGroup(
            schedulePickUpDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(schedulePickUpDisplayPanelLayout.createSequentialGroup()
                .addGroup(schedulePickUpDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(scheduledPickUpLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(scheduledPickUpIdLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.add(schedulePickUpDisplayPanel, "card2");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("ΗΜΕΡΟΜΗΝΙΑ");

        pickUpDatePicker.setDateFormatString("dd/MM/yyyy");
        pickUpDatePicker.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jButton3.setText("<html><center>ΠΑΤΗΣΕ ΓΙΑ <br>PICK-UP ΠΑΡΑΛΑΒΗ</center></html>");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout nonScheduledPickUpPanelLayout = new javax.swing.GroupLayout(nonScheduledPickUpPanel);
        nonScheduledPickUpPanel.setLayout(nonScheduledPickUpPanelLayout);
        nonScheduledPickUpPanelLayout.setHorizontalGroup(
            nonScheduledPickUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nonScheduledPickUpPanelLayout.createSequentialGroup()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pickUpDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        nonScheduledPickUpPanelLayout.setVerticalGroup(
            nonScheduledPickUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pickUpDatePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(nonScheduledPickUpPanelLayout.createSequentialGroup()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel4.add(nonScheduledPickUpPanel, "card1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pickUpReportNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addItemButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(savePickUpReportButton)
                .addGap(56, 56, 56))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(5, 5, 5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(savePickUpReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pickUpReportNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pickUpItemsPanel.setBackground(new java.awt.Color(153, 153, 255));
        pickUpItemsPanel.setLayout(new javax.swing.BoxLayout(pickUpItemsPanel, javax.swing.BoxLayout.LINE_AXIS));

        pickUpItemsTable.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        pickUpItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ΠΕΡΙΓΡΑΦΗ ΠΡΟΙΟΝΤΟΣ", "ΚΩΔΙΚΟΣ ΤΕΜΑΧΙΟΥ", "ΚΑΘΑΡΙΣΜΑ", "ΦΥΛΑΞΗ", "ΕΠΙΔΙΟΡΘΩΣΗ", "ΣΗΜΕΙΩΜΑ"
            }
        ));
        pickUpItemsTable.setColumnSelectionAllowed(true);
        pickUpItemsTable.setEnabled(false);
        pickUpItemsTable.setRowHeight(36);
        jScrollPane2.setViewportView(pickUpItemsTable);
        pickUpItemsTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (pickUpItemsTable.getColumnModel().getColumnCount() > 0) {
            pickUpItemsTable.getColumnModel().getColumn(0).setPreferredWidth(60);
            pickUpItemsTable.getColumnModel().getColumn(0).setMaxWidth(70);
            pickUpItemsTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            pickUpItemsTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            pickUpItemsTable.getColumnModel().getColumn(2).setMaxWidth(200);
            pickUpItemsTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            pickUpItemsTable.getColumnModel().getColumn(3).setMaxWidth(200);
            pickUpItemsTable.getColumnModel().getColumn(4).setPreferredWidth(100);
            pickUpItemsTable.getColumnModel().getColumn(4).setMaxWidth(200);
            pickUpItemsTable.getColumnModel().getColumn(5).setPreferredWidth(100);
            pickUpItemsTable.getColumnModel().getColumn(5).setMaxWidth(200);
        }

        pickUpItemsPanel.add(jScrollPane2);

        javax.swing.GroupLayout newPickUpLayout = new javax.swing.GroupLayout(newPickUp);
        newPickUp.setLayout(newPickUpLayout);
        newPickUpLayout.setHorizontalGroup(
            newPickUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pickUpItemsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1238, Short.MAX_VALUE)
            .addGroup(newPickUpLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1226, Short.MAX_VALUE)
                .addContainerGap())
        );
        newPickUpLayout.setVerticalGroup(
            newPickUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newPickUpLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pickUpItemsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        customerCardsTabbedPane.addTab("ΝΕΑ ΠΑΡΑΛΑΒΗ", newPickUp);

        javax.swing.GroupLayout customerArchiveTabLayout = new javax.swing.GroupLayout(customerArchiveTab);
        customerArchiveTab.setLayout(customerArchiveTabLayout);
        customerArchiveTabLayout.setHorizontalGroup(
            customerArchiveTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1238, Short.MAX_VALUE)
        );
        customerArchiveTabLayout.setVerticalGroup(
            customerArchiveTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 462, Short.MAX_VALUE)
        );

        customerCardsTabbedPane.addTab("ΑΡΧΕΙΟ", customerArchiveTab);

        HeadPanel.setPreferredSize(new java.awt.Dimension(1024, 413));

        CombinedPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lastlNameLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lastlNameLabel.setText("ΕΠΙΘΕΤΟ");

        lastNameField.setEditable(false);
        lastNameField.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lastNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lastNameFieldKeyPressed(evt);
            }
        });

        firstNameLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        firstNameLabel.setText("ΟΝΟΜΑ");

        firstNameField.setEditable(false);
        firstNameField.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        firstNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                firstNameFieldKeyPressed(evt);
            }
        });

        landLineLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        landLineLabel.setText("ΣΤΑΘΕΡΟ ΤΗΛΕΦΩΝΟ");

        mobileLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        mobileLabel.setText("ΚΙΝΗΤΟ ΤΗΛΕΦΩΝΟ");

        landLineField.setEditable(false);
        try {
            landLineField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("21########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        landLineField.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        landLineField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                landLineFieldKeyPressed(evt);
            }
        });

        mobileField.setEditable(false);
        try {
            mobileField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("69########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        mobileField.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        mobileField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mobileFieldKeyPressed(evt);
            }
        });

        buttonsPanel.setLayout(new java.awt.CardLayout());

        newCustomerButton.setBackground(new java.awt.Color(153, 153, 255));
        newCustomerButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        newCustomerButton.setText("<html><center>ΚΑΙΝΟΥΡΓΙΟΣ ΠΕΛΑΤΗΣ</center></html>");
        newCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCustomerButtonActionPerformed(evt);
            }
        });
        newCustomerEditCustomerPanel.add(newCustomerButton);

        editCustomerButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        editCustomerButton.setText("<html><center>ΔΙΟΡΘΩΣΗ ΣΤΟΙΧΙΩΝ</center></html>");
        editCustomerButton.setEnabled(false);
        editCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCustomerButtonActionPerformed(evt);
            }
        });
        newCustomerEditCustomerPanel.add(editCustomerButton);

        buttonsPanel.add(newCustomerEditCustomerPanel, "card1");

        saveNewCustomerButton.setBackground(new java.awt.Color(0, 204, 51));
        saveNewCustomerButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        saveNewCustomerButton.setText("ΑΠΟΘΗΚΕΥΣΗ");
        saveNewCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveNewCustomerButtonActionPerformed(evt);
            }
        });
        saveCancelPanel.add(saveNewCustomerButton);

        cancelButton.setBackground(new java.awt.Color(255, 102, 102));
        cancelButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cancelButton.setText("ΑΚΥΡΩΣΗ");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        saveCancelPanel.add(cancelButton);

        buttonsPanel.add(saveCancelPanel, "card2");

        customerIdField.setEditable(false);
        customerIdField.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        customerIdField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerIdFieldMouseClicked(evt);
            }
        });
        customerIdField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                customerIdFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                customerIdFieldKeyTyped(evt);
            }
        });

        findButton.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        findButton.setText("ΒΡΕΣ ΠΕΛΑΤΗ");
        findButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CombinedPanelLayout = new javax.swing.GroupLayout(CombinedPanel);
        CombinedPanel.setLayout(CombinedPanelLayout);
        CombinedPanelLayout.setHorizontalGroup(
            CombinedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CombinedPanelLayout.createSequentialGroup()
                .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(CombinedPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CombinedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CombinedPanelLayout.createSequentialGroup()
                        .addComponent(lastlNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(CombinedPanelLayout.createSequentialGroup()
                        .addGroup(CombinedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CombinedPanelLayout.createSequentialGroup()
                                .addGroup(CombinedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(landLineLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                    .addComponent(mobileLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(CombinedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mobileField)
                                    .addComponent(landLineField)))
                            .addGroup(CombinedPanelLayout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(lastNameField))
                            .addGroup(CombinedPanelLayout.createSequentialGroup()
                                .addComponent(findButton, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(customerIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(CombinedPanelLayout.createSequentialGroup()
                                .addComponent(firstNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(firstNameField)))
                        .addContainerGap())))
        );

        CombinedPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {firstNameLabel, lastlNameLabel});

        CombinedPanelLayout.setVerticalGroup(
            CombinedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CombinedPanelLayout.createSequentialGroup()
                .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CombinedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(findButton, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(customerIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CombinedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastlNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CombinedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(firstNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CombinedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(landLineLabel)
                    .addComponent(landLineField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(CombinedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mobileField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mobileLabel))
                .addContainerGap())
        );

        CombinedPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {firstNameField, lastNameField});

        CombinedPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {landLineField, mobileField});

        addressPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        alternativeAddressLabel3.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        alternativeAddressLabel3.setText("ΔΙΕΥΘΥΝΣΗ");

        districtLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        districtLabel.setText("ΠΕΡΙΟΧΗ");

        alternativeStreetLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        alternativeStreetLabel3.setText("ΟΔΟΣ");

        districtPanel.setBackground(new java.awt.Color(255, 51, 51));
        districtPanel.setLayout(new java.awt.CardLayout());

        dontChangePanel.setBackground(new java.awt.Color(153, 255, 153));

        districtField.setEditable(false);
        districtField.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Τ.Κ.");

        postalCodeField.setEditable(false);
        postalCodeField.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        javax.swing.GroupLayout dontChangePanelLayout = new javax.swing.GroupLayout(dontChangePanel);
        dontChangePanel.setLayout(dontChangePanelLayout);
        dontChangePanelLayout.setHorizontalGroup(
            dontChangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dontChangePanelLayout.createSequentialGroup()
                .addComponent(districtField, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(postalCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        dontChangePanelLayout.setVerticalGroup(
            dontChangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(districtField, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(postalCodeField)
        );

        districtPanel.add(dontChangePanel, "NO");

        changePanel.setBackground(new java.awt.Color(51, 255, 153));
        changePanel.setVisible(false);

        changeDistrictField.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Τ.Κ");

        changePostalCodeField.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        javax.swing.GroupLayout changePanelLayout = new javax.swing.GroupLayout(changePanel);
        changePanel.setLayout(changePanelLayout);
        changePanelLayout.setHorizontalGroup(
            changePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changePanelLayout.createSequentialGroup()
                .addComponent(changeDistrictField, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(changePostalCodeField, 0, 116, Short.MAX_VALUE)
                .addContainerGap())
        );
        changePanelLayout.setVerticalGroup(
            changePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(changeDistrictField, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
            .addGroup(changePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(changePostalCodeField))
        );

        districtPanel.add(changePanel, "YES");

        addressChangeButtonsPanel.setLayout(new java.awt.CardLayout());
        addressChangeButtonsPanel.setVisible(false);

        changeButton.setBackground(new java.awt.Color(0, 255, 0));
        changeButton.setText("ΘΕΛΩ ΝΑ ΑΛΛΑΞΩ ΠΕΡΙΟΧΗ");
        changeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeButtonActionPerformed(evt);
            }
        });
        addressChangeButtonsPanel.add(changeButton, "YES");

        dontChangeButton.setBackground(new java.awt.Color(255, 102, 102));
        dontChangeButton.setText("ΔΕΝ ΘΕΛΩ ΝΑ ΑΛΛΑΞΩ ΠΕΡΙΟΧΗ");
        dontChangeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dontChangeButtonActionPerformed(evt);
            }
        });
        addressChangeButtonsPanel.add(dontChangeButton, "NO");

        streetField.setEditable(false);
        streetField.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        alternativeFloorLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        alternativeFloorLabel3.setText("ΟΡΟΦΟΣ");

        alternativeBellNameLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        alternativeBellNameLabel1.setText("ΟΝΟΜΑ ΣΤΟ ΚΟΥΔΟΥΝΟΙ");

        doorbellNameField.setEditable(false);
        doorbellNameField.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        noteField.setEditable(false);
        noteField.setColumns(20);
        noteField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        noteField.setLineWrap(true);
        noteField.setRows(5);
        jScrollPane3.setViewportView(noteField);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("E-mail");

        emailField.setEditable(false);
        emailField.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        floorField.setEditable(false);
        floorField.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Email Status");

        emailStatusField.setEditable(false);
        emailStatusField.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        javax.swing.GroupLayout addressPanelLayout = new javax.swing.GroupLayout(addressPanel);
        addressPanel.setLayout(addressPanelLayout);
        addressPanelLayout.setHorizontalGroup(
            addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addressPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addressPanelLayout.createSequentialGroup()
                        .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(districtLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(alternativeStreetLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addressPanelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(districtPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(addressPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(streetField)
                                .addContainerGap())))
                    .addGroup(addressPanelLayout.createSequentialGroup()
                        .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addressPanelLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(alternativeAddressLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addressChangeButtonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addressPanelLayout.createSequentialGroup()
                                .addComponent(alternativeFloorLabel3)
                                .addGap(38, 38, 38)
                                .addComponent(floorField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(alternativeBellNameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(doorbellNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addressPanelLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailStatusField)))
                        .addContainerGap())))
        );
        addressPanelLayout.setVerticalGroup(
            addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addressPanelLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(alternativeAddressLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addressChangeButtonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(districtPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(districtLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(alternativeStreetLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(streetField, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(doorbellNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(alternativeBellNameLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(floorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(alternativeFloorLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailField)
                    .addComponent(emailStatusField)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout HeadPanelLayout = new javax.swing.GroupLayout(HeadPanel);
        HeadPanel.setLayout(HeadPanelLayout);
        HeadPanelLayout.setHorizontalGroup(
            HeadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeadPanelLayout.createSequentialGroup()
                .addComponent(CombinedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addressPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HeadPanelLayout.setVerticalGroup(
            HeadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeadPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(HeadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addressPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CombinedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        measurementButton.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        measurementButton.setText("<html><center>ΔΙΑΣΤΑΣΕΙΣ ΚΑΙ<br>ΕΠΙΔΙΟΡΘΩΣΗ</center></html>");
        measurementButton.setActionCommand("<html><center>ΔΙΑΣΤΑΣΕΙΣ ΚΑΙ<br><ln>ΕΠΙΔΙΟΡΘΩΣΗ</center></html>");
        measurementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                measurementButtonActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jButton1.setText("<html><center>ΕΤΟΙΜΟΠΑΡΑΔΟΤΑ<br>ΑΜΕΣΗ ΕΠΙΣΤΡΟΦΗ</center></html>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jButton5.setText("<html><center>ΠΡΟΓΡΑΜΜΑΤΙΣΜΕΝΕΣ<br>DELIVERIES</center></html>");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton2.setText("ΔΡΟΜΟΛΟΓΙΑ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jButton6.setText("<html><center>ΠΡΟΓΡΑΜΜΑΤΙΣΜΕΝΑ<br>PICK-UPS</center><html>");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        connectionButton.setText("<html><center>ΑΠΟΚΑΤΑΣΤΑΣΗ<br>ΣΥΝΔΕΣΗΣ</center></html>");
        connectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(connectionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(measurementButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(measurementButton)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton5)
                .addComponent(jButton6))
            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(connectionButton, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout RootPanelLayout = new javax.swing.GroupLayout(RootPanel);
        RootPanel.setLayout(RootPanelLayout);
        RootPanelLayout.setHorizontalGroup(
            RootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RootPanelLayout.createSequentialGroup()
                .addGroup(RootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(menuPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customerCardsTabbedPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(HeadPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1243, Short.MAX_VALUE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        RootPanelLayout.setVerticalGroup(
            RootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RootPanelLayout.createSequentialGroup()
                .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HeadPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customerCardsTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );

        jScrollPane1.setViewportView(RootPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1283, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 912, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        DayRoutsFrame dayRoutsFrame = new DayRoutsFrame(this);
        dayRoutsFrame.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        RoutPlanningFrame routPlanningFrame = new RoutPlanningFrame();
        routPlanningFrame.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ReadyOrdersFrame readyOrdersFrame = new ReadyOrdersFrame(this);
        readyOrdersFrame.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void measurementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_measurementButtonActionPerformed
        MeasurementFrame measurementFrame = new MeasurementFrame();
        measurementFrame.setVisible(true);
    }//GEN-LAST:event_measurementButtonActionPerformed

    private void dontChangeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dontChangeButtonActionPerformed
        CardLayout changeButtonCard = (CardLayout) addressChangeButtonsPanel.getLayout();
        changeButtonCard.show(addressChangeButtonsPanel, "YES");

        CardLayout districtCard = (CardLayout) districtPanel.getLayout();
        districtCard.show(districtPanel, "NO");
        changePanel.setVisible(false);
    }//GEN-LAST:event_dontChangeButtonActionPerformed

    private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeButtonActionPerformed

        CardLayout changeButtonCard = (CardLayout) addressChangeButtonsPanel.getLayout();
        changeButtonCard.show(addressChangeButtonsPanel, "NO");

        showChangeDistrictPanel();
    }//GEN-LAST:event_changeButtonActionPerformed

    private void findButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findButtonActionPerformed
        openFindUserFields();
        availableRoutsModel.removeAllElements();
        availableRoutsModel_pickUp.removeAllElements();
    }//GEN-LAST:event_findButtonActionPerformed

    private void customerIdFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customerIdFieldKeyTyped
        //making sure that only + signed integers will be typed
        char c = evt.getKeyChar();
        String input = customerIdField.getText();
        if (!(Character.isDigit(c))
                || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE)
                || (input.length() == 5)) {
            evt.consume();
        }
    }//GEN-LAST:event_customerIdFieldKeyTyped

    private void customerIdFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customerIdFieldKeyPressed

        if (customerIdField.isEditable() && evt.getKeyCode() == 10 && customerIdInputValid()) {
            int id = Integer.parseInt(customerIdField.getText());
            dispalyCustomerById(id);
            fillTables();

        }
    }//GEN-LAST:event_customerIdFieldKeyPressed

    private void customerIdFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerIdFieldMouseClicked
        if (evt.getClickCount() == 2) {
            openFindUserFields();
            availableRoutsModel.removeAllElements();
            availableRoutsModel_pickUp.removeAllElements();
        }
    }//GEN-LAST:event_customerIdFieldMouseClicked

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        saveAndCancelButtonsActions();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void saveNewCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveNewCustomerButtonActionPerformed
        //no need to check if input is valid, it is ,because here id comes from database
        if (customerInputsValid()) {
            Customer customer = collectCustomerInformation();
            if (customerIdField.getText().equals("")) {// checks if customer is new (equals("")

                String identifier = customerController.saveNewCustomer(customer);
                customer = customerController.getCustomerByIdentifier(identifier);
                saveAndCancelButtonsActions();
                displayCustomer(customer);
                fillTables();
                customerCardsTabbedPane.setSelectedIndex(1);
            } else { //or is to be edited

                customer.setId(Integer.parseInt(customerIdField.getText().trim()));//i guess, no need for trim(), but, just in case
                customerController.editCustomer(customer);
                customer = customerController.getCustomerById(customer.getId());
                saveAndCancelButtonsActions();
                displayCustomer(customer);
                fillTables();
            }

        }
    }//GEN-LAST:event_saveNewCustomerButtonActionPerformed

    private void editCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCustomerButtonActionPerformed

        makeSearchFieldsEditable();
        makeFieldsEditable();
        customerIdField.setEditable(false);

        CardLayout card = (CardLayout) buttonsPanel.getLayout();
        card.show(buttonsPanel, "card2");

        addressChangeButtonsPanel.setVisible(true);
        loadDistrictComboBoxes();
    }//GEN-LAST:event_editCustomerButtonActionPerformed

    private void newCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCustomerButtonActionPerformed
        cleanFields();
        makeSearchFieldsEditable();
        makeFieldsEditable();
        customerIdField.setEditable(false);
        loadDistrictComboBoxes();
        // clearTables();

        CardLayout card = (CardLayout) buttonsPanel.getLayout();
        card.show(buttonsPanel, "card2");

        showChangeDistrictPanel();
    }//GEN-LAST:event_newCustomerButtonActionPerformed

    private void mobileFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobileFieldKeyPressed
        if (mobileField.isEditable() && evt.getKeyCode() == 10) {
            String mobile = mobileField.getText().trim();

            ArrayList<Customer> customers = customerController.getCustomerByMobileNumber(mobile);
            SearchFrame searchFrame = new SearchFrame(this, customers);
            searchFrame.setVisible(true);

        }
    }//GEN-LAST:event_mobileFieldKeyPressed

    private void landLineFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_landLineFieldKeyPressed
        if (landLineField.isEditable() && evt.getKeyCode() == 10) {
            String landLine = landLineField.getText().trim();

            ArrayList<Customer> customers = customerController.getCustomerByLandLineNumber(landLine);
            SearchFrame searchFrame = new SearchFrame(this, customers);
            searchFrame.setVisible(true);

        }
    }//GEN-LAST:event_landLineFieldKeyPressed

    private void firstNameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstNameFieldKeyPressed

    }//GEN-LAST:event_firstNameFieldKeyPressed

    private void lastNameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastNameFieldKeyPressed
        if (lastNameField.isEditable() && evt.getKeyCode() == 10) {
            String lastName = lastNameField.getText().trim();

            ArrayList<Customer> customers = customerController.getCustomerByLastName(lastName);
            SearchFrame searchFrame = new SearchFrame(this, customers);
            searchFrame.setVisible(true);

        }
    }//GEN-LAST:event_lastNameFieldKeyPressed

    private void processButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processButtonActionPerformed
        // too complicated man, make it simplier, too much complicated
        /*Report report = collectDeliveryReportInformation();
        int index = availableRoutsList.getSelectedIndex();
        int DRoutId = routeController.insertDRout(index);
        Date DRoutDate = routeController.getChosenRouteDate(index);
        report.setDate(DRoutDate);
        int reportId = reportController.insertDeliveryReport(report);
        routeController.inserDRout_Report(DRoutId, reportId);
        fillTables();
         */
        //number 2 variation

        Report report = collectDeliveryReportInformation();
        int index = availableRoutsList.getSelectedIndex();
        report.setRoute_id(routeController.getChosenRouteId(index));
        report.setDate(routeController.getChosenRouteDate(index));
        reportController.createAndSaveDeliveryReport(report);
        fillTables();
    }//GEN-LAST:event_processButtonActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

    }//GEN-LAST:event_formFocusGained

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // System.out.println("MainForm now active");
        //initializing connection, for the case when computers goes aslip, and then wakes up

        loadDistrictComboBoxes();//it does not matter what i trigger for database connection reinitializition
    }//GEN-LAST:event_formWindowActivated

    private void savePickUpOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePickUpOrderButtonActionPerformed
        Report report = new Report();
        report.setType(Report.Type.PICKUP);
        Customer customer = new Customer();
        int customer_id = Integer.parseInt(customerIdField.getText());
        customer.setId(customer_id);
        report.setCustomer(customer);
        int index = availableRoutsList_pickUp.getSelectedIndex();
        Date date = routeController.getChosenRouteDate(index);
        int route_id = routeController.getChosenRouteId(index);
        report.setDate(date);
        report.setRoute_id(route_id);
        reportController.createPickUpReport(report);
        displayScheduledPickUps();
    }//GEN-LAST:event_savePickUpOrderButtonActionPerformed

    private void savePickUpReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePickUpReportButtonActionPerformed

        if (reportGoodToGo()) {
            Report report = collectPickUpReportInformation();
            reportController.savePickUpReport(report);
            cleanPickUpReport();

        }
    }//GEN-LAST:event_savePickUpReportButtonActionPerformed

    private void addItemButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addItemButtonKeyPressed
        if (evt.getKeyCode() == 10) {
            addItemButton.doClick();
        }
    }//GEN-LAST:event_addItemButtonKeyPressed

    private void addItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemButtonActionPerformed
        PickUpItemFrame itemFrame = new PickUpItemFrame(this);
        itemFrame.setVisible(true);
    }//GEN-LAST:event_addItemButtonActionPerformed

    private void addItemButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_addItemButtonItemStateChanged

    }//GEN-LAST:event_addItemButtonItemStateChanged

    private void pickUpReportNumberFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pickUpReportNumberFieldKeyPressed
        if (evt.getKeyCode() == 10) {
            addItemButton.doClick();
        }
    }//GEN-LAST:event_pickUpReportNumberFieldKeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        if (!scheduledPickUpIdLabel.getText().equals("")) {
            int result = JOptionPane.showConfirmDialog(this,
                    "<html><center>ΥΠΑΡΧΕΙ ΠΡΟΓΡΑΜΜΑΤΙΣΜΕΝΗ PICK-UP ΠΑΡΑΓΓΕΛΙΑ:<br><b> "
                    + scheduledPickUpLabel.getText()
                    + ".<br></b> ΕΙΣΑΙ ΣΙΓΟΥΡΟΣ ΟΤΙ ΘΕΛΕΙΣ ΝΑ ΤΗΝ ΑΓΝΟΗΣΕΙΣ?", "ΗΔΗ ΥΠΑΡΧΕΙ PICK-UP ΠΑΡΑΓΓΕΛΙΑ</center></html>",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                CardLayout card = (CardLayout) jPanel4.getLayout();
                card.show(jPanel4, "card1");
            } else if (result == JOptionPane.NO_OPTION) {
                //DO NOTHING
            } else {
                //DO NOTHING
            }
        } else {
            CardLayout card = (CardLayout) jPanel4.getLayout();
            card.show(jPanel4, "card1");
        }


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CardLayout card = (CardLayout) jPanel4.getLayout();
        card.show(jPanel4, "card2");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        ScheduledPickUpFrame scheduledPickUpFrame = new ScheduledPickUpFrame(this);
        scheduledPickUpFrame.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void connectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectionButtonActionPerformed
        ConnectionsDispatcher.getDispatcherInstance().renewConnectionsStack();
    }//GEN-LAST:event_connectionButtonActionPerformed

    private void myInitialization() {
        customerController = new CustomerController();
        itemController = new ItemController();
        reportController = new ReportController();
        addressController = new AddressController();
        routeController = new RouteController();

        focusInColor = new Color(255, 255, 0);
        focusOutColor = new Color(240, 240, 240);

        Font headerFont = new Font("Tahoma", Font.BOLD, 14);
        pickUpItemsTableHeader = pickUpItemsTable.getTableHeader();
        pickUpItemsTableHeader.setFont(headerFont);

        pickUpItemsTableModel = (DefaultTableModel) pickUpItemsTable.getModel();

        pickUpDatePicker.setDate(new Date());
        pickUpDatePickerTextField = (JTextField) pickUpDatePicker.getComponent(1);
        pickUpDatePickerTextField.setEditable(false);

        //initializing comboboxListeners
        districtFieldItemSelectionListener = new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED)//to fire only when item is selecet, otherwise event is fired 2 time, because, first /some/ item is disselected, and then some another item is selleceted
                {
                    districFieldItemSeleceted(evt);
                }
            }

        };

        postalCodeFieldItemSelectionListener = new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED)//to fire only when item is selecet, otherwise event is fired 2 time, because, first /some/ item is disselected, and then some another item is selleceted
                {
                    postalCodeFieldItemSeleceted(evt);
                }
            }

        };

        availableRoutsModel = new DefaultComboBoxModel();
        availableRoutsModel_pickUp = new DefaultComboBoxModel();
    }

    private void saveAndCancelButtonsActions() {
        makeSearchFieldsUneditable();
        makeFieldsUneditable();
        editCustomerButton.setEnabled(false);
        cleanFields();
        CardLayout card = (CardLayout) buttonsPanel.getLayout();
        card.show(buttonsPanel, "card1");

        changeDistrictField.removeItemListener(districtFieldItemSelectionListener);
        addressChangeButtonsPanel.setVisible(false);
        dontChangeButton.doClick();

        hideChangeDistrictPanel();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("System".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CombinedPanel;
    private javax.swing.JPanel HeadPanel;
    private javax.swing.JPanel RootPanel;
    private javax.swing.JButton addItemButton;
    private javax.swing.JPanel addressChangeButtonsPanel;
    private javax.swing.JPanel addressPanel;
    private javax.swing.JLabel alternativeAddressLabel3;
    private javax.swing.JLabel alternativeBellNameLabel1;
    private javax.swing.JLabel alternativeFloorLabel3;
    private javax.swing.JLabel alternativeStreetLabel3;
    private javax.swing.JComboBox<String> availableRoutsList;
    private javax.swing.JComboBox<String> availableRoutsList_pickUp;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JPanel calculationDisplayPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton changeButton;
    private javax.swing.JComboBox<String> changeDistrictField;
    private javax.swing.JPanel changePanel;
    private javax.swing.JComboBox<String> changePostalCodeField;
    private javax.swing.JButton connectionButton;
    private javax.swing.JPanel customerArchiveTab;
    private javax.swing.JPanel customerCardPanel;
    private javax.swing.JPanel customerCardTab;
    private javax.swing.JTabbedPane customerCardsTabbedPane;
    private javax.swing.JTextField customerIdField;
    private javax.swing.JTextField districtField;
    private javax.swing.JLabel districtLabel;
    private javax.swing.JPanel districtPanel;
    private javax.swing.JButton dontChangeButton;
    private javax.swing.JPanel dontChangePanel;
    private javax.swing.JTextField doorbellNameField;
    private javax.swing.JButton editCustomerButton;
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField emailStatusField;
    private javax.swing.JButton findButton;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField floorField;
    private javax.swing.JLabel fpaLabel;
    private javax.swing.JLabel fpaLabel1;
    private javax.swing.JLabel fpaSum;
    private javax.swing.JLabel fpaSum1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JFormattedTextField landLineField;
    private javax.swing.JLabel landLineLabel;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastlNameLabel;
    private javax.swing.JButton measurementButton;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JFormattedTextField mobileField;
    private javax.swing.JLabel mobileLabel;
    private javax.swing.JButton newCustomerButton;
    private javax.swing.JPanel newCustomerEditCustomerPanel;
    private javax.swing.JPanel newPickUp;
    private javax.swing.JPanel newPickUpOrdredPanel;
    private javax.swing.JPanel nonScheduledPickUpPanel;
    private javax.swing.JTextArea noteField;
    private javax.swing.JLabel pickUpButtonLabel;
    private com.toedter.calendar.JDateChooser pickUpDatePicker;
    private javax.swing.JPanel pickUpItemsPanel;
    private javax.swing.JTable pickUpItemsTable;
    private javax.swing.JPanel pickUpPanel;
    private javax.swing.JFormattedTextField pickUpReportNumberField;
    private javax.swing.JTextField postalCodeField;
    private javax.swing.JButton processButton;
    private javax.swing.JPanel saveCancelPanel;
    private javax.swing.JButton saveNewCustomerButton;
    private javax.swing.JButton savePickUpOrderButton;
    private javax.swing.JButton savePickUpReportButton;
    private javax.swing.JPanel schedulePickUpDisplayPanel;
    private javax.swing.JLabel scheduledPickUpIdLabel;
    private javax.swing.JLabel scheduledPickUpLabel;
    private javax.swing.JPanel scheduledPickUpPanel;
    private javax.swing.JTextField streetField;
    private javax.swing.JLabel subTotalLabel;
    private javax.swing.JLabel subTotalLabel1;
    private javax.swing.JLabel subTotalSum;
    private javax.swing.JLabel subTotalSum1;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JLabel totalLabel1;
    private javax.swing.JLabel totalSum;
    private javax.swing.JLabel totalSum1;
    // End of variables declaration//GEN-END:variables

    private void makeFieldsEditable() {

        firstNameField.setEditable(true);

        noteField.setEditable(true);
        streetField.setEditable(true);
        streetField.setEditable(true);
        floorField.setEditable(true);
        doorbellNameField.setEditable(true);

    }

    private void makeFieldsUneditable() {

        firstNameField.setEditable(false);

        noteField.setEditable(false);
        streetField.setEditable(false);
        changeDistrictField.setEditable(false);
        changePostalCodeField.setEditable(false);
        floorField.setEditable(false);
        doorbellNameField.setEditable(false);

    }

    public void dispalyCustomerById(int id) {

        if (customerController.checkCustomerById(id)) {
            Customer customer = customerController.getCustomerById(id);
            makeSearchFieldsUneditable();
            displayCustomer(customer);
            editCustomerButton.setEnabled(true);
        } else {
//do nothing
        }
    }

    private void displayCustomer(Customer customer) {
        customerIdField.setText(Integer.toString(customer.getId()));
        lastNameField.setText(customer.getLastName());
        firstNameField.setText(customer.getFirstName());
        landLineField.setText(customer.getLandlinePhone());
        mobileField.setText(customer.getMobilePhone());

        districtField.setText(customer.getDistrict());
        postalCodeField.setText(customer.getPostalCode());
        streetField.setText(customer.getStreet());
        floorField.setText(customer.getFloor());
        doorbellNameField.setText(customer.getDoorbellName());
        noteField.setText(customer.getNote());

        emailField.setText(customer.getEmailIdentifier());
        emailStatusField.setText(customer.getStatus());

    }

    private void makeSearchFieldsEditable() {
        customerIdField.setEditable(true);
        lastNameField.setEditable(true);
        landLineField.setEditable(true);
        mobileField.setEditable(true);
    }

    private void makeSearchFieldsUneditable() {
        customerIdField.setEditable(false);
        lastNameField.setEditable(false);
        landLineField.setEditable(false);
        mobileField.setEditable(false);
    }

    private void cleanFields() {

        customerCardPanel.removeAll();//removing pickUp card`s table
        customerCardPanel.repaint();

        scheduledPickUpPanel.removeAll();
        scheduledPickUpPanel.repaint();

        availableRoutsList_pickUp.removeAllItems();

        customerIdField.setText("");

        lastNameField.setText("");
        firstNameField.setText("");
        landLineField.setText("");
        mobileField.setText("");

        districtField.setText("");
        postalCodeField.setText("");
        changeDistrictField.removeAllItems();
        changePostalCodeField.removeAllItems();
        streetField.setText("");
        floorField.setText("");
        doorbellNameField.setText("");

        noteField.setText("");
        emailField.setText("");
        emailStatusField.setText("");

    }

    private boolean customerIdInputValid() {
        boolean valid = true;
        customerIdField.setText(customerIdField.getText().trim());

        if (customerIdField.getText().equals("")) {
            JOptionPane.showMessageDialog(new javax.swing.JFrame(),
                    "ΠΕΔΙΟ 'ID ΠΕΛΑΤΗ' ΔΕΝ ΜΠΟΡΕΙ ΝΑ ΕΙΝΑΙ ΑΔΙΟ.",
                    "ΛΑΘΟΣ ΚΩΔΙΚΟΣ ΠΕΛΑΤΗ",
                    JOptionPane.ERROR_MESSAGE);
            customerIdField.setBackground(Color.red);
            valid = false;
        }
        char[] characters = customerIdField.getText().toCharArray();
        for (char c : characters) {
            if (!(Character.isDigit(c))) {//in case of copy paste with wrong characters
                valid = false;
                JOptionPane.showMessageDialog(new javax.swing.JFrame(),
                        "ΣΤΟ ΠΕΔΙΟ 'ID ΠΕΛΑΤΗ' ΕΠΙΤΡΕΠΟΝΤΑΙ ΜΟΝΟ ΑΡΙΜΟΙ",
                        "ΛΑΘΟΣ ΚΩΔΙΚΟΣ ΠΕΛΑΤΗ ",
                        JOptionPane.ERROR_MESSAGE);
                customerIdField.setBackground(Color.red);
                break;
            }

        }

        return valid;
    }

    private boolean customerInputsValid() {
        boolean valid = true;
        if (!lastNameInputValid() || !firstNameInputeValid() || !noteInputValid()
                || !streetInputValid()
                || !districtInputValid() || !postalCodeInputValid()
                || !floorInputValid() || !doorbellNameInputValid()) {
            valid = false;
        }

        return valid;
    }

    private Customer collectCustomerInformation() {
        Customer customer = new Customer();
        customer.setLastName(lastNameField.getText().trim());
        customer.setFirstName(firstNameField.getText().trim());
        customer.setLandlinePhone(landLineField.getText());
        customer.setMobilePhone(mobileField.getText());
        customer.setNote(noteField.getText().trim());

        if (changePanel.isVisible()) {
            if (changeDistrictField.getSelectedIndex() != -1) {
                customer.setDistrict(changeDistrictField.getSelectedItem().toString());

            } else {
                customer.setDistrict("");
            }
            if (changePostalCodeField.getSelectedIndex() != -1) {
                customer.setPostalCode(changePostalCodeField.getSelectedItem().toString());
            } else {
                customer.setPostalCode("");
            }

        } else {
            customer.setDistrict(districtField.getText().trim());
            customer.setPostalCode(postalCodeField.getText().trim());
        }

        customer.setStreet(streetField.getText());
        customer.setFloor(floorField.getText());
        customer.setDoorbellName(doorbellNameField.getText().trim());

        return customer;
    }

    private boolean lastNameInputValid() {
        boolean valid = true;
        String lastName = lastNameField.getText().trim();
        if (lastName.equals("")) {
            JOptionPane.showMessageDialog(new JFrame(),
                    "ΠΕΔΙΟ 'ΕΠΙΘΕΤΟ' ΔΕΝ ΜΠΟΡΕΙ ΝΑ ΕΙΝΑΙ ΑΔΕΙΟ",
                    "ΕΠΙΘΕΤΟ",
                    JOptionPane.ERROR_MESSAGE);
            valid = false;
        }
        if (lastName.length() > 45) {
            JOptionPane.showMessageDialog(new JFrame(),
                    "ΠΕΔΙΟ 'ΕΠΙΘΕΤΟ' ΔΕΝ ΜΠΟΡΕΙ ΝΑ ΕΧΕΙ ΠΑΝΩ ΑΠΟ 45 ΓΡΑΜΜΑΤΑ",
                    "ΕΠΙΘΕΤΟ",
                    JOptionPane.ERROR_MESSAGE);
            valid = false;
        }
        return valid;

    }

    private boolean firstNameInputeValid() {
        boolean valid = true;
        String firstName = firstNameField.getText().trim();

        if (firstName.length() > 45) {
            JOptionPane.showMessageDialog(new JFrame(),
                    "ΠΕΔΙΟ 'ΟΝΟΜΑ' ΔΕΝ ΜΠΟΡΕΙ ΝΑ ΕΧΕΙ ΠΑΝΩ ΑΠΟ 45 ΓΡΑΜΜΑΤΑ",
                    "ΟΝΟΜΑ",
                    JOptionPane.ERROR_MESSAGE);
            valid = false;
        }
        return valid;
    }

    private boolean noteInputValid() {
        boolean valid = true;
        String note = noteField.getText().trim();

        if (note.length() > 250) {
            JOptionPane.showMessageDialog(new JFrame(),
                    "ΠΕΔΙΟ 'ΣΗΜΕΙΩΜΑ' ΔΕΝ ΜΠΟΡΕΙ ΝΑ ΕΧΕΙ ΠΑΝΩ ΑΠΟ 250 ΓΡΑΜΜΑΤΑ",
                    "ΣΗΜΕΙΩΜΑ",
                    JOptionPane.ERROR_MESSAGE);
            valid = false;
        }
        return valid;
    }

    private boolean streetInputValid() {
        boolean valid = true;
        System.out.println("streetInputValid-MainFrame- i think no need for this anymore");
        return valid;
    }

    private boolean districtInputValid() {
        boolean valid = true;
        System.out.println("districtInputValid-MainFrame- i think no need for this anymore");

        return valid;

    }

    private boolean postalCodeInputValid() {
        boolean valid = true;
        System.out.println("postalCodeInputValid-MainFrame- i think no need for this anymore");

        return valid;
    }

    private boolean floorInputValid() {
        boolean valid = true;
        System.out.println("need to change field for combobox with floors -10 to 100 with δομα and υπογειο ");
        String floor = floorField.getText().trim();
        if (floor.length() > 10) {
            JOptionPane.showMessageDialog(new JFrame(),
                    "ΠΕΔΙΟ 'ΟΡΟΦΟΣ' ΔΕΝ ΜΠΟΡΕΙ ΝΑ ΕΧΕΙ ΠΑΝΩ ΑΠΟ 10 ΓΡΑΜΜΑΤΑ",
                    "ΟΡΟΦΟΣ",
                    JOptionPane.ERROR_MESSAGE);
            valid = false;
        }
        return valid;
    }

    private boolean doorbellNameInputValid() {
        boolean valid = true;
        String bellName = doorbellNameField.getText().trim();

        if (bellName.length() > 60) {
            JOptionPane.showMessageDialog(new JFrame(),
                    "ΠΕΔΙΟ 'ΟΝΟΜΑ ΣΤΟ ΚΟΥΔΟΥΝΙ' ΔΕΝ ΜΠΟΡΕΙ ΝΑ ΕΧΕΙ ΠΑΝΩ ΑΠΟ 60 ΓΡΑΜΜΑΤΑ",
                    "ΟΝΟΜΑ ΣΤΟ ΚΟΥΔΟΥΝΙ",
                    JOptionPane.ERROR_MESSAGE);
            valid = false;
        }
        return valid;
    }

    public void fillTables() {
        fillCardTable();
        loadAvailableRouts();
        displayScheduledPickUps();
        /*
System.out.println("maybe to drop switch, and fille all the table simultaniously, don know yet");

        String tabName = customerCardsTabbedPane.getTitleAt(customerCardsTabbedPane.getSelectedIndex());
        switch (tabName) {
            case "ΚΑΡΤΕΛΑ":
                fillCardTable();
                break;
            case "ΝΕΑ ΠΑΡΑΛΑΒΗ":
                System.out.println("nneed to write code here for new pickUp");
                break;
            case "ΑΡΧΕΙΟ":
                System.out.println("need to write code here for archive");
                break;
        }
         */
    }

    private void fillCardTable() {
        customerCardPanel.removeAll();
        cardTableModel = new MyTableModel();

        Object[] columns = new Object[20];

        columns[0] = "ΚΩΔΙΚΟΣ ΠΡΟΙΟΝΤΟΣ";
        columns[1] = "ΠΕΡΙΓΡΑΦΗ";
        columns[2] = "ΚΩΔΙΚΟΣ ΤΕΜΑΧΙΟΥ";
        columns[3] = "ΧΡΟΝΙΑ";
        columns[4] = "ΚΑΘΑΡΙΣΜΑ";
        columns[5] = "ΦΥΛΑΞΗ";
        columns[6] = "ΕΠΙΔΙΟΘΡΩΣΗ";
        columns[7] = "ΣΗΜΕΙΩΜΑ";

        columns[8] = "ΤΙΜΗ ΓΙΑ ΚΑΘΑΡΙΣΜΑ";
        columns[9] = "ΤΙΜΗ ΓΙΑ ΦΥΛΑΞΗ";

        columns[10] = "ΜΗΚΟΣ";
        columns[11] = "ΠΛΑΟΤΟΣ";
        columns[12] = "ΤΕΤΡΑΓΩΝΙΚΑ";

        columns[13] = "ΧΡΕΩΣΗ ΓΙΑ ΚΑΘΑΡΙΣΜΑ";
        columns[14] = "ΧΡΕΩΣΗ ΓΙΑ ΦΥΛΑΞΗ";
        columns[15] = "ΧΡΕΩΣΗ ΓΙΑ ΕΠΙΔΙΟΡΘΩΣΗ";

        columns[16] = "ΣΥΝΟΛΟ ΧΡΕΩΣΗΣ ΤΕΜΑΧΙΟΥ";
        columns[17] = "ΚΑΤΑΣΤΑΣΗ";
        columns[18] = "ΔΙΑΛΟΓΗ";
        columns[19] = "aba";
        cardTableModel.setColumnIdentifiers(columns);

        ArrayList<Item> items = itemController.getCustomerItemsForCard(Integer.parseInt(customerIdField.getText()));

        for (Item item : items) {
            Object[] row = new Object[20];

            row[0] = item.getId();
            row[1] = item.getDescription();
            row[2] = item.getCode();
            row[3] = item.getYear();
            if (item.isForCleaning()) {
                row[4] = "*";
            } else {
                row[4] = "-";
            }
            if (item.isForStoring()) {
                row[5] = "*";
            } else {
                row[5] = "-";
            }
            if (item.isForMending()) {
                row[6] = "*";
            } else {
                row[6] = "-";
            }

            row[7] = item.getNote();

            row[8] = item.getCleaningPrice();
            row[9] = item.getStoringPrice();

            if (item.getLength() != null) {
                BigDecimal length, width, square;
                row[10] = length = item.getLength();
                row[11] = width = item.getWidth();
                square = length.multiply(width);
                row[12] = square.setScale(2, RoundingMode.HALF_EVEN);
            } else {
                row[10] = "N/A";
                row[11] = "N/A";
                row[12] = "N/A";
            }
            BigDecimal cleaningCharge, storingCharge, mendingCharge, s, totalCharge;
            row[13] = cleaningCharge = item.getCleaningCharge();
            row[14] = storingCharge = item.getStoringCharge();
            row[15] = mendingCharge = item.getMendingCharge();
            totalCharge = storingCharge.add(cleaningCharge).add(mendingCharge);
            row[16] = totalCharge;
            row[17] = item.getStatus();
            boolean status;
            if (item.getStatus().equals("ready")) {
                row[18] = status = Boolean.TRUE;
            } else {
                row[18] = status = Boolean.FALSE;
            }
            if (item.getSpot() == null) {
                row[19] = "N/A";
            } else {
                row[19] = item.getSpot();
            }

            cardTableModel.addRow(row, status);
        }
        JScrollPane sc = (JScrollPane) createTable(cardTableModel);

        customerCardPanel.add(sc);
        customerCardPanel.setLayout(new BoxLayout(customerCardPanel, BoxLayout.LINE_AXIS));
        //You have added a new component. The contentPane will be invalid, and needs repainting
//strange thing for me, if i change costomer, there is no problem, it paints allrigth,
//problems appear ,when i dont change costmer, i mean, it is the same number, same customer.
        customerCardPanel.validate();
        customerCardPanel.repaint();
        //   pack();
//if i dont put it, MainFrame shrinks to is original dimensions, even if i have it to full screen
        countTotal(cardTableModel);
    }

    private JComponent createTable(DefaultTableModel model) {
//do not ask much about this, i don know how it works
        JTable table = new JTable(model) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);

                //  Color row based on a cell value
                if (!isRowSelected(row)) {
                    c.setBackground(getBackground());
                    int modelRow = convertRowIndexToModel(row);
                    String status = (String) getModel().getValueAt(modelRow, 17);
                    boolean ready = (boolean) getModel().getValueAt(modelRow, 18);

                    if (status.equals("processing")) {
                        //model.setValueAt(false, modelRow, 17);
                        c.setBackground(Color.RED);
                    }
                    if (status.equals("delivery_scheduled")) {
                        //model.setValueAt(false, modelRow, 17);
                        c.setBackground(Color.BLUE);
                    }

                    if (ready) {
                        c.setBackground(Color.GREEN);
                    }

                }

                if (isRowSelected(row)) {
                    //   c.setBackground(getBackground());
                    int modelRow = convertRowIndexToModel(row);
                    String status = (String) getModel().getValueAt(modelRow, 17);
                    if (!"ready".equals(status)) {
                        // model.setValueAt(false, modelRow, 17);
                        c.setBackground(Color.PINK);

                    }

                }

                return c;
            }
        };

        table.getModel().addTableModelListener(
                new TableModelListener() {

            public void tableChanged(TableModelEvent evt) {
                countTotal((DefaultTableModel) table.getModel());
            }
        }
        );

        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setRowHeight(36);

        table.setFont(new java.awt.Font("Tahoma", 0, 30));

        table.changeSelection(0, 0, false, false);
        table.setAutoCreateRowSorter(true);
        // table.setAutoResizeMode(AUTO_RESIZE_OFF);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        int scrollPaneHeigth = (model.getRowCount() + 2) * table.getRowHeight();
        scrollPane.setPreferredSize(new Dimension(scrollPane.getPreferredSize().width, scrollPaneHeigth));
        return scrollPane;
    }

    private void countTotal(DefaultTableModel model) {

        int rowCount = model.getRowCount();
        BigDecimal subTotal = BigDecimal.ZERO;

        for (int x = 0; x < rowCount; x++) {
            if (!Boolean.valueOf(model.getValueAt(x, 18).toString())) {
                continue;
            }
            //summing up of item`s total charges
            subTotal = subTotal.add(new BigDecimal(model.getValueAt(x, 16).toString()));
            subTotal = subTotal.setScale(2, RoundingMode.HALF_EVEN);
        }
        subTotalSum.setText(subTotal.toString());

        BigDecimal fpa = subTotal.multiply(new BigDecimal(24).divide(new BigDecimal(100)));
        fpa = fpa.setScale(2, RoundingMode.HALF_EVEN);
        fpaSum.setText(fpa.toString());

        BigDecimal total = subTotal.add(fpa);
        total.setScale(2, RoundingMode.HALF_EVEN);
        totalSum.setText(total.toString());

    }

    public void addItemToPickUpItemsTable(Item item) {
        String[] row = new String[7];
        row[0] = String.valueOf(item.getId());
        row[1] = item.getDescription();
        row[2] = String.valueOf(item.getCode());
        if (item.isForCleaning()) {
            row[3] = "*";
        } else {
            row[3] = "-";
        }
        if (item.isForStoring()) {
            row[4] = "*";
        } else {
            row[4] = "-";
        }
        if (item.isForMending()) {
            row[5] = "*";
        } else {
            row[5] = "-";
        }
        row[6] = item.getNote();

        pickUpItemsTableModel.addRow(row);
    }

    private Report collectPickUpReportInformation() {

        Report report = new Report();

        if (scheduledPickUpIdLabel.getText().equals("")) {
            report.setId(0);
            report.setDate(pickUpDatePicker.getDate());
            report.setRoute_id(0);
        } else {

            report.setId(Integer.parseInt(scheduledPickUpIdLabel.getText()));

        }
        report.setType(Report.Type.PICKUP);
        report.getCustomer().setId(Integer.parseInt(customerIdField.getText().toString()));
        report.setNumber(Integer.parseInt(pickUpReportNumberField.getText()));
        DefaultTableModel model = (DefaultTableModel) pickUpItemsTable.getModel();

        for (int x = 0; x < model.getRowCount(); x++) {
            Item item = new Item();
            item.setId(Integer.parseInt(model.getValueAt(x, 0).toString()));
            item.setCode(Integer.parseInt(model.getValueAt(x, 2).toString()));
            if (model.getValueAt(x, 3).equals("*")) {
                item.setForCleaning(true);
            } else {
                item.setForCleaning(false);
            }
            if (model.getValueAt(x, 4).equals("*")) {
                item.setForStoring(true);
            } else {
                item.setForStoring(false);
            }
            if (model.getValueAt(x, 5).equals("*")) {
                item.setForMending(true);
            } else {
                item.setForMending(false);
            }
            item.setNote(model.getValueAt(x, 6).toString());
            report.getItems().add(item);
        }

        return report;
    }

    private boolean reportGoodToGo() {
        if (customerIdInputValid() && pickUpReportNumberGoodToGo() && pickUpReportTableGoodToGo()) {
            int customerId = Integer.parseInt(customerIdField.getText());
            if (customerController.checkCustomerById(customerId)) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }

    }

    private boolean pickUpReportNumberGoodToGo() {
        if (pickUpReportNumberField.getText().trim().length() > 0) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "ΠΕΔΙΟ 'ΑΡΙΘΜΟΣ ΔΕΛΤΙΟΥ ΔΕΝ ΜΠΟΡΕΙ ΝΑ ΕΙΝΑΙ ΑΔΙΟ",
                    "ΛΑΘΟΣ ΑΡΙΘΜΟΣ ΔΕΛΤΙΟΥ",
                    JOptionPane.ERROR_MESSAGE);
            pickUpReportNumberField.setBackground(Color.red);
            pickUpReportNumberField.requestFocus();
            return false;
        }

    }

    private boolean pickUpReportTableGoodToGo() {
        if (pickUpItemsTable.getModel().getRowCount() > 0) {

            return true;
        } else {
            JOptionPane.showMessageDialog(null, "ΠΡΕΠΕΙ ΝΑ ΥΠΑΡΧΕΙ ΤΟΥΛΑΧΙΣΤΟΝ ΕΝΑ ΤΕΜΑΧΙΟ ΣΤΟ ΔΕΛΤΙΟ ΠΑΡΑΛΑΒΗΣ",
                    "ΛΑΘΟΣ ΤΕΜΑΧΙΑ",
                    JOptionPane.ERROR_MESSAGE);
            pickUpReportNumberField.setBackground(Color.red);
            pickUpReportNumberField.requestFocus();
            return false;
        }
    }

    private void cleanPickUpReport() {
        pickUpReportNumberField.setText("");
        pickUpItemsTableModel.setRowCount(0);
        scheduledPickUpLabel.setText("");
        scheduledPickUpIdLabel.setText("");
        cleanFields();
    }

    private void openFindUserFields() {
        cleanFields();
        makeFieldsUneditable();
        makeSearchFieldsEditable();
        CardLayout card = (CardLayout) buttonsPanel.getLayout();
        card.show(buttonsPanel, "card1");
    }

    private void loadDistrictComboBoxes() {

        districtsList = addressController.getDistrictsList();
        for (String district : districtsList.keySet()) {

            changeDistrictField.addItem(district);
            changeDistrictField.setSelectedIndex(-1);//why on hell did i do this???

        }
        //adding listener now, and not before, because otherwise it works the moment field is loaded, and i dont want this to happen, i want it to start listeneing after field is loaded
        changeDistrictField.addItemListener(districtFieldItemSelectionListener);
    }

    private void districFieldItemSeleceted(ItemEvent evt) {
        changePostalCodeField.removeAllItems();
        String district = evt.getItem().toString();
        ArrayList<String> district_postal_codes = districtsList.get(district);
        for (String postalCode : district_postal_codes) {
            changePostalCodeField.addItem(postalCode);
        }
        changePostalCodeField.setSelectedIndex(-1);
        changePostalCodeField.addItemListener(postalCodeFieldItemSelectionListener);
    }

    private void postalCodeFieldItemSeleceted(ItemEvent evt) {
    }

    private void showChangeDistrictPanel() {
        CardLayout districtCard = (CardLayout) districtPanel.getLayout();
        districtCard.show(districtPanel, "YES");
        changePanel.setVisible(true);
    }

    private void hideChangeDistrictPanel() {
        CardLayout districtCard = (CardLayout) districtPanel.getLayout();
        districtCard.show(districtPanel, "NO");
        changePanel.setVisible(false);
    }

    private void loadAvailableRouts() {
        // String district = districtField.getText();
        String postal_code = postalCodeField.getText();
        availableRoutsModel.removeAllElements();
        ArrayList<String> availableRouts;
        availableRouts = routeController.getAvailableRoutForDistrict(postal_code);

        for (String day : availableRouts) {
            availableRoutsModel.addElement(day);

        }
        availableRoutsList.setModel(availableRoutsModel);
        availableRoutsList_pickUp.setModel(availableRoutsModel);
    }

    public void showCardTab() {
        customerCardsTabbedPane.setSelectedIndex(0);
    }

    public void showNewPickUpTab() {
        customerCardsTabbedPane.setSelectedIndex(2);
    }

    private Report collectDeliveryReportInformation() {
        Report report = new Report();
        report.setType(Report.Type.DELIVERY);
        report.getCustomer().setId(Integer.parseInt(customerIdField.getText()));
        int rowCount = cardTableModel.getRowCount();
        for (int x = 0; x < rowCount; x++) {

            if ((boolean) cardTableModel.getValueAt(x, 18)) {
                Item item = new Item();
                item.setCode((int) cardTableModel.getValueAt(x, 2));
                item.setYear((int) cardTableModel.getValueAt(x, 3));
                item.setCleaningCharge((BigDecimal) cardTableModel.getValueAt(x, 13));
                item.setStoringCharge((BigDecimal) cardTableModel.getValueAt(x, 14));

                report.getItems().add(item);
            }

        }
        return report;
    }

    public DefaultTableModel getPickUpItemsTableModel() {
        return pickUpItemsTableModel;
    }

    public void displayScheduledPickUps() {
        int customer_id = Integer.parseInt(customerIdField.getText());
        //at first i thougth for possibility to order multiple pick-ups, 
        //but then , i realize, it has no sense, 
        //why would you order second pick-up, while you still have active one
        //anyway, i left as it was for now, we`ll see later.
        LinkedHashMap<Integer, String> scheduledPickUpList = reportController.getSceduledPickUpList(customer_id);

        Set<Integer> keys = scheduledPickUpList.keySet();
        if (keys.size() > 0) {
            scheduledPickUpPanel.removeAll();
            for (Integer report_id : keys) {
                String route = scheduledPickUpList.get(report_id);
                ScheduledPickUpPanel panel = new ScheduledPickUpPanel(this, report_id, route);
                scheduledPickUpPanel.add(panel);
                savePickUpOrderButton.setEnabled(false);
                pickUpButtonLabel.setText("ΓΙΑ ΝΑ ΚΑΝΟΝΙΣΕΙΣ ΚΑΙΝΟΥΡΙΑ ΕΠΙΣΚΕΨΗ ΑΚΥΡΩΣΕ ΠΡΩΤΑ ΤΗΝ ΗΔΗ ΥΠΑΡΧΟΥΣΑ");
                scheduledPickUpIdLabel.setText(String.valueOf(report_id));
                scheduledPickUpLabel.setText(route);
            }
        } else {
            scheduledPickUpPanel.removeAll();
            savePickUpOrderButton.setEnabled(true);
            pickUpButtonLabel.setText("");
            scheduledPickUpIdLabel.setText(String.valueOf(""));
            scheduledPickUpLabel.setText("ΔΕΝ ΕΧΕΙ PICK-UP ΠΑΡΑΓΓΕΛΙΑ");

        }

        jButton3.doClick();//the button to show panel for scheduled PickUps
        scheduledPickUpPanel.revalidate();
        scheduledPickUpPanel.repaint();

    }

    public void showConnectionsCountOnMainFrameHeader(int connectionsCount) {
        Date now = new Date();
        this.setTitle("Connections in DataBase at: " + now + ":   " + String.valueOf(connectionsCount));

    }

    public void connectionRed() {
        connectionButton.setBackground(Color.RED);
    }

    public void connectionGreen() {
        connectionButton.setBackground(Color.GREEN);
    }

}
