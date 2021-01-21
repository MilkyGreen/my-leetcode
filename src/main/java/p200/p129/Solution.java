package p200.p129;

import java.util.ArrayList;
import java.util.List;

/**
 * //给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * //
 * // 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * //
 * // 计算从根到叶子节点生成的所有数字之和。
 * //
 * // 说明: 叶子节点是指没有子节点的节点。
 * //
 * // 示例 1:
 * //
 * // 输入: [1,2,3]
 * //    1
 * //   / \
 * //  2   3
 * //输出: 25
 * //解释:
 * //从根到叶子节点路径 1->2 代表数字 12.
 * //从根到叶子节点路径 1->3 代表数字 13.
 * //因此，数字总和 = 12 + 13 = 25.
 * //
 * // 示例 2:
 * //
 * // 输入: [4,9,0,5,1]
 * //    4
 * //   / \
 * //  9   0
 * // / \
 * //5   1
 * //输出: 1026
 * //解释:
 * //从根到叶子节点路径 4->9->5 代表数字 495.
 * //从根到叶子节点路径 4->9->1 代表数字 491.
 * //从根到叶子节点路径 4->0 代表数字 40.
 * //因此，数字总和 = 495 + 491 + 40 = 1026.
 */
public class Solution {


    /**
     * 思路：比较直观的dfs操作。
     * 还可以用bfs遍历
     */
    List<Integer> list = new ArrayList<>();
    public int sumNumbers(TreeNode root) {

        if(root == null){
            return 0;
        }
        dfs(root,0);
        int ans = 0;
        for (Integer integer : list) {
            ans += integer;
        }
        return ans;
    }


    private void dfs(TreeNode node,int curr){
        curr = curr*10 + node.val;
        if(node.left == null && node.right == null){
            list.add(curr);
            return;
        }

        if(node.left != null){
            dfs(node.left,curr);
        }
        if(node.right != null){
            dfs(node.right,curr);
        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}