package basic1.dp.practice;
// 9465

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Sticker {

  public static void main(String[] args) {
    try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int T = Integer.parseInt(br.readLine());  //테스트 케이스 개수
      while (T-- > 0) {
        int n = Integer.parseInt(br.readLine());  //스티커 길이
        int[][] a = new int[2][n + 1];  //스티거 점수

        for (int i = 0; i < 2; i++) {
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          for (int j = 1; j <= n; j++) {
            a[i][j] = Integer.parseInt(st.nextToken());
          }
        }
        // d[i][j] 2*i에서 얻을 수 있는 최대, i번 에서 뜯는 스티커 j
        // j=0 안뜯, j=1 위, j=2 아래
        int[][] d = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
          d[i][0] = Math.max(Math.max(d[i - 1][0], d[i - 1][1]), d[i - 1][2]);
          d[i][1] = Math.max(d[i - 1][0], d[i - 1][2]) + a[0][i];
          d[i][2] = Math.max(d[i - 1][0], d[i - 1][1]) + a[1][i];
        }

        bw.write(Math.max(Math.max(d[n][0], d[n][1]), d[n][2]) + System.lineSeparator());
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
