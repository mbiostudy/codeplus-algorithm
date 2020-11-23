package basic1;

import java.util.Scanner;

public class IntegerTriangle {

  static int[][] d;
  static int[][] a;

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    a = new int[n+1][n+1];
    d = new int[n+1][n+1];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        a[i][j] = sc.nextInt();
      }
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (d[i-1][j] > d[i-1][j-1]) {
          d[i][i] += d[i-1][j] + a[i][j];
        } else {
          d[i][i] += d[i-1][j-1] + a[i][j];
        }
      }
    }
  }
}
