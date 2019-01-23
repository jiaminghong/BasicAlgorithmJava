/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractionalknapsack;

/**
 *
 * @author jiaminghong
 */
public class FractionalKnapsack {
    //greedy process
    public static double getMaxValue(int[] weight, int[] value, int capacity) {
        double maxValue = 0;
        backBag[] bbSort = getCost(weight, value);
        for(backBag b : bbSort) {
            if(capacity - b.weight > 0) {
                maxValue += b.value;
                capacity -= b.weight;
            }
            else {
                maxValue += (double)capacity/(double)b.weight*b.value;
                break;
            }
        }
        return maxValue;
    }
    //create backBag Array and initialize cost value
    public static backBag[] getCost(int[] weight, int[] value) {
        backBag[] bbCost = new backBag[weight.length];
        for(int i=0; i<weight.length; i++) {
            bbCost[i] = new backBag(weight[i], value[i]);
        }
        sortCost(bbCost);
        return bbCost;
    }
    //sort backBag Array
    public static backBag[] sortCost(backBag[] bbCost) {
        for(int i=0; i<bbCost.length-1; i++) {
            double max = bbCost[i].cost;
            for(int j=i; j<bbCost.length; j++) {
                if(bbCost[j].cost>bbCost[i].cost) {
                    backBag temp = bbCost[j];
                    bbCost[j] = bbCost[i];
                    bbCost[i] = temp;
                }
            }
        }
        return bbCost;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] weight = {10, 40, 20, 30}; 
        int[] value = {60, 40, 100, 120}; 
        int capacity = 50;
        double maxValue = getMaxValue(weight, value, capacity);
        System.out.println("the max value we can get is: " + maxValue);
    }
    
    static class backBag {
        int weight;
        int value;
        double cost;
        public backBag(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.cost = 1.0*value/(1.0*weight);
        }
    } 
}