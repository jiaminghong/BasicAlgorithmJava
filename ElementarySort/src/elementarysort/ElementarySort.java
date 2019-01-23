/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementarysort;

/**
 *
 * @author jiaminghong
 */
public class ElementarySort {
    //Selection Sort Method
    public static void SelectionSort(int[] input) {
        int len = input.length;
        for(int i=0; i<len-1; i++) {
            int min = input[i];
            for(int j=i+1; j<len; j++) {
                if(input[j]<input[i]) {
                    int temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }
        }
    }
    //Insertion Sort Method
    public static void InsertionSort(int[] input) {
        int len = input.length;
        for(int i=1; i<len; i++) {
            int temp = input[i];
            int j = i-1;
            while(j>=0 && input[j]>temp) {
                input[j+1] = input[j];
                j--;
            }
            input[j+1] = temp;
        }
    }
    //Shell Sort Method
    public static void ShellSort(int[] input) {
        int len = input.length;
        for(int gap = len/2; gap > 0; gap /= 2) {
            for(int i=gap; i<len; i++) {
                int temp = input[i];
                int j = i-gap;
                while(j>=0 && input[j]>temp) {
                    input[j+gap] = input[j];
                    j -= gap;
                }
                input[j+gap] = temp;
            }
        }
    }
    //Array Print
    public static void arrayPrint(int[] input) {
        for(int i : input) {
            System.out.print(i + " ");
        }
        System.out.println("");
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
        arrayPrint(arrSort);
        System.out.print("After SelectionSort: ");
        InsertionSort(arrSort);
        arrayPrint(arrSort);
        System.out.print("Original Array: ");
        int arrSort2[] = new int[20];
        randomArray(min, max, arrSort2);
        arrayPrint(arrSort2);
        System.out.print("After InsertionSort: ");
        SelectionSort(arrSort2);
        arrayPrint(arrSort2);
        System.out.print("Original Array: ");
        int arrSort3[] = new int[20];
        randomArray(min, max, arrSort3);
        arrayPrint(arrSort3);
        System.out.print("After ShellSort: ");
        ShellSort(arrSort3);
        arrayPrint(arrSort3);    
    }
    
}
