import java.util.Scanner;

public class UpUpUpNumbers {
  static int[][] d;

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    d = new int[n+1][10];

    for (int i = 0; i < 10; i++) {
      d[1][i] = 1;
    }

    for (int i = 2; i <= n; i++) {
      for (int j = 0; j <= 9; j++) {
        for (int k = 0; k <=j; k++) {
          d[i][j] += d[i-1][k];
        }
      }
    }
  }
}
