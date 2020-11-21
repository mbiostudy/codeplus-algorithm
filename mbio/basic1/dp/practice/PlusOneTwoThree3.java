package basic1.dp.practice;
//15988
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PlusOneTwoThree3 {

  static final long mod = 1000000009L;
  static final int limit = 1000000;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int t = Integer.parseInt(br.readLine());
      long[] d = new long[limit + 1];
      d[0] = 1;
      d[1] = 1;
      d[2] = 2;
      d[3] = 4;
      d[4] = 7;
      for (int i = 5; i <= limit; i++) {
        d[i] = (d[i - 1] + d[i - 2] + d[i - 3]) % mod;
      }

      while (t-- > 0) {
        int n = Integer.parseInt(br.readLine());
        bw.write(d[n]+System.lineSeparator());
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
