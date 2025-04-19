package com.app.gfg_potd.april;

import java.util.Objects;

public class Trie {

    static class TrieNode {
        TrieNode[] nodes = new TrieNode[26];
        boolean isEnd;
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode curr = root;

        for (int i = 0; i < word.length(); i++) {
            TrieNode trieNode = curr.nodes[word.charAt(i) - 97];
            if (Objects.isNull(trieNode)) {
                trieNode = new TrieNode();
                curr.nodes[word.charAt(i) - 97] = trieNode;
            }
            curr = trieNode;
        }
        curr.isEnd = true;

    }

    // Search for a word in the Trie
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode node = curr.nodes[word.charAt(i) - 97];
            if (node == null) {
                return false;
            }
            curr = node;
        }
        return curr.isEnd;
    }

    // Check if a prefix exists in the Trie
    public boolean isPrefix(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode node = curr.nodes[word.charAt(i) - 97];
            if (node == null) {
                return false;
            }
            curr = node;
        }
        return true;
    }
}