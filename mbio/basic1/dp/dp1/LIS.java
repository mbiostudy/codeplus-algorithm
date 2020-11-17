package basic1.dp.dp1;
// 11053

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LIS {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {

      int n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int[] a = new int[n];
      int cnt = 0;
      while (st.hasMoreTokens()) {
        a[cnt++] = Integer.parseInt(st.nextToken());
      }

      int[] d = new int[n]; //a[i]를 마지막으로하는 가장긴 부분수열의 길이 배열
      for (int i = 0; i < n; i++) {
        d[i] = 1;
        for (int j = 0; j < i; j++) {
          if (a[j] < a[i] && d[i] < d[j] + 1) { //증가하는, 가장 긴
            d[i] = d[j] + 1;
          }
        }
      }

      //최대값 출력
      int result = d[0];
      for (int i = 0; i < n; i++) {
        if (result < d[i]) {
          result = d[i];
        }
      }
      bw.write(result + "");

    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
