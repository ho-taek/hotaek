import java.util.*;

public class _main {

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
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> {
            if(o1 == o2){
                return 0;
            }else if(o1 > o2){
                return -1;
            }else{
                return 1;
            }
        });
        pq.offer(2);
        pq.offer(3);
        System.out.println(pq);
        pq.offer(1);
        System.out.println(pq);
        pq.add(9);
        System.out.println(pq);
        pq.add(7);
        System.out.println(pq);
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());


    }

   
}
