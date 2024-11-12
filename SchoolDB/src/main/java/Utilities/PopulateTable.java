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

    public static void subject(javax.swing.JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        try (MongoClient client = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase db = client.getDatabase("Enrollment");

            ArrayList<Subject> subjects = Subject.getSubjects(db);
            for (Subject s : subjects) {
                String[] row = new String[]{
                    s.getSubjectCode(),
                    s.getDescription(),
                    String.format("%.1f", s.getUnits())
                };

                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void student(javax.swing.JTable table, boolean courseFilter, javax.swing.JComboBox<String> comboCourse, boolean yearLevelFilter, javax.swing.JComboBox<String> comboYearLevel) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        try (MongoClient client = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase db = client.getDatabase("Enrollment");

            ArrayList<Student> students = Student.getStudents(db);
            for (Student s : students) {
                if (courseFilter && !s.getCourse().equals(comboCourse.getSelectedItem().toString())) {
                    continue;
                }
                if (yearLevelFilter && !s.getYearLevelString().equals(comboYearLevel.getSelectedItem().toString())) {
                    continue;
                }

                String[] row = new String[]{
                    Integer.toString(s.getStudentId()),
                    s.getStudentName(),
                    s.getCourse(),
                    s.getYearLevelString()
                };

                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void grade(javax.swing.JTable table, javax.swing.JComboBox<String> comboStudentName) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        if (comboStudentName.getSelectedItem() == null) {
            return;
        }

        try (MongoClient client = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase db = client.getDatabase("Enrollment");

            Student student = Student.getStudentByName(db, comboStudentName.getSelectedItem().toString());
            if (student != null) {
                ArrayList<Enrollment> enrollments = Enrollment.getEnrollments(db);
                for (Enrollment e : enrollments) {
                    if (e.getStudentId() == student.getStudentId()) {
                        Subject subject = Subject.getSubjectByCode(db, e.getSubjectCode());

                        String[] row = new String[]{
                            e.getSubjectCode(),
                            subject.getDescription(),
                            String.format("%.1f", subject.getUnits()),
                            String.format("%.2f", e.getGrade())
                        };

                        model.addRow(row);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
