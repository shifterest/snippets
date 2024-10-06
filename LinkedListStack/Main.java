import java.util.Scanner;

public class Main {
    public static void main (String [] args) {
        Scanner scan = new Scanner (System.in);
        StackUsingLinkedList stack = new StackUsingLinkedList();
        
        System.out.println ("Stack Operations Menu:");
        System.out.println ("1. Push");
        System.out.println ("2. Pop");
        System.out.println ("3. Peek");
        System.out.println ("4. Display Stack");
        System.out.println ("5. Exit");
        
        while (true) {
            System.out.print ("Enter your choice: ");
            int choice = scan.nextInt(); scan.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print ("Enter element to push: ");
                    stack.push(scan.nextInt());
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.peek();
                    break;
                case 4:
                    stack.displayStack();
                    break;
                case 5:
                    System.out.println ("I am committed to becoming an expert software developer.");
                    System.out.println ("I will learn new things, practice regularly, and never give up.");
                    System.out.println ("This is my JAVA program that implement stack operations on linked list nodes");
                    System.exit (0);
            }
        }
    }
}
