package basic1.dp.practice;
// 11057

import java.util.Scanner;

public class NumberOfClimbs {

  static final long mod = 10007L;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();
    int[][] d = new int[n + 1][10];
//    d[i][j] = 길이 i, 마지막수 j 인 오르막 수의 개수
//    d[i][j] = sum d[i-1][k] (0<=k<=j)
    for (int i = 0; i < 10; i++) {
      d[1][i] = 1;
    }
    for (int i = 2; i <= n; i++) {
      for (int j = 0; j < 10; j++) {
        for (int k = 0; k <= j; k++) {
          d[i][j] += d[i - 1][k];
          d[i][j] %= mod;
        }
      }
    }

    long result = 0;
    for (int i = 0; i < 10; i++) {
      result += d[n][i];
    }
    System.out.println(result % mod);
  }
}
