package basic1.math.math1;

import java.io.*;

public class Remainder {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
      String[] lines = br.readLine().split(" ");
      int a = Integer.parseInt(lines[0]);
      int b = Integer.parseInt(lines[1]);
      int c = Integer.parseInt(lines[2]);
      bw.write((a + b) % c + System.lineSeparator());
      bw.write(((a % c) + (b % c)) % c + System.lineSeparator());
      bw.write((a * b) % c + System.lineSeparator());
      bw.write(((a % c) * (b % c)) % c + System.lineSeparator());

    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

  }
}
