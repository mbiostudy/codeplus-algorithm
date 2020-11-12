package basic1.math.math1;

import java.io.*;
import java.util.ArrayList;

public class Goldbach {

  static final String WRONG = "Goldbach's conjecture is wrong";
  static final int MAX = 1000000;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
      ArrayList<Integer> prime = new ArrayList<>();
      boolean[] check = new boolean[MAX + 1];
      check[0] = check[1] = true;
      for (int i = 2; i * i <= MAX; i++) {
        if (!check[i]) {
          prime.add(i);
          for (int j = i + i; j <= MAX; j += i) {
            check[j] = true;
          }
        }
      }
      while (true) {
        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
          break;
        }

        for (int i = 1; i < prime.size(); i++) {
          int a = prime.get(i);
          if (check[n - a] == false) {
            bw.write(n + " = " + a + " + " + (n - a) + System.lineSeparator());
            break;
          }
        }
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
