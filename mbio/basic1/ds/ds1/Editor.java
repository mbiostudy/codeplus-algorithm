package basic1.ds.ds1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Editor {

  public static void main(String args[]) {
    try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
      Stack<Character> lstack = new Stack<>();
      Stack<Character> rstack = new Stack<>();
      for (char ch : br.readLine().toCharArray()) {
        lstack.push(ch);
      }
      int n = Integer.parseInt(br.readLine());
      while (n-- > 0) {
        String[] line = br.readLine().split(" ");
        char cmd = line[0].charAt(0);
        if (cmd == 'L') {
          if (!lstack.isEmpty()) {
            rstack.push(lstack.pop());
          }
        } else if (cmd == 'D') {
          if (!rstack.isEmpty()) {
            lstack.push(rstack.pop());
          }
        } else if (cmd == 'B') {
          if (!lstack.isEmpty()) {
            lstack.pop();
          }
        } else {
          lstack.push(line[1].charAt(0));
        }
      }
      while (!lstack.isEmpty()) {
        rstack.push(lstack.pop());
      }
      while (!rstack.isEmpty()) {
        bw.write(rstack.pop());
      }

      bw.write(System.lineSeparator());
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
