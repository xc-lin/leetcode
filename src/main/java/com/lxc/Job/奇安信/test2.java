package com.lxc.Job.奇安信;

import java.util.*;

public class test2 {
    int size;
    StringBuilder sb = new StringBuilder();
    char[] seed;
    List<String> list=new LinkedList<>();

    public String[] Permutation(char[] seed, int size) {
        Arrays.sort(seed);
        this.size = size;
        this.seed = seed;
        dfs(new HashSet<>(),0,0);
        return list.toArray(new String[list.size()]);

    }

    public void dfs(Set<Character> set, int index, int depth) {
        if (sb.length()==size) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < seed.length; i++) {
            if (!set.contains(seed[i])) {
                sb.append(seed[i]);
                set.add(seed[i]);
                dfs(set, 0, depth + 1);
                sb.deleteCharAt(sb.length() - 1);
                set.remove(seed[i]);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new test2().Permutation(new char[]{'0','1','2'},2)));
    }

}
