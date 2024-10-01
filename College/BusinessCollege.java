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
public class BusinessCollege extends College {
    private int businessPrograms;
    
    public BusinessCollege (String collegeName, int totalStudents, int businessPrograms) {
        super(collegeName, totalStudents);
        this.businessPrograms = businessPrograms;
        
        fees = new ArrayList<>();
        fees.add(new Fee("Tuition Fee", 10000));
        fees.add(new Fee("Material and Resource Fee", 1000));
        fees.add(new Fee("Technology Fee", 500));
        fees.add(new Fee("Examination Fee", 800));
        fees.add(new Fee("Internship/Placement Fee", 1500));
    }
    
    @Override
    public void displayCollegeDetails() {
        System.out.println("Business College: " + collegeName);
        System.out.println("Total Students: " + totalStudents);
        System.out.println("Business Programs: " + businessPrograms);
    }
}
