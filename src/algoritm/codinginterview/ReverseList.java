package algoritm.codinginterview;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode a = null, b = head, c= null;
        while(b!=null){
            ListNode next = b.next;
            if(next == null)
                c = b;
            b.next = a;
            a = b;
            b = next;
        }
        return c;

    }
}
