package com.app.gfg_potd.dp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinimumPlatforms {
    static class Train {
        public int arr;
        public int dep;
        public int platformRequired = 1;

        public Train(int arr, int dep) {
            this.arr = arr;
            this.dep = dep;
        }
    }

    private static int totalPlatform(Train prev, Train curr) {
        if (prev.dep < curr.arr) {
            return curr.platformRequired = prev.platformRequired;
        }
        return curr.platformRequired = prev.platformRequired + 1;
    }

    static int findPlatform(int arr[], int dep[]) {

        List<Train> trains = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            trains.add(new Train(arr[i], dep[i]));
        }

        trains.sort(Comparator.comparingInt(o -> o.arr));
        int ans = 1;
        for (int i = 1; i < trains.size(); i++) {
            int x = totalPlatform(trains.get(i - 1), trains.get(i));
            ans = Math.max(ans, x);
        }
        return ans;
    }

    //1114 825 357 1415
    // 54 2323
    // 1740 1110 2238 1535

}
