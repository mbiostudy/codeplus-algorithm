package basic1;

import java.util.Scanner;

public class RGBStreet2 {

  static int[][] d;
  static int[][] a;

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    a = new int[n + 1][3];
    d = new int[n + 1][3];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 3; j++) {
        a[i][j] = sc.nextInt();
      }
    }

    int ans = 1000 * 1000 + 1;

    for (int k = 0; k <= 2; k++) {
        // 첫 집의 색깔을 정해준다
      for (int j = 0; j <= 2; j++) {
        if (j == k) {
          d[1][j] = a[1][j];
        } else {
          d[1][j] = 1000 * 1000 + 1;
        }
      }

      for (int i = 1; i <= n; i++) {
        d[i][0] = Math.min(d[i - 1][1], d[i - 1][2]) + a[i][0];
        d[i][1] = Math.min(d[i - 1][0], d[i - 1][2]) + a[i][1];
        d[i][2] = Math.min(d[i - 1][0], d[i - 1][1]) + a[i][2];
      }

      // 마지막 집의 색이 같은경우 패스
      for (int j = 0; j <= 2; j++) {
        if (j == k) {
          continue;
        }

        ans = Math.min(ans,d[n][j]);
      }
    }

    System.out.println(ans);
  }
}
