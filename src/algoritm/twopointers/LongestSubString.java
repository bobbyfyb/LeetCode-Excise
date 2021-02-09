package algoritm.twopointers;
/*
* https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestSubString {
    public String findLongestWord(String s, List<String> d) {
        char[] cs = s.toCharArray();

        int[] count = new int[d.size()];
        for(int n=0; n<d.size(); n++){
            char[] chars = d.get(n).toCharArray();

            int i=0, j=0;
            while(i<cs.length&&j<chars.length){
                if(cs[i]==chars[j]){
                    ++count[n];
                    ++i;
                    ++j;

                }
                else{
                    ++i;

                }
            }
        }
        ArrayList<Integer> match = new ArrayList<>();
        for(int i = 0; i<d.size();i++){
            if(count[i]==d.get(i).length())
                match.add(i);
        }
        if(match.size()==0)
            return "";
        int max = match.get(0);
        for(int c:match){
            if(d.get(c).length()>d.get(max).length() || d.get(c).length()==d.get(max).length()&&d.get(c).compareTo(d.get(max))<0)
                max = c;

        }

        return d.get(max);

    }
    public static void main(String[] args) {
        new LongestSubString().findLongestWord("abpcplea",
                Arrays.asList(new String[]{"a", "b", "c"}.clone()));
    }
}
