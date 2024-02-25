package LinkedList;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }

    public static int size(ListNode head){
        ListNode temp = head;
        int size =0;
        while(temp!=null){
            temp = temp.next;
            size++;
        }
        return size;
    }

    public static void printList(ListNode head){
        ListNode temp = head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
    }
}
