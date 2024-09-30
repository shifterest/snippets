import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main (String [] args) {
        Scanner csd = new Scanner (System.in);
        Stack<Item> items = new Stack<>();
        
        while (true) {
            System.out.println ("Stack Operations Menu for Item Class:");
            System.out.println ("1. Push");
            System.out.println ("2. Pop");
            System.out.println ("3. Peek");
            System.out.println ("4. Display Stack");
            System.out.println ("5. Exit");
            System.out.print ("Enter your choice: ");
            
            int choice = csd.nextInt(); csd.nextLine();
            String d;
            double p;
            Item z;
            
            switch (choice) {
                case 1:
                    System.out.print ("Enter item description: ");
                    d = csd.nextLine();
                    System.out.print ("Enter item price: ");
                    p = csd.nextDouble(); csd.nextLine();
                    z = new Item (d, p);
                    items.push (z);
                    System.out.println ("Pushed " + d + " " + p + " onto the stack. top=" + (items.size() - 1));
                    break;
                case 2:
                    z = items.pop();
                    d = z.getDescription();
                    p = z.getPrice();
                    System.out.println ("Popped item: " + d + " " + p + " top=" + (items.size() - 1));
                    break;
                case 3:
                    z = items.peek();
                    d = z.getDescription();
                    p = z.getPrice();
                    System.out.println ("Peeked item: " + d + " " + p + " top=" + (items.size() - 1));
                    break;
                case 4:
                    if (items.size() == 0) System.out.println ("Stack is empty!");
                    else {
                        System.out.println ("Stack items:");
                        int top = (items.size() - 1);
                        PrintStack (items);
                        System.out.println (" top=" + top);
                    }
                    break;
                case 5:
                    System.out.println ("I am committed to becoming an expert software developer.");
                    System.out.println ("I will learn new things, practice regularly, and never give up.");
                    System.out.println ("Exiting STACK Operations Application!");
                    System.exit (0);
            }
        }
    }
    
    public static void PrintStack (Stack<Item> stack) {
        if (stack.isEmpty()) return;
        
        Item item = stack.pop();
        String d = item.getDescription();
        double p = item.getPrice();
        System.out.print (d + " " + p + " ");
        PrintStack (stack);
        stack.push (item);
    }
}
