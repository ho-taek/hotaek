package reetcode.java.easy;

public class _1 {
    
    public static void main(String[] args){

    }
    public static int[] twoSum(int[] nums, int target) {
        for(int i=0 ; i < nums.length; i++){
            for(int j=i+1 ; i < nums.length; j++){
                if(nums[i]+nums[j] == target){
                    int[] result = {i,j};
                    return result;
                }
            }
        }
        return new int[0];
    }
}
