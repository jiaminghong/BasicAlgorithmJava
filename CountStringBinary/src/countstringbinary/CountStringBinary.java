/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countstringbinary;

/**
 *
 * @author jiaminghong
 */

/*
Write a recursive method countStringBinary that has one integer parameter n
and returns the number of binary strings of length n that do not have two consecutive 0's.
For example, for n = 4, the number of binary strings of length 4 that 
do not contain two consecutive 0's is 8: 1111, 1110, 1101, 1011, 1010, 0111, 0110, 0101
*/
public class CountStringBinary {
    void CSB(int n) {
       int result = CSBRec0(n)+CSBRec1(n);
       System.out.println("The number of binary strings of length" + 
               " n that do not have two consecutive 0's is " + result);
    }
    //start with 1
    int CSBRec1(int n) {
        if(n == 1) {
            return 1;
        }
        return CSBRec1(n-1)+CSBRec0(n-1);
    }
    //start with 0
    int CSBRec0(int n) {
        if(n == 1) {
            return 1;
        }
        return CSBRec1(n-1);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CountStringBinary csb = new CountStringBinary();
        for(int i=1; i<10; i++) {
            csb.CSB(i);
        }
    }
    
}
