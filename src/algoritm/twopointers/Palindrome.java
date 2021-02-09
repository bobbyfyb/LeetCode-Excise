package algoritm.twopointers;
/*
* https://leetcode-cn.com/problems/valid-palindrome-ii/
 */

public class Palindrome {
    int n = 0;
    public boolean validPalindrome(String s) {
        for(int i=0, j=s.length()-1;i<j;i++,j--){
            if(s.charAt(i)!=s.charAt(j)){
                if(n==1)
                    return false;
                else{
                    n=1;
                    return validPalindrome(s.substring(i, j))||validPalindrome(s.substring(i+1, j+1));
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Palindrome().validPalindrome("ebcbbececabbacecbbcbe");
    }
}
