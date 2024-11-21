/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import Classes.*;
import com.mongodb.client.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Delmoro-Ke
 */
public class PopulateTable {

    public static void subject(JTable table) {
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

    public static void student(JTable table, boolean courseFilter, JComboBox<String> comboCourse, boolean yearLevelFilter, JComboBox<String> comboYearLevel) {
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
                    s.getStudentId(),
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

    public static void grade(JTable table, String studentName) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        if (studentName == null) {
            return;
        }

        try (MongoClient client = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase db = client.getDatabase("Enrollment");

            Student student = Student.getStudentByName(db, studentName);
            if (student != null) {
                ArrayList<Enrollment> enrollments = Enrollment.getEnrollments(db);
                for (Enrollment e : enrollments) {
                    if (e.getStudent().getStudentId().equals(student.getStudentId())) {
                        Subject subject = Subject.getSubjectByCode(db, e.getSubject().getSubjectCode());

                        String[] row = new String[]{
                            e.getSubject().getSubjectCode(),
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
