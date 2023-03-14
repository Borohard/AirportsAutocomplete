package org.example.Trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    TrieNode rootNode;

    public Trie(List<String> words) {
        rootNode = new TrieNode();
        for (String word : words)
            rootNode.insert(word);
    }

    public void suggestHelper(TrieNode root, List<String> list, StringBuffer curr) {
        if (root.isWord) {
            list.add(curr.toString());
        }

        if (root.childrenNodes == null || root.childrenNodes.isEmpty())
            return;

        for (TrieNode childNode : root.childrenNodes.values()) {
            suggestHelper(childNode, list, curr.append(childNode.c));
            curr.setLength(curr.length() - 1);
        }
    }

    public List<String> suggest(String prefix) {
        List<String> list = new ArrayList<>();
        TrieNode lastNode = rootNode;
        StringBuffer curr = new StringBuffer();
        for (char c : prefix.toCharArray()) {
            lastNode = lastNode.childrenNodes.get(c);
            if (lastNode == null)
                return list;
            curr.append(c);
        }
        suggestHelper(lastNode, list, curr);
        return list;
    }
}
