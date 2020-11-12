package basic1.math.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class GoldbachPartition {

  static final int MAX = 1000000;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
      ArrayList<Integer> prime = new ArrayList<>();
      boolean[] check = new boolean[MAX + 1];
      for (int i = 2; i <= MAX; i++) {
        if (!check[i]) {
          prime.add(i);
          for (int j = i + i; j <= MAX; j += i) {
            check[j] = true;
          }
        }
      }
      int t = Integer.parseInt(br.readLine());
      while (t-- > 0) {
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int p : prime) {
          if (n - p >= 2 && p <= n - p) {
            if (check[n - p] == false) {
              sum += 1;
            }
          } else {
            break;
          }
        }
        bw.write(sum + System.lineSeparator());
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
