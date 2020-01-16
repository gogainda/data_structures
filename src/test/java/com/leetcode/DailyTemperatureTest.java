package com.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DailyTemperatureTest {

  @Test
  void dailyTemperatures() {
    DailyTemperature dt = new DailyTemperature();
    int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};
    dt.dailyTemperatures(temps);
  }
}