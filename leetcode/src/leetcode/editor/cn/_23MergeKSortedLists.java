package leetcode.editor.cn;

//You are given an array of k linked-lists lists, each linked-list is sorted in
//ascending order.
//
// Merge all the linked-lists into one sorted linked-list and return it.
//
//
// Example 1:
//
//
//Input: lists = [[1,4,5],[1,3,4],[2,6]]
//Output: [1,1,2,3,4,4,5,6]
//Explanation: The linked-lists are:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//merging them into one sorted list:
//1->1->2->3->4->4->5->6
//
//
// Example 2:
//
//
//Input: lists = []
//Output: []
//
//
// Example 3:
//
//
//Input: lists = [[]]
//Output: []
//
//
//
// Constraints:
//
//
// k == lists.length
// 0 <= k <= 10⁴
// 0 <= lists[i].length <= 500
// -10⁴ <= lists[i][j] <= 10⁴
// lists[i] is sorted in ascending order.
// The sum of lists[i].length will not exceed 10⁴.
//
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2726 👎 0

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
* @author xj
* @version 1.0
* @Date 2023-12-22 23:55:59
**/
public class _23MergeKSortedLists{
	public static void main(String[] args) {
		Solution solution = new _23MergeKSortedLists().new Solution();

	}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


// if you want to  successfully submit in leetcode, here(The whole ListNode class) must be commented out.
public class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
	private PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((a, b)->
		a.val - b.val
	);
    public ListNode mergeKLists(ListNode[] lists) {
		ListNode res = new ListNode();
		ListNode cur = res;
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				priorityQueue.add(lists[i]);
			}
		}

		while (!priorityQueue.isEmpty()) {
			ListNode tmp = priorityQueue.poll();
			ListNode needPutAgain = tmp.next;
			tmp.next = null;
			cur.next = tmp;
			cur = cur.next;
			if (needPutAgain != null) {
				priorityQueue.add(needPutAgain);
			}
		}
		return res.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
