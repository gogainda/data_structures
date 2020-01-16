package com.leetcode;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

  public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();
      int[] nums = {3, 0 ,2};
      mn.missingNumber(nums);
  }
}
