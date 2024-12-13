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

    public static double GPA(String studentName, String semesterName, String schoolYear) {
        if (studentName != null) {
            try (MongoClient client = MongoClients.create("mongodb://localhost:27017")) {
                MongoDatabase db = client.getDatabase("Enrollment");
                Student student = Student.getStudentByName(db, studentName);
                if (student != null) {
                    double wg = 0.0;
                    double units = 0.0;
                    Student stud = Student.getStudentByName(db, studentName);
                    Semester sem = Semester.getSemesterByNameYear(db, semesterName, schoolYear);
                    Enrollment e = Enrollment.getEnrollmentByStudent(
                            db, stud != null ? stud.getStudentId() : null, sem != null ? sem.getSemesterId() : -1
                    );
                    for (int i = 0; i < e.getSubjects().size(); i++) {
                        Subject s = e.getSubjects().get(i);
                        wg += e.getGrades().get(i) * s.getUnits();
                        units += s.getUnits();
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
