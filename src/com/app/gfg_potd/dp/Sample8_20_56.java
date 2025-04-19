package com.app.gfg_potd.dp;

import com.app.dsa.model.Job;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sample8_20_56 {


    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {

        List<Job> jobs = new ArrayList<>();

        int maxDeadline = 0;
        for (int i = 0; i < deadline.length; i++) {
            Job job = new Job(i, deadline[i], profit[i]);
            jobs.add(job);
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }

        jobs.sort(Comparator.comparingInt(x -> x.profit));

        Job last = jobs.get(jobs.size() - 1);
        boolean[] busySlot = new boolean[maxDeadline + 1];

        int benefit = 0;
        int jobCount = 0;

        for (int i = jobs.size() - 1; i >= 0; i--) {
            Job curr = jobs.get(i);

            int j = curr.deadline;
            while (-1 < j) {
                if (!busySlot[j]) {
                    benefit += curr.profit;
                    jobCount++;
                    busySlot[j] = true;
                    break;
                }
                j--;
            }

        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(jobCount);
        ans.add(benefit);
        return ans;
    }
}
