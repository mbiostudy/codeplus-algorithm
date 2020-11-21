package basic1.dp.practice;
// 1932

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class IntegerTriangle {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
      int n = Integer.parseInt(br.readLine());
      int[][] a = new int[n][n];
      int[][] d = new int[n][n];
      for (int i = 0; i < n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int j = 0; j <= i; j++) {
          a[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      d[0][0] = a[0][0];
      for (int i = 1; i < n; i++) {
        for (int j = 0; j <= i; j++) {
          d[i][j] = d[i - 1][j] + a[i][j];
          if (j - 1 >= 0 && d[i][j] < d[i - 1][j - 1] + a[i][j]) {
            d[i][j] = d[i - 1][j - 1] + a[i][j];
          }
        }
      }

      int result = d[n - 1][0];
      for (int i = 0; i < n; i++) {
        if (result < d[n - 1][i]) {
          result = d[n - 1][i];
        }
      }
      bw.write(result + "");

    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
