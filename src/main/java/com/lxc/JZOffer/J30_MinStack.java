package com.lxc.JZOffer;

import java.util.Stack;

public class J30_MinStack {
    /** initialize your data structure here. */
    Stack<Integer> normal, min;
    public J30_MinStack() {
        normal=new Stack<>();
        min=new Stack<>();
    }

    public void push(int x) {
        normal.push(x);
        // 当min是空的时候，是normal是空,min也是空的情况，往min中添加int,可以保底，min的栈底和normal的栈底是一样的
        // 最起码min里面的元素不会为空，直到normal里面为空'
        // 加等号的原因是，如果不加等号，如果stack里有两个一样的最小值元素，一个最小值呗pop，normal里还有一个，但是min里面就没有了
        // 而且如果最小值是栈底元素，pop了，min栈里元素就空了
        if (min.isEmpty()||min.peek()>=x){
            min.push(x);
        }
    }
    public void pop() {
        // 因为是包装类，没有自动拆箱，所以要用equal
        if (normal.peek().equals(min.peek())){
            min.pop();
        }
        normal.pop();
    }
    // stack里面的top是peek()
    public int top() {
        return normal.peek();
    }

    public int min() {
        return min.peek();
    }
}
