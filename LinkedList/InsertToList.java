package LinkedList;

import java.util.List;

public class InsertToList {
    public static void main(String[] args) {
        ListNode head = insert(null,1,0);
        head = insert(head,2,1);
        head = insert(head,3,2);
        head = insert(head,4,3);
        head = insert(head,5,4);
        head = insert(head,6,5);
        head = insert(head,7,6);
        ListNode.printList(head);
    }

    public static ListNode prepend(ListNode head,int val){
        ListNode node = new ListNode(val);
        if(head == null)
            head = node;
        else{
            node.next = head;
            head = node;
        }
        return head;
    }

    public static ListNode insert(ListNode head,int val,int index){
        ListNode node = new ListNode(val);
        if(head==null || index==0) {
            node.next = head;
            head = node;

        }else{
            ListNode temp = head;
            for(int i=0;i<index-1;i++){
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
        }
        return head;
    }
}
