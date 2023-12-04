package leetcode.editor.cn;

//Given an array of integers nums sorted in non-decreasing order, find the
//starting and ending position of a given target value.
//
// If target is not found in the array, return [-1, -1].
//
// You must write an algorithm with O(log n) runtime complexity.
//
//
// Example 1:
// Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
//
// Example 2:
// Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
//
// Example 3:
// Input: nums = [], target = 0
//Output: [-1,-1]
//
//
// Constraints:
//
//
// 0 <= nums.length <= 10⁵
// -10⁹ <= nums[i] <= 10⁹
// nums is a non-decreasing array.
// -10⁹ <= target <= 10⁹
//
//
// Related Topics 数组 二分查找 👍 2555 👎 0
/**
 * @author xj
 * @version 1.0
 * @DateTime 2023-12-04 22:33:45
 **/
public class _34FindFirstAndLastPositionOfElementInSortedArray {
	public static void main(String[] args) {
		Solution solution = new _34FindFirstAndLastPositionOfElementInSortedArray().new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		/*
			1					1
			11					2
			21					3
			1211				4
			111221				5
			312211				6
			13112221			7
			1113213211			8
			31131211131221		9
		 */
		public String countAndSay(int n) {

			StringBuffer sb = new StringBuffer("1");
			for (int i = 2; i <= n; i++) {
				String nStr = sb.toString();


				int slow = 0;
				int fast = 0;
				int len = nStr.length();

				sb = new StringBuffer();
				while (fast < len) {
					char numOfChar = nStr.charAt(slow);
					while (fast < len && nStr.charAt(fast) == numOfChar) {
						fast++;
					}
					int count = fast - slow;
					sb.append(count).append(numOfChar);
					slow = fast;
				}
			}
			return sb.toString();
		}
//leetcode submit region end(Prohibit modification and deletion)
	}
}
