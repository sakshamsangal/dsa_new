package com.app.dsa;

public class Main {
    public static void foo(Integer val) {
        val = 5;
    }

    public static void main(String[] args) {
        Integer x = 2;
        foo(x);
        System.out.println("x = " + x);
    }
}