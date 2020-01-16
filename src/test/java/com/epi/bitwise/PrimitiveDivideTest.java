package com.epi.bitwise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimitiveDivideTest {

  @Test
  void divide() {
    assertEquals(25,  PrimitiveDivide.divide(11,  2));
  }
}