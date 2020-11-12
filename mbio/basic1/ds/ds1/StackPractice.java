package basic1.ds.ds1;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StackPractice {

  public static final String PUSH = "push";
  public static final String POP = "pop";
  public static final String SIZE = "size";
  public static final String EMPTY = "empty";
  public static final String TOP = "top";

  public static void main(String args[]) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
      int n = Integer.parseInt(br.readLine());
      Stack stack = new Stack(n);
      while (n-- > 0) {
        String cmd = br.readLine();
        if (cmd.startsWith(PUSH)) {
          stack.push(Integer.parseInt(cmd.split(" ")[1]));
        } else if (cmd.startsWith(POP)) {
          bw.write(stack.pop() + System.lineSeparator());
        } else if (cmd.startsWith(SIZE)) {
          bw.write(stack.size + System.lineSeparator());
        } else if (cmd.startsWith(EMPTY)) {
          bw.write(stack.emtpy() + System.lineSeparator());
        } else if (cmd.startsWith(TOP)) {
          bw.write(stack.top() + System.lineSeparator());
        }
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}

class Stack {

  int[] stack;
  int size = 0;

  Stack(int n) {
    stack = new int[n];
  }

  void push(int data) {
    stack[size++] = data;
  }

  int pop() {
    if (size == 0) {
      return -1;
    } else {
      return stack[--size];
    }
  }

  int size() {
    return size;
  }

  int emtpy() {
    if (size == 0) {
      return 1;
    } else {
      return 0;
    }
  }

  int top() {
    if (size == 0) {
      return -1;
    } else {
      return stack[size - 1];
    }
  }
}