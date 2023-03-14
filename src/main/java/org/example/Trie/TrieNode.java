package org.example.Trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<Character, TrieNode> childrenNodes;
    char c;
    boolean isWord;

    public TrieNode(char c) {
        this.c = c;
        childrenNodes = new HashMap<>();
    }

    public TrieNode() {
        childrenNodes = new HashMap<>();
    }

    public void insert(String word) {
        if (word == null || word.isEmpty())
            return;
        char firstChar = word.charAt(0);
        TrieNode childNode = childrenNodes.get(firstChar);
        if (childNode == null) {
            childNode = new TrieNode(firstChar);
            childrenNodes.put(firstChar, childNode);
        }

        if (word.length() > 1)
            childNode.insert(word.substring(1));
        else
            childNode.isWord = true;
    }

}
