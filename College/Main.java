/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package college;

import java.util.Scanner;

/**
 *
 * @author Delmoro-Ke
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner (System.in);
        
        BusinessCollege bc;
        EducationCollege ec;
        MedicalCollege mc;
        EngineeringCollege enc;
        
        while (true) {
            System.out.println ("COLLEGE FEE SYSTEM");
            System.out.println ("1. Business College");
            System.out.println ("2. Education College");
            System.out.println ("3. Medical College");
            System.out.println ("4. Engineering College");
            System.out.println ("5. Exit");
            System.out.print ("\nEnter your choice: ");
            
            int c = s.nextInt();
            
            switch (c) {
                case 1:
                    System.out.print ("Enter number of students for Business College: ");
                    int bc_n = s.nextInt();
                    bc = new BusinessCollege("College of Business Administration", bc_n, 10);
                    System.out.println();
                    bc.welcomeMessage();
                    bc.displayCollegeDetails();
                    System.out.println();
                    System.out.println ("Total Fees: $" + bc.calculateFees() + "\n");
                    break;
                case 2:
                    System.out.print ("Enter number of students for Education College: ");
                    int ec_n = s.nextInt();
                    ec = new EducationCollege("College of Education", ec_n, 8);
                    System.out.println();
                    ec.welcomeMessage();
                    ec.displayCollegeDetails();
                    System.out.println();
                    System.out.println ("Total Fees: $" + ec.calculateFees() + "\n");
                    break;
                case 3:
                    System.out.print ("Enter number of students for Medical College: ");
                    int mc_n = s.nextInt();
                    mc = new MedicalCollege("College of Arts and Sciences", mc_n, 12);
                    System.out.println();
                    mc.welcomeMessage();
                    mc.displayCollegeDetails();
                    System.out.println();
                    System.out.println ("Total Fees: $" + mc.calculateFees() + "\n");
                case 4:
                    System.out.print ("Enter number of students for Engineering College: ");
                    int enc_n = s.nextInt();
                    enc = new EngineeringCollege("College of Engineering, Architecture, and Computing", enc_n, 15);
                    System.out.println();
                    enc.welcomeMessage();
                    enc.displayCollegeDetails();
                    System.out.println();
                    System.out.println ("Total Fees: $" + enc.calculateFees() + "\n");
                case 5:
                    System.exit(0);
            }
        }
    }
    
}
