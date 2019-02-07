/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort;

/**
 *
 * @author jiaminghong
 */
public class BubbleSort {
    void BSort(int[] input) {
        int n = input.length;
        for(int i=n-1; i>=0; i--) {
            for(int j=0; j<i; j++) {
                if(input[j]>input[j+1]) {
                    int swap = input[j];
                    input[j] = input[j+1];
                    input[j+1] = swap;
                }
            }
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
        BubbleSort bs = new BubbleSort();
        int[] arr = new int[20];
        bs.randomArray(0, 100, arr);
        System.out.println("Original array:");
        bs.arrPrint(arr);
        bs.BSort(arr);
        System.out.println("Array after sort:");
        bs.arrPrint(arr);
    }
    
}
