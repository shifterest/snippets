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
public abstract class College {
    protected String collegeName;
    protected int totalStudents;
    private double totalExpenses;
    protected ArrayList<Fee> fees;
    
    public College (String collegeName, int totalStudents) {
        this.collegeName = collegeName;
        this.totalStudents = totalStudents;
    }
    
    public abstract void displayCollegeDetails();
    
    public void welcomeMessage() {
        System.out.println ("Welcome to " + collegeName + "!");
    }
    
    public double calculateFees() {
        double total = 0;
        
        for (int i = 0; i < fees.size(); i++) {
            System.out.println(fees.get(i).getFee() + ": $" + fees.get(i).getRate() * totalStudents);
            total += fees.get(i).getRate() * totalStudents;
        }
        
        return total;
    }

    public String getCollegeName() {
        return collegeName;
    }
    
    public ArrayList<Fee> getFees() {
        return fees;
    }
}
