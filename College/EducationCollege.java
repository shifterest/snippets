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
public class EducationCollege extends College {
    private int educationPrograms;
    
    public EducationCollege (String collegeName, int totalStudents, int educationPrograms) {
        super(collegeName, totalStudents);
        this.educationPrograms = educationPrograms;
        
        fees = new ArrayList<>();
        fees.add(new Fee("Tuition Fee", 8000));
        fees.add(new Fee("Library and Resource Fee", 800));
        fees.add(new Fee("Field Trip Fee", 300));
        fees.add(new Fee("Student Association Fee", 200));
        fees.add(new Fee("Examination and Assessment Fee", 700));
    }
    
    @Override
    public void displayCollegeDetails() {
        System.out.println("Educaiton College: " + collegeName);
        System.out.println("Total Students: " + totalStudents);
        System.out.println("Education Programs: " + educationPrograms);
    }
}
