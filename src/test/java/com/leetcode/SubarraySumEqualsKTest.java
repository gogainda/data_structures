package com.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubarraySumEqualsKTest {

  @Test
  void subarraySum() {
    SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
    int k = 3;
    int[] nums = {1,2,1,2,1};
    subarraySumEqualsK.subarraySum2(nums, k);
  }
}