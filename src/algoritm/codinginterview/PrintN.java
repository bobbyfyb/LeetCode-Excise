package algoritm.codinginterview;
/*
* 剑指offer 17. 打印从1到最大的n位数
* https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 */
public class PrintN {
    public void printN(int n){
        if(n<=0)
            return;
        char[] number = new char[n+1];
        number[n] = '\0';
        while(!increment(number))
            printNumber(number);

    }

    public void printN2(int n){
        if(n<=0)
            return;
        char[] number = new char[n+1];
        number[n] = '\0';

        for(int i=0;i<10;++i){
            number[0] = (char) (i + '\0');
            print1ToN(number, n, 0);
        }
    }

    private void print1ToN(char[] number, int n, int index){
        if(index == n-1) {
            printNumber(number);
            return;
        }
        for(int i = 0; i<10; ++i){
            number[index + 1] = (char) ('\0' + i);
            print1ToN(number, n, index+1);
        }
    }


    private boolean increment(char[] number){
        boolean isOverFlow = false;
        int nTakeOver = 0;
        for(int i = number.length-1;i>=0;i--){
            int nSum = number[i] - '0' + nTakeOver;
            if(i == number.length-1)
                nSum++;
            if(nSum >=10){
                if(i==0)
                    isOverFlow = true;
                else{
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] = (char) ('0' + nSum);
                }
            }
            else{
                number[i] = (char) ('0'+nSum);
                break;
            }
        }
        return isOverFlow;
    }



    private void printNumber(char[] number){
        boolean isBeginning = true;
        for(int i = 0; i<number.length;++i){
            if(isBeginning && number[i] != '0')
                isBeginning=false;
            if(!isBeginning)
                System.out.print(number[i]);
        }
        System.out.print('\t');
    }


}
