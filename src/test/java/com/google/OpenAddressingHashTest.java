package com.google;

import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OpenAddressingHashTest {


    @Test
    void addValue() {
        OpenAddressingHash openAddressingHash  = new OpenAddressingHash();
        openAddressingHash.add(1, "one");
        openAddressingHash.add(2, "two");
        openAddressingHash.add(3, "three");

        OpenAddressingHash openAddressingHash2  = new OpenAddressingHash();
        openAddressingHash2.add(1, "one");
        openAddressingHash2.add(2, "two");
        openAddressingHash2.add(3, "three");

        assertEquals(openAddressingHash, openAddressingHash2);


    }

    @Test
    void addValue2() {
        OpenAddressingHash openAddressingHash  = new OpenAddressingHash();
        openAddressingHash.add(100, "one");
        openAddressingHash.add(20, "two");
        openAddressingHash.add(3, "three1");
        openAddressingHash.add(4, "three2");
        openAddressingHash.add(5, "three3");
        openAddressingHash.add(6, "three4");
        openAddressingHash.add(7, "three5");
        openAddressingHash.add(8, "three6");
        openAddressingHash.add(9, "three7");
        openAddressingHash.add(10, "three8");
        openAddressingHash.add(110, "three9");
        openAddressingHash.add(12, "three11");
        openAddressingHash.add(13, "three12");


    }

    @Test
    void getValue() {
        OpenAddressingHash openAddressingHash  = new OpenAddressingHash();
        openAddressingHash.add(100, "one");
        openAddressingHash.add(20, "two");

    System.out.println(openAddressingHash.values);
    System.out.println(openAddressingHash.keys);

        assertEquals("two", openAddressingHash.get(20));
        assertEquals(null, openAddressingHash.get(101));
    }

    @Test
    void deleteValue() {
        OpenAddressingHash openAddressingHash  = new OpenAddressingHash();
        openAddressingHash.add(100, "one");
        openAddressingHash.add(20, "two");

        openAddressingHash.remove(20);
        openAddressingHash.remove(100);
        openAddressingHash.add(21, "two1");



        assertEquals(null, openAddressingHash.get(20));
        assertEquals(null, openAddressingHash.get(100));
        assertEquals("two1", openAddressingHash.get(21));
    }
}