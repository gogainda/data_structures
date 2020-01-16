package com.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayNestingTest {
    @Test
    public void test() {
        ArrayNesting arrayNesting = new ArrayNesting();
        int[] ary = {5,4,0,3,1,6,2};
        arrayNesting.arrayNesting(ary);
    }

}