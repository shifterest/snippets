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

    private int enrollmentId;
    private Student student;
    private Semester semester;
    private ArrayList<Subject> subjects;
    private ArrayList<Double> grades;

    public Enrollment(int enrollmentId, Student student, Semester semester, ArrayList<Subject> subjects, ArrayList<Double> grades) {
        this.enrollmentId = enrollmentId;
        this.student = student;
        this.semester = semester;
        this.subjects = subjects;
        this.grades = grades;
    }

    public static Enrollment fromDocument(MongoDatabase db, Document doc) {
        if (doc == null) {
            return null;
        }
        
        int enrollmentId = doc.getInteger("EnrollmentID");
        Student student = Student.getStudentById(db, doc.getString("StudentID"));
        Semester semester = Semester.getSemesterById(db, doc.getInteger("SemesterID"));
        ArrayList<String> subjectCodes = (ArrayList) doc.getList("SubjectCodes", String.class);
        ArrayList<Subject> subjects = new ArrayList<Subject>();
        ArrayList<Double> grades = new ArrayList<>();
        doc.getList("Grades", Object.class).forEach((grade) -> grades.add(((Number) grade).doubleValue()));
        
        for (String code : subjectCodes) {
            subjects.add(Subject.getSubjectByCode(db, code));
        }

        return new Enrollment(enrollmentId, student, semester, subjects, grades);
    }

    public Document toDocument() {
        Document doc = new Document();
        
        ArrayList<String> subjectsToDoc = new ArrayList<String>();
        for (Subject subject : subjects) {
            subjectsToDoc.add(subject.getSubjectCode());
        }

        doc.append("EnrollmentID", this.enrollmentId);
        doc.append("StudentID", this.student.getStudentId());
        doc.append("SemesterID", this.semester.getSemesterId());
        doc.append("SubjectCodes", subjectsToDoc);
        doc.append("Grades", this.grades);

        return doc;
    }

    public static ArrayList<Enrollment> getEnrollments(MongoDatabase db) {
        MongoCollection<Document> collection = db.getCollection("Enrollment");
        ArrayList<Enrollment> enrollments = new ArrayList<>();

        for (Document doc : collection.find().sort(Sorts.ascending("StudentName"))) {
            enrollments.add(fromDocument(db, doc));
        }

        return enrollments;
    }

    public static Enrollment getEnrollmentByStudent(MongoDatabase db, String studentId, int semesterId) {
        if (studentId == null) {
            return null;
        }
        MongoCollection<Document> collection = db.getCollection("Enrollment");
        Document query = new Document("StudentID", studentId);
        if (semesterId != -1) {
            query.append("SemesterID", semesterId);
        }

        return fromDocument(db, collection.find(query).first());
    }

    public void addEnrollment(MongoDatabase db) {
//        MongoCollection<Document> collection = db.getCollection("Enrollment");
//
//        Bson filters = Filters.and(Filters.eq("StudentID", student.getStudentId()), Filters.eq("SubjectCode", subject.getSubjectCode()));
//        Document result = collection.find(filters).first();
//
//        if (result != null) {
////            JOptionPane.showMessageDialog(null, "Enrollment already exists for this student in this course!", "Error", JOptionPane.ERROR_MESSAGE);
//            Enrollment existingEnrollment = fromDocument(db, result);
//            if (grade == existingEnrollment.getGrade()) {
//                JOptionPane.showMessageDialog(null, "Nothing to update!", "Error", JOptionPane.ERROR_MESSAGE);
//            } else {
//                Bson updates = Updates.set("Grade", grade);
//                collection.updateOne(filters, updates);
//                JOptionPane.showMessageDialog(null, "Enrollment updated!", "Information", JOptionPane.INFORMATION_MESSAGE);
//            }
//            return;
//        }
//
//        collection.insertOne(this.toDocument());
//        JOptionPane.showMessageDialog(null, "Enrollment added!", "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    public int getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(int enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    public ArrayList<Double> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Double> grades) {
        this.grades = grades;
    }
}
