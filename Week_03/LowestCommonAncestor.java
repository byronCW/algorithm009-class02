package com.gkb.algorithm;

/**
 * @author Byron Wang
 * @desc 寻找最近公共祖先
 * @date 2020/6/7
 */
public class LowestCommonAncestor {

    private TreeNode ancestor;

    /**
     * 寻找最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ancestor;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }

        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);

        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ancestor = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}