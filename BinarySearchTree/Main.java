import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main (String [] args) {
        TreeNode root = null;
        Scanner scan = new Scanner (System.in);
        
        while (true) {
            System.out.println();
            System.out.println ("Binary Search Tree Operations Menu:");
            System.out.println ("1. Insert a value");
            System.out.println ("2. Search for a value");
            System.out.println ("3. Find minimum value");
            System.out.println ("4. Find maximum value");
            System.out.println ("5. Delete a node");
            System.out.println ("6. Inorder traversal");
            System.out.println ("7. Pre-order traversal");
            System.out.println ("8. Post-order traversal");
            System.out.println ("9. Check if valid BST");
            System.out.println ("10. Find Lowest Common Ancestor (LCA)");
            System.out.println ("11. Display root value");
            System.out.println ("12. Exit");
            System.out.print ("Enter your choice: ");
            
            int c = scan.nextInt();
            ArrayList<Integer> t;
            switch (c) {
                case 1:
                    System.out.print ("Enter value to insert: ");
                    int v = scan.nextInt();
                    root = BinarySearchTree.insertIntoBST (root, v);
                    System.out.println ("Inserted " + v);
                    break;
                case 2:
                    System.out.print ("Enter value to search: ");
                    v = scan.nextInt();
                    SearchResult r = BinarySearchTree.searchBST (root, v);
                    if (r.getFound())
                        if (r.getPosition().equals("root"))
                            System.out.println("Value found,  of Parent: None (This is the root node)");
                        else
                            System.out.println("Value found, on the " + r.getPosition() + " of Parent: " + r.getParent().val);
                    else
                        System.out.println("Value not found.");
                    break;
                case 3:
                    System.out.println ("Minimum value: " + BinarySearchTree.findMin(root).val);
                    break;
                case 4:
                    System.out.println ("Maximum value: " + BinarySearchTree.findMax(root).val);
                    break;
                case 5:
                    System.out.print ("Enter value to delete: ");
                    int d = scan.nextInt();
                    System.out.println ("Delete using:");
                    System.out.println ("1. In-order Predecessor");
                    System.out.println ("2. In-order Successor");
                    int s = scan.nextInt();
                    root = BinarySearchTree.deleteNode (root, d, !(s == 1));
                    System.out.println ("Deleted " + d);
                    break;
                case 6:
                    t = BinarySearchTree.inOrderTraversal(root);
                    System.out.print ("Inorder Traversal: [");
                    for (int i = 0; i < t.size(); i++) {
                        if (i != 0) System.out.print (", ");
                        System.out.print (t.get(i));
                    }
                    System.out.println("]");
                    break;
                case 7:
                    t = BinarySearchTree.preOrderTraversal(root);
                    System.out.print ("Pre-order Traversal: [");
                    for (int i = 0; i < t.size(); i++) {
                        if (i != 0) System.out.print (", ");
                        System.out.print (t.get(i));
                    }
                    System.out.println("]");
                    break;
                case 8:
                    t = BinarySearchTree.postOrderTraversal(root);
                    System.out.print ("Post-order Traversal: [");
                    for (int i = 0; i < t.size(); i++) {
                        if (i != 0) System.out.print (", ");
                        System.out.print (t.get(i));
                    }
                    System.out.println("]");
                    break;
                case 9:
                    if (BinarySearchTree.isValidBST(root))
                        System.out.println("The tree is a valid BST.");
                    break;
                case 10:
                    System.out.print ("Enter first value for LCA: ");
                    int x = scan.nextInt();
                    System.out.print ("Enter second value for LCA: ");
                    int y = scan.nextInt();
                    System.out.println ("LCA of " + x + " and " + y + " is: " + BinarySearchTree.findLCA(root, x, y));
                    break;
                case 11:
                    int a = root.val;
                    System.out.println ("Current root value: " + a);
                    break;
                case 12:
                    System.out.println ("Exiting...");
                    System.exit(0);
            }
        }
    }
}