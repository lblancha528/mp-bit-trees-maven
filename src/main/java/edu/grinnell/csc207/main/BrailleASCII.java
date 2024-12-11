package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.BrailleAsciiTables;

/**
 * Takes user input and returns it in the requested script.
 *
 * @author Lily Blanchard
 */
public class BrailleASCII {
  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Inputs in the format 'script "message here"' Script options are 'braille', 'unicode', and
   * 'ascii'. 'braille' returns the provided ascii message in 6bit strings representing the braille
   * letter 'unicode' returns the provided ascii message in unicode characters of the braille
   * letters 'ascii' returns the provided bit-string message in ascii
   * 
   * @param args where the first element is the desired script and the second is a message to encode
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    for (int i = 0; i < args.length; i++) {
      pen.println(args[i]);
    }

    if ((args.length != 2)
        || (!(args[0].equals("unicode") || args[0].equals("ascii") || args[0].equals("braille")))) {
      pen.println("Invalid command 1.");
      return;
    } // if command or prompt is invalid, quit

    String script = args[0];
    String message = args[1];
    String end = "";

    if (script.equals("unicode")) {
      char[] msgLtrs = message.toCharArray();
      for (int i = 0; i < msgLtrs.length; i++) {
        String bits = BrailleAsciiTables.toBraille(msgLtrs[i]);
        end = end + BrailleAsciiTables.toUnicode(bits);
      } // for each letter ascii->braille->unicode
      pen.println(end);
      pen.close();
      return;
    } else if (script.equals("ascii")) {
      if ((message.length() % 6) == 0 && message.matches("[01]+")) {
        String[] bits = new String[message.length() / 6];
        for (int i = 0, j = 0; i < message.length(); i += 6, j++) {
          bits[j] = message.substring(i, i + 6);
        } // seperate into 6bit chunks

        for (int i = 0; i < bits.length; i++) {
          end = end + BrailleAsciiTables.toAscii(bits[i]);
        } // translate each chunk
        pen.println(end);
        pen.close();
        return;
      } else {
        pen.println("Invalid bit string.");
        pen.close();
        return;
      } // if valid string
    } else if (script.equals("braille")) {
      char[] msgLtrs = message.toCharArray();
      for (int i = 0; i < msgLtrs.length; i++) {
        end = end + BrailleAsciiTables.toBraille(msgLtrs[i]);
      } // for each letter
      pen.println(end);
      pen.close();
      return;
    } else {
      pen.println("Invalid command 2.");
      pen.close();
      return;
    } // run correct command
  } // main(String[]
} // class BrailleASCII
