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

    public StudentIDListener (javax.swing.JComboBox<String> combo) {
        this.combo = combo;
    }

    @Override
    public void insertUpdate (DocumentEvent e) {
        setComboStudentName(e);
    }

    @Override
    public void removeUpdate (DocumentEvent e) {
        setComboStudentName(e);
    }

    @Override
    public void changedUpdate (DocumentEvent e) {
        setComboStudentName(e);
    }

    private void setComboStudentName(DocumentEvent e) {        
        try (MongoClient client = MongoClients.create ("mongodb://localhost:27017")) {
            MongoDatabase db = client.getDatabase ("Enrollment");
            
            Student student = Student.getStudentById(db, Integer.parseInt(
                e.getDocument().getText(0, e.getDocument().getLength()).trim()
            ));
        
        if (student == null)
            combo.setSelectedItem(null);
        else
            combo.setSelectedItem(student.getStudentName());
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}
