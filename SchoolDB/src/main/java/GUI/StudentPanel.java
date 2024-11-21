/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import Classes.*;
import Utilities.*;
import com.mongodb.client.*;
import java.awt.Color;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.AbstractDocument;
import org.bson.Document;

/**
 *
 * @author Delmoro-Ke
 */
public class StudentPanel extends JPanel {

    private boolean courseFilter;
    private boolean yearLevelFilter;
    private boolean saveState;
    private boolean isAdjusting;

    /**
     * Creates new form EnrollmentPane
     */
    public StudentPanel() {
        initComponents();
        ((AbstractDocument) txtStudentId.getDocument()).setDocumentFilter(new StudentIDFilter());
        tableStudents.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                tableSelectionChanged(e);
            }
        });

        PopulateTable.student(tableStudents, courseFilter, comboCourse, yearLevelFilter, comboYearLevel);
        courseFilter = false;
        yearLevelFilter = false;
        saveState = false;
        isAdjusting = false;
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
        panelCourse = new javax.swing.JPanel();
        lblCourse = new javax.swing.JLabel();
        comboCourse = new javax.swing.JComboBox<>();
        btnCourseFilter = new javax.swing.JButton();
        panelYearLevel = new javax.swing.JPanel();
        lblYearLevel = new javax.swing.JLabel();
        comboYearLevel = new javax.swing.JComboBox<>();
        btnYearLevelFilter = new javax.swing.JButton();
        panelStudentID = new javax.swing.JPanel();
        lblStudentID = new javax.swing.JLabel();
        txtStudentId = new javax.swing.JTextField();
        panelStudentName = new javax.swing.JPanel();
        lblStudentName = new javax.swing.JLabel();
        txtStudentName = new javax.swing.JTextField();
        btnAddSave = new javax.swing.JButton();
        panelSelected = new javax.swing.JPanel();
        lblStudentName1 = new javax.swing.JLabel();
        btnDeselect = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        scrollInfo = new javax.swing.JScrollPane();
        tableStudents = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 204, 255));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        panelInputs.setMaximumSize(new java.awt.Dimension(32767, 160));
        panelInputs.setOpaque(false);
        panelInputs.setPreferredSize(new java.awt.Dimension(100, 160));
        panelInputs.setLayout(new javax.swing.BoxLayout(panelInputs, javax.swing.BoxLayout.Y_AXIS));

        panelCourse.setOpaque(false);

        lblCourse.setText("Course");
        lblCourse.setMaximumSize(new java.awt.Dimension(100, 25));
        lblCourse.setMinimumSize(new java.awt.Dimension(100, 25));
        lblCourse.setPreferredSize(new java.awt.Dimension(100, 25));
        panelCourse.add(lblCourse);

        comboCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BLIS", "BSCS", "BSIT" }));
        comboCourse.setMaximumSize(new java.awt.Dimension(175, 30));
        comboCourse.setMinimumSize(new java.awt.Dimension(175, 30));
        comboCourse.setName(""); // NOI18N
        comboCourse.setPreferredSize(new java.awt.Dimension(175, 30));
        comboCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCourseActionPerformed(evt);
            }
        });
        panelCourse.add(comboCourse);

        btnCourseFilter.setText("Filter");
        btnCourseFilter.setMaximumSize(new java.awt.Dimension(70, 30));
        btnCourseFilter.setMinimumSize(new java.awt.Dimension(70, 30));
        btnCourseFilter.setPreferredSize(new java.awt.Dimension(70, 30));
        btnCourseFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCourseFilterActionPerformed(evt);
            }
        });
        panelCourse.add(btnCourseFilter);

        panelInputs.add(panelCourse);

        panelYearLevel.setOpaque(false);

        lblYearLevel.setText("Year level");
        lblYearLevel.setMaximumSize(new java.awt.Dimension(100, 25));
        lblYearLevel.setMinimumSize(new java.awt.Dimension(100, 25));
        lblYearLevel.setPreferredSize(new java.awt.Dimension(100, 25));
        panelYearLevel.add(lblYearLevel);

        comboYearLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "First year", "Second year", "Third year", "Fourth year", "Fifth year" }));
        comboYearLevel.setToolTipText("");
        comboYearLevel.setMaximumSize(new java.awt.Dimension(175, 30));
        comboYearLevel.setMinimumSize(new java.awt.Dimension(175, 30));
        comboYearLevel.setName(""); // NOI18N
        comboYearLevel.setPreferredSize(new java.awt.Dimension(175, 30));
        comboYearLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboYearLevelActionPerformed(evt);
            }
        });
        panelYearLevel.add(comboYearLevel);

        btnYearLevelFilter.setText("Filter");
        btnYearLevelFilter.setMaximumSize(new java.awt.Dimension(70, 30));
        btnYearLevelFilter.setMinimumSize(new java.awt.Dimension(70, 30));
        btnYearLevelFilter.setPreferredSize(new java.awt.Dimension(70, 30));
        btnYearLevelFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYearLevelFilterActionPerformed(evt);
            }
        });
        panelYearLevel.add(btnYearLevelFilter);

        panelInputs.add(panelYearLevel);

        panelStudentID.setOpaque(false);

        lblStudentID.setText("Student ID");
        lblStudentID.setMaximumSize(new java.awt.Dimension(100, 25));
        lblStudentID.setMinimumSize(new java.awt.Dimension(100, 25));
        lblStudentID.setPreferredSize(new java.awt.Dimension(100, 25));
        panelStudentID.add(lblStudentID);

        txtStudentId.setEnabled(false);
        txtStudentId.setMaximumSize(new java.awt.Dimension(250, 30));
        txtStudentId.setMinimumSize(new java.awt.Dimension(250, 30));
        txtStudentId.setPreferredSize(new java.awt.Dimension(250, 30));
        panelStudentID.add(txtStudentId);

        panelInputs.add(panelStudentID);

        panelStudentName.setOpaque(false);

        lblStudentName.setText("Student name");
        lblStudentName.setMaximumSize(new java.awt.Dimension(100, 25));
        lblStudentName.setMinimumSize(new java.awt.Dimension(100, 25));
        lblStudentName.setPreferredSize(new java.awt.Dimension(100, 25));
        panelStudentName.add(lblStudentName);

        txtStudentName.setEnabled(false);
        txtStudentName.setMaximumSize(new java.awt.Dimension(175, 30));
        txtStudentName.setMinimumSize(new java.awt.Dimension(175, 30));
        txtStudentName.setPreferredSize(new java.awt.Dimension(175, 30));
        panelStudentName.add(txtStudentName);

        btnAddSave.setText("Add");
        btnAddSave.setMaximumSize(new java.awt.Dimension(70, 30));
        btnAddSave.setMinimumSize(new java.awt.Dimension(70, 30));
        btnAddSave.setPreferredSize(new java.awt.Dimension(70, 30));
        btnAddSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSaveActionPerformed(evt);
            }
        });
        panelStudentName.add(btnAddSave);

        panelInputs.add(panelStudentName);

        add(panelInputs);

        panelSelected.setOpaque(false);

        lblStudentName1.setText("Selected student");
        lblStudentName1.setMaximumSize(new java.awt.Dimension(100, 25));
        lblStudentName1.setMinimumSize(new java.awt.Dimension(100, 25));
        lblStudentName1.setPreferredSize(new java.awt.Dimension(100, 25));
        panelSelected.add(lblStudentName1);

        btnDeselect.setText("Deselect");
        btnDeselect.setEnabled(false);
        btnDeselect.setMaximumSize(new java.awt.Dimension(85, 30));
        btnDeselect.setMinimumSize(new java.awt.Dimension(85, 30));
        btnDeselect.setPreferredSize(new java.awt.Dimension(85, 30));
        btnDeselect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeselectActionPerformed(evt);
            }
        });
        panelSelected.add(btnDeselect);

        btnUpdate.setText("Update");
        btnUpdate.setEnabled(false);
        btnUpdate.setMaximumSize(new java.awt.Dimension(85, 30));
        btnUpdate.setMinimumSize(new java.awt.Dimension(85, 30));
        btnUpdate.setPreferredSize(new java.awt.Dimension(85, 30));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        panelSelected.add(btnUpdate);

        btnDelete.setBackground(new java.awt.Color(255, 102, 102));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.setEnabled(false);
        btnDelete.setMaximumSize(new java.awt.Dimension(70, 30));
        btnDelete.setMinimumSize(new java.awt.Dimension(70, 30));
        btnDelete.setPreferredSize(new java.awt.Dimension(70, 30));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        panelSelected.add(btnDelete);

        add(panelSelected);

        tableStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Student name", "Course", "Year level"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableStudents.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableStudents.getTableHeader().setReorderingAllowed(false);
        tableStudents.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableStudentsKeyPressed(evt);
            }
        });
        scrollInfo.setViewportView(tableStudents);
        tableStudents.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tableStudents.getColumnModel().getColumnCount() > 0) {
            tableStudents.getColumnModel().getColumn(0).setMinWidth(0);
            tableStudents.getColumnModel().getColumn(0).setPreferredWidth(0);
            tableStudents.getColumnModel().getColumn(2).setMinWidth(0);
            tableStudents.getColumnModel().getColumn(2).setPreferredWidth(0);
            tableStudents.getColumnModel().getColumn(3).setMinWidth(0);
            tableStudents.getColumnModel().getColumn(3).setPreferredWidth(0);
        }

        add(scrollInfo);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCourseFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCourseFilterActionPerformed
        courseFilter = !courseFilter;
        if (courseFilter) {
            btnCourseFilter.setBackground(Color.YELLOW);
        } else {
            btnCourseFilter.setBackground(Color.WHITE);
        }
        PopulateTable.student(tableStudents, courseFilter, comboCourse, yearLevelFilter, comboYearLevel);
    }//GEN-LAST:event_btnCourseFilterActionPerformed

    private void btnYearLevelFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYearLevelFilterActionPerformed
        yearLevelFilter = !yearLevelFilter;
        if (yearLevelFilter) {
            btnYearLevelFilter.setBackground(Color.YELLOW);
        } else {
            btnYearLevelFilter.setBackground(Color.WHITE);
        }
        PopulateTable.student(tableStudents, courseFilter, comboCourse, yearLevelFilter, comboYearLevel);
    }//GEN-LAST:event_btnYearLevelFilterActionPerformed

    private void btnAddSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSaveActionPerformed
        if (saveState) {
            if (txtStudentId.getText().isBlank() || txtStudentName.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Enter a valid student ID and name!", "Input error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                try (MongoClient client = MongoClients.create("mongodb://localhost:27017")) {
                    MongoDatabase db = client.getDatabase("Enrollment");
                    MongoCollection<Document> collection = db.getCollection("Student");

                    Student student = new Student(
                            txtStudentId.getText().trim(),
                            txtStudentName.getText().trim(),
                            comboCourse.getSelectedItem().toString(),
                            comboYearLevel.getSelectedIndex() + 1
                    );

                    if (Student.getStudentById(db, student.getStudentId()) != null) {
                        JOptionPane.showMessageDialog(null, "A student with this ID already exists!", "Duplicate entry", JOptionPane.ERROR_MESSAGE);
                        txtStudentId.requestFocus();
                    } else if (Student.getStudentByName(db, student.getStudentName()) != null) {
                        JOptionPane.showMessageDialog(null, "A student with this name already exists!", "Duplicate entry", JOptionPane.ERROR_MESSAGE);
                        txtStudentName.requestFocus();
                    } else {
                        student.addStudent(db);
                        PopulateTable.student(tableStudents, courseFilter, comboCourse, yearLevelFilter, comboYearLevel);
                        JOptionPane.showMessageDialog(null, "Student added!", "Information", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            txtStudentId.setText("");
            txtStudentName.setText("");
            saveState = false;
            setSaveState();
        } else {
            saveState = true;
            setSaveState();
        }
    }//GEN-LAST:event_btnAddSaveActionPerformed

    private void comboCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCourseActionPerformed
        if (courseFilter) {
            PopulateTable.student(tableStudents, courseFilter, comboCourse, yearLevelFilter, comboYearLevel);
        }
    }//GEN-LAST:event_comboCourseActionPerformed

    private void comboYearLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboYearLevelActionPerformed
        if (yearLevelFilter) {
            PopulateTable.student(tableStudents, courseFilter, comboCourse, yearLevelFilter, comboYearLevel);
        }
    }//GEN-LAST:event_comboYearLevelActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try (MongoClient client = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase db = client.getDatabase("Enrollment");

            MongoCollection<Document> collection = db.getCollection("Student");
            String id = tableStudents.getValueAt(tableStudents.getSelectedRow(), 0).toString();
            Student s = Student.getStudentById(db, id);

            if (s.hasEnrollments(db)) {
                JOptionPane.showMessageDialog(null, "Remove this student's enrollments before deleting it!", "Enrollments exist", JOptionPane.ERROR_MESSAGE);
                return;
            }

            s.deleteStudent(db);
            PopulateTable.student(tableStudents, courseFilter, comboCourse, yearLevelFilter, comboYearLevel);
            JOptionPane.showMessageDialog(null, "Student deleted!", "Information", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnDeselectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeselectActionPerformed
        tableStudents.clearSelection();
    }//GEN-LAST:event_btnDeselectActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (txtStudentId.getText().isBlank() || txtStudentName.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Enter a valid student ID and name!", "Input error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (MongoClient client = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase db = client.getDatabase("Enrollment");

            MongoCollection<Document> collection = db.getCollection("Student");
            String oldId = tableStudents.getValueAt(tableStudents.getSelectedRow(), 0).toString();
            Student oldS = Student.getStudentById(db, oldId);
            Student newS = new Student(
                    txtStudentId.getText().trim(),
                    txtStudentName.getText().trim(),
                    comboCourse.getSelectedItem().toString(),
                    comboYearLevel.getSelectedIndex() + 1
            );

            if (!oldId.equals(newS.getStudentId()) && oldS.hasEnrollments(db)) {
                JOptionPane.showMessageDialog(null, "Remove this student's enrollments before updating it!", "Enrollments exist", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (Student.getStudentById(db, newS.getStudentId()) != null && !Student.getStudentById(db, newS.getStudentId()).equals(oldS)) {
                JOptionPane.showMessageDialog(null, "A student with this ID already exists!", "Duplicate entry", JOptionPane.ERROR_MESSAGE);
                txtStudentId.requestFocus();
                return;
            }
            if (Student.getStudentByName(db, newS.getStudentName()) != null && !Student.getStudentByName(db, newS.getStudentName()).equals(oldS)) {
                JOptionPane.showMessageDialog(null, "A student with this name already exists!", "Duplicate entry", JOptionPane.ERROR_MESSAGE);
                txtStudentName.requestFocus();
                return;
            }

            oldS.deleteStudent(db);
            newS.addStudent(db);
            PopulateTable.student(tableStudents, courseFilter, comboCourse, yearLevelFilter, comboYearLevel);
            JOptionPane.showMessageDialog(null, "Student updated!", "Information", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tableStudentsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableStudentsKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE) {
            btnDeleteActionPerformed(null);
        }
    }//GEN-LAST:event_tableStudentsKeyPressed

    private void tableSelectionChanged(ListSelectionEvent evt) {
        if (isAdjusting || evt.getValueIsAdjusting()) {
            return;
        }

        isAdjusting = true;

        if (tableStudents.getSelectedRow() >= 0) {
            int row = tableStudents.getSelectedRow();
            btnDeselect.setEnabled(true);
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
            btnCourseFilter.setEnabled(false);
            btnYearLevelFilter.setEnabled(false);
            btnAddSave.setEnabled(false);
            comboCourse.setEnabled(true);
            comboYearLevel.setEnabled(true);
            txtStudentId.setEnabled(true);
            txtStudentName.setEnabled(true);
            saveState = false;

            txtStudentId.setText(tableStudents.getValueAt(row, 0).toString());
            txtStudentName.setText(tableStudents.getValueAt(row, 1).toString());
            comboCourse.setSelectedItem(tableStudents.getValueAt(row, 2).toString());
            comboYearLevel.setSelectedItem(tableStudents.getValueAt(row, 3).toString());

            tableStudents.setRowSelectionInterval(row, row);
        } else {
            btnDeselect.setEnabled(false);
            btnUpdate.setEnabled(false);
            btnDelete.setEnabled(false);
            btnCourseFilter.setEnabled(true);
            btnYearLevelFilter.setEnabled(true);
            btnAddSave.setEnabled(true);
            setSaveState();

            txtStudentId.setText("");
            txtStudentName.setText("");
        }

        isAdjusting = false;
    }

    private void setSaveState() {
        if (saveState) {
            comboCourse.setEnabled(false);
            comboYearLevel.setEnabled(false);
            txtStudentId.setEnabled(true);
            txtStudentName.setEnabled(true);
            btnAddSave.setText("Save");
        } else {
            comboCourse.setEnabled(true);
            comboYearLevel.setEnabled(true);
            txtStudentId.setEnabled(false);
            txtStudentName.setEnabled(false);
            btnAddSave.setText("Add");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddSave;
    private javax.swing.JButton btnCourseFilter;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeselect;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnYearLevelFilter;
    private javax.swing.JComboBox<String> comboCourse;
    private javax.swing.JComboBox<String> comboYearLevel;
    private javax.swing.JLabel lblCourse;
    private javax.swing.JLabel lblStudentID;
    private javax.swing.JLabel lblStudentName;
    private javax.swing.JLabel lblStudentName1;
    private javax.swing.JLabel lblYearLevel;
    private javax.swing.JPanel panelCourse;
    private javax.swing.JPanel panelInputs;
    private javax.swing.JPanel panelSelected;
    private javax.swing.JPanel panelStudentID;
    private javax.swing.JPanel panelStudentName;
    private javax.swing.JPanel panelYearLevel;
    private javax.swing.JScrollPane scrollInfo;
    private javax.swing.JTable tableStudents;
    private javax.swing.JTextField txtStudentId;
    private javax.swing.JTextField txtStudentName;
    // End of variables declaration//GEN-END:variables
}
