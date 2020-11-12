package basic1.ds.ds1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class QueuePractice {

  public static final String PUSH = "push";
  public static final String POP = "pop";
  public static final String SIZE = "size";
  public static final String EMPTY = "empty";
  public static final String FRONT = "front";
  public static final String BACK = "back";

  public static void main(String args[]) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int n = Integer.parseInt(br.readLine());
      Queue queue = new Queue();
      while (n-- > 0) {
        String[] line = br.readLine().split(" ");
        String cmd = line[0];
        if (PUSH.equals(cmd)) {
          queue.push(Integer.parseInt(line[1]));
        } else if (POP.equals(cmd)) {
          bw.write(queue.pop() + System.lineSeparator());
        } else if (SIZE.equals(cmd)) {
          bw.write(queue.size() + System.lineSeparator());
        } else if (EMPTY.equals(cmd)) {
          bw.write(queue.empty() + System.lineSeparator());
        } else if (FRONT.equals(cmd)) {
          bw.write(queue.front() + System.lineSeparator());
        } else if (BACK.equals(cmd)) {
          bw.write(queue.back() + System.lineSeparator());
        }
      }
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }
  }
}

class Queue {

  int[] queue = new int[10000];
  int begin = 0;
  int end = 0;

  void push(int data) {
    queue[end++] = data;
  }

  int pop() {
    if (begin == end) {
      return -1;
    } else {
      return queue[begin++];
    }
  }

  int front() {
    if (begin == end) {
      return -1;
    } else {
      return queue[begin];
    }
  }

  int back() {
    if (begin == end) {
      return -1;
    } else {
      return queue[end - 1];
    }
  }

  int empty() {
    if (begin == end) {
      return 1;
    } else {
      return 0;
    }
  }

  int size() {
    return end - begin;
  }
}
