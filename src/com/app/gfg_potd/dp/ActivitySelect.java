package com.app.gfg_potd.dp;

import com.app.dsa.model.Activity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ActivitySelect {

    public int activitySelection(int[] start, int[] finish) {

        List<Activity> activities = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            activities.add(new Activity(start[i], finish[i], i));
        }
        activities.sort(Comparator.comparingInt(o -> o.start));
        int count = 1;
        Activity prev = activities.get(0);

        for (int i = 1; i < activities.size(); i++) {
            Activity curr = activities.get(i);
            if (prev.end < curr.start) {
                prev = curr;
                count++;
            } else if (curr.end < prev.end) {
                prev = curr;
            }
        }
        return count;
    }

}
