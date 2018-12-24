/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_list;

/**
 *
 * @author jiaminghong
 */
public class Linked_List {
    Node head;
    static class Node {
        int data;
        Node next;
        Node(int a) {
            data = a;
            next = null;
        }
    }
    //traverse a linked list
    public void printList() {
        Node currentNode = head;
        System.out.print("Elements in this Linked List:  ");
        while(currentNode != null) {
            System.out.print(currentNode.data + " => ");
            currentNode = currentNode.next;
        }
        System.out.print("Null"+"\n");
    }
    //insert a node at the front of the linked list
    public void insertAtFront(int input) {
        Node InputNode = new Node(input);
        InputNode.next = head;
        head = InputNode;
        System.out.print("Elements in this Linked List(after front insertion):  ");
        printList();
    }
    //insert a node after a given node
    public void insertAtSelected(int input, Node given) {
        Node currentNode = head;
        while(currentNode != given) {
            currentNode = currentNode.next;
        }
        if(currentNode == null) {
            System.out.print("Your given node is not inside this Linked List.");
            return;
        }
        Node inputNode = new Node(input);
        inputNode.next = currentNode.next;
        currentNode.next = inputNode;
        System.out.print("Elements in this Linked List(after given node insertion):  ");
        printList();
    }
    //insert a node at the end of the linked list
    public void insertAtTail(int input) {
        Node currentNode = head;
        while(currentNode.next != null) {
            currentNode = currentNode.next;
        }
        Node inputNode = new Node(input);
        currentNode.next = inputNode;
        System.out.print("Elements in this Linked List(after tail insertion):  ");
        printList();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Linked_List ll = new Linked_List();
        ll.head = new Node(0);
        Node second = new Node(1);
        Node third = new Node(3);
        Node fourth = new Node(4);
        ll.head.next = second;
        second.next = third;
        third.next = fourth;
        ll.printList();
        ll.insertAtFront(-1);
        ll.insertAtSelected(2, second);
        ll.insertAtTail(5);
    }
    
}
