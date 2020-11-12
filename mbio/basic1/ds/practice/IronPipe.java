package basic1.ds.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class IronPipe {

  public static void main(String args[]) {
    try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
      String line = br.readLine();
      Stack<Integer> stack = new Stack<>();
      int ret = 0;
      for (int i = 0; i < line.length(); i++) {
        char c = line.charAt(i);
        if (c == '(') {
          stack.add(i);
        } else {
          int tmp = stack.pop();
          if (i - tmp == 1) {
            ret += stack.size();
          } else {
            ret += 1;
          }
        }
      }
      bw.write(ret + System.lineSeparator());
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

  }

}
