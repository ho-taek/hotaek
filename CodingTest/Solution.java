import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        Deque<Integer> deque = new LinkedList<>(Arrays.asList(4, 5));
        deque.addFirst(3); // [3,4,5]
        System.out.println(deque);
        deque.addLast(6); // [3,4,5,6]
        System.out.println(deque);
        deque.offerFirst(2); // [2,3,4,5,6]
        System.out.println(deque);
        deque.offerLast(7); // [2,3,4,5,6,7]
        System.out.println(deque);

        deque.removeFirst(); // [3,4,5,6,7]
        System.out.println(deque);
        deque.removeLast(); // [3,4,5,6]
        System.out.println(deque);

        System.out.println(deque.getFirst()); // 3
        System.out.println(deque.peekFirst()); // 3
        System.out.println(deque);
        System.out.println(deque.getLast()); // 6
        System.out.println(deque.peekLast()); // 6
        System.out.println(deque);
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
