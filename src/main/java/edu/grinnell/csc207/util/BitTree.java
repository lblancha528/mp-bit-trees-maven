package edu.grinnell.csc207.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Trees intended to be used in storing mappings between fixed-length sequences of bits and
 * corresponding values.
 *
 * @author Your Name Here
 */
public class BitTree {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /** The root node of the tree. */
  BitTreeNode root;

  /** The height of the tree. */
  int height;

  /** The number of set leaves in the tree. */
  int size;

  /** A spot to store values. */
  String cache;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Constructs a new bit tree of a specified height without creating any nodes.
   *
   * @param n the height of the tree
   */
  public BitTree(int n) {
    this.root = new BitTreeBranch();
    this.height = n;
    this.size = 0;
    this.cache = null;
  } // BitTree(int)

  // +---------------+-----------------------------------------------
  // | Local helpers |
  // +---------------+

  /**
   * Recurses over the tree to set the value at the correct spot.
   *
   * @param node the node to start at
   * @param bits the path to follow
   * @param value the value to set
   * @return the node that was set
   */
  public BitTreeNode helperSet(BitTreeNode node, String bits, String value) {
    if (node instanceof BitTreeLeaf) {
      node.setVal(value);
      size++;
    } else {
      if (bits.charAt(0) == 0) {
        node.setLeft(helperSet(node.getLeft(), bits.substring(1), value));
      } else if (bits.charAt(0) == 1) {
        node.setRight(helperSet(node.getRight(), bits.substring(1), value));
      } // if
    } // if
    return node;
  } // helperSet(BitTreeNode, String, String)

  /**
   * Recurses over the tree to get the value at the correct spot.
   *
   * @param node the node to start at
   * @param bits the path to follow
   * @return the value that was found
   */
  public String helperGet(BitTreeNode node, String bits) {
    if (node instanceof BitTreeLeaf) {
      return node.getVal();
    } else {
      if (bits.charAt(0) == 0) {
        helperGet(node.getLeft(), bits.substring(1));
      } else if (bits.charAt(0) == 1) {
        helperGet(node.getRight(), bits.substring(1));
      } // if
    } // if
    return node.getVal();
  } // helperSet(BitTreeNode, String, String)

  /**
   * Recurses over the tree to retrieve each leaf.
   * 
   * @param bitsSoFar a string of the bit path needed to reach the current node
   * @param node the node we start recursing from
   * @param pen to print
   */
  public void helperDump(String bitsSoFar, BitTreeNode node, PrintWriter pen) {
    if (node instanceof BitTreeLeaf) {
      pen.println(bitsSoFar + "," + node.getVal());
      return;
    } else {
      helperDump(bitsSoFar + 0, node.getLeft(), pen);
      helperDump(bitsSoFar + 1, node.getRight(), pen);
    } // if
  } // helperDump(String, BitTreeNode, PrintWriter)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sets the node reached by following the provided bits to the provided value.
   *
   * @param bits the bit path to follow
   * @param value the value to set at the node found
   */
  public void set(String bits, String value) throws Exception {
    if (bits.length() == 6 || bits.matches("[01]+")) {
      // if bits is appropriate length and has only 0 and 1 characters
      this.root = helperSet(this.root, bits, value);
    } else {
      throw new Exception("Invalid bit string.");
    } // if
  } // set(String, String)

  /**
   * Retrieves the value at the node reached by following the specified bit path.
   *
   * @param bits the bit path to follow
   * @return the value at the found node, as a string
   */
  public String get(String bits) throws Exception {
    if (bits.length() == 6 || bits.matches("[01]+")) {
      // if bits is appropriate length and has only 0 and 1 characters
      return helperGet(this.root, bits);
    } else {
      throw new Exception("Invalid bit string.");
    } // if
  } // get(String, String)

  /**
   * Prints all existing leaves of the tree in the following format: 'bitpath,value'
   *
   * @param pen to write with
   */
  public void dump(PrintWriter pen) {
    String bitsSoFar = new String("");
    helperDump(bitsSoFar, this.root, pen);
  } // dump(PrintWriter)

  /**
   * Fills in the tree using a table of specified bit paths and values.
   *
   * @param source the table of paths and values
   */
  public void load(InputStream source) {
    InputStreamReader isr = new InputStreamReader(source);
    BufferedReader eyes = new BufferedReader(isr);

    try {
      String line = eyes.readLine();
      while (line != null) {
        String bits = line.split(",")[0];
        String value = line.split(",")[1];
        this.set(bits, value);
        line = eyes.readLine();
      } // while
    } catch (Exception IOException) {
    } // try/catch
  } // load(InputStream)

} // class BitTree
