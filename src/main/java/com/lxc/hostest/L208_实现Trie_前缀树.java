package com.lxc.hostest;

public class L208_实现Trie_前缀树 {
    L208_实现Trie_前缀树 children[];
    boolean isEnd;

    /**
     * Initialize your data structure here.
     */
    public L208_实现Trie_前缀树() {
        children = new L208_实现Trie_前缀树[26];
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {

        char[] c = word.toCharArray();
        L208_实现Trie_前缀树 node = this;
        for (int i = 0; i < c.length; i++) {
            if (node.children[c[i] - 'a'] == null) {
                node.children[c[i] - 'a'] = new L208_实现Trie_前缀树();
            }
            node = node.children[c[i] - 'a'];
        }
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        char[] c = word.toCharArray();
        L208_实现Trie_前缀树 node = this;
        for (int i = 0; i < c.length; i++) {
            if (node.children[c[i] - 'a'] == null) {
                return false;
            }
            node = node.children[c[i] - 'a'];
        }
        if (node.isEnd) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] c = prefix.toCharArray();
        L208_实现Trie_前缀树 node = this;
        for (int i = 0; i < c.length; i++) {
            if (node.children[c[i] - 'a'] == null) {
                return false;
            }
            node = node.children[c[i] - 'a'];
        }
        return true;
    }
}
