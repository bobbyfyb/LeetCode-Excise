package algoritm.greed;

import java.util.ArrayList;
import java.util.Arrays;

/*
* https://leetcode-cn.com/problems/candy/
 */
public class Candy {
    public int candy(int[] ratings) {
        int size = ratings.length;
        if(size < 2)
            return size;

        ArrayList<Integer> candies = new ArrayList<>();
        for(int i = 0; i < size; i++)
            candies.add(1);

        for(int i=1; i<size; i++){
            if(ratings[i] > ratings[i - 1])
                candies.set(i, candies.get(i-1).intValue()+1);
        }

        for(int i = size-1; i>0; i--){
            if(ratings[i-1]>ratings[i])
                candies.set(i-1, Math.max(candies.get(i-1).intValue(), candies.get(i).intValue()+1));
        }

        int sum = 0;
        for(int candy:candies)
            sum += candy;
        return sum;
    }
}
