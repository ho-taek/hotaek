package reetcode.java.easy;

import java.util.HashMap;

public class _1 {

    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();

        for(int i=0; i < nums.length; i++){
            if(map.containsKey(target-nums[i])){
                return new int[] {map.get(target-nums[i]),i};
            }

            map.put(target-nums[i], i);

        }
        return null;
    }
}
