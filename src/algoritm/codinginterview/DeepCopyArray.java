package algoritm.codinginterview;
/*
* 剑指offer 35. 复杂链表的复制
* https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/submissions/
 */
import java.util.HashMap;
import java.util.Map;

public class DeepCopyArray {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Node cur = head;
        Map<Node, Node> hash = new HashMap<>();
        while(cur!=null){
            hash.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while(cur!=null){
            hash.get(cur).next = hash.get(cur.next);
            hash.get(cur).random = hash.get(cur.random);
            cur = cur.next;
        }
        return hash.get(head);
    }

    public Node copyRandomList2(Node head) {
        if(head == null) return null;
        Node cur = head;
        // 1. 复制各节点，并构建拼接链表
        while(cur != null) {
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        // 2. 构建各新节点的 random 指向
        cur = head;
        while(cur != null) {
            if(cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        // 3. 拆分两链表
        cur = head.next;
        Node pre = head, res = head.next;
        while(cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null; // 单独处理原链表尾节点
        return res;      // 返回新链表头节点
    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}