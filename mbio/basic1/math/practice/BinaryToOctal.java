package basic1.math.practice;

import java.io.*;

public class BinaryToOctal {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
      String s = br.readLine();
      int n = s.length();
      StringBuffer sb = new StringBuffer();
      if (n % 3 == 1) {
        bw.write(s.charAt(0) + "");
      } else if (n % 3 == 2) {
        bw.write((s.charAt(0) - '0') * 2 + (s.charAt(1) - '0') + "");
      }

      for (int i = s.length(); i > 2; i -= 3) {
        sb.insert(0, Integer.parseInt(s.substring(i - 3, i - 2)) * 4
            + Integer.parseInt(s.substring(i - 2, i - 1)) * 2
            + Integer.parseInt(s.substring(i - 1, i)));
      }
      bw.write(sb.toString());
      //      Integer.toString(Integer.parseInt(s,2), 8)  use java func
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
