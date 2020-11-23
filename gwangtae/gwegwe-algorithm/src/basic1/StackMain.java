package basic1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StackMain {

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.valueOf(br.readLine());

    String command;
    Stack stack = new Stack();

    for (int i = 0; i < n; i++) {
      command = br.readLine();
      if (command.startsWith("push")) {
        int num = Integer.valueOf(command.split(" ")[1]);
        stack.push(num);
      } else if (command.startsWith("pop")) {
        bw.write(stack.pop() + "\n");
      } else if (command.startsWith("size")) {
        bw.write(stack.size() + "\n");
      } else if (command.startsWith("empty")) {
        bw.write(stack.empty() + "\n");
      } else if (command.startsWith("top")) {
        bw.write(stack.top() + "\n");
      }
    }

    bw.flush();
    bw.close();
  }
}

class Stack {

  int[] stack = new int[10000];
  int size = 0;

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

  int empty() {
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