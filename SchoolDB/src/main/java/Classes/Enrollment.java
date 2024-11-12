/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Delmoro-Ke
 */
public class Enrollment {

    private int studentId;
    private String subjectCode;
    private double grade;

    public Enrollment(int studentId, String subjectCode, double grade) {
        this.studentId = studentId;
        this.subjectCode = subjectCode;
        this.grade = grade;
    }

    public static Enrollment fromDocument(Document doc) {
        if (doc == null) {
            return null;
        }

        int studentId = doc.getInteger("StudentID");
        String subjectCode = doc.getString("SubjectCode");
        double grade = ((Number) doc.get("Grade")).doubleValue();

        return new Enrollment(studentId, subjectCode, grade);
    }

    public Document toDocument() {
        Document doc = new Document();

        doc.append("StudentID", this.studentId);
        doc.append("SubjectCode", this.subjectCode);
        doc.append("Grade", this.grade);

        return doc;
    }

    public static ArrayList<Enrollment> getEnrollments(MongoDatabase database) {
        MongoCollection<Document> collection = database.getCollection("Enrollment");
        ArrayList<Enrollment> enrollments = new ArrayList<>();

        for (Document doc : collection.find().sort(Sorts.ascending("StudentName"))) {
            Integer studentId = doc.getInteger("StudentID");
            String subjectCode = doc.getString("SubjectCode");
            double grade = ((Number) doc.get("Grade")).doubleValue();

            if (studentId == null) {
                continue;
            }
            enrollments.add(new Enrollment(studentId, subjectCode, grade));
        }

        return enrollments;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

}
