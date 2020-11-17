package basic1.dp.dp1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MakeOneBottomUp {

  static int[] d;

  public static void main(String args[]) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
      int n = Integer.parseInt(br.readLine());
      d = new int[n + 1];
      d[1] = 0;
      bw.write(getCount(n) + "");
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  static int getCount(int n) {
    for (int i = 2; i <= n; i++) {
      d[i] = d[i - 1] + 1;
      if (i % 2 == 0 && d[i] > d[i / 2] + 1) {
        d[i] = d[i / 2] + 1;
      }
      if (i % 3 == 0 && d[i] > d[i / 3] + 1) {
        d[i] = d[i / 3] + 1;
      }
    }
    return d[n];
  }
}
