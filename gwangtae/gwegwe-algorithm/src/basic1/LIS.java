package basic1;

import java.util.Scanner;

public class LIS {

  static int[] a;
  static int[] d;

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    a = new int[n+1];
    d = new int[n+1];

    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }

    int result = 0;
    for (int i = 0; i < n; i++) {
      d[i] = 1;
      for (int j = 0; j < i; j++) {
        if (a[j] < a[i] && d[i] < d[j] + 1) {
          d[i] = d[j] + 1;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      if (d[i] > result) {
        result = d[i];
      }
    }

    System.out.println(result);
    sc.close();
  }
}
