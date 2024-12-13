package Utilities;

import Classes.*;
import com.mongodb.client.*;
import javax.swing.event.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Delmoro-Ke
 */
public class StudentIDListener implements DocumentListener {

    private final javax.swing.JComboBox<String> combo;
    private final javax.swing.JTable table;

    public StudentIDListener(javax.swing.JComboBox<String> combo, javax.swing.JTable table) {
        this.combo = combo;
        this.table = table;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
//        setComboStudentName(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
//        setComboStudentName(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
//        setComboStudentName(e);
    }

//    private void setComboStudentName(DocumentEvent e) {
//        try (MongoClient client = MongoClients.create("mongodb://localhost:27017")) {
//            MongoDatabase db = client.getDatabase("Enrollment");
//
//            String text = e.getDocument().getText(0, e.getDocument().getLength()).trim();
//            Student student = (text.isEmpty()) ? null : Student.getStudentById(db, text);
//
//            combo.setSelectedItem(student == null ? "" : student.getStudentName());
//            
//            PopulateTable.grade(table, student.getStudentName());
//        } catch (Exception error) {
//            error.printStackTrace();
//        }
//    }
}
