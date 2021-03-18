package algoritm.codinginterview;
/*
* 剑指offer 18. 删除链表的节点
* https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class DeleteNode {


    public ListNode deleteNode(ListNode head, int val) {
        if(head == null)
            return null;
        if(head.val == val)
            return head.next;
        ListNode node = head;
        while(node.next!=null){
            if(node.next.val == val){
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
        return head;
    }
}





