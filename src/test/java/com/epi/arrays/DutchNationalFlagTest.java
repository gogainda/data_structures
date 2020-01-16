package com.epi.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.epi.arrays.DutchNationalFlag.Color.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DutchNationalFlagTest {

    @Test
    void dutchFlagPartition() {
        List<DutchNationalFlag.Color> list = Arrays.asList(RED, WHITE, BLUE, WHITE, RED);
        DutchNationalFlag.dutchFlagPartition(1, list);
        assertEquals(Arrays.asList(RED, RED, WHITE, WHITE, BLUE), list);
    }
}