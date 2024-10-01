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
public class EngineeringCollege extends College {
    private int engineeringPrograms;
    
    public EngineeringCollege (String collegeName, int totalStudents, int engineeringPrograms) {
        super(collegeName, totalStudents);
        this.engineeringPrograms = engineeringPrograms;
        
        fees = new ArrayList<>();
        fees.add(new Fee("Tuition Fee", 15000));
        fees.add(new Fee("Laboratory and Workshop Fee", 2500));
        fees.add(new Fee("Technology and Infrastructure Fee", 1200));
        fees.add(new Fee("Project and Research Fee", 1000));
        fees.add(new Fee("Industry Collaboration Fee", 1500));
    }
    
    @Override
    public void displayCollegeDetails() {
        System.out.println("Engineering College: " + collegeName);
        System.out.println("Total Students: " + totalStudents);
        System.out.println("Engineering Programs: " + engineeringPrograms);
    }
}
