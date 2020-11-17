package basic1.dp.dp1;

// 16194

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BuyingCard2 {

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

      int[] d = new int[n + 1];  // 카드 N개를 갖기위해 지불해야 하는 금액의 최소값 배열
      for (int i = 1; i < n + 1; i++) {
        d[i] = -1;  //최소값 초기화
      }

      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= i; j++) {
          int temp = d[i - j] + p[j];
          if (d[i] == -1 || d[i] > temp) {
            d[i] = temp;
          }
        }
      }

      bw.write(d[n] + "");
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
