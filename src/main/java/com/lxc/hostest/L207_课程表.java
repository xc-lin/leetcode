package com.lxc.hostest;

import java.util.ArrayList;
import java.util.List;

public class L207_课程表 {
    int visited[];
    int[][] graph;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new int[numCourses][numCourses];
        int m = prerequisites.length;
        if (m == 0) {
            return true;
        }
        int n = prerequisites[0].length;
        for (int i = 0; i < m; i++) {
            graph[prerequisites[i][1]][prerequisites[i][0]] = 1;
        }
        visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int i) {
        if (visited[i] == 1) return false;
        if (visited[i] == -1) return true;
        visited[i] = 1;
        for (int j = 0; j < visited.length; j++) {
            if (graph[i][j] == 1) {
                if (!dfs(j)) {
                    return false;
                }
            }
        }
        visited[i] = -1;
        return true;
    }

    List<List<Integer>> adjacency = new ArrayList<>();

    public boolean canFinish2(int numCourses, int[][] prerequisites) {

        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adjacency.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs2(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs2(int i) {
        if (visited[i] == 1) return false;
        if (visited[i] == -1) return true;
        visited[i] = 1;
        for (int j = 0; j < adjacency.get(i).size(); j++) {
            if (!dfs2(adjacency.get(i).get(j))) {
                return false;
            }

        }
        visited[i] = -1;
        return true;
    }
}
