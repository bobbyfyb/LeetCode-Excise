package algoritm.greed;
/*
* https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 */
import java.util.Arrays;
import java.util.Comparator;

public class BurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0)
            return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if(o1[1] < o2[1])
                    return -1;
                else if(o1[1] > o2[1])
                    return 1;
                else
                    return 0;
            }
        });

        int n = 1;
        int prev = points[0][1];
        for (int[] point:points){
            if(point[0] > prev){
                n++;
                prev = point[1];
            }
        }
        return n;
    }

    public static void main(String[] args) {
        BurstBalloons burstBalloons = new BurstBalloons();
         int[][] test = new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}};
        burstBalloons.findMinArrowShots(test);
    }
}
