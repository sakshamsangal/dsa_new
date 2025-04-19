package com.app.gfg_potd.dp;

import java.util.ArrayList;
import java.util.List;

import java.util.function.BiFunction;

public class BiFunctionExample {


    public void compute(int a, int b, BiFunction<Integer, Integer, List<String>> operation) {
        List<String> tenantId = new ArrayList<>();
        for (String tenant : tenantId) {
            List<String> ole = new ArrayList<>();
            for (String ole1 : ole) {
                List<String> documents = operation.apply(a, b);
                for (String document : documents) {
                    addDocumentToQueue(document);
                }
            }
        }
    }


    public void computeAp(int a, int b, BiFunction<Integer, Integer, List<String>> operation) {
        List<String> res1 = new ArrayList<>();
        for (String res : res1) {
            List<String> res2 = new ArrayList<>();
            // save into table
        }
    }

    public  List<String> add(int x, int y) {
        return List.of("asas", "qwee");
    }


    public static void main(String[] args) {
        BiFunctionExample biFunctionExample = new BiFunctionExample();
        biFunctionExample.compute(10, 20, biFunctionExample::add);
    }

    private static void addDocumentToQueue(String s) {}

}


