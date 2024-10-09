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
    int SIZE = 10;
    int front, rear;
    int items[] = new int[SIZE];
    
    public Queue() {
        front = -1;
        rear = -1;
    }
    
    boolean isFull() {
        if (front == 0 && rear == SIZE - 1) {
            return true;
        }
        return (front == rear + 1);
    }
    
    boolean isEmpty() {
        return (front == -1);
    }
    
    void enQueue (int element) {
        if (isFull()) {
            System.out.println ("Queue is full");
        } else {
            if (front == -1)
                front = 0;
            rear = (rear + 1) % SIZE;
            items[rear] = element;
            System.out.println ("Element " + element + " has been added to the queue.");
            displayFrontRear();
        }
    }
    
    int deQueue () {
        int element;
        if (isEmpty()) {
            System.out.println ("Queue is empty");
            displayFrontRear();
            return -1;
        } else {
            element = items[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            }
            else {
                front = (front + 1) % SIZE;
            }
            System.out.println ("Element " + element + " has been deleted from the queue.");
            displayFrontRear();
            return element;
        }
    }
    
    void display() {
        int i;
        if (isEmpty()) {
            System.out.println ("Empty Queue");
        } else {
            System.out.println ("Front -> " + front);
            System.out.println ("Items -> ");
            for (i = front; i != rear; i = (i + 1) % SIZE)
                System.out.print (items[i] + " ");
            System.out.println (items[i]);
            System.out.println ("Rear -> " + rear);
        }
    }
    
    void displayCount() {
        int c = isEmpty() ? 0 : Math.abs ((front % SIZE) - (rear % SIZE)) + 1;
            
        System.out.println ("Number of elements in the queue: " + c);
        displayFrontRear();
    }
    
    void displayFrontRear() {
        System.out.println ("Front: " + front + ", Rear: " + rear);
    }
}