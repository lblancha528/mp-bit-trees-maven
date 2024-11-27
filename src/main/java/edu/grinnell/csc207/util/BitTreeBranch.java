package edu.grinnell.csc207.util;

/**
 * A bit tree node with two children. It also stores the bit value that would be gotten by
 * traversing to this node.
 */
public class BitTreeBranch implements BitTreeNode {
  /** The left child. */
  BitTreeNode left;

  /** The right child. */
  BitTreeNode right;

  /** The bit in this branch. */
  String bit;

  /** A way to access the left child. */
  public BitTreeNode getLeft() {
    return this.left;
  } // getLeft()

  /** A way to access the right child. */
  public BitTreeNode getRight() {
    return this.right;
  } // getRight()

  /** A way to access the bit. */
  public String getVal() {
    return this.bit;
  } // getBit()

  /** A way to set the left child. */
  public void setLeft(BitTreeNode node) {
    this.left = node;
  } // setLeft(BitTreeNode)

  /** A way to set the right child. */
  public void setRight(BitTreeNode node) {
    this.right = node;
  } // setRight(BitTreenode)

  /** A way to set the bit or character at a node. */
  public void setVal(String val) {
    this.bit = val;
  } // setVal(String)
} // class BitTreeBranch
