package com.bob.codeLabs;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * created by cly on 2022/3/1
 */
public class DemoTest {
    @Test
    public void test() {
        //两个有序队列合并
        int[] nums1 = {5, 6, 7, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;
//        merge(nums1, m, nums2, n);
//        flip(nums1);
        //两数之和
//        int[] ints = twoSum(nums1, 5);
//        System.out.println(Arrays.toString(ints));
        // 单链表 两数相加
        ListNode listNode1 = new ListNode(9, new ListNode(2, new ListNode(3)));
        ListNode listNode2 = new ListNode(4, new ListNode(5, new ListNode(6)));
        ListNode listNode = addTwoNumbers(listNode1, listNode2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode();
        ListNode cursor = root;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int i = l1 != null ? l1.val : 0;
            int j = l2 != null ? l2.val : 0;
            int sum = i + j + carry;
            carry = sum / 10;
            ListNode listNode = new ListNode(sum % 10);
            cursor.next = listNode;
            cursor = listNode;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return root.next;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                res[0] = hashMap.get(nums[i]);
                res[1] = i;
                break;
            }
            hashMap.put(target - nums[i], i);
        }
        return res;
    }

    public void flip(int[] ints) {
        for (int i = 0; i < ints.length / 2; i++) {
            int temp = ints[i];
            ints[i] = ints[ints.length - 1 - i];
            ints[ints.length - 1 - i] = temp;
        }
        System.out.println(ints);
    }

    /**
     * 两个有序队列合并
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
     * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-- + --n;
        while (n >= 0) {
            nums1[i--] = m >= 0 && nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        System.out.println(Arrays.toString(nums1));
    }


    private class ListNode {
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
}
