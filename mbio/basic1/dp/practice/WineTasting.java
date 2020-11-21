package basic1.dp.practice;
// 2156

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class WineTasting {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
      int n = Integer.parseInt(br.readLine());
      int[] a = new int[n + 1]; //포도주의 양
      for (int i = 1; i <= n; i++) {
        a[i] = Integer.parseInt(br.readLine());
      }
      int[] d = new int[n + 1];
      d[1] = a[1];
      if (n >= 2) {
        d[2] = a[1] + a[2];
      }
      for (int i = 3; i <= n; i++) {
        d[i] = d[i - 1];
        int temp = d[i - 2] + a[i];
        if (d[i] < temp) {
          d[i] = temp;
        }
        temp = d[i - 3] + a[i] + a[i - 1];
        if (d[i] < temp) {
          d[i] = temp;
        }
      }

      int result = d[1];
      for (int i = 2; i <= n; i++) {
        result = Math.max(result, d[i]);
      }
      bw.write(result + "");

    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

}
