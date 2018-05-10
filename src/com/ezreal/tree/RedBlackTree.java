package com.ezreal.tree;

/**
 * @author Ezreal#
 * @version 2018/5/10.
 */
public class RedBlackTree {

    RBTNode root;
     /**
     * 对红黑树的节点(x)进行左旋转
     *
     * 左旋示意图(对节点x进行左旋)：
     *      px                              px
     *     /                               /
     *    x                               y
     *   /  \      --(左旋)-.            / \
     *  lx   y                          x  ry
     *     /   \                       /  \
     *    ly   ry                     lx  ly
     *
     *
     */
    private void leftRotate(RBTNode x){
        RBTNode y = x.right;
        x.right = y.left;
        if (y.left != null){
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null){
            this.root = y;
        } else if (x == x.parent.left){
            x.parent.left = y;
        }else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }
     /**
     * 对红黑树的节点(y)进行右旋转
     *
     * 右旋示意图(对节点y进行左旋)：
     *            py                               py
     *           /                                /
     *          y                                x
     *         /  \      --(右旋)-.            /  \
     *        x   ry                         lx   y
     *       / \                                 / \
     *      lx  rx                              rx  ry
     *
     */
    private void rightRotate(RBTNode y) {
        RBTNode x = y.left;
        y.left = x.right;
        if (x.right != null) {
            x.right.parent = y;
        }
        x.parent = y.parent;
        if (y.parent == null) {
            this.root = x;
        } else if (y == y.parent.right) {
            y.parent.right = x;
        } else {
            y.parent.right = x;
        }
        x.right = y;
        y.parent = x;
    }

    public void insert(RBTNode z){
        RBTNode y = null;
        RBTNode x = this.root;
        while (x != null) {
            y = x;
            if (z.value < x.value) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = y;
        if (y == null){
            this.root = z;
        } else if (z.value < y.value){
            y.left = z;
        }else {
            y.right = z;
        }
        z.left = null;
        z.right = null;
        z.color = RBTNode.RED;
        insertFixUp(z);
    }

    public  void insertFixUp(RBTNode z){
        while (z.parent != null && z.parent.color == RBTNode.RED){
            if (z.parent == z.parent.parent.left){
                RBTNode y = z.parent.parent.right;
                if (y != null && y.color == RBTNode.RED){
                    z.parent.color = RBTNode.BLACK;
                    y.color = RBTNode.BLACK;
                    y.parent.parent.color = RBTNode.RED;
                    z = z.parent.parent;
                } else if (z == z.parent.right){
                    z = z.parent;
                    leftRotate(z);
                }
                z.parent.color = RBTNode.BLACK;
                z.parent.parent.color = RBTNode.RED;
                rightRotate(z);
            }else {
                RBTNode x = z.parent.parent.left;
                if (x != null && x.color == RBTNode.RED){
                    z.parent.color = RBTNode.BLACK;
                    x.color = RBTNode.BLACK;
                    x.parent.parent.color = RBTNode.RED;
                    z = z.parent.parent;
                } else if (z == z.parent.left){
                    z = z.parent;
                    rightRotate(z);
                }
                z.parent.color = RBTNode.BLACK;
                z.parent.parent.color = RBTNode.RED;
                leftRotate(z);
            }
        }
        this.root.color = RBTNode.BLACK;
    }
}
