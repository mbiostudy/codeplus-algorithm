package basic1.math.math1;

import java.io.*;
import java.util.StringTokenizer;

public class Prime {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      int ret = 0;
      while (n-- > 0) {
        int targetNum = Integer.parseInt(st.nextToken());
        if (isPrime(targetNum)) {
          ret++;
        }
      }
      bw.write(ret + System.lineSeparator());
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  static boolean isPrime(int input) {
    if (input < 2) {
      return false;
    }
    for (int i = 2; i * i < input; i++) {
      if (input % i == 0) {
        return false;
      }
    }
    return true;
  }
}
