package com.app.dsa.part2.graph;

import com.app.dsa.model.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ample6_31_24 {
    public static void main(String[] args) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(5, Comparator.comparingInt(o -> o.ceil));
        pq.add(new Pair(10, 2));
        pq.add(new Pair(20, 2));
        Pair pair = new Pair(50, 2);
        pq.add(pair);

        pair.ceil = 5;
        pair.visited = true;
        pq.add(pair);

        while (!pq.isEmpty()) {
            Pair poll = pq.poll();
            if (!poll.visited) {
                System.out.println("poll.ceil = " + poll.ceil);
            }
        }

    }
}
