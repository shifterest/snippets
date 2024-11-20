/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import com.mongodb.client.*;
import com.mongodb.client.model.*;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Delmoro-Ke
 */
public class Student {

    private int studentId;
    private String studentName;
    private String course;
    private int yearLevel;

    public Student(Integer studentId, String studentName, String course, Integer yearLevel) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.course = course;
        this.yearLevel = yearLevel;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Student s = (Student) obj;

        return studentId == s.studentId
                && yearLevel == s.yearLevel
                && studentName.equals(s.studentName)
                && course.equals(s.course);
    }

    public static Student fromDocument(Document doc) {
        if (doc == null) {
            return null;
        }

        int studentID = doc.getInteger("StudentID");
        String studentName = doc.getString("StudentName");
        String course = doc.getString("Course");
        int yearLevel = doc.getInteger("YearLevel");

        return new Student(studentID, studentName, course, yearLevel);
    }

    public Document toDocument() {
        Document doc = new Document();

        doc.append("StudentID", this.studentId);
        doc.append("StudentName", this.studentName);
        doc.append("Course", this.course);
        doc.append("YearLevel", this.yearLevel);

        return doc;
    }

    public static ArrayList<Student> getStudents(MongoDatabase db) {
        MongoCollection<Document> collection = db.getCollection("Student");
        ArrayList<Student> students = new ArrayList<>();

        for (Document doc : collection.find().sort(Sorts.ascending("StudentName"))) {
            Integer studentId = doc.getInteger("StudentID");
            String studentName = doc.getString("StudentName");
            String course = doc.getString("Course");
            int yearLevel = doc.getInteger("YearLevel");

            if (studentId == null || studentName == null) {
                continue;
            }
            students.add(new Student(studentId, studentName, course, yearLevel));
        }

        return students;
    }

    public static ArrayList<String> getStudentNames(MongoDatabase db) {
        MongoCollection<Document> collection = db.getCollection("Student");
        ArrayList<String> studentNames = new ArrayList<>();

        for (Document doc : collection.find().sort(Sorts.ascending("StudentName"))) {
            String studentName = doc.getString("StudentName");

            if (studentName == null) {
                continue;
            }
            studentNames.add(studentName);
        }

        return studentNames;
    }

    public static Student getStudentById(MongoDatabase db, int id) {
        MongoCollection<Document> collection = db.getCollection("Student");
        Document query = new Document("StudentID", id);

        return fromDocument(collection.find(query).first());
    }

    public static Student getStudentByName(MongoDatabase db, String name) {
        MongoCollection<Document> collection = db.getCollection("Student");
        Document query = new Document("StudentName", name);

        return fromDocument(collection.find(query).first());
    }

    public String getYearLevelString() {
        return switch (yearLevel) {
            case 1 ->
                "First year";
            case 2 ->
                "Second year";
            case 3 ->
                "Third year";
            case 4 ->
                "Fourth year";
            case 5 ->
                "Fifth year";
            default ->
                "Invalid year";
        };
    }

    public void addStudent(MongoDatabase db) {
        MongoCollection<Document> collection = db.getCollection("Student");

        collection.insertOne(this.toDocument());
    }

    public void deleteStudent(MongoDatabase db) {
        MongoCollection<Document> students = db.getCollection("Student");
        Document r = students.find(Filters.eq("StudentID", studentId)).first();
        if (r != null) {
            students.deleteOne(r);
        }
    }

    public boolean hasEnrollments(MongoDatabase db) {
        MongoCollection<Document> enrollments = db.getCollection("Enrollment");
        Document e = enrollments.find(Filters.eq("StudentID", studentId)).first();

        return e != null;
    }

    public ArrayList<Enrollment> getEnrollments(MongoDatabase db) {
        ArrayList<Enrollment> enrollmentsList = new ArrayList<>();

        MongoCollection<Document> enrollments = db.getCollection("Enrollment");
        FindIterable<Document> enrollmentsIter = enrollments.find(Filters.eq("StudentID", studentId));

        for (Document e : enrollmentsIter) {
            enrollmentsList.add(Enrollment.fromDocument(db, e));
        }

        return enrollmentsList;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
