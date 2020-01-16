package com.google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeNodeTest {

  @Test
  void insert() {
    TreeNode n = new TreeNode(10);
    n.insert(5);
    n.insert(15);
    assertEquals("5 10 15", n.toString());
  }

    @Test
    void insert2() {
        TreeNode n = new TreeNode(40);
        n.insert(20);
        n.insert(60);
        n.insert(10);
        n.insert(30);
        n.insert(50);
        n.insert(70);
        assertEquals("10 20 30 40 50 60 70", n.toString());
    }
    @Test
    void nodeCount() {
        TreeNode n = new TreeNode(10);
        n.insert(5);
        n.insert(15);
        n.insert(15);
        assertEquals(3, n.nodes);
    }

    @Test
    void isInTree() {
        TreeNode n = new TreeNode(10);
        n.insert(5);
        n.insert(15);
        n.insert(15);
        assertEquals(true, n.isInTree(15));
        assertEquals(false, n.isInTree(45));
    }

    @Test
    void getHeigth() {
        TreeNode n = new TreeNode(10);
        n.insert(11);
        n.insert(12);
        n.insert(13);
        assertEquals(3, n.getHeigth());
    }

    @Test
    void isBST() {
        TreeNode n = new TreeNode(10);
        n.right = new TreeNode(9);
        n.left = new TreeNode(11);
        assertEquals(false, n.isBST());
    }

    @Test
    void isBST2() {
        TreeNode n = new TreeNode(10);
        n.right = new TreeNode(11);
        n.left = new TreeNode(9);
        assertEquals(true, n.isBST());
    }

    @Test
    void deleteLeaveChild() {
        TreeNode n = new TreeNode(10);
        n.insert(11);
        n.insert(12);
        n.insert(13);
        n.delete(13);
        assertEquals("10 11 12", n.toString());
    }

    @Test
    void deleteWithOneChild() {
        TreeNode n = new TreeNode(10);
        n.insert(11);
        n.insert(12);
        n.insert(13);
        n.delete(12);
        assertEquals("10 11 13", n.toString());
    }

    @Test
    void deleteWithTwoChild() {
        TreeNode n = new TreeNode(12);
        n.insert(5);
        n.insert(15);
        n.insert(3);
        n.insert(7);
        n.insert(13);
        n.insert(17);
        n.insert(1);
        n.insert(9);
        n.delete(12);
        assertEquals("1 3 5 7 9 13 15 17", n.toString());
    }
}