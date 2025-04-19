package com.app.dsa;

import java.util.*;

public class Sample10_49_20 {

    List<List<Character>> vertices = new ArrayList<>();
    StringBuilder sb;

    public String findOrder(String[] words) {
        sb = new StringBuilder();

        Map<Character, Integer> inDeg = new HashMap<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (!inDeg.containsKey(word.charAt(i))) {
                    inDeg.put(word.charAt(i), 0);
                }
            }
        }

        for (int i = 0; i < inDeg.size(); i++) {
            vertices.add(new ArrayList<>());
        }


        for (int i = 1; i < words.length; i++) {
            if (!addEdge(words[i - 1], words[i])) {
                return "";
            }
        }
        return topoSort(inDeg);
    }

    public boolean addEdge(String s1, String s2) {
        int i = 0;
        int j = 0;

        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) != s2.charAt(j)) {
                vertices.get(s1.charAt(i)).add(s2.charAt(j));
                return true;
            }
            i++;
            j++;
        }
        return i < s1.length() && j == s2.length();
    }

    private String topoSort(Map<Character, Integer> inDeg) {

        for (List<Character> nieList : vertices) {
            for (Character nei : nieList) {
                Integer val = inDeg.getOrDefault(nei, 0);
                inDeg.put(nei, val + 1);
            }
        }

        Queue<Character> queue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : inDeg.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            Character node = queue.poll();
            handleNode(node, inDeg, queue);
            count++;
        }

        return count == 26 ? sb.toString() : "";
    }


    private void handleNode(Character node, Map<Character, Integer> inDeg, Queue<Character> queue) {
        sb.append(node);

        for (List<Character> neiList : vertices) {
            for (Character nei : neiList) {


                Integer val = inDeg.getOrDefault(nei, 0);
                inDeg.put(nei, val - 1);

                if (inDeg.get(nei) == 0) {
                    queue.add(nei);
                }
            }
        }
    }

    public static void main(String[] args) {
        Sample10_49_20 sample10_49_20 = new Sample10_49_20();
        String[] w = {"baa", "abcd", "abca", "cab", "cad"};
        String order = sample10_49_20.findOrder(w);
        System.out.println("order = " + order);
    }
}
