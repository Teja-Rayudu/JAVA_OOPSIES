package DSA.LINKED_LISTS;

import java.util.Scanner;
import static DSA.LINKED_LISTS.ReverseLL.reverse;

public class PalindromeList {

    private static boolean isPalindrome(Node head) {
        if(head == null || head.next == null) return true;
        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverse(slow.next);
        slow = slow.next;

        while (slow != null){
            if(head.data != slow.data) return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
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
        boolean rev = isPalindrome(head);
        if(rev) System.out.println("Given list is a palindrome");
        else System.out.println("Given list is not a palindrome");
    }
}
