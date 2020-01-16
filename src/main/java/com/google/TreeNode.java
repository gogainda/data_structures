package com.google;

import java.util.Stack;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    int nodes = 0;

    public TreeNode(int i) {
        val = i;
        nodes = 1;
    }

    public boolean isBST() {
        return isBstUtil(this, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBstUtil(TreeNode treeNode, int minValue, int maxValue) {
        if (treeNode == null) {
            return true;
        }
        if (treeNode.val > minValue
                && treeNode.val < maxValue
                && isBstUtil(treeNode.left, minValue, treeNode.val)
                && isBstUtil(treeNode.right, treeNode.val, maxValue)
        ) {
            return true;
        } else {
            return false;
        }
    }

    public boolean insert(int toInsert) {
        TreeNode curr = this;
        int comp = Integer.compare(toInsert, curr.val);

        while(comp < 0 && curr.left != null || comp > 0 && curr.right != null) {
            if (comp > 0) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
            comp = Integer.compare(toInsert, curr.val);
        }

        if (comp > 0) {
            curr.insertRightChild(toInsert);
        } else if (comp < 0) {
            curr.insertLeftChild(toInsert);
        } else {
            return false;
        }

        return true;
    }

    private void insertRightChild(int toInsert) {
        this.right = new TreeNode(toInsert);
        nodes++;
    }

    private void insertLeftChild(int toInsert) {
        this.left = new TreeNode(toInsert);
        nodes++;

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode curr = this;
        while (!s.empty() || curr != null) {
            if (curr != null) {
                s.add(curr);
                curr = curr.left;
            } else {
                TreeNode n = s.pop();
                sb.append(n.val);
                sb.append(" ");
                curr = n.right;
            }
        }
        return sb.toString().trim();
    }

    public boolean isInTree(int i) {
        TreeNode curr = this;
        int comp = Integer.compare(i, curr.val);

        while(comp < 0 && curr.left != null || comp > 0 && curr.right != null) {
            if (comp > 0) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        return curr.val == i;

    }

    public int getHeigth() {
        return getHeigth(this);

    }

    public int getHeigth(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = getHeigth(root.left);
        int rightHeight = getHeigth(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public void delete(int i) {
        deleteFromTree(this, i);
    }

    private TreeNode deleteFromTree(TreeNode treeNode, int i) {
        if (treeNode == null) {
            return treeNode;
        }
        if (treeNode.val < i) {
            treeNode.right = deleteFromTree(treeNode.right, i);
        } else if (treeNode.val > i) {
            treeNode.left = deleteFromTree(treeNode.left, i);
        } else {
            //no child
            if (treeNode.left == null && treeNode.right == null) {
                return null;
            } else if (treeNode.left == null) {
                return treeNode.right;
            } else if (treeNode.right == null) {
                return treeNode.left;
            } else {
                // 2 child
                TreeNode nextEl = findMin(treeNode.right);
                treeNode.val = nextEl.val;
                deleteFromTree(treeNode.right, nextEl.val);
            }
        }
        return treeNode;
    }

    private TreeNode findMin(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        if (treeNode.left == null) {
            return treeNode;
        }
        return findMin(treeNode.left);
    }
}
