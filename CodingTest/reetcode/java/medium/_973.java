package reetcode.java.medium;

import java.util.*;
public class _973 {
    
    public static void main(String[] args){
        int[][] array = new int[][] {{1,3},{2,-2}};
        System.out.println(Arrays.toString(kClosest(array, 1)));
 

    }

    static class Pointer{
        int[] point;
        double distance;

        public Pointer(int[] point, double distance){
            this.point = point;
            this.distance = distance;
        }
    }


    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pointer> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a.distance));
        
        int[][] array = new int[k][];

        for(int i =0; i < points.length; i++){
            double result = Math.sqrt(points[i][0])+Math.sqrt(points[i][1]);
            pq.add(new Pointer(points[i], result));
        }
        
        for(int i=0; i <k; i++){
            array[i] = pq.poll().point;
        }

        return array;
    }
}
