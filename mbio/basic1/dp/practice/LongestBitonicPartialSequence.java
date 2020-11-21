package basic1.dp.practice;
// 11054

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LongestBitonicPartialSequence {

  public static void main(String[] args) {
    try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(br.readLine());
      int[] a = new int[n];
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      for (int i = 0; i < n; i++) {
        a[i] = Integer.parseInt(st.nextToken());
      }

      int[] d = new int[n]; //a[i]를 마지막으로하는 가장 긴 증가하는 부분수열의 길이 배열
      for (int i = 0; i < n; i++) {
        d[i] = 1;
        for (int j = 0; j < i; j++) {
          if (a[j] < a[i] && d[i] < d[j] + 1) { //증가하는, 가장 긴
            d[i] = d[j] + 1;
          }
        }
      }

      int[] d2 = new int[n]; //a[i]를 마지막으로하는 가장 긴 감소하는 부분수열의 길이 배열
      for (int i = n - 1; i >= 0; i--) {
        d2[i] = 1;
        for (int j = i + 1; j < n; j++) {
          if (a[j] < a[i] && d2[i] < d2[j] + 1) { //감소하는, 가장 긴
            d2[i] = d2[j] + 1;
          }
        }
      }

      int result = d[0] + d2[0] - 1;
      for (int i = 0; i < n; i++) {
        if (result < d[i] + d2[i] - 1) {
          result = d[i] + d2[i] - 1;
        }
      }
      bw.write(result + "");


    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
