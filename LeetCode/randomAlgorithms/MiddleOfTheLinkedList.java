/**
* 876. Middle of the Linked List
* https://leetcode.com/problems/middle-of-the-linked-list/description/
*/

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}

// fast & slow pointers (rabbit & turtle)
// Time complexity: O(N)
// Space complexity: O(1)
