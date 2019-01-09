/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackusinglinkedlist;

/**
 *
 * @author jiaminghong
 */
public class StackUsingLinkedList {
    Node first;
    static class Node {
        String data;
        Node next;
        Node(String a) {
            data = a;
            next = null;
        }
    }
    public void push(String input) {
        Node oldfirst = first;
        first = new Node(input);
        first.next = oldfirst;
    }
    public String pop() {
        if(isEmpty())   return "";
        else {
            String item = first.data;
            first = first.next;
            return item;
        }
    }
    public boolean isEmpty() {
        if(first == null) return true;
        else return false;
    }
    public void popPrint() {
        System.out.print("pop: ");
        while(first != null) {
            System.out.print(pop()+" -> ");
        }
        System.out.println("end");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StackUsingLinkedList sull = new StackUsingLinkedList();
        sull.push("Ming");
        sull.push("Qin");
        sull.push("Samed");
        sull.popPrint();
        StackUsingLinkedList sull2 = new StackUsingLinkedList();
        boolean output = (sull2.isEmpty() == true) ? true : false;
        System.out.println("Is this stack empty: " + output);
        sull2.push("Ming");
        boolean output2 = (sull2.isEmpty() == true) ? true : false;
        System.out.println("Is this stack empty: " + output2);
    }
    
}
