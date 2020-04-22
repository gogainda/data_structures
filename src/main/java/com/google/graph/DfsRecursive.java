package com.google.graph;

import java.util.*;

public class DfsRecursive {
    Set<Vertex> visited;
    int time = 0;
    Map<Vertex, Integer> times = new HashMap<>();

    void iterate(Map<Vertex, List<Vertex>> input, Vertex from) {
        visited = new HashSet<>();
        visit(input, from);
        List<Map.Entry<Vertex, Integer>> entrySet = new ArrayList<>(times.entrySet());
        entrySet.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for (Map.Entry<Vertex, Integer> entry: entrySet) {
            System.out.println("v:" + entry.getKey() + "time:" + entry.getValue());
        }
    }

    private void visit(Map<Vertex, List<Vertex>> input, Vertex vertex) {
        visited.add(vertex);
        System.out.println(vertex);
        for(Vertex friend: input.get(vertex)) {
            if (!visited.contains(friend)) {
                visit(input, friend);
            }
        }
        time++;
        times.put(vertex, time);

    }


}
