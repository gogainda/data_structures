package com.google.graph;

import java.util.*;

public class BfsIterative {


    void iterate(Map<Vertex, List<Vertex>> adj, Vertex from ) {
        HashMap<Vertex, Integer>  level = new HashMap<>();
        level.put(from, 0);

        HashMap<Vertex, Vertex>  parent = new HashMap<>();
        level.put(from, null);

        int i = 1;
        List<Vertex> frontier = new ArrayList<>();
        frontier.add(from);
        while(!frontier.isEmpty()) {
            List<Vertex> next = new ArrayList<>();
            for(Vertex u: frontier) {
                for(Vertex v: adj.get(u)) {
                    if (!level.containsKey(v)) {
                        level.put(v, i);
                        parent.put(v, u);
                        System.out.println(v + ", parent:" + u);
                        next.add(v);
                    }
                }
            }
            frontier = next;
            i++;
        }

    }
}
