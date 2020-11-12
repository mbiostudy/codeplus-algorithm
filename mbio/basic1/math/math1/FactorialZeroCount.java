package basic1.math.math1;

import java.io.*;

public class FactorialZeroCount {

  public static void main(String[] args) {
    try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
      int n = Integer.parseInt(br.readLine());
      if (n < 5) {
        bw.write(0 + System.lineSeparator());
      } else {
        int div = 5;
        int ret = n / div;
        while (div * 5 < n) {
          div = div * 5;
          ret += n / div;
        }
        bw.write(ret + System.lineSeparator());
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
