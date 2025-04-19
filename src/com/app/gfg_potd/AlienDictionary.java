package com.app.gfg_potd;

import java.util.*;

public class AlienDictionary {

    List<List<Integer>> adj = new ArrayList<>();
    StringBuilder sb;

    public String findOrder(String[] words) {
        sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 1; i < words.length; i++) {
            if (!addEdge(words[i - 1], words[i])){
                return "";
            }
        }

        Set<Character> set = new HashSet<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                set.add(word.charAt(i));
            }
        }

        String s = topoSort();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

    public boolean addEdge(String s1, String s2) {
        int i = 0;
        int j = 0;

        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) != s2.charAt(j)) {
                adj.get(s1.charAt(i) - 97).add(s2.charAt(j) - 97);
                return true;
            }
            i++;
            j++;
        }
        return i == s1.length();
    }

    private String topoSort() {
        int[] inDeg = new int[26];

        for (int i = 0; i < 26; i++) {
            for (Integer nei : adj.get(i)) {
                inDeg[nei]++;
            }
        }

        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < inDeg.length; i++) {
            if (inDeg[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            handleNode(node, inDeg, queue);
            count++;
        }

        return count == 26 ? sb.toString() : "";
    }


    private void handleNode(int node, int[] inDeg, Queue<Integer> queue) {
        char ch = (char) (node + 97);
        sb.append(ch);

        for (Integer nei : adj.get(node)) {
            inDeg[nei]--;
            if (inDeg[nei] == 0) {
                queue.add(nei);
            }
        }
    }

    public static void main(String[] args) {
        AlienDictionary alienDictionary = new AlienDictionary();
        String[] w = {"baa", "abcd", "abca", "cab", "cad"};
        String order = alienDictionary.findOrder(w);
        System.out.println("order = " + order);
    }
}
