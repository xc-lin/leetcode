package com.lxc.JZOffer2;

public class J12_Exist {
    boolean visit[][];
    char c[];
    char[][] board;
    boolean result = false;

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        c = word.toCharArray();
        this.board = board;
        visit = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, 0);
                if (result == true) {
                    return true;
                }
            }
        }
        return result;
    }

    public void dfs(int i, int j, int depth) {
        if (i > board.length - 1 || i < 0 || j > board[0].length - 1 || j < 0 || c[depth] != board[i][j] || visit[i][j] == true) {
            return;
        }
        if (depth == c.length - 1) {
            result = true;
            return;
        }
        if (result == true) {
            return;
        }

        visit[i][j] = true;
        dfs(i + 1, j, depth + 1);
        dfs(i - 1, j, depth + 1);
        dfs(i, j + 1, depth + 1);
        dfs(i, j - 1, depth + 1);
        visit[i][j] = false;
    }

    public static void main(String[] args) {
        System.out.println(new J12_Exist().exist(new char[][]{{'a'}}, "ab"));
    }
}
