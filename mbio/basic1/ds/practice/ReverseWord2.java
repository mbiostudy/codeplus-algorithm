package basic1.ds.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class ReverseWord2 {

  public static final char START_TAG = '<';
  public static final char END_TAG = '>';
  public static final char SPACE = ' ';

  public static void main(String args[]) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
      String line = br.readLine();
      StringBuffer result = new StringBuffer();
      Stack<Character> word = new Stack<>();
      Boolean isTag = Boolean.FALSE;
      for (char c : line.toCharArray()) {
        if (c == START_TAG) {
          if (!word.isEmpty()) {
            result.append(reverse(word));
          }
          isTag = Boolean.TRUE;
          result.append(c);
        } else if (c == END_TAG) {
          result.append(c);
          isTag = Boolean.FALSE;
        } else if (c == SPACE) {
          if (isTag) {
            result.append(c);
          } else {
            result.append(reverse(word));
            result.append(SPACE);
          }
        } else {
          if (isTag) {
            result.append(c);
          } else {
            word.add(c);
          }
        }
      }
      if (!word.isEmpty()) {
        result.append(reverse(word));
      }
      bw.write(result.toString() + System.lineSeparator());

    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  static String reverse(Stack<Character> input) {
    StringBuffer sb = new StringBuffer();
    while (!input.empty()) {
      sb.append(input.pop());
    }
    return sb.toString();
  }
}