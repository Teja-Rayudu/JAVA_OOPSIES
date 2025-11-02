package DSA.LINKED_LISTS;

import java.util.Scanner;

import static DSA.LINKED_LISTS.ReverseLL.display;

public class KGroups { // Reverse nodes in K groups
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nodes = sc.nextLine().split(" ");
        int n = nodes.length;
        if(n == 0) return;
        Node head = new Node(Integer.parseInt(nodes[0]));
        Node curr = head;
        for (int i = 1; i < n; i++) {
            curr.next = new Node(Integer.parseInt(nodes[i]));
            curr = curr.next;
        }
        int k = sc.nextInt();
        Node rev = reverseKGroups(head, k);
        display(rev);
    }

    private static Node reverseKGroups(Node head, int k) {
        if(head == null) return null;
        Node tail = head;
        for(int i = 0; i < k; i++){
            if(tail == null) return head;
            tail = tail.next;
        }
        Node newHead = reverse(head, tail);
        head.next = reverseKGroups(tail, k);
        return newHead;
    }

    private static Node reverse(Node curr, Node end){
        Node prev = null;
        while(curr != end){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
