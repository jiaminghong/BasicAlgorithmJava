/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

/**
 *
 * @author jiaminghong
 */
public class QuickSort {
    public static void quickSort(int[] input, int head, int tail) {
        if(head < tail) {
            int pivot = partitionFirst(input, head, tail);
            quickSort(input, head, pivot-1);
            quickSort(input, pivot+1, tail);
        }
    }
    //Select last element as pivot
    public static int partitionLast(int[] input, int head, int tail) {
        int key = input[tail];
        int m = 0, n = tail-head;
        int[] sortArr = new int[n+1];
        for(int i=head; i<tail; i++) {
            if(input[i]<=key) {
                sortArr[m] = input[i];
                m++;
            }
            else {
                sortArr[n] = input[i];
                n--;
            }
        }
        sortArr[n] = key;
        for(int i=head; i<=tail; i++) {
            input[i] = sortArr[i-head];
        }
        return head+n;
    }
    //Select first element as pivot
    public static int partitionFirst(int[] input, int head, int tail) {
        int key = input[head];
        int ind = tail;
        for(int i=tail; i>head; i--) {
            if(input[i]>key) {
                int temp = input[i];
                input[i] = input[ind];
                input[ind] = temp;
                ind--;
            }
        }
        int temp = input[ind];
        input[ind] = input[head];
        input[head] = temp;
        return ind;
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
        System.out.println("Array before quicksort: ");
        for(int i : arrSort) {
            System.out.print(i + " ");
        }
        quickSort(arrSort, 0, arrSort.length-1);
        System.out.println("");
        System.out.println("Array after quicksort: ");
        for(int i : arrSort) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
    
}
