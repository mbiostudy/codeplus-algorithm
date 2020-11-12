package basic1.ds.ds1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class StackSequence {

  public static String sequence(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    int max = 0;
    for (int num : arr) {
      if (num > max) {
        while (num > max) {
          stack.push(++max);
          sb.append("+" + System.lineSeparator());
        }
        stack.pop();
        sb.append("-" + System.lineSeparator());
      } else {
        if (stack.peek() != num) {
          sb = new StringBuilder("NO" + System.lineSeparator());
          return sb.toString();
        } else {
          stack.pop();
          sb.append("-" + System.lineSeparator());
        }
      }
    }
    return sb.toString();
  }

  public static void main(String args[]) {
    try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(br.readLine());
      }
      bw.write(sequence(arr));
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
