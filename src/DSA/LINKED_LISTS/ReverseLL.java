package DSA.LINKED_LISTS;

import java.util.Scanner;

public class ReverseLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = new Node(sc.nextInt());
        Node curr = head;
        int i = 0;
        while (i < n - 1){
            curr.next = new Node(sc.nextInt());
            curr = curr.next;
            i++;
        }
        Node rev = reverse(head);
        display(rev);
    }

    public static void display(Node rev) {
        if(rev == null) return;
        Node curr = rev;
        while (curr != null){
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static Node reverse(Node head) {
        if(head == null || head.next == null) return head;
        Node curr = head;
        Node prev = null;
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
