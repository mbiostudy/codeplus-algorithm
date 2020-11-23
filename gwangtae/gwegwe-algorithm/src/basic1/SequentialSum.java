package basic1;

import java.util.Scanner;

public class SequentialSum {

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

    d[0] = a[0];
    for (int i = 0; i < n - 1; i++) {
      if (a[i+1] > d[i] + a[i+1]) {
        d[i+1] = a[i+1];
      } else {
        d[i+1] = a[i+1] + d[i];
      }
    }

    int result = 0;
    for (int i = 0; i < n; i++) {
      if (d[i] > result) {
        result = d[i];
      }
    }

    System.out.println(result);
    sc.close();
  }
}
