package basic1.ds.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Odeungkeunsu {

  public static void main(String[] args) {
    try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(br.readLine());
      int[] a = new int[n];   //입력된 숫자 배열
      int[] ans = new int[n]; //정답 출력용 배열
      int[] f = new int[1000001]; //등장 횟수
      String[] temp = br.readLine().split(" ");
      for (int i = 0; i < n; i++) {
        a[i] = Integer.parseInt(temp[i]);
        f[a[i]] += 1;
      }
      Stack<Integer> s = new Stack<>();
      s.push(0);
      for (int i = 1; i < n; i++) {
        if (s.isEmpty()) {
          s.push(i);
        }
        while (!s.isEmpty() && f[a[s.peek()]] < f[a[i]]) {
          ans[s.pop()] = a[i];
        }
        s.push(i);
      }
      while (!s.empty()) {
        ans[s.pop()] = -1;
      }

      for (int i = 0; i < n; i++) {
        bw.write(ans[i] + " ");
      }
      bw.write("\n");

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
