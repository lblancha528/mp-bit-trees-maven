package edu.grinnell.csc207.util;

/**
 * A bit tree node with no children. Instead it holds a character.
 */
public class BitTreeLeaf implements BitTreeNode {
  /** The letter this leaf represents. */
  String val;

  /** The left child. */
  public BitTreeNode left = null;

  /** The right child. */
  public BitTreeNode right = null;

  /** A way to access the left child. */
  public BitTreeNode getLeft() {
    return this.left;
  } // getLeft()

  /** A way to access the right child. */
  public BitTreeNode getRight() {
    return this.right;
  } // getRight()

  /** A way to access the value. */
  public String getVal() {
    return this.val;
  } // getVal()

  /** A way to set the left child. */
  public void setLeft(BitTreeNode node) {
    this.left = node;
  } // setLeft(BitTreeNode)

  /** A way to set the right child. */
  public void setRight(BitTreeNode node) {
    this.right = node;
  } // setRight(BitTreeNode)

  /** A way to set the bit or character at a node. */
  public void setVal(String val) {
    this.val = val;
  } // setVal(String)
} // class BitTreeBranch
