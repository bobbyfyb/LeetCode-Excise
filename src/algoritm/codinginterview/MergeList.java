package algoritm.codinginterview;
/*
* 剑指offer 25. 合并两个排序的链表
* https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 */
public class MergeList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 !=null)
            return l2;
        if(l1 != null && l2==null)
            return l1;
        if(l1==null && l2 == null)
            return null;
        ListNode res;
        if(l1.val <= l2.val){
            res = l1;
            l1 = l1.next;
        }
        else{
            res = l2;
            l2 = l2.next;
        }
        res.next = mergeTwoLists(l1, l2);
        return res;

    }
}
