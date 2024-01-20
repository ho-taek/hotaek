package 백준.java;

import java.util.Arrays;

class 연습{

    public static void main(String[] args) {
       int[] array = {2,3,5,1,0,4};

       for(int i=0; i<array.length-1; i++){
        
            int min = Integer.MAX_VALUE;
            int index = 0;
            int tmp = array[i];
            for(int j=i; j<(array.length-1); j++){
                if(array[j] < min){
                    index = j;
                    min = array[j];
                }
            }
            array[i] = array[index];
            array[index] = tmp;   
       }
       System.out.println(Arrays.toString(array));
    }
}