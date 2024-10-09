/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CircularQueue;

import java.util.Scanner;

/**
 *
 * @author Delmoro-Ke
 */
public class Main {
    public static void main (String [] args) {
        Scanner ror = new Scanner (System.in);
        Queue q = new Queue();
        
        System.out.println ("Options:");
        System.out.println ("1 - Add an element to the queue");
        System.out.println ("2 - Remove an element from the queue");
        System.out.println ("3 - Count elements in the queue");
        System.out.println ("4 - Display circular Queue");
        System.out.println ("5 - Exit the program");
        System.out.println ("");
        
        while (true) {
            System.out.print ("Enter your option: ");
            int choice = ror.nextInt(); ror.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print ("Enter the element to add: ");
                    q.enQueue (ror.nextInt()); ror.nextLine();
                    System.out.println();
                    break;
                case 2:
                    q.deQueue();
                    System.out.println();
                    break;
                case 3:
                    q.displayCount();
                    System.out.println();
                    break;
                case 4:
                    q.display();
                    System.out.println();
                    break;
                case 5:
                    System.out.println ("Exiting the program.");
                    System.exit (0);
            }
        }
    }
}