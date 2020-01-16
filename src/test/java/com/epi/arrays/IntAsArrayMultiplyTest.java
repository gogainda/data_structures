package com.epi.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class IntAsArrayMultiplyTest {

  @Test
  void multiply() {
    assertEquals(Arrays.asList(1,2,1,4,0,1), IntAsArrayMultiply.multiply(Arrays.asList(1,2,3), Arrays.asList(1,2)));
  }
}