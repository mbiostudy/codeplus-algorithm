package basic1.dp.dp1;
// 14002

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LIS4 {

  static int[] a;
  static int[] d;
  static int[] v;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      a = new int[n];
      int cnt = 0;
      while (st.hasMoreTokens()) {
        a[cnt++] = Integer.parseInt(st.nextToken());
      }

      d = new int[n]; //a[i]를 마지막으로하는 가장긴 부분수열의 길이 배열
      v = new int[n]; // 이전에 위치한 수의 위치를 기록
      for (int i = 0; i < n; i++) {
        d[i] = 1;
        v[i] = -1;
        for (int j = 0; j < i; j++) {
          if (a[j] < a[i] && d[i] < d[j] + 1) { //증가하는, 가장 긴
            d[i] = d[j] + 1;
            v[i] = j;
          }
        }
      }

      //최대값 출력
      int result = d[0];
      int p = 0;  //최대값 index
      for (int i = 0; i < n; i++) {
        if (result < d[i]) {
          result = d[i];
          p = i;
        }
      }
      System.out.println(result);
      go(p);
      System.out.println();

    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  static void go(int p) {
    if (p == -1) {
      return;
    }
    go(v[p]);
    System.out.print(a[p] + " ");
  }
}
