package basic1;

import java.util.Scanner;

public class OneTwoThreePlus {

  static int[] d;

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      int testNumber = sc.nextInt();
      d = new int[testNumber+2];
      d[0] = 1;
      d[1] = 1;
      d[2] = 2;
      int result = calculate(testNumber);
      System.out.println(result);
    }
    sc.close();
  }

  public static int calculate(int n) {
    if (d[n] > 0) {
      return d[n];
    }

    return calculate(n-3) + calculate(n-2) + calculate(n-1);
  }
}
