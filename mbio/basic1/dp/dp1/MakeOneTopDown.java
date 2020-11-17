package basic1.dp.dp1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MakeOneTopDown {

  static int[] d;

  public static void main(String args[]) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
      int n = Integer.parseInt(br.readLine());
      d = new int[n + 1];
      bw.write(getCount(n) + "");
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  static int getCount(int n) {
    if (n == 1) {
      return 0;
    }
    if (d[n] > 0) {
      return d[n];
    }
    d[n] = getCount(n - 1) + 1;
    if (n % 2 == 0) {
      int temp = getCount(n / 2) + 1;
      if (d[n] > temp) {
        d[n] = temp;
      }
    }
    if (n % 3 == 0) {
      int temp = getCount(n / 3) + 1;
      if (d[n] > temp) {
        d[n] = temp;
      }
    }
    return d[n];
  }
}
