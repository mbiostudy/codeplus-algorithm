package basic1.math.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class OctalToBinary {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
      String s = br.readLine();
      StringBuffer sb = new StringBuffer();
      if ("0".equals(s)) {
        bw.write("0");
      }
      sb.append(convertBinary(Character.getNumericValue(s.charAt(0)), true));
      for (int i = 1; i < s.length(); i++) {
        int a = Character.getNumericValue(s.charAt(i));
        sb.append(convertBinary(a, false));
      }
      bw.write(sb.toString());
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  static String convertBinary(int a, boolean isFirst) {
    StringBuffer ret = new StringBuffer();
    while (a > 0) {
      ret.insert(0, a % 2);
      a = a / 2;
    }
    if (!isFirst) {
      if(ret.length() <1){
        ret.append("000");
      }else if (ret.length() < 2) {
        ret.insert(0, "00");
      } else if (ret.length() < 3) {
        ret.insert(0, "0");
      }
    }
    return ret.toString();
  }
}
