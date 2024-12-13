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
public class Semester {

    private int semesterId;
    private String semesterName;
    private String schoolYear;

    public Semester(int semesterId, String semesterName, String schoolYear) {
        this.semesterId = semesterId;
        this.semesterName = semesterName;
        this.schoolYear = schoolYear;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Semester s = (Semester) obj;

        return semesterId == s.semesterId
                && semesterName.equals(s.semesterName)
                && schoolYear.equals(s.schoolYear);
    }

    public static Semester fromDocument(Document doc) {
        if (doc == null) {
            return null;
        }

        int semesterId = doc.getInteger("SemesterID");
        String semesterName = doc.getString("SemesterName");
        String schoolYear = doc.getString("SchoolYear");

        return new Semester(semesterId, semesterName, schoolYear);
    }

    public Document toDocument() {
        Document doc = new Document();

        doc.append("SemesterID", this.semesterId);
        doc.append("SemesterName", this.semesterName);
        doc.append("SchoolYear", this.schoolYear);

        return doc;
    }

    public static ArrayList<Semester> getSemesters(MongoDatabase db) {
        MongoCollection<Document> collection = db.getCollection("Semester");
        ArrayList<Semester> semesters = new ArrayList<>();

        for (Document doc : collection.find().sort(Sorts.ascending("SemesterID"))) {
            semesters.add(fromDocument(doc));
        }

        return semesters;
    }

    public static ArrayList<String> getUniqueSemesterNamesByYear(MongoDatabase db) {
        MongoCollection<Document> collection = db.getCollection("Semester");
        ArrayList<String> names = new ArrayList<>();

        for (Document doc : collection.find().sort(Sorts.ascending("SemesterID"))) {
            String semesterName = doc.getString("SemesterName");

            if (semesterName == null || names.contains(semesterName)) {
                continue;
            }
            names.add(semesterName);
        }

        return names;
    }

    public static ArrayList<String> getUniqueSchoolYears(MongoDatabase db) {
        MongoCollection<Document> collection = db.getCollection("Semester");
        ArrayList<String> schoolYears = new ArrayList<>();

        for (Document doc : collection.find().sort(Sorts.ascending("SemesterID"))) {
            String schoolYear = doc.getString("SchoolYear");

            if (schoolYear == null || schoolYears.contains(schoolYear)) {
                continue;
            }
            schoolYears.add(schoolYear);
        }

        return schoolYears;
    }

    public static Semester getSemesterById(MongoDatabase db, int id) {
        MongoCollection<Document> collection = db.getCollection("Semester");
        Document query = new Document("SemesterID", id);

        return fromDocument(collection.find(query).first());
    }

    public static Semester getSemesterByNameYear(MongoDatabase db, String name, String year) {
        MongoCollection<Document> collection = db.getCollection("Semester");
        Document query = new Document("SemesterName", name).append("SchoolYear", year);

        return fromDocument(collection.find(query).first());
    }

    public void addSemester(MongoDatabase db) {
        MongoCollection<Document> collection = db.getCollection("Semester");

        collection.insertOne(this.toDocument());
    }

    public void deleteStudent(MongoDatabase db) {
        MongoCollection<Document> students = db.getCollection("Semester");
        Document r = students.find(Filters.eq("SemesterID", semesterId)).first();
        if (r != null) {
            students.deleteOne(r);
        }
    }

    public boolean hasEnrollments(MongoDatabase db) {
        MongoCollection<Document> enrollments = db.getCollection("Enrollment");
        Document e = enrollments.find(Filters.eq("SemesterID", semesterId)).first();

        return e != null;
    }

    public ArrayList<Enrollment> getEnrollments(MongoDatabase db) {
        ArrayList<Enrollment> enrollmentsList = new ArrayList<>();

        MongoCollection<Document> enrollments = db.getCollection("Enrollment");
        FindIterable<Document> enrollmentsIter = enrollments.find(Filters.eq("SemesterID", semesterId));

        for (Document e : enrollmentsIter) {
            enrollmentsList.add(Enrollment.fromDocument(db, e));
        }

        return enrollmentsList;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

}
