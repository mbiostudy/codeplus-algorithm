package basic1.dp.dp1;
//1912
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ContinuousSum {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int[] a = new int[n]; //입력받은 수열
      int[] d = new int[n]; //i번째 수에서 끝나는 연속합중 가장 큰 것들을 담음

      int cnt = 0;
      while (st.hasMoreTokens()) {
        a[cnt++] = Integer.parseInt(st.nextToken());
      }

      for (int i = 0; i < n; i++) {
        d[i] = a[i];  //자기 자신
        if (i == 0) {
          continue;
        }
        int temp = d[i - 1] + a[i];
        if (d[i] < temp) {
          d[i] = temp;
        }
      }

      int result = d[0];
      for (int i = 0; i < n; i++) {
        if (result < d[i]) {
          result = d[i];
        }
      }
      bw.write(result + "");

    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
