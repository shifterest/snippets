/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.bson.Document;
import org.bson.conversions.Bson;

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

    public static ArrayList<Enrollment> getEnrollments(MongoDatabase db) {
        MongoCollection<Document> collection = db.getCollection("Enrollment");
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
    
    public static Enrollment getEnrollment(MongoDatabase database, int id, String code) {
        MongoCollection<Document> collection = database.getCollection("Student");
        Document query = new Document("StudentID", id).append("SubjectCode", code);

        return fromDocument(collection.find(query).first());
    }

    public void addEnrollment(MongoDatabase db) {
        MongoCollection<Document> collection = db.getCollection("Enrollment");

        Bson filters = Filters.and(Filters.eq("StudentID", studentId), Filters.eq("SubjectCode", subjectCode));
        Document result = collection.find(filters).first();
        
        if (result != null) {
//            JOptionPane.showMessageDialog(null, "Enrollment already exists for this student in this course!", "Error", JOptionPane.ERROR_MESSAGE);
            Enrollment existingEnrollment = fromDocument(result);
            if (grade == existingEnrollment.getGrade()) {
                JOptionPane.showMessageDialog(null, "Nothing to update.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Bson updates = Updates.set("Grade", grade);
                collection.updateOne(filters, updates);
                JOptionPane.showMessageDialog(null, "Enrollment updated.", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            return;
        }

        collection.insertOne(this.toDocument());
        JOptionPane.showMessageDialog(null, "Enrollment added.", "Information", JOptionPane.INFORMATION_MESSAGE);
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
