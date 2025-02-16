package com.app.dsa.binary_search_space;

import java.util.*;

public class Sample8_01_17 {
    static class Node {
        int data;
        Node next;
        Node random;

        Node(int x) {
            data = x;
            next = null;
            random = null;
        }
    }

    record NodeInfo(boolean hasLoop, Node slow, Node fast, Node prev) {
    }

    public static void removeLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while (Objects.nonNull(fast) && Objects.nonNull(fast.next)) {
            Node prev = slow;
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                while (head != slow) {
                    head = head.next;
                    prev = slow;
                    slow = slow.next;
                }
                prev.next = null;
            }
        }
    }


    static Node addTwoLists(Node num1, Node num2) {
        while (Objects.nonNull(num1) && num1.data == 0) {
            num1 = num1.next;
        }

        while (Objects.nonNull(num2) && num2.data == 0) {
            num2 = num2.next;
        }

        num1 = reverseList(num1);
        num2 = reverseList(num2);

        int carry = 0;

        Node newHead = null;
        while (Objects.nonNull(num1) && Objects.nonNull(num2)) {
            int sum = carry + num1.data + num2.data;
            if (9 < sum) {
                carry = 1;
                sum = sum % 10;
            }
            Node item = new Node(sum);
            item.next = newHead;
            newHead = item;
            num1 = num1.next;
            num2 = num2.next;
        }
        while (Objects.nonNull(num1)) {
            int sum = carry + num1.data;
            if (9 < sum) {
                carry = 1;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            Node item = new Node(sum);
            item.next = newHead;
            newHead = item;
            num1 = num1.next;
        }

        while (Objects.nonNull(num2)) {
            int sum = carry + num2.data;
            if (9 < sum) {
                carry = 1;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            Node item = new Node(sum);
            item.next = newHead;
            newHead = item;
            num2 = num2.next;
        }

        if (carry == 1) {
            Node item = new Node(1);
            item.next = newHead;
            newHead = item;
        }
        return newHead;
    }


    public static Node reverseList(Node head) {
        Node curr = head;
        Node newHead = null;
        while (Objects.nonNull(curr)) {
            Node item = curr;
            curr = curr.next;
            newHead = addFirst(newHead, item);
        }
        return newHead;
    }

    public static Node addFirst(Node head, Node item) {
        item.next = head;
        return item;
    }


    public Node cloneLinkedList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (Objects.nonNull(curr)) {
            map.put(curr, new Node(curr.data));
            curr = curr.next;
        }

        curr = head;
        while (Objects.nonNull(curr)) {
            Node node = map.get(curr);
            node.next = map.get(curr.next);
            node.random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }

    public static Node findFirstNode(Node head) {
        Set<Node> set = new HashSet<>();
        Node curr = head;
        while (Objects.nonNull(curr)) {
            if (set.contains(curr)) {
                return curr;
            }
            set.add(curr);
            curr = curr.next;
        }
        return null;
    }

    public static boolean detectLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while (Objects.nonNull(fast) && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Sample8_01_17 sample8_01_17 = new Sample8_01_17();
        int[] arr = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
    }

}
