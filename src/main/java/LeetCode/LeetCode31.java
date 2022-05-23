package LeetCode;

import java.util.Arrays;

/**
 * @description:
 * @author: rzcai
 * @time: 2022/5/23 10:05
 */

public class LeetCode31 {
    public static void main(String[] args) {
        int[] nums=new int[]{1,3,2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
    static public void nextPermutation(int[] nums) {
        for(int i=nums.length-2;i>=0;i--){
            for(int j=nums.length-1;j>i;j--)
            if(nums[i]<nums[j]){
                nums=swap(nums,i,j);
//                System.out.println(Arrays.toString(nums));
                return;
            }
        }
        for(int i=0;i<nums.length/2;i++)nums=swap(nums,i,nums.length-i-1);
//        System.out.println(Arrays.toString(nums));
    }
    static int[] swap(int[] nums,int i,int j){
        int x=nums[i];
        nums[i]=nums[j];
        nums[j]=x;
        return nums;
    }
}
