/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import Classes.Enrollment;
import Classes.Student;
import Classes.Subject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Delmoro-Ke
 */
public class PopulateTable {

    /**
     *
     * @param tableGrades
     * @param comboStudentName
     */
    public static void populateGradeTable (javax.swing.JTable tableGrades, javax.swing.JComboBox<String> comboStudentName) {
        DefaultTableModel model = (DefaultTableModel) tableGrades.getModel();
        model.setRowCount(0);
        
        if (comboStudentName.getSelectedItem() == null) return;
        
        try (MongoClient client = MongoClients.create ("mongodb://localhost:27017")) {
            MongoDatabase db = client.getDatabase ("Enrollment");
            
            Student student = Student.getStudentByName (db, comboStudentName.getSelectedItem().toString());
            ArrayList<Enrollment> enrollments = Enrollment.getEnrollments(db);
            for (Enrollment e : enrollments) {
                if (e.getStudentId() == student.getStudentId()) {
                    Subject subject = Subject.getSubjectByCode (db, e.getSubjectCode());

                    String[] row = new String[] {
                        e.getSubjectCode(),
                        subject.getDescription(),
                        String.format("%.1f", subject.getUnits()),
                        String.format("%.2f", e.getGrade())
                    };

                    model.addRow(row);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
