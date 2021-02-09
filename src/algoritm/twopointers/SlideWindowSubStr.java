package algoritm.twopointers;
/*
* https://leetcode-cn.com/problems/minimum-window-substring/
 */
public class SlideWindowSubStr {
    public String minWindow(String s, String t) {
        int[] chars = new int[128];
        boolean[] flags = new boolean[128];
        for(int i=0; i<t.length();++i){
            flags[t.charAt(i)] = true;
            ++chars[t.charAt(i)];
        }

        int cnt = 0, l=0, min_l=0, min_size = s.length()+1;
        for(int r=0; r<s.length();++r){
            if(flags[s.charAt(r)]){
                if(--chars[s.charAt(r)]>=0) {
                    ++cnt;
                }
                while (cnt == t.length()){
                    if(r-l+1<min_size){
                        min_l = l;
                        min_size = r-l+1;
                    }
                    if(flags[s.charAt(l)] && ++chars[s.charAt(l)]>0){
                        --cnt;
                    }
                    ++l;
                }
            }
        }
        return min_size>s.length()?"":s.substring(min_l, min_l+min_size);

    }
}
