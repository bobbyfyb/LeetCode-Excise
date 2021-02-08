package algoritm.greed;
/*
* https://leetcode-cn.com/problems/can-place-flowers/
 */
public class PlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i = 0; i<flowerbed.length; i++){
            if(flowerbed[i]==0 && (i==0 || flowerbed[i-1]==0) &&(i==flowerbed.length-1 || flowerbed[i+1]==0)){
                n--;
                if(n == 0) return true;
                flowerbed[i] = 1;
            }
        }
        return n<=0;


    }
}
