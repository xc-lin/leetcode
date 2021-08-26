package com.lxc.hostest;

public class L79_单词搜索 {
    int m, n;
    char[][] board;
    String word;
    int length;
    boolean visited[][];

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited=new boolean[m][n];
        this.board = board;
        this.word = word;
        length = word.length();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i,j,0)){
                    System.out.println(i+" "+j);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int i, int j, int depth) {
        if (depth == length) {
            return true;
        }
        if (i >= m || i < 0 || j < 0 || j >= n||visited[i][j]) {
            return false;
        }
        if (word.charAt(depth) != board[i][j]) {
            return false;
        }
        try {
            visited[i][j]=true;
            return dfs(i, j - 1, depth + 1) || dfs(i, j + 1, depth + 1) || dfs(i - 1, j, depth + 1) || dfs(i + 1, j, depth + 1);
        }finally {
            visited[i][j]=false;
        }
    }

}
