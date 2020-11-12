package basic1.math.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class HideAndSeek6 {

  static int gcd(int a, int b) {
    while (b != 0) {
      int r = a % b;
      a = b;
      b = r;
    }
    return a;
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int n = Integer.parseInt(st.nextToken()); //동생숫자
      int s = Integer.parseInt(st.nextToken()); //수빈이 위치
      int[] arr = new int[n]; //동생 위치들
      StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
      for(int i=0;i<n;i++){
        arr[i] = Math.abs(Integer.parseInt(st2.nextToken()) - s); //수빈이와의 위치 차를 절대값으로 넣음
      }
      int result = arr[0];
      for(int i=1;i<n;i++){
        result = gcd(result, arr[i]);
      }
      bw.write(result + System.lineSeparator());

    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
