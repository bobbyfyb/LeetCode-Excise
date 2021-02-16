package algoritm.sort;
/*
* https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for(int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0)+1);
            }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        pq.addAll(counts.entrySet());

        int[] results = new int[k];

        for(int i=0;i<k;i++)
            results[i] = pq.remove().getKey();

        return results;
    }
}
