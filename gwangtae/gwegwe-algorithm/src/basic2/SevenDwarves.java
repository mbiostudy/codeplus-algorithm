package basic2;

import java.util.Arrays;
import java.util.Scanner;

public class SevenDwarves {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int[] nineDwarves = new int[9];
    int sumOfNineDwarvesHeights = 0;
    for (int i = 0; i < 9; i++) {
      nineDwarves[i] = sc.nextInt();
      sumOfNineDwarvesHeights += nineDwarves[i];
    }

    Arrays.sort(nineDwarves);

    for (int i = 0; i < 9; i++) {
      for (int j = i + 1; j < 9; j++) {
        if (sumOfNineDwarvesHeights - nineDwarves[i] - nineDwarves[j] == 100) {
          for (int k = 0; k < 9; k++) {
            if (k == i || k == j) {
              continue;
            }
            System.out.println(nineDwarves[k]);
          }
          System.exit(0);
        }
      }
    }
  }
}
