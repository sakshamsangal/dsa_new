package com.app.gfg_potd.dp;

import java.util.Stack;

public class LongestValidParentheses {


    static int maxLength(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (1 == stack.size()) {
                // track last closing
                stack.pop();
                stack.push(i);
            } else {
                stack.pop();
                max = Math.max(max, (i - stack.peek()));
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int i = maxLength("((()");
        System.out.println("i = " + i);
    }
}



