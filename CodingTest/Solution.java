import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        System.out.println("0 ~ 100 사이의 난수 1개 발생 : " + (int) (Math.random() * 11));

        int[] li = new int[] { 1, 2, 3 };

        for (int i = 5; i > 0; i--) {
            System.out.println(i);
        }

    }

    // public static void perm(int depth , boolean[] array, boolean[] output, int r,
    // int n){
    // if(depth == r){
    // System.out.println(Arrays.toString(output));
    // return;
    // }

    // for(int i =0; i <n ; i++){
    // output[depth] = true;
    // perm(depth+1, array, output, r, n);
    // output[depth] = false;
    // perm(depth+1, array, output, r, n);

    // }

}
