import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class ParenthesisMain {

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int index = Integer.valueOf(br.readLine());

    for (int i = 0; i < index; i++) {
      String parenthesisWord = br.readLine();
      Stack<Character> stack = new Stack();
      Boolean isVPS = false;
      for (int j = 0; j < parenthesisWord.length(); j++) {
        if ('(' == parenthesisWord.charAt(j)) {
          stack.push(parenthesisWord.charAt(j));
        } else {
          if (!stack.isEmpty()) {
            stack.pop();
          } else {
            isVPS = true;
            break;
          }
        }
      }

      if (isVPS) {
        bw.write("NO" + "\n");
      } else {
        if (!stack.isEmpty()) {
          bw.write("NO" + "\n");
        } else {
          bw.write("YES" + "\n");
        }
      }

    }

    bw.flush();
    bw.close();
  }
}

