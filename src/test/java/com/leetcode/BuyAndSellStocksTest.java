package com.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuyAndSellStocksTest {

    @Test
    void test() {
        BuyAndSellStocks buyAndSellStocks = new BuyAndSellStocks();
        int[] ary = {1, 19, 2, 22};
        assertEquals(5, buyAndSellStocks.maxProfit(ary));
    }

}