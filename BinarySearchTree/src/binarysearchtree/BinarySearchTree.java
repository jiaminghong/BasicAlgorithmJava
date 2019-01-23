/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;
import static java.lang.Math.max;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author jiaminghong
 */
public class BinarySearchTree {
    Node root;
    public BinarySearchTree() {
        root = null;
    }
    class Node {
        int key;
        Node left, right;
        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
    
    //Insert a node into the tree
    void insert(int key) {
        root = insertRecursion(root, key);
    }
    Node insertRecursion(Node root, int key) {
        if(root == null) {
            root = new Node(key);
            System.out.println("Node with " + key + " inserted successfully.");
            return root;
        }
        if(key < root.key) {
            root.left = insertRecursion(root.left, key);
        }
        if(key > root.key) {
            root.right = insertRecursion(root.right, key);
        }
        if(key == root.key) {
            System.out.println("This tree has one node have the value same as inserted item.");
        }
        return root;
    }
    
    //Delete a specific node from a tree
    void delete(int key) {
        boolean delSuc = true;
        deleteRec(root, key, delSuc);
        if(delSuc == true) {
            System.out.println("The deletion of the Node with " + key + " succeed.");
        }
    }
    Node deleteRec(Node root, int key, boolean delSuc) {
        if(root == null) {
            System.out.println("No such key in the tree, deletion failed.");
            delSuc = false;
            return root;
        }
        if(key == root.key) {
            if(root.left == null) {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }
            else {
                Node rightMin = searchRightMin(root.right);
                root.key = rightMin.key;
                root.right = deleteRec(root.right, rightMin.key, delSuc);
            }
        }
        else if(key < root.key) {
            root.left = deleteRec(root.left, key, delSuc);
        }
        else if(key > root.key) {
            root.right = deleteRec(root.right, key, delSuc);  
        }
        return root;
    }
    Node searchRightMin(Node node) {
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }
    
    //Binary search using recursion
    void search(int key) {
        boolean result = searchRec(key, root);
        System.out.println("Node with " + key + " is inside the tree: " + result);
    }
    boolean searchRec(int key, Node node) {
        if(node == null) {
            return false;
        }
        if(key == node.key) {
            return true;
        }
        boolean temp = false;
        if(key < node.key) {
            temp = searchRec(key, node.left);
        }
        if(key > node.key) {
            temp = searchRec(key, node.right);
        }
        return temp;
    }
    
    //Binary search using a simple while loop
    boolean searchIter(int key) {
        Node tempNode = root;
        while(tempNode != null) {
            if(key == tempNode.key) {
                System.out.println("The Node with " + key + " client search is inside the tree.");
                return true;
            }
            else if(key < tempNode.key) {
                tempNode = tempNode.left;
            }
            else {
                tempNode = tempNode.right;
            }
        }
        System.out.println("The Node with " + key + " client search is NOT inside the tree.");
        return false;
    }
    
    //Print tree in breadth first order by printing elements in each level
    //Time complexity: O(N^2), N is the number of nodes in the skewed tree
    void bFO() {
        int height = bFOLevelsHeight(root);
        if(height == 0) {
            System.out.println("Nothing inside tree.");
            return;
        }
        System.out.print("Breadth first traversal method 1: ");
        for(int i=1; i<=height; i++) {
            bFOLevelsPrint(root, i);
        }
        System.out.print("end\n");
    }
    int bFOLevelsHeight(Node root) {
        if(root == null) {
            return 0;
        }
        else {
            int leftLevels = bFOLevelsHeight(root.left);
            int rightLevels = bFOLevelsHeight(root.right);
            int temp = max(leftLevels, rightLevels);
            return temp+1;
        }
    }
    void bFOLevelsPrint(Node root, int level) {
        if(level == 1) {
            System.out.print(root.key + " -> ");
        }
        else {
            bFOLevelsPrint(root.left, level-1);
            bFOLevelsPrint(root.right, level-1);
        }
    }
    
    //Print tree in breadth first order by queue
    void bFQueue() {
        Queue<Node> treeQ = new LinkedList<Node>();
        if(root == null) {
            System.out.println("Nothing inside tree.");
            return;
        }
        System.out.print("Breadth first traversal method 2: ");
        treeQ.add(root);
        while(!treeQ.isEmpty()) {
            Node tempNode = treeQ.poll();
            System.out.print(tempNode.key + " -> ");
            if(tempNode.left != null) {
                treeQ.add(tempNode.left);
            }
            if(tempNode.right != null) {
                treeQ.add(tempNode.right);
            }
        }
        System.out.print("end\n");
    }
    
    //Inorder Traversal(left, root, right)
    void inorderPrint() {
        if(root == null) {
            System.out.println("Nothing inside tree.");
            return;
        }
        System.out.print("Inorder traversal: ");
        inorderRec(root);
        System.out.print("end\n");
    }
    void inorderRec(Node node) {
        if(node == null) {
            return;
        }
        inorderRec(node.left);
        System.out.print(node.key + " -> ");
        inorderRec(node.right); 
    }
    
    //Preorder Traversal(root, left, right)
    void preorderPrint() {
        if(root == null) {
            System.out.println("Nothing inside tree.");
            return;
        }
        System.out.print("Preorder traversal: ");
        preorderRec(root);
        System.out.print("end\n");
    }
    void preorderRec(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.key + " -> ");
        preorderRec(node.left);
        preorderRec(node.right);
    }
    
    //Postorder Traversal(left, right, root)
    void postorderPrint() {
        if(root == null) {
            System.out.println("Nothing inside tree.");
            return;
        }
        System.out.print("Postorder traversal: ");
        postorderRec(root);
        System.out.print("end\n");
    }
    void postorderRec(Node node) {
        if(node == null) {
            return;
        } 
        postorderRec(node.left);
        postorderRec(node.right);
        System.out.print(node.key + " -> ");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(4);
        bst.insert(2);
        bst.insert(6);
        bst.insert(1);
        bst.insert(3);
        bst.insert(5);
        bst.insert(7);
        bst.inorderPrint();
        bst.preorderPrint();
        bst.postorderPrint();
        bst.bFQueue();
        bst.bFO();
        bst.search(1);
        bst.search(8);
        bst.searchIter(3);
        bst.searchIter(0);
        bst.delete(1);
        bst.inorderPrint();
        bst.delete(2);
        bst.postorderPrint();
        bst.delete(4);
        bst.preorderPrint();      
    }
    
}
