package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionMergin2Lists {
    public static void main(String[] args) {
        Queue q = new LinkedList<String>();
        q.add("aa");
        q.add("bb");
        q.add("cc");
        q.remove();
        System.out.println(q.element());
//        SolutionMergin2Lists s = new SolutionMergin2Lists();
//
//        ListNode l1 = new ListNode(1);
//        ListNode l11 = new ListNode(2);
//        l11.next = new ListNode(5);
//        l1.next = l11;
//        ListNode l2 = new ListNode(1);
//        ListNode l22 = new ListNode(3);
//        l22.next = new ListNode(4);
//        l2.next = l22;
//        s.mergeTwoLists(l1, l2);


    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }



      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

}
