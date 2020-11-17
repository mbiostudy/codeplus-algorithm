package basic1.dp.dp1;

import java.util.Scanner;

public class TwoMultipleNTiling2 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] d = new int[1001];
    d[0] = 1;
    d[1] = 1;
    d[2] = 3;
    for (int i = 3; i <= n; i++) {
      d[i] = (d[i - 1] + 2*d[i - 2]) % 10007;
    }
    System.out.println(d[n]);
    sc.close();
  }
}
