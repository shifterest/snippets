/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import com.mongodb.client.*;
import com.mongodb.client.model.*;
import java.util.ArrayList;
import javax.swing.*;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Delmoro-Ke
 */
public class Enrollment {

    private Student student;
    private Subject subject;
    private double grade;

    public Enrollment(Student student, Subject subject, double grade) {
        this.student = student;
        this.subject = subject;
        this.grade = grade;
    }

    public static Enrollment fromDocument(MongoDatabase db, Document doc) {
        if (doc == null) {
            return null;
        }

        Student student = Student.getStudentById(db, doc.getString("StudentID"));
        Subject subject = Subject.getSubjectByCode(db, doc.getString("SubjectCode"));
        double grade = ((Number) doc.get("Grade")).doubleValue();

        return new Enrollment(student, subject, grade);
    }

    public Document toDocument() {
        Document doc = new Document();

        doc.append("StudentID", this.student.getStudentId());
        doc.append("SubjectCode", this.subject.getSubjectCode());
        doc.append("Grade", this.grade);

        return doc;
    }

    public static ArrayList<Enrollment> getEnrollments(MongoDatabase db) {
        MongoCollection<Document> collection = db.getCollection("Enrollment");
        ArrayList<Enrollment> enrollments = new ArrayList<>();

        for (Document doc : collection.find().sort(Sorts.ascending("StudentName"))) {
            Student student = Student.getStudentById(db, doc.getString("StudentID"));
            Subject subject = Subject.getSubjectByCode(db, doc.getString("SubjectCode"));
            double grade = ((Number) doc.get("Grade")).doubleValue();

            if (student == null) {
                continue;
            }
            enrollments.add(new Enrollment(student, subject, grade));
        }

        return enrollments;
    }

    public static Enrollment getEnrollment(MongoDatabase db, int id, String code) {
        MongoCollection<Document> collection = db.getCollection("Student");
        Document query = new Document("StudentID", id).append("SubjectCode", code);

        return fromDocument(db, collection.find(query).first());
    }

    public void addEnrollment(MongoDatabase db) {
        MongoCollection<Document> collection = db.getCollection("Enrollment");

        Bson filters = Filters.and(Filters.eq("StudentID", student.getStudentId()), Filters.eq("SubjectCode", subject.getSubjectCode()));
        Document result = collection.find(filters).first();

        if (result != null) {
//            JOptionPane.showMessageDialog(null, "Enrollment already exists for this student in this course!", "Error", JOptionPane.ERROR_MESSAGE);
            Enrollment existingEnrollment = fromDocument(db, result);
            if (grade == existingEnrollment.getGrade()) {
                JOptionPane.showMessageDialog(null, "Nothing to update!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Bson updates = Updates.set("Grade", grade);
                collection.updateOne(filters, updates);
                JOptionPane.showMessageDialog(null, "Enrollment updated!", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            return;
        }

        collection.insertOne(this.toDocument());
        JOptionPane.showMessageDialog(null, "Enrollment added!", "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

}
