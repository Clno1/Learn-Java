package Javaguide;


import java.util.ArrayList;
import java.util.*;

public class listreverse {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack=new Stack<Integer>();
        while (listNode!=null) {
            stack.add(listNode.val);
            listNode=listNode.next;
        }
        
        ArrayList<Integer> ret=new ArrayList<Integer>();
        while (!stack.isEmpty()) {
            ret.add(stack.pop());
        }
        return ret;
    }
}

class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
