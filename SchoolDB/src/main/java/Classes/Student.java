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

    public static ArrayList<Student> getStudents(MongoDatabase database) {
        MongoCollection<Document> collection = database.getCollection("Student");
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

    public static ArrayList<String> getStudentNames(MongoDatabase database) {
        MongoCollection<Document> collection = database.getCollection("Student");
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

    public static Student getStudentById(MongoDatabase database, int id) {
        MongoCollection<Document> collection = database.getCollection("Student");
        Document query = new Document("StudentID", id);

        return fromDocument(collection.find(query).first());
    }

    public static Student getStudentByName(MongoDatabase database, String name) {
        MongoCollection<Document> collection = database.getCollection("Student");
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

        Bson filters = Filters.or(Filters.eq("StudentID", studentId), Filters.eq("StudentName", studentName));
        Document result = collection.find(filters).first(); 
        
        if (result != null) {
//            JOptionPane.showMessageDialog(null, "Student already exists!", "Error", JOptionPane.ERROR_MESSAGE);
            Student existingStudent = fromDocument(result);
            if (course.equals(existingStudent.getCourse()) && yearLevel == existingStudent.getYearLevel()) {
                JOptionPane.showMessageDialog(null, "Nothing to update.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Bson updates = Updates.combine(Updates.set("Course", course), Updates.set("YearLevel", yearLevel));
                collection.updateOne(filters, updates);
                JOptionPane.showMessageDialog(null, "Student updated.", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            return;
        }

        collection.insertOne(this.toDocument());
        JOptionPane.showMessageDialog(null, "Student added.", "Information", JOptionPane.INFORMATION_MESSAGE);
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
