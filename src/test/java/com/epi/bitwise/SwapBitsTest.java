package com.epi.bitwise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwapBitsTest {

  @Test
  void swapBits() {
    PrintUtils.printIntToBinary(73l);
    PrintUtils.printIntToBinary(SwapBits.swapBits(73, 1, 6));
  }
}