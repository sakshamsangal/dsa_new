package com.app.gfg_potd.queue;


import com.app.dsa.model.gfg.linklist.Node;

import java.util.*;

public class ample9_14_26 {

    // Function to merge K sorted linked list.
    Node mergeKLists(List<Node> arr) {

        Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(x->x.data));

        Node head = new Node(-1);
        Node tail = head;

        while (!arr.isEmpty()) {
            for (int i = 0; i < arr.size(); i++) {
                Node removed = arr.remove(i);
                pq.add(removed);

                Node next = removed.next;
                if (Objects.nonNull(next)) {
                    arr.add(next);
                }
            }
            tail = addLast(tail, pq.poll());
        }

        return head.next;
    }


    public Node addLast(Node tail, Node item) {
        tail.next = item;
        return item;
    }
}
