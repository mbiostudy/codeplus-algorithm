package basic1.dp.practice;
// 1309
import java.util.Scanner;

public class Zoo {

  static final long mod = 9901L;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();
    long[][] d = new long[n + 1][3];
    d[0][0] = 1L;
    for (int i = 1; i <= n; i++) {
      d[i][0] = (d[i - 1][0] + d[i - 1][1] + d[i - 1][2]) % mod;
      d[i][1] = (d[i - 1][0] + d[i - 1][2]) % mod;
      d[i][2] = (d[i - 1][0] + d[i - 1][1]) % mod;
    }
    System.out.println((d[n][0] + d[n][1] + d[n][2]) % mod);
  }
}
