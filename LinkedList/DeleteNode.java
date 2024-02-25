package LinkedList;

public class DeleteNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head = InsertToList.insert(head,2,1);
        head = InsertToList.insert(head,3,2);
        head = InsertToList.insert(head,4,3);
        head = InsertToList.insert(head,5,4);

        head = removeNodeAt(head,2);
        ListNode.printList(head);
    }

    public static ListNode removeNodeAt(ListNode head,int index){
        if(index ==0)
            head = head.next;
        else{
            ListNode temp = head;
            for(int i=0;i<index-1;i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        return head;
    }
}
