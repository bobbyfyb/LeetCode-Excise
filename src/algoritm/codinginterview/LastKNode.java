package algoritm.codinginterview;
/*
* 剑指Offer 22. 链表中倒数第k个节点
*  https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class LastKNode {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null || k<=0)
            return null;
        ListNode fast = head, slow = head;
        for(int i = 1; i<=k-1;i++)
            fast = fast.next;
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
