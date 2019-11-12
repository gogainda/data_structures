package com.epi.bitwise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BigBitsReverseTest {

  @Test
  void reverseBits() {
    BigBitsReverse bigBitsReverse = new BigBitsReverse();
    PrintUtils.printIntToBinary(bigBitsReverse.reverseBits(0b1110000000000001010000000000000000000000000000000000000000000000L));
  }
}