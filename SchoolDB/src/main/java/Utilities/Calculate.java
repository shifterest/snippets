/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import Classes.*;
import com.mongodb.client.*;
import java.util.ArrayList;

/**
 *
 * @author candy
 */
public class Calculate {

    public static double GPA(String studentName) {
        if (studentName != null) {
            try (MongoClient client = MongoClients.create("mongodb://localhost:27017")) {
                MongoDatabase db = client.getDatabase("Enrollment");
                Student student = Student.getStudentByName(db, studentName);
                if (student != null) {
                    double wg = 0.0;
                    double units = 0.0;
                    ArrayList<Enrollment> enrollments = Enrollment.getEnrollments(db);
                    for (Enrollment e : enrollments) {
                        if (e.getStudent().getStudentId() == student.getStudentId()) {
                            Subject s = Subject.getSubjectByCode(db, e.getSubject().getSubjectCode());
                            wg += e.getGrade() * s.getUnits();
                            units += s.getUnits();
                        }
                    }
                    return wg / units;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1.0;
    }
}
