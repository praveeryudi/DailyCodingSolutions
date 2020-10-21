package src.solutions.dailySolutions;

import java.util.*;

/**
 * You are given a list of jobs to be done, where each job is represented by a start time and end time.
 * Two jobs are compatible if they don't overlap. Find the largest subset of compatible jobs.
 *
 * For example, given the following jobs (there is no guarantee that jobs will be sorted):
 *
 * [(0, 6),
 * (1, 4),
 * (3, 5),
 * (3, 8),
 * (4, 7),
 * (5, 9),
 * (6, 10),
 * (8, 11)]
 * Return:
 *
 * [(1, 4),
 * (4, 7),
 * (8, 11)]
 */
public class _397_Compatible_Jobs {

    public static void main(String[] args) {
        int[][] jobs = {
                {0,6},
                {1,4},
                {3,5},
                {3,8},
                {4,7},
                {5,9},
                {6,10},
                {8,11}
        };

        Arrays.sort(jobs, (a,b) -> a[1] - b[1]);
        List<int[]> compatibleJobs = new ArrayList<>();
        for(int[] arr : jobs) {
            if(compatibleJobs.isEmpty()) {
                compatibleJobs.add(arr);
                continue;
            }

            int[] prev = compatibleJobs.get(compatibleJobs.size() - 1);
            // If interval overlapping
            if(arr[0] < prev[1]) {
                if(arr[1] < prev[1]) {
                    compatibleJobs.add(arr);
                }
                else {
                    compatibleJobs.add(prev);
                }
            }
            else {
                compatibleJobs.add(arr);
            }
        }

        Set<int[]> res = new HashSet<>(compatibleJobs);
        compatibleJobs.clear();
        compatibleJobs.addAll(res);
        compatibleJobs.sort((a,b) -> a[0] - b[0]);

        for(int[] curr : compatibleJobs)
            System.out.println(Arrays.toString(curr));
    }

}
