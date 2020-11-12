package basic1.math.math1;

import java.io.*;
import java.util.StringTokenizer;

public class Lcm {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
      int n = Integer.parseInt(br.readLine());
      while (n-- > 0) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int g = gcd(a, b);
        bw.write(a * b / g + System.lineSeparator());
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
