package EverydayTest;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定链表头结点head，该链表上的每个结点都有一个 唯一的整型值 。同时给定列表nums，该列表是上述链表中整型值的一个子集。
 * <p>
 * 返回列表nums中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表nums中）构成的集合。
 */
public class numComponents {
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

    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);

        }
        ListNode p = head;
        while (p != null) {
            if (set.contains(p.val) && (!set.contains(p.next.val) || p.next == null)) {
                count++;
            }
            p = p.next;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
