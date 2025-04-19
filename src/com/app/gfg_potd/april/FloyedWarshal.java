package com.app.gfg_potd.april;

public class FloyedWarshal {


    private static void updateCell(int[][] mat, int via) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (i != j
                        && mat[i][via] != 100000000
                        && mat[via][j] != 100000000) {
                    int sum = mat[i][via] + mat[via][j];
                    if (sum < mat[i][j]) {
                        mat[i][j] = sum;
                    }
                }
            }
        }
    }


    public void floydWarshall(int[][] dis) {
        for (int i = 0; i < dis.length; i++) {
            dis[i][i] = 0;
        }

        for (int i = 0; i < dis.length; i++) {
            updateCell(dis, i);
        }

    }
}
