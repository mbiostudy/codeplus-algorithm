package basic1.ds.ds1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Josephus {

  public static void main(String args[]) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
      String[] arr = br.readLine().split(" ");
      int n = Integer.parseInt(arr[0]);
      int k = Integer.parseInt(arr[1]);
      int cnt = 0;
      Queue<Integer> queue = new LinkedList<>();
      for (int i = 1; i <= n; i++) {
        queue.add(i);
      }
      StringBuilder sb = new StringBuilder("<");
      while (!queue.isEmpty()) {
        cnt++;
        if (cnt == k) {
          sb.append(queue.poll() + ", ");
          cnt = 0;
        } else {
          queue.add(queue.poll());
        }
      }
      sb.delete(sb.length() - 2, sb.length());
      bw.write(sb.toString() + ">" + System.lineSeparator());
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
