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
public class Student {
    private Integer studentID;
    private String studentName;
    private String course;
    private Integer yearLevel;

    public Student(Integer studentID, String studentName, String course, Integer yearLevel) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.course = course;
        this.yearLevel = yearLevel;
    }
    
    public static Student fromDocument (Document doc) {
        if (doc == null) return null;
        
        Integer studentID = doc.getInteger("StudentID");
        String studentName = doc.getString("StudentName");
        String course = doc.getString("Course");
        Integer yearLevel = doc.getInteger("YearLevel");
        
        return new Student (studentID, studentName, course, yearLevel);
    }
    
    public Document toDocument() {
        Document doc = new Document();
        
        doc.append ("StudentID", this.studentID);
        doc.append ("StudentName", this.studentName);
        doc.append ("Course", this.course);
        doc.append ("YearLevel", this.yearLevel);
        
        return doc;
    }
    
    public static ArrayList<Student> getStudents (MongoDatabase database) {
        MongoCollection<Document> collection = database.getCollection("Student");
        ArrayList<Student> students = new ArrayList<>();
        
        for (Document doc : collection.find().sort(Sorts.ascending("StudentName"))) {
            Integer studentID = doc.getInteger("StudentID");
            String studentName = doc.getString("StudentName");
            String course = doc.getString("Course");
            Integer yearLevel = doc.getInteger("YearLevel");
            
            if (studentID == null || studentName == null) continue;
            students.add (new Student (studentID, studentName, course, yearLevel));
        }
        
        return students;
    }
    
    public static ArrayList<String> getStudentNames (MongoDatabase database) {
        MongoCollection<Document> collection = database.getCollection("Student");
        ArrayList<String> studentNames = new ArrayList<>();
        
        for (Document doc : collection.find().sort(Sorts.ascending("StudentName"))) {
            String studentName = doc.getString("StudentName");
            
            if (studentName == null) continue;
            studentNames.add (studentName);
        }
        
        return studentNames;
    }
    

    public Integer getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(Integer yearLevel) {
        this.yearLevel = yearLevel;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
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
