/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package college;

import java.util.ArrayList;

/**
 *
 * @author Delmoro-Ke
 */
public class MedicalCollege extends College {
    private int medicalPrograms;
    
    public MedicalCollege (String collegeName, int totalStudents, int medicalPrograms) {
        super(collegeName, totalStudents);
        this.medicalPrograms = medicalPrograms;
        
        fees = new ArrayList<>();
        fees.add(new Fee("Tuition Fee", 12000));
        fees.add(new Fee("Laboratory and Equipment Fee", 2000));
        fees.add(new Fee("Clinical Placement Fee", 1500));
        fees.add(new Fee("Medical Insurance Fee", 1200));
        fees.add(new Fee("Researh and Publication Fee", 1000));
    }
    
    @Override
    public void displayCollegeDetails() {
        System.out.println("Medical College: " + collegeName);
        System.out.println("Total Students: " + totalStudents);
        System.out.println("Medical Programs: " + medicalPrograms);
    }
}
