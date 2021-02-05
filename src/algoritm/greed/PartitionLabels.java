package algoritm.greed;
/*
* https://leetcode-cn.com/problems/partition-labels/b
 */
import java.util.*;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Character> characterList = new ArrayList<>();
        for (char c:S.toCharArray())
            characterList.add(c);
        HashSet<Character> characterHashSet = new HashSet<>(characterList);
        Map<Character, Integer> lastloc = new HashMap<>();
        for(Character c:characterHashSet) {
            lastloc.put(c,S.lastIndexOf(c));
        }
        List<Integer> partition = new ArrayList<>();
        int start=0, end = 0;
        for(int i = 0; i<S.length();i++){
            end = Math.max(end, lastloc.get(S.toCharArray()[i]));
            if(i == end){
                partition.add(end-start+1);
                start = end+1;
            }
        }
        return partition;


    }
}
