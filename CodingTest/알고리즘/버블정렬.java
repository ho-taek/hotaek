package 알고리즘;

import java.util.Arrays;

public class 버블정렬 {
    
    public static void main(String[] args){
        int[] array = {3,1,4,0,2};
        
        for(int i = 0; i < array.length; i++){
            for(int j=0; j < (array.length-i); j++){
                if(j != (array.length-1)){
                    if(array[j] > array[j+1]){
                        int tmp = array[j+1];
                        array[j+1] = array[j];
                        array[j] = tmp;
                    }
                }
            }    
        }
        System.out.println(Arrays.toString(array));
    }
}
