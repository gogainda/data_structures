package com.epi.bitwise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClosestIntSameWeightTest {
    @Test
    public void closestIntSameWeightTest() {
        assertEquals(11, ClosestIntSameWeight.closestIntSameWeight(7));
        assertEquals(11, ClosestIntSameWeight.closestIntSameWeight2(7));
    }

}