package com.epi.arrays;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntAsArrayIncrementTest {

  @Test
  void plusOne() {
    List<Integer> list = new ArrayList<>(Arrays.asList(9, 9));
    IntAsArrayIncrement.plusOne(list);

  }
}