package com.lxc.hostest;

import java.util.*;

public class L399_除法求值 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int nvars = 0;
        Map<String, Integer> variables = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            if (!variables.containsKey(equations.get(i).get(0))) {
                variables.put(equations.get(i).get(0), nvars++);
            }
            if (!variables.containsKey(equations.get(i).get(1))) {
                variables.put(equations.get(i).get(1), nvars++);
            }
        }
        List<Pair>[] edges = new List[nvars];
        for (int i = 0; i < nvars; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < equations.size(); i++) {
            int va = variables.get(equations.get(i).get(0));
            int vb = variables.get(equations.get(i).get(1));
            edges[va].add(new Pair(vb, values[i]));
            edges[vb].add(new Pair(va, 1.0 / values[i]));
        }
        double[] ret = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            double result = -1.0;
            if (variables.containsKey(query.get(0)) && variables.containsKey(query.get(1))) {
                int ia = variables.get(query.get(0));
                int ib = variables.get(query.get(1));
                if (ia == ib) {
                    result = 1.0;
                }else {
                    Queue<Integer> queue=new LinkedList<>();
                    queue.offer(ia);
                    double[] ratios=new double[nvars];
                    Arrays.fill(ratios,-1.0);
                    ratios[ia]=1.0;

                    while (!queue.isEmpty()&& ratios[ib]<0){
                        int x= queue.poll();

                        for (Pair pair:edges[x]){
                            int y=pair.index;
                            double val=pair.value;
                            if (ratios[y]<0){
                                ratios[y]=ratios[x]*val;
                                queue.offer(y);
                            }
                        }
                    }
                    result=ratios[ib];
                }
            }
            ret[i]=result;

        }
        return ret;

    }
}

class Pair {
    int index;
    double value;

    Pair(int index, double value) {
        this.index = index;
        this.value = value;
    }
}
