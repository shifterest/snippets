public class LinkedList {
    protected Node head;
    
    public LinkedList () {
        head = null;
    }
    
    public int getLength () {
        int l = 0;
        Node curr = head;
        while (curr != null) {
            l++;
            curr = curr.next;
        }
        return l;
    }
    
    // INSERT
    public void insertAtBeginning (int data) {
        Node node = new Node (data);
        node.next = head;
        head = node;
    }
    
    public void insertAtEnd (int data) {
        Node node = new Node (data);
        if (head == null) head = node;
        else {
            Node curr = head;
            while (curr.next != null) curr = curr.next;
            curr.next = node;
        }
    }
    
    public void insertAtIndex (int data, int pos) {
        if (pos < 0) {
            System.out.println ("Invalid position");
            return;
        }
        if (pos == 0) {
            insertAtBeginning (data);
            return;
        }
        if (pos == getLength() - 1) {
            insertAtEnd (data);
            return;
        }
        if (pos > getLength() - 1) {
            System.out.println ("Position is greater than the list length");
            return;
        }
        
        Node node = new Node (data);
        Node curr = head;
        for (int i = 0; i < pos - 1; i++) curr = curr.next;
        node.next = curr.next;
        curr.next = node;
    }
    
    // DELETE
    public void deleteAtBeginning () {
        if (head != null) head = head.next;
    }
    
    public void deleteAtEnd () {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            return;
        }
        Node curr = head;
        while (curr.next.next != null) curr = curr.next;
        curr.next = null;
    }
    
    public void deleteAtPosition (int pos) {
        if (pos < 0) {
            System.out.println ("Invalid position");
            return;
        } else if (pos == 0) {
            deleteAtBeginning();
            return;
        } else if (pos == getLength() - 1) {
            deleteAtEnd();
            return;
        } else if (pos > getLength() - 1) {
            System.out.println ("Position is greater than the list length");
            return;
        }
        
        Node curr = head;
        for (int i = 0; i < pos - 1; i++) curr = curr.next;
        curr.next = curr.next.next;
    }
}
