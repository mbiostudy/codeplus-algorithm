package basic1;

import java.util.Scanner;

public class BuyingCard {

  static int[] d;
  static int[] p;
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    d = new int[n+2];
    p = new int[n+2];
    for (int i = 1; i <= n; i++) {
      p[i] = sc.nextInt();
    }
    d[0] = 0;
    d[1] = p[1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        d[i] = Math.max(d[i], d[i-j] + p[j]);
      }
    }

    System.out.println(d[n]);
    sc.close();
  }

}
