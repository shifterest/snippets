/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CircularQueue;

/**
 *
 * @author Delmoro-Ke
 */
public class Queue {
    int SIZE = 10; // Size of Circular Queue
    int front, rear;
    int items[] = new int[SIZE];
    
    /**
     * Creates new form CircularQueue
     */
    public Queue() {
        front = -1;
        rear = -1;
    }

    // Check if the queue is full
    boolean isFull() {
        if (front == 0 && rear == SIZE - 1) {
            return true;
        }
        if (front == rear + 1) {
            return true;
        }
        return false;
    }

    // Check if the queue is empty
    boolean isEmpty() {
        if (front == -1)
            return true;
        else
            return false;
    }

    // Adding an element
    void enQueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1)
                front = 0;
            rear = (rear + 1) % SIZE;
            items[rear] = element;
            System.out.println("Element " + element + " has been added to the queue.");
            displayFrontRear();
        }
    }

    // Removing an element
    int deQueue() {
        int element;
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return (-1);
        } else {
            element = items[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } /* Q has only one element, so we reset the queue after deleting it. */
            else {
                front = (front + 1) % SIZE;
            }
            System.out.println("Element " + element + " has been deleted from the queue.");
            displayFrontRear();
            return (element);
        }
    }

    void display() {
        /* Function to display status of Circular Queue */
        int i;
        if (isEmpty()) {
            System.out.println("Empty Queue");
        } else {
            System.out.println("Front -> " + front);
            System.out.println("Items -> ");
            for (i = front; i != rear; i = (i + 1) % SIZE)
                System.out.print(items[i] + " ");
            System.out.println(items[i]);
            System.out.println("Rear -> " + rear);
        }
    }
    
    void displayCount() {
        int c = 0;
        if (isEmpty()) {
            System.out.println("Empty Queue");
            return;
        }
        else
            c = Math.abs ((front % SIZE) - (rear % SIZE));
        
        System.out.println ("Number of elements in the queue: " + c);
        displayFrontRear();
    }
    
    void displayFrontRear() {
        System.out.println ("Front: " + front + ", Rear: " + rear);
    }
}
