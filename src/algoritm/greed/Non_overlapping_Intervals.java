package algoritm.greed;

import java.util.Arrays;
import java.util.Comparator;

public class Non_overlapping_Intervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0)
            return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int t = o1[1] - o2[1];
                if(t < 0)
                    return -1;
                else if(t > 0)
                    return 1;
                else
                    return 0;
            }
        });
        int total = 0, prev = intervals[0][1];
        for(int i = 1; i<intervals.length;i++){
            if(intervals[i][0] < prev)
                total++;
            else
                prev = intervals[i][1];
        }
        return total;

    }
}
