package 알고리즘;

import java.util.Arrays;

public class 삽입정렬 {
    public static void main(String[] args){
        int[] array = {3,1,5,2,4};

        for(int i=1; i < array.length; i++){
            for(int j =i; j > 0; j--){
                if(array[j] < array[j-1]){
                    int tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
