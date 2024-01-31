package reetcode.java.easy;

public class _21 {
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        if (list1.val < list2.val){
            list1.next = mergetTwoLists(list1.next, list2);
            return list1;
        }else{
            list2.next = mergetTwoLists(list1, list2.next);
            return list2;
        }
    }
}


