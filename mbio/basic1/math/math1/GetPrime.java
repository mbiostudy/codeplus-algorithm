package basic1.math.math1;

import java.io.*;
import java.util.StringTokenizer;

public class GetPrime {

  public static void main(String[] args) {
    try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int m = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      boolean[] check = new boolean[n + 1];
      check[0] = check[1] = true;
      //에라토스테네스의 체
      for (int i = 2; i * i <= n; i++) {
        if (!check[i]) {
          for (int j = i + i; j <= n; j += i) {
            check[j] = true;
          }
        }
      }
      for (int i = m; i <= n; i++) {
        if (!check[i]) {
          bw.write(i + System.lineSeparator());
        }
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
