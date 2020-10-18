import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// 오큰수..?
public class RightBiggerNumber {

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int number = Integer.valueOf(br.readLine());
    int[] inputArr = new int[number];
    String[] temp = br.readLine().split(" ");
    for (int i=0; i<number; i++) {
      inputArr[i] = Integer.valueOf(temp[i]);
    }

    int[] resultArr = new int[number];
    Stack<Integer> stack = new Stack<>();
    stack.push(0);

    for (int i = 1; i < number; i++) {
      if (stack.isEmpty()) {
        stack.push(i);
      }

      while (!stack.isEmpty() && inputArr[stack.peek()] < inputArr[i]) {
        resultArr[stack.pop()] = inputArr[i];
      }

      stack.push(i);
    }

    while (!stack.empty()) {
      resultArr[stack.pop()] = -1;
    }

    for (int i = 0; i < resultArr.length; i++) {
      bw.write(resultArr[i] + " ");
    }

    bw.write("\n");
    bw.flush();
    bw.close();
    br.close();
  }

}
