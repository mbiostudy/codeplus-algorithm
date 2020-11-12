package basic1.math.math1;

import java.io.*;
import java.util.StringTokenizer;

public class Combination {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      long n = Long.parseLong(st.nextToken());
      long m = Long.parseLong(st.nextToken());
      long two = 0, five = 0;
      for (long i = 2; i <= n; i *= 2) {
        two += n / i;
      }
      for (long i = 5; i <= n; i *= 5) {
        five += n / i;
      }
      for (long i = 2; i <= m; i *= 2) {
        two -= m / i;
      }
      for (long i = 5; i <= m; i *= 5) {
        five -= m / i;
      }
      for (long i = 2; i <= n - m; i *= 2) {
        two -= (n - m) / i;
      }
      for (long i = 5; i <= n - m; i *= 5) {
        five -= (n - m) / i;
      }
      bw.write(Math.min(two, five) + System.lineSeparator());
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
