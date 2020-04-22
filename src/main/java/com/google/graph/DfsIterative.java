package com.google.graph;

import java.util.*;

public class DfsIterative {
  Set<Vertex> processed = new HashSet<>();
  Stack<Vertex> order = new Stack<>();

  void iterate(Map<Vertex, List<Vertex>> input, Vertex from) {
    Stack<Vertex> stack = new Stack<>();

    Vertex curr = from;
    while (!stack.isEmpty() || curr != null) {
      if (curr != null) {
        stack.add(curr);

        curr = getNextUnvisited(input, curr);
      } else {
        if (processed.contains(stack.peek())) {
          stack.pop();
        } else {
          Vertex v = stack.peek();
          curr = getNextUnvisited(input, v);
        }



      }
    }

    while (!order.isEmpty()) {
      Vertex v = order.pop();
      System.out.println("top order:" + v);
    }
  }

  private Vertex getNextUnvisited(Map<Vertex, List<Vertex>> input, Vertex v) {
    if (processed.contains(v)) {
      return null;
    }
    Vertex unvisited = null;
    boolean allProcessed = true;
    for (Vertex neib : input.get(v)) {
      if (!processed.contains(neib)) {
        // get first unprocessed neigbour
        unvisited = neib;
        allProcessed = false;
        break;
      }
    }
    if (allProcessed) {
      order.push(v);
      processed.add(v);
    }
    return unvisited;
  }
}
