package com.lxc.medium.BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.HashSet;

public class Permutation {
    public String[] permutation(String s) {
        char strs[] = s.toCharArray();
        ArrayList<String> result= new ArrayList<>();
        char temp[]=new char[s.length()];
        result=a(result,temp,strs,0);
        return result.toArray(new String[result.size()]);
    }

    public ArrayList<String> a(ArrayList<String> result, char temp[], char strs[], int k) {
        if (k == strs.length - 1) {
            temp[k]=strs[k];
            result.add(String.valueOf(temp));
            return result;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = k; i < strs.length; i++) {
            if (set.contains(strs[i]))
                continue;
            temp[k] = strs[i];
            set.add(strs[i]);
            char temp2[]= strs.clone();
            char tempx = temp2[i];
            temp2[i]=temp2[k];
            temp2[k]=tempx;
            result=a(result,temp,temp2,k+1);

        }
        return result;

    }
}
