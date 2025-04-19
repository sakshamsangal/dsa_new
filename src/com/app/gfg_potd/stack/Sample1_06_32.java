package com.app.gfg_potd.stack;

import java.util.Objects;
import java.util.Stack;

public class Sample1_06_32 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            if (minStack.isEmpty() || Objects.equals(stack.peek(), minStack.peek())) {
                minStack.pop();
            }
            stack.pop();
        }
    }

    public int peek() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public int getMin() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }

    public static void main(String[] args) {
        Sample1_06_32 sample1_06_32 = new Sample1_06_32();
        sample1_06_32.push(2);
        sample1_06_32.push(3);
        System.out.println("sample1_06_32.stack = " + sample1_06_32.stack);
        System.out.println("sample1_06_32.stack = " + sample1_06_32.minStack);
        sample1_06_32.pop();
        int min = sample1_06_32.getMin();


    }
}
