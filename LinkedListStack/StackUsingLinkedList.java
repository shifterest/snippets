public class StackUsingLinkedList extends LinkedList {
    public void push (int data) {
        insertAtEnd (data);
        System.out.println ("Pushed: " + data);
    }
    
    public int pop () {
        if (getLength() == 0) {
            System.out.println ("Stack is empty. Cannot pop.");
            return -1;
        }
        Node curr = head;
        while (curr.next != null) curr = curr.next;
        int data = curr.data;
        deleteAtEnd();
        System.out.println ("Popped element:" + data);
        return data;
    }
    
    public int peek () {
        if (getLength() == 0) {
            System.out.println ("Stack is empty. Cannot peek.");
            return -1;
        }
        Node curr = head;
        while (curr.next != null) curr = curr.next;
        System.out.println ("Peeked element: " + curr.data);
        return curr.data;
    }
    
    public void displayStack () {
        if (getLength() == 0) {
            System.out.println ("Stack is empty!");
            return;
        }
        Node curr = head;
        System.out.print ("Stack: ");
        while (curr != null) {
            System.out.print (curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
        System.out.println("Size of the linked list: " + getLength());
    }
}
