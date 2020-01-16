package com.epi.arrays;

import java.util.Collections;
import java.util.List;

public class DutchNationalFlag {
    public enum Color {RED, WHITE, BLUE};
    public static void dutchFlagPartition(int pivotIndex, List<Color> A){
        Color pivot = A.get(pivotIndex);
        int smaller = 0;
        for(int i = 0; i < A.size(); i++) {
            if (A.get(i).ordinal() < pivot.ordinal()) {
                Collections.swap(A, smaller++, i);
            }
        }

        int larger = A.size() - 1;
        for(int i = A.size() - 1; i >= 0; i--) {
            if (A.get(i).ordinal() > pivot.ordinal()) {
                Collections.swap(A, larger--, i);
            }
        }


    }
}
