import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class WordReverseMain {

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int index = Integer.valueOf(br.readLine());

    for (int i = 0; i < index; i++) {
      String sentence = br.readLine();
      String [] words = sentence.split(" ");
      for (int j = 0; j < words.length; j++) {
        Stack<Character> stack = new Stack();
        for (int k = 0; k < words[j].length(); k++) {
          stack.push(words[j].charAt(k));
        }
        for (int k = 0; k < words[j].length(); k++){
          bw.write(stack.pop());
        }

        bw.write(" ");
      }
    }

    bw.flush();
    bw.close();
  }
}
