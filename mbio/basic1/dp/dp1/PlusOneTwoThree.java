package basic1.dp.dp1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PlusOneTwoThree {

  public static void main(String[] args){
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
      int T = Integer.parseInt(br.readLine());
      int[] d = new int[12];
      d[0] = 1;
      d[1] = 1;
      d[2] = 2;
      d[3] = 4;
      d[4] = 7;
      while(T-->0){
        int n = Integer.parseInt(br.readLine());
        for(int i=5;i<=n;i++){
          d[i] = d[i-1] + d[i-2] + d[i-3];
        }
        bw.write(d[n] + System.lineSeparator());
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
