package basic1;

import java.util.Scanner;

public class TwoMultipleNTiling2 {

  static int[] d;

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    d = new int[n+1];
    d[0] = 1;
    d[1] = 1;
    System.out.println(calculate(n));
    sc.close();
  }

  public static int calculate(int n) {
    if (d[n] > 0) {
      return d[n];
    }

    d[n] = (calculate(n-1) + calculate(n-2) + calculate(n-2)) % 10007;
    return d[n];
  }
}
