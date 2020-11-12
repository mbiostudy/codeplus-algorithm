package basic1.ds.ds1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ReverseWord1 {

  public static void main(String args[]) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
      int n = Integer.parseInt(br.readLine());

      while (n-- > 0) {
        String sentence = br.readLine();
        String[] arr = sentence.split(" ");
        for (int i = 0; i < arr.length; i++) {
          bw.write(reverse(arr[i]) + " ");
        }
        bw.write(System.lineSeparator());
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

  }

  static String reverse(String input) {
    Stack1 stack = new Stack1(20);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < input.length(); i++) {
      stack.push(input.charAt(i));
    }
    while (stack.empty() != 1) {
      sb.append(stack.pop());
    }
    return sb.toString();
  }
}

class Stack1 {

  char[] stack;
  int size = 0;

  Stack1(int n) {
    stack = new char[n];
  }

  void push(char data) {
    stack[size++] = data;
  }

  char pop() {
    if (size == 0) {
      return '0';
    } else {
      return stack[--size];
    }
  }

  int size() {
    return size;
  }

  int empty() {
    if (size == 0) {
      return 1;
    } else {
      return 0;
    }
  }

  char top() {
    if (size == 0) {
      return '0';
    } else {
      return stack[size - 1];
    }
  }
}
