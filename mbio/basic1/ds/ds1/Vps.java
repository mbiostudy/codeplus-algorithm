package basic1.ds.ds1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Vps {

  public static void main(String args[]) {

    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
      int n = Integer.parseInt(br.readLine());
      while (n-- > 0) {
        String cmd = br.readLine();
        Stack<Character> stack = new Stack<>();
        boolean isNoMoreLps = Boolean.TRUE;
        for (Character ch : cmd.toCharArray()) {
          if (ch.equals('(')) {
            stack.push(ch);
          } else {
            if (stack.isEmpty()) {
              isNoMoreLps = Boolean.FALSE;
            } else {
              stack.pop();
            }
          }
        }
        if (isNoMoreLps) {
          if (stack.isEmpty()) {
            bw.write("YES");
          } else {
            bw.write("NO");
          }
        } else {
          bw.write("NO");
        }
        bw.write(System.lineSeparator());

      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

}
