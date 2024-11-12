/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import static Classes.Student.fromDocument;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Delmoro-Ke
 */
public class Subject {
    private String subjectCode;
    private String description;
    private double units;

    public Subject(String subjectCode, String description, double units) {
        this.subjectCode = subjectCode;
        this.description = description;
        this.units = units;
    }
    
    public static Subject fromDocument (Document doc) {
        if (doc == null) return null;
        
        String subjectCode = doc.getString ("SubjectCode");
        String description = doc.getString ("Description");
        double units = ((Number) doc.get ("Units")).doubleValue();
        
        return new Subject (subjectCode, description, units);
    }
    
    public Document toDocument() {
        Document doc = new Document();
        
        doc.append ("SubjectCode", this.subjectCode);
        doc.append ("Description", this.description);
        doc.append ("Units", this.units);
        
        return doc;
    }
    
    public static ArrayList<Subject> getSubjects (MongoDatabase database) {
        MongoCollection<Document> collection = database.getCollection("Subject");
        ArrayList<Subject> subjects = new ArrayList<>();

        for (Document doc : collection.find().sort(Sorts.ascending("SubjectCode"))) {
            String subjectCode = doc.getString("SubjectCode");
            String description = doc.getString("Description");
            double units = ((Number) doc.get ("Units")).doubleValue();

            if (subjectCode == null) continue;
            subjects.add(new Subject (subjectCode, description, units));
        }

        return subjects;
    }
    
    public static ArrayList<String> getSubjectCodes (MongoDatabase database) {
        MongoCollection<Document> collection = database.getCollection("Subject");
        ArrayList<String> subjectCodes = new ArrayList<>();
        
        for (Document doc : collection.find().sort(Sorts.ascending("SubjectCode"))) {
            String subjectCode = doc.getString("SubjectCode");
            
            if (subjectCode == null) continue;
            subjectCodes.add (subjectCode);
        }
        
        return subjectCodes;
    }
    
    public static ArrayList<String> getSubjectDescs (MongoDatabase database) {
        MongoCollection<Document> collection = database.getCollection("Subject");
        ArrayList<String> subjectDescs = new ArrayList<>();
        
        for (Document doc : collection.find().sort(Sorts.ascending("Description"))) {
            String subjectDesc = doc.getString("Description");
            
            if (subjectDesc == null) continue;
            subjectDescs.add (subjectDesc);
        }
        
        return subjectDescs;
    }
    
    public static Subject getSubjectByCode (MongoDatabase database, String code) {
        MongoCollection<Document> collection = database.getCollection("Subject");
        Document query = new Document ("SubjectCode", code);
        
        return fromDocument (collection.find(query).first());
    }
    
    public static Subject getSubjectByDesc (MongoDatabase database, String desc) {
        MongoCollection<Document> collection = database.getCollection("Subject");
        Document query = new Document ("Description", desc);
        
        return fromDocument (collection.find(query).first());
    }

    public double getUnits() {
        return units;
    }

    public void setUnits(double units) {
        this.units = units;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
