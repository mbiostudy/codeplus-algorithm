package basic1.dp.dp1;
//1699
import java.util.Scanner;

public class SumOfSquares {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] d = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      d[i] = i;
      for (int j = 1; j * j <= i; j++) {
        int temp = d[i - j * j] + 1;
        if (d[i] > temp) {
          d[i] = temp;
        }
      }
    }

    System.out.println(d[n]);
  }
}
