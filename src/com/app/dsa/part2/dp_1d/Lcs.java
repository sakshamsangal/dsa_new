package com.app.dsa.part2.dp_1d;

public class Lcs {
    static int lcs(String s1, String s2) {
        DpInfoTab2d dpInfoTab2d = new DpInfoTab2d(s1.length(), s2.length(), dp -> {
            DpUtil.fillAllZeroInFirstRow(dp);
            DpUtil.fillAllZeroInFirstCol(dp);
        });

        for (int i = 1; i < dpInfoTab2d.dpRows; i++) {
            for (int j = 1; j < dpInfoTab2d.dpCols; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    int opt1 = dpInfoTab2d.getAnsForIndex(i - 1, j - 1);
                    dpInfoTab2d.saveAnsForIndex(i, j, opt1);
                } else {
                    int opt1 = dpInfoTab2d.getAnsForIndex(i - 1, j);
                    int opt2 = dpInfoTab2d.getAnsForIndex(i, j - 1);
                    dpInfoTab2d.saveAnsForIndex(i, j, Math.max(opt1, opt2));
                }
            }
        }
        return dpInfoTab2d.getAnsForIndex(dpInfoTab2d.dpRows - 1, dpInfoTab2d.dpCols - 1);
    }
}
