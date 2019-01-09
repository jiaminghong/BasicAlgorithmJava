/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queueusingarray;

/**
 *
 * @author jiaminghong
 */
public class QueueUsingArray {
    String q[];
    int head = 0, tail = 0;
    public QueueUsingArray(int capacity) {
        q = new String[capacity];
    }
    public void enqueue(String input) {
        if(isFull()) {
            System.out.println("This queue is full, can't insert element anymore.");
            return;
        }
        else{
            q[tail++] = input;
        }     
    }
    public String dequeue() {
        if(isEmpty()) {
            System.out.println("This queue is empty, can't withdraw element anymore.");
            return "";
        }
        else{
            String target = q[head];
            q[head++] = null;
            return target;
        }
    }
    public boolean isEmpty() {
        return head==tail;
    }
    public boolean isFull() {
        return tail==q.length;
    }
    public void dequeuePrint() {
        System.out.print("dequeue: ");
        while(isEmpty()==false) {
            System.out.print(dequeue() + " -> ");
        }
        System.out.println("end");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        QueueUsingArray qua = new QueueUsingArray(3);
        qua.enqueue("Ming");
        qua.enqueue("Gu");
        qua.enqueue("zhou");
        qua.enqueue("haha");
        qua.dequeue();
        qua.dequeuePrint();
    }
    
}
