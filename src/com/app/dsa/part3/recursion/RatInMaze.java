package com.app.dsa.part3.recursion;

import java.util.ArrayList;

public class RatInMaze {

    private static int[][] getMat2d(ArrayList<ArrayList<Integer>> mat) {
        int[][] mat2d = new int[mat.size()][mat.get(0).size()];
        for (int i = 0; i < mat.size(); i++) {
            ArrayList<Integer> row = mat.get(i);
            for (int j = 0; j < row.size(); j++) {
                mat2d[i][j] = row.get(j);
            }
        }
        return mat2d;
    }

    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        int[][] mat2d = getMat2d(mat);

        return null;
    }


}
