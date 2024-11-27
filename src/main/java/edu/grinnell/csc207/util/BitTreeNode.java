package edu.grinnell.csc207.util;

/**
 * An interface for nodes of a bit tree.
 */
public interface BitTreeNode {
  /** A way to access the left child. */
  public BitTreeNode getLeft();

  /** A way to access the right child. */
  public BitTreeNode getRight();

  /** A way to access the value. */
  public String getVal();

  /** A way to set the left child. */
  public void setLeft(BitTreeNode node);

  /** A way to set the right child. */
  public void setRight(BitTreeNode node);

  /** A way to set the bit or character at a node. */
  public void setVal(String val);
} // interface BitTreeNode
