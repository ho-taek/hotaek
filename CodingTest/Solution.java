import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
      LinkedHashSet<List<Integer>> set = new LinkedHashSet<>();

      List<List<Integer>> list = new ArrayList<>();
      List<List<Integer>> list2 = new ArrayList<>();

      List<Integer> d = new ArrayList<>();
      List<Integer> c = new ArrayList<>();
      for(int i=0; i <3 ; i++){
        d.add(i);
        c.add(i);
      }
      c.add(3);
      list.add(d);
      list.add(c);

      list2.add(d);
      list2.add(c);

      set.addAll(list);
      set.addAll(list2);

      System.out.println(set);
    }

}
