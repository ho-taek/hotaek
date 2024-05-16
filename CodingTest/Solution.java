import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        int[] one = new int[] { 0, 1, 2 };
        int[] two = new int[] { 0, 1, 2 };
        List<int[]> li = new ArrayList<>();

        li.add(one);
        one[2] = 4;

        System.out.println(li.contains(one));
        System.out.println(Arrays.equals(one, two));
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
