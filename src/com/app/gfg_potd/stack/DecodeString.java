package com.app.gfg_potd.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DecodeString {

    static String decodeStringold(String s) {
        Stack<Character> st = new Stack<>();
        Stack<String> stAns = new Stack<>();


        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                StringBuilder temp = new StringBuilder();

                while (!st.isEmpty() && st.peek() != '[') {
                    temp.append(st.pop());
                }
                temp.reverse();
                st.pop();

                StringBuilder size = new StringBuilder();
                while (!st.isEmpty() && '0' <= st.peek() && st.peek() <= '9') {
                    size.append(st.pop());
                }
                // bcaca
                // bcaca
                // bcaca
                decodeString1(temp, Integer.parseInt(size.reverse().toString()) - 1);
                stAns.push(temp.toString());
            } else {
                st.push(s.charAt(i));
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stAns.isEmpty()) {
            stringBuilder.append(stAns.pop());
        }
        return stringBuilder.toString();
    }


    static void decodeString1(StringBuilder sb, int size) {
        int end = sb.length();
        sb.append(String.valueOf(sb.subSequence(0, end)).repeat(size));
    }



    private static void simplifyString(Stack<Character> st) {
        List<Character> al = new ArrayList<>();

        while (st.peek() != '[') {
            al.add(st.pop());
        }
        st.pop();

        StringBuilder numStr = new StringBuilder();
        while (!st.isEmpty() && '0' <= st.peek() && st.peek() <= '9') {
            numStr.append(st.pop());
        }

        int num = Integer.parseInt(numStr.reverse().toString());
        while (num != 0) {
            for (int i = al.size() - 1; i >= 0; i--) {
                Character ch = al.get(i);
                st.push(ch);
            }
            num--;
        }
    }

    static String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                simplifyString(st);
            } else {
                st.push(s.charAt(i));
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String s = decodeString("3[b2[ca]]");
        // String s = decodeString("3abab");
        System.out.println("s = " + s);
    }

}
