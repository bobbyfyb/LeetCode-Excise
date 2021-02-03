package algoritm.greed;

import java.util.Arrays;

/*
* https://leetcode-cn.com/problems/assign-cookies/
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0, cookies = 0;
        while(child < g.length && cookies < s.length){
            if(g[child]<=s[cookies])
                child++;
            cookies++;
        }
        return child;

    }
}
