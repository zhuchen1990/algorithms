package com.ezreal.tree;

/**
 * @author Ezreal#
 * @version 2018/5/10.
 */
public class RBTNode {
    public static final boolean RED   = false;
    public static final boolean BLACK = true;

    Integer value;
    RBTNode left;
    RBTNode right;
    RBTNode parent;
    //以该节点为根的子树中的结点总数
    //由其父结点指向它的链接的颜色也就是结点颜色.
    boolean color;

    public RBTNode(Integer value, RBTNode left, RBTNode right, RBTNode parent, boolean color) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.color = color;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public RBTNode getLeft() {
        return left;
    }

    public void setLeft(RBTNode left) {
        this.left = left;
    }

    public RBTNode getRight() {
        return right;
    }

    public void setRight(RBTNode right) {
        this.right = right;
    }

    public RBTNode getParent() {
        return parent;
    }

    public void setParent(RBTNode parent) {
        this.parent = parent;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }
}
