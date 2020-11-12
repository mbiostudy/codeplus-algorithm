package basic1.math.math1;

import java.io.*;

public class Factorial {

  public static void main(String[] args) {
    try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
      int n = Integer.parseInt(br.readLine());
      int ret = 1;
      for (int i = 2; i <= n; i++) {
        ret = ret * i;
      }
      bw.write(ret + System.lineSeparator());

    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
