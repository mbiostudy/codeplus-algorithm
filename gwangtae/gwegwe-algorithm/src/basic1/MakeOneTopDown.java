package basic1;

import java.io.IOException;
import java.util.Scanner;

public class MakeOneTopDown {

  public static int[] d;

  public static void main(String args[]) throws IOException {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    d = new int[n + 1];
    int result = calculate(n);
    System.out.println(result);
    sc.close();
  }

  private static int calculate(int n) {
    if (n == 1) {
      return 0;
    }

    if (d[n] > 0) {
      return d[n];
    }

    d[n] = calculate(n - 1) + 1;

    if (n % 2 == 0) {
      int temp = calculate(n / 2) + 1;
      if (d[n] > temp) {
        d[n] = temp;
      }
    }

    if (n % 3 == 0) {
      int temp = calculate(n / 3) + 1;
      if (d[n] > temp) {
        d[n] = temp;
      }
    }

    return d[n];
  }
}
