package basic1.dp.dp1;

//15990

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PlusOneTwoThree5 {

  static final long mod = 1000000009L;
  static final int limit = 100000;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
      long[][] d = new long[limit + 1][4];
      for (int i = 1; i <= limit; i++) {
        if (i - 1 >= 0) {
          d[i][1] = d[i - 1][2] + d[i - 1][3];
          if (i == 1) {
            d[i][1] = 1;
          }
        }
        if (i - 2 >= 0) {
          d[i][2] = d[i - 2][1] + d[i - 2][3];
          if (i == 2) {
            d[i][2] = 1;
          }
        }
        if (i - 3 >= 0) {
          d[i][3] = d[i - 3][1] + d[i - 3][2];
          if (i == 3) {
            d[i][3] = 1;
          }
        }
        d[i][1] %= mod;
        d[i][2] %= mod;
        d[i][3] %= mod;
      }
      int T = Integer.parseInt(br.readLine());
      while (T-- > 0) {
        int n = Integer.parseInt(br.readLine());
        bw.write((d[n][1] + d[n][2] + d[n][3]) % mod + System.lineSeparator());
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
