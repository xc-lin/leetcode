package com.lxc.hostest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L621_任务调度器 {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }
        int m = map.size();
        List<Integer> nextValid = new ArrayList<>();
        List<Integer> rest = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            // 下一次可以在什么时间执行
            nextValid.add(1);
            // 代表第几个任务还剩余的次数
            rest.add(entry.getValue());
        }

        int time = 0;
        for (int i = 0; i < tasks.length; i++) {
            time++;
            int min = Integer.MAX_VALUE;
            //判断是不是需要直接跳过冷却时间，接下来的时间就是下一个任务可以执行的时间
            for (int j = 0; j < m; j++) {
                if (rest.get(j) != 0) {
                    min = Math.min(min, nextValid.get(j));
                }
            }
            // 可能这个任务在这个时间点之前就可以执行
            time = Math.max(time, min);
            int best = -1;
            for (int j = 0; j < m; j++) {
                if (rest.get(j) != 0 && nextValid.get(j) <= time) {
                    if (best == -1 || rest.get(j) > rest.get(best)) {
                        best = j;
                    }
                }
            }
            nextValid.set(best,time+n+1);
            rest.set(best,rest.get(best)-1);

        }
        return time;
    }
}
