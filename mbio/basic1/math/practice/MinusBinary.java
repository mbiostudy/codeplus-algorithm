package basic1.math.practice;

import java.io.*;

public class MinusBinary {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
      int n = Integer.parseInt(br.readLine());
      if (n == 0) {
        bw.write(0 + "");
      } else {
        StringBuffer sb = new StringBuffer();
        while (n != 0) {
          if (n % -2 == 0) {
            n = n / -2;
            sb.insert(0, "0");
          } else {
            if (n == -1) {
              n = 1;
            } else {
              n = n / -2;
              if (n > 0) {
                n += 1;
              }
            }
            sb.insert(0, "1");
          }
        }
        bw.write(sb.toString());
      }

    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
