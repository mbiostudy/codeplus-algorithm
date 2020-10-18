import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SumOfGCD {

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int number = Integer.valueOf(br.readLine());

    for (int i = 0; i < number; i++) {
      String[] numbersString = br.readLine().split(" ");
      int[] numbers = new int[numbersString.length - 1];

      for (int j = 1; j < numbersString.length; j++) {
        numbers[j - 1] = Integer.valueOf(numbersString[j]);
      }

      long answer = 0;

      for (int k = 0; k < numbers.length; k++) {
        for (int r = k + 1; r < numbers.length; r++) {
          answer += gcd(numbers[k], numbers[r]);
        }
      }

      bw.write(String.valueOf(answer));
      bw.write("\n");
      bw.flush();
    }

  }

  static int gcd(int a, int b) {

    if (b == 0) {
      return a;
    } else {
      return gcd(b, a % b);
    }
  }
}
