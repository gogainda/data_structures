package com.epi.bitwise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimitiveMultiplyTest {
    @Test
    public void multiply() {
        assertEquals(3 * 9, PrimitiveMultiply.multiply(3, 9));
    }

}