package Utilities;

import Classes.Student;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

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
        setComboStudentName(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        setComboStudentName(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        setComboStudentName(e);
    }

    private void setComboStudentName(DocumentEvent e) {
        try (MongoClient client = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase db = client.getDatabase("Enrollment");

            String text = e.getDocument().getText(0, e.getDocument().getLength()).trim();
            Student student = (text.isEmpty()) ? null : Student.getStudentById(db, Integer.parseInt(text));

            combo.setSelectedItem((student == null) ? "" : student.getStudentName());
        } catch (Exception error) {
            error.printStackTrace();
        }
        
        PopulateTable.grade(table, combo);
    }
}
