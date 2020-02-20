package com.zh.algorithm;

/**
 * 算法题2：两数相加
 * 描述：
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例:
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 *
 * @author he.zhang
 * @date 2020/2/20 15:52
 */
public class question2_sum {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 定义根节点，并把光标定义为根节点
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            // 1. 提取值
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            // 2. 计算两数之和
            int sumVal = l1Val + l2Val + carry;
            // 3. 计算进位
            carry = sumVal / 10;

            // 4. 把当前值写入node
            ListNode sumNode = new ListNode(sumVal % 10);
            // 5. 下级node = sumNode，用于建立链表关系
            cursor.next = sumNode;
            // 6. 设置节点为sumNode，用于下一次循环
            cursor = sumNode;
            // 7. 判断不为空时，取下一个值
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        // 根节点的值是空的，只用来建立链表关系，所以返回时取next
        return root.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode node11 = new question2_sum.ListNode(2);
        ListNode node12 = new question2_sum.ListNode(4);
        ListNode node13 = new question2_sum.ListNode(3);
        node11.next = node12;
        node12.next = node13;

        ListNode node21 = new question2_sum.ListNode(5);
        ListNode node22 = new question2_sum.ListNode(6);
        ListNode node23 = new question2_sum.ListNode(4);
        node21.next = node22;
        node22.next = node23;

        question2_sum sum = new question2_sum();
        ListNode listNode = sum.addTwoNumbers(node11, node21);
        System.out.println("执行结果：" + listNode.val + " --> " + listNode.next.val + " --> " + listNode.next.next.val);
    }
}


