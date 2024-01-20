package 알고리즘;

import java.util.Arrays;

public class 선택정렬 {
     public static void main(String[] args) {
       int[] array = {2,3,5,1,0,4};

       for(int i=0; i<array.length-1; i++){
        
            int min = Integer.MAX_VALUE;
            int index = 0;
            int tmp = array[i];
            for(int j=i; j<array.length; j++){
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
