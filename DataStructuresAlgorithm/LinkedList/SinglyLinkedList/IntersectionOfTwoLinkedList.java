package DataStructuresAlgorithm.LinkedList.SinglyLinkedList;

// Generic ListNode class
class ListNode<T> {
    public T data;
    public ListNode<T> next;

    public ListNode(T data) {
        this.data = data;
        this.next = null;
    }
}

public class IntersectionOfTwoLinkedList {
    public static void main(String[] args) {
        // Creating first linked list: 4 -> 1 -> 8 -> 4 -> 5
        ListNode<Integer> headA = new ListNode<>(4);
        headA.next = new ListNode<>(1);
        ListNode<Integer> intersection = new ListNode<>(8);
        headA.next.next = intersection;
        headA.next.next.next = new ListNode<>(4);
        headA.next.next.next.next = new ListNode<>(5);

        // Creating second linked list: 5 -> 0 -> 1 -> 8 -> 4 -> 5
        ListNode<Integer> headB = new ListNode<>(5);
        headB.next = new ListNode<>(0);
        headB.next.next = new ListNode<>(1);
        headB.next.next.next = intersection;

        // Should print 8
        System.out.println(findIntersection(headA, headB));
    }

    // Finds the intersection point value of two linked lists, or -1 if there's none
    public static int findIntersection(ListNode<Integer> firstHead, 
                                       ListNode<Integer> secondHead) {
        int lenA = getLength(firstHead);
        int lenB = getLength(secondHead);
        int diff = Math.abs(lenA - lenB);

        // Move the head pointer of the longer list ahead by 'diff' nodes
        if (lenB > lenA) {
            while (diff-- > 0) {
                secondHead = secondHead.next;
            }
        } else {
            while (diff-- > 0) {
                firstHead = firstHead.next;
            }
        }

        // Move both pointers and check for intersection
        while (firstHead != null && secondHead != null) {
            if (firstHead == secondHead) {
                return firstHead.data; // Found intersection node
            }
            firstHead = firstHead.next;
            secondHead = secondHead.next;
        }

        return -1; // No intersection
    }

    // Helper to get length of a linked list
    public static int getLength(ListNode<Integer> head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
