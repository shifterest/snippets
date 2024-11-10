/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

/**
 *
 * @author Delmoro-Ke
 */
public class EnrollmentPane extends javax.swing.JPanel {

    /**
     * Creates new form EnrollmentPane
     */
    public EnrollmentPane() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInputs = new javax.swing.JPanel();
        panelStudentID = new javax.swing.JPanel();
        lblStudentID = new javax.swing.JLabel();
        txtStudentID = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        panelStudentName = new javax.swing.JPanel();
        lblStudentName = new javax.swing.JLabel();
        txtStudentName = new javax.swing.JTextField();
        panelCourse = new javax.swing.JPanel();
        lblCourse = new javax.swing.JLabel();
        comboCourse = new javax.swing.JComboBox<>();
        btnCourseFilter = new javax.swing.JButton();
        panelYearLevel = new javax.swing.JPanel();
        lblYearLevel = new javax.swing.JLabel();
        comboYearLevel = new javax.swing.JComboBox<>();
        btnYearLevelFilter = new javax.swing.JButton();
        tableInfo = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 204, 255));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        panelInputs.setMaximumSize(new java.awt.Dimension(32767, 160));
        panelInputs.setOpaque(false);
        panelInputs.setPreferredSize(new java.awt.Dimension(100, 160));
        panelInputs.setLayout(new javax.swing.BoxLayout(panelInputs, javax.swing.BoxLayout.Y_AXIS));

        panelStudentID.setOpaque(false);

        lblStudentID.setText("Student ID");
        lblStudentID.setMaximumSize(new java.awt.Dimension(100, 25));
        lblStudentID.setMinimumSize(new java.awt.Dimension(100, 25));
        lblStudentID.setPreferredSize(new java.awt.Dimension(100, 25));
        panelStudentID.add(lblStudentID);

        txtStudentID.setMaximumSize(new java.awt.Dimension(215, 30));
        txtStudentID.setMinimumSize(new java.awt.Dimension(215, 30));
        txtStudentID.setPreferredSize(new java.awt.Dimension(215, 30));
        txtStudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentIDActionPerformed(evt);
            }
        });
        panelStudentID.add(txtStudentID);

        btnAdd.setText("+");
        btnAdd.setMaximumSize(new java.awt.Dimension(30, 30));
        btnAdd.setMinimumSize(new java.awt.Dimension(30, 30));
        btnAdd.setPreferredSize(new java.awt.Dimension(30, 30));
        panelStudentID.add(btnAdd);

        panelInputs.add(panelStudentID);

        panelStudentName.setOpaque(false);

        lblStudentName.setText("Student name");
        lblStudentName.setMaximumSize(new java.awt.Dimension(100, 25));
        lblStudentName.setMinimumSize(new java.awt.Dimension(100, 25));
        lblStudentName.setPreferredSize(new java.awt.Dimension(100, 25));
        panelStudentName.add(lblStudentName);

        txtStudentName.setMaximumSize(new java.awt.Dimension(250, 30));
        txtStudentName.setMinimumSize(new java.awt.Dimension(250, 30));
        txtStudentName.setPreferredSize(new java.awt.Dimension(250, 30));
        txtStudentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentNameActionPerformed(evt);
            }
        });
        panelStudentName.add(txtStudentName);

        panelInputs.add(panelStudentName);

        panelCourse.setOpaque(false);

        lblCourse.setText("Course");
        lblCourse.setMaximumSize(new java.awt.Dimension(100, 25));
        lblCourse.setMinimumSize(new java.awt.Dimension(100, 25));
        lblCourse.setPreferredSize(new java.awt.Dimension(100, 25));
        panelCourse.add(lblCourse);

        comboCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BSIT", "BSCS", "BLIS" }));
        comboCourse.setMaximumSize(new java.awt.Dimension(185, 30));
        comboCourse.setMinimumSize(new java.awt.Dimension(185, 30));
        comboCourse.setName(""); // NOI18N
        comboCourse.setPreferredSize(new java.awt.Dimension(185, 30));
        panelCourse.add(comboCourse);

        btnCourseFilter.setText("Filter");
        btnCourseFilter.setMaximumSize(new java.awt.Dimension(60, 30));
        btnCourseFilter.setMinimumSize(new java.awt.Dimension(60, 30));
        btnCourseFilter.setPreferredSize(new java.awt.Dimension(60, 30));
        panelCourse.add(btnCourseFilter);

        panelInputs.add(panelCourse);

        panelYearLevel.setOpaque(false);

        lblYearLevel.setText("Year level");
        lblYearLevel.setMaximumSize(new java.awt.Dimension(100, 25));
        lblYearLevel.setMinimumSize(new java.awt.Dimension(100, 25));
        lblYearLevel.setPreferredSize(new java.awt.Dimension(100, 25));
        panelYearLevel.add(lblYearLevel);

        comboYearLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        comboYearLevel.setToolTipText("");
        comboYearLevel.setMaximumSize(new java.awt.Dimension(185, 30));
        comboYearLevel.setMinimumSize(new java.awt.Dimension(185, 30));
        comboYearLevel.setName(""); // NOI18N
        comboYearLevel.setPreferredSize(new java.awt.Dimension(185, 30));
        panelYearLevel.add(comboYearLevel);

        btnYearLevelFilter.setText("Filter");
        btnYearLevelFilter.setMaximumSize(new java.awt.Dimension(60, 30));
        btnYearLevelFilter.setMinimumSize(new java.awt.Dimension(60, 30));
        btnYearLevelFilter.setPreferredSize(new java.awt.Dimension(60, 30));
        panelYearLevel.add(btnYearLevelFilter);

        panelInputs.add(panelYearLevel);

        add(panelInputs);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject code", "Description", "Units", "Grade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        tableInfo.setViewportView(jTable1);

        add(tableInfo);
    }// </editor-fold>//GEN-END:initComponents

    private void txtStudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentIDActionPerformed

    private void txtStudentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCourseFilter;
    private javax.swing.JButton btnYearLevelFilter;
    private javax.swing.JComboBox<String> comboCourse;
    private javax.swing.JComboBox<String> comboYearLevel;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCourse;
    private javax.swing.JLabel lblStudentID;
    private javax.swing.JLabel lblStudentName;
    private javax.swing.JLabel lblYearLevel;
    private javax.swing.JPanel panelCourse;
    private javax.swing.JPanel panelInputs;
    private javax.swing.JPanel panelStudentID;
    private javax.swing.JPanel panelStudentName;
    private javax.swing.JPanel panelYearLevel;
    private javax.swing.JScrollPane tableInfo;
    private javax.swing.JTextField txtStudentID;
    private javax.swing.JTextField txtStudentName;
    // End of variables declaration//GEN-END:variables
}
