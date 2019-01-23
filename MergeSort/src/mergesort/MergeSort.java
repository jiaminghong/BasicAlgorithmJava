/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

/**
 *
 * @author jiaminghong
 */
public class MergeSort {
    static void mergeSort(int[] input, int head, int tail) {
        if(head<tail) {
            int medium = (head+tail)/2;
            mergeSort(input, head, medium);
            mergeSort(input, medium+1, tail);
            merge(input, head, tail, medium);
        }
    }
    
    static void merge(int[] input, int head, int tail, int medium) {
        int leftLen = medium-head+1;
        int rightLen = tail-medium;
        int[] left = new int[leftLen];
        int[] right = new int[rightLen];
        for(int i=0; i<leftLen; i++) {
            left[i] = input[i+head];
        }
        for(int i=0; i<rightLen; i++) {
            right[i] = input[i+medium+1];
        }
        int l=0, r=0;
        //int num=0;
        while(l<leftLen && r<rightLen) {
            if(left[l]<=right[r]) {
                input[head+l+r] = left[l];
                l++;
            }
            else {
                input[head+l+r] = right[r];
                r++;
            }
        }
        while(l<leftLen) {
            input[head+l+r] = left[l];
            l++;
        }
        while(r<rightLen) {
            input[head+l+r] = right[r];
            r++;
        }
    }
    //Generate Random Integer
    public static void randomArray(int min, int max, int[] input) {
        for(int i=0; i<input.length; i++) {
            input[i] = (int)(Math.random()*((max-min)+1))+min;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int min = 0, max = 100;
        System.out.print("Original Array: ");
        int arrSort[] = new int[20];
        randomArray(min, max, arrSort);
        System.out.println("Array before mergesort: ");
        for(int i : arrSort) {
            System.out.print(i + " ");
        }
        mergeSort(arrSort, 0, arrSort.length-1);
        System.out.println("");
        System.out.println("Array after mergesort: ");
        for(int i : arrSort) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
    
}
