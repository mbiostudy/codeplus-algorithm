package basic1.dp.dp1;

// 11052

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BuyingCard {

  public static void main(String[] args) {
    try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
      int n = Integer.parseInt(br.readLine());  //카드 개수
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int[] p = new int[10000];
      int cnt = 1;
      while (st.hasMoreTokens()) {
        p[cnt++] = Integer.parseInt(st.nextToken());
      }
      int[] d = new int[n + 1];
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= i; j++) {
          d[i] = Math.max(d[i], d[i - j] + p[j]);
        }
      }
      bw.write(d[n] + "");
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
