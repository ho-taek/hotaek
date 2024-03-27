import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println("0 ~ 100 사이의 난수 1개 발생 : " + (int) (Math.random() * 30));
        Integer[] arr = new Integer[] { 5, 5, 128, 128, 400, 400 };
        for (int i = 0; i < 6; i += 2) {
            if (arr[i].equals(arr[i + 1])) {
                System.out.println("~~");
            } else {
                System.out.println("!!");
            }
        }

    }

}