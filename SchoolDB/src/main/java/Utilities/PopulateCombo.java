package Utilities;

import Classes.*;
import com.mongodb.client.*;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author candy
 */
public class PopulateCombo {
    public static void studentName(javax.swing.JComboBox<String> comboStudentName) {
        Object curr = comboStudentName.getSelectedItem();
        comboStudentName.removeAllItems();
        comboStudentName.addItem("");

        try (MongoClient client = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase db = client.getDatabase("Enrollment");

            ArrayList<String> names = Student.getStudentNames(db);
            for (String name : names) {
                comboStudentName.addItem(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        comboStudentName.setSelectedItem(curr);
    }
    
    public static void subjectCode(javax.swing.JComboBox<String> comboSubjectCode) {
        Object curr = comboSubjectCode.getSelectedItem();
        comboSubjectCode.removeAllItems();
        comboSubjectCode.addItem("");

        try (MongoClient client = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase db = client.getDatabase("Enrollment");

            ArrayList<String> codes = Subject.getSubjectCodes(db);
            for (String code : codes) {
                comboSubjectCode.addItem(code);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        comboSubjectCode.setSelectedItem(curr);
    }
    
    public static void subjectDesc(javax.swing.JComboBox<String> comboSubjectDesc) {
        Object curr = comboSubjectDesc.getSelectedItem();
        comboSubjectDesc.removeAllItems();
        comboSubjectDesc.addItem("");

        try (MongoClient client = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase db = client.getDatabase("Enrollment");

            ArrayList<String> descs = Subject.getSubjectDescs(db);
            for (String desc : descs) {
                comboSubjectDesc.addItem(desc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        comboSubjectDesc.setSelectedItem(curr);
    }
}
