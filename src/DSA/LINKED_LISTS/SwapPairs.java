package DSA.LINKED_LISTS;

import java.util.Scanner;

import static DSA.LINKED_LISTS.ReverseLL.display;

public class SwapPairs {
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
        Node rev = swapPairs(head);
        display(rev);
    }

    private static Node swapPairs(Node head) {
        if(head == null || head.next == null) return head;
        Node start = new Node(0);
        start.next = head;
        Node curr = start;
        while (curr.next != null && curr.next.next != null){
            curr.next = swap(curr.next, curr.next.next);
            curr = curr.next.next;
        }
        return start.next;
    }

    private static Node swap(Node p1, Node p2){
        p1.next = p2.next;
        p2.next = p1;
        return p2;
    }
}
