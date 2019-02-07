/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heapsort;

/**
 *
 * @author jiaminghong
 */
public class HeapSort { //Max Heap Sort
    void sort(int[] input) {
        int len = input.length;
        for(int i=(len-2)/2; i>=0; i--) {
            heapify(input, i, len);
        }
        for(int i=len-1; i>0; i--) {
            int temp = input[i];
            input[i] = input[0];
            input[0] = temp;
            heapify(input, 0, i); 
        }
    }
    void heapify(int[] input, int start, int size) {
        int maxIndex = start;
        int left = 2*start+1;
        int right = 2*start+2;
        if(left<size && input[left]>input[maxIndex]) {
            maxIndex = left;
        }
        if(right<size && input[right]>input[maxIndex]) {
            maxIndex = right;
        }
        if(maxIndex != start) {
            int temp = input[start];
            input[start] = input[maxIndex];
            input[maxIndex] = temp;
            heapify(input, maxIndex, size);
        }
    }
    
    void arrPrint(int[] input) {
        for(int i: input) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    //Generate Random Integer
    void randomArray(int min, int max, int[] input) {
        for(int i=0; i<input.length; i++) {
            input[i] = (int)(Math.random()*((max-min)+1))+min;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HeapSort hs = new HeapSort();
        int[] arr = new int[18];
        hs.randomArray(0, 100, arr);
        System.out.println("Original array:");
        hs.arrPrint(arr);
        hs.sort(arr);
        System.out.println("Array after sort:");
        hs.arrPrint(arr);
    }
    
}
