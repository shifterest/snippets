import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main (String [] args) {
        Scanner tan = new Scanner (System.in);
        Stack<Integer> ken = new Stack<>();
        
        System.out.print("Enter valid postfix notation to evaluate: ");
        String postfix = tan.nextLine();
        System.out.println();
        
        for (int i = 0; i < postfix.length(); i++) {
            System.out.println("token: " + postfix.charAt(i));
            if (postfix.charAt(i) >= '0' && postfix.charAt(i) <= '9') {
                System.out.println("isDigit true");
                ken.push(postfix.charAt(i) - '0');
            } else {
                int op2 = ken.pop();
                int op1 = ken.pop();
                switch (postfix.charAt(i)) {
                    case '+':
                        System.out.println();
                        ken.push(op1 + op2);
                        break;
                    case '-':
                        System.out.println();
                        ken.push(op1 - op2);
                        break;
                    case '*':
                        System.out.println();
                        ken.push(op1 * op2);
                        break;
                    case '/':
                        System.out.println();
                        ken.push(op1 / op2);
                        break;
                    case '^':
                        ken.push((int) Math.pow(op1, op1));
                        break;
                }
            }
            
            System.out.println("Stack Elements:");
            printStack(ken);
            System.out.println();
        }
        
        System.out.print("Result: " + ken.pop());
    }
    
    public static void printStack (Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        
        int n = stack.pop();
        System.out.print(n + " ");
        printStack(stack);
        stack.push(n);
    }
}
