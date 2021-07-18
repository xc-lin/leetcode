package com.lxc.JZOffer;

public class J12_Exist {
    int m, n;
    String word;
    char[][] board;

    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        this.n = board[0].length;
        this.word = word;
        this.board = board;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean visited[][] = new boolean[m][n];
                if (dfs(i, j, 0, visited)) {
                    return true;
                }

            }

        }
        return false;
    }

    public boolean dfs(int i, int j, int index, boolean visited[][]) {
        if (0 >i|| i >= m ||j<0|| j >= n || board[i][j] != word.charAt(index)||visited[i][j]) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        ++index;
        boolean result= dfs(i + 1, j, index, visited) || dfs(i, j + 1, index, visited) || dfs(i - 1, j, index, visited) || dfs(i, j - 1, index, visited);
        visited[i][j] = false;
        return result;
    }
}
