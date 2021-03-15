package algoritm.codinginterview;
/*
* 剑指offer 06. 从尾到头打印链表
* https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class ReverseLinkedArray {
    public int[] reversePrint(ListNode head){
        if(head == null)
            return new int[]{};
        int count=0;
        ListNode temp = new ListNode(head.val);
        temp.next = head.next;
        while(head!=null){
            ++count;
            head = head.next;
        }
        int[] res = new int[count];
        for(int i=0; i<res.length;i++){
            res[res.length-i-1] = temp.val;
            temp = temp.next;
        }
        return res;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}