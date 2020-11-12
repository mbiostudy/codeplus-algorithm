package basic1.math.practice;

import java.io.*;
import java.util.StringTokenizer;

public class SumGcd {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
      int n = Integer.parseInt(br.readLine());
      while (n-- > 0) {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long sum = 0;
        for (int i = 0; i < m; i++) {
          for (int j = i + 1; j < m; j++) {
            sum += gcd(arr[i], arr[j]);
          }
        }
        bw.write(sum + System.lineSeparator());
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  static int gcd(int a, int b) {
    while (b != 0) {
      int r = a % b;
      a = b;
      b = r;
    }
    return a;
  }
}
