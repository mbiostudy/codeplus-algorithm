package basic1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class WordReverse2Main {

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String word = br.readLine();
    boolean isTag = false;
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < word.length(); i++) {
      if (word.charAt(i) == '<') {
        while (!stack.isEmpty()) {
          bw.write(stack.pop());
        }
        isTag = true;
        bw.write(word.charAt(i));
      } else if (word.charAt(i) == '>') {
        isTag = false;
        bw.write(word.charAt(i));
      } else if (isTag) {
        bw.write(word.charAt(i));
      } else {
        if (word.charAt(i) != ' ') {
          stack.push(word.charAt(i));
        } else {
          while (!stack.isEmpty()) {
            bw.write(stack.pop());
          }
          bw.write(' ');
        }
      }
    }

    while (!stack.isEmpty()) {
      bw.write(stack.pop());
    }

    bw.flush();
    bw.close();
  }
}
