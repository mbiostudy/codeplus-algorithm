package basic1;

import java.util.Scanner;

public class EasyStairNumber {

  static int[][] d;

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    d = new int[n+1][10];

    // 초기값
    for (int i = 1; i <= 9; i++) {
      d[1][i] = 1;
    }

    for (int i = 2; i<= n; i++) {
      for (int j = 0; j <= 9; j++) {
        if (j-1 >= 0) {
          d[i][j] += d[i-1][j-1];
        }

        if (j+1 <=9) {
          d[i][j] += d[i-1][j+1];
        }

        d[i][j] %= 1000000000;
      }
    }

    Long result = 0L;
    for (int i = 0; i <= 9; i++) {
      result += Long.valueOf(d[n][i]);
    }
    result %= 1000000000;

    System.out.println(result);
    sc.close();
  }
}
