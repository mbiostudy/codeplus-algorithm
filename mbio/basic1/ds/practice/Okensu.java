package basic1.ds.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Okensu {
  // 시관 초과...
  // public static void main(String args[]) {
  // try (BufferedWriter bw = new BufferedWriter(new
  // OutputStreamWriter(System.out));
  // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
  // int n = Integer.parseInt(br.readLine());
  // int[] arr = new int[n];
  // String[] strArr = br.readLine().split(" ");
  // for (int i = 0; i < n; i++) {
  // arr[i] = Integer.parseInt(strArr[i]);
  // }
  // for (int i = 0; i < n-1; i++) {
  // boolean isExist = false;
  // int num = arr[i];
  // for (int j = i + 1; j < n; j++) {
  // if (arr[j] > num) {
  // bw.write(arr[j] + " ");
  // isExist = true;
  // break;
  // }
  // }
  // if (!isExist) {
  // bw.write(-1 + " ");
  // }
  // }
  // bw.write(-1 + System.lineSeparator());
  // } catch (IOException ioe) {
  // ioe.printStackTrace();
  // }
  // }

  // 정답
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bf.readLine());
    int[] a = new int[n];
    int[] ans = new int[n];
    String[] temp = bf.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(temp[i]);
    }
    Stack<Integer> s = new Stack<>();
    s.push(0);
    for (int i = 1; i < n; i++) {
      if (s.isEmpty()) {
        s.push(i);
      }
      while (!s.isEmpty() && a[s.peek()] < a[i]) {
        ans[s.pop()] = a[i];
      }
      s.push(i);
    }
    while (!s.empty()) {
      ans[s.pop()] = -1;
    }
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i = 0; i < n; i++) {
      bw.write(ans[i] + " ");
    }
    bw.write("\n");
    bw.flush();
  }
}
