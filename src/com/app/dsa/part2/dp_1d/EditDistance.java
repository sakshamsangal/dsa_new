package com.app.dsa.part2.dp_1d;

class EditDistance {

    DpInfoTab2d dpInfoTab2d;

    public int editDistanceTab(String s1, String s2, DpInfoTab2d dpInfoTab2d) {
        int dpRowSize = dpInfoTab2d.dp.length;
        int dpColSize = dpInfoTab2d.dp[0].length;

        for (int i = 1; i < dpRowSize; i++) {
            for (int j = 1; j < dpColSize; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    int opt3 = dpInfoTab2d.getAnsForIndex(i - 1, j - 1);
                    dpInfoTab2d.saveAnsForIndex(i, j, opt3);

                } else {

                    int opt1 = dpInfoTab2d.getAnsForIndex(i - 1, j);
                    int opt2 = dpInfoTab2d.getAnsForIndex(i, j - 1);
                    int opt3 = dpInfoTab2d.getAnsForIndex(i - 1, j - 1);
                    int min = 1 + Math.min(Math.min(opt1, opt2), opt3);

                    dpInfoTab2d.saveAnsForIndex(i, j, min);
                }
            }
        }
        return this.dpInfoTab2d.getAnsForIndex(dpRowSize - 1, dpColSize - 1);
    }


    public int editDistance1(String s1, String s2) {
        dpInfoTab2d = new DpInfoTab2d(s1.length(), s2.length(), dp -> {
            int count = 0;
            for (int i = 0; i < dp.length; i++) {
                dp[i][0] = count++;
            }
            count = 0;
            for (int j = 0; j < dp[0].length; j++) {
                dp[0][j] = count++;
            }
        });

        return editDistanceTab(s1, s2, dpInfoTab2d);
    }

    public int editDistance(String s1, String s2) {
        int[] dp = new int[s2.length() + 1];
        int[] dp2 = new int[s2.length() + 1];

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                int opt1 = dp[j];
                int opt2 = dp2[j - 1];
                int opt3 = dp[j - 1];
                int min = 1 + Math.min(Math.min(opt1, opt2), opt3);

                dp[i] = min;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        editDistance.editDistance("geek", "gesek");
    }
}