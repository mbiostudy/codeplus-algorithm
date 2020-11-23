package basic1;

import java.util.Scanner;

public class TwoMultipleNTiling {

  static int[] d;

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    d = new int[n+1];
    d[0] = 1;
    d[1] = 1;
    int result = calculate(n);
    System.out.println(result);
    sc.close();
  }

  public static int calculate(int n) {
    if (d[n] > 0) {
      return d[n];
    }

    d[n] = (calculate(n-1) + calculate(n-2)) % 10007;
    return d[n];
  }
}
