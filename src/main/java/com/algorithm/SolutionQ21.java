package com.algorithm;

public class SolutionQ21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //判断l1或l2为空时操作
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode head;
        //建立头节点用于返回，建立temp节点，用于构造整个链表
        if(l1.val<l2.val){
            head = l1;
            l1 = l1.next;
        }
        else {
            head = l2;
            l2 = l2.next;
        }
        ListNode temp = head;
        //当l1和l2不为空时，通过temp节点，构造链表
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            }
            else {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            }
        }
        //当l1或l2已经到尾节点时
        if(l1==null)
            temp.next = l2;
        else if(l2==null)
            temp.next = l1;
        return head;
    }
}
