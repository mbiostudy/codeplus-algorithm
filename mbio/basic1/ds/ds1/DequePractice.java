package basic1.ds.ds1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DequePractice {

  public static final String PUSH_FRONT = "push_front";
  public static final String PUSH_BACK = "push_back";
  public static final String POP_FRONT = "pop_front";
  public static final String POP_BACK = "pop_back";
  public static final String SIZE = "size";
  public static final String EMPTY = "empty";
  public static final String FRONT = "front";
  public static final String BACK = "back";

  public static void main(String args[]) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int n = Integer.parseInt(br.readLine());
      Deque deque = new Deque();
      while (n-- > 0) {
        String[] line = br.readLine().split(" ");
        String cmd = line[0];
        if (PUSH_FRONT.equals(cmd)) {
          deque.pushFront(Integer.parseInt(line[1]));
        } else if (PUSH_BACK.equals(cmd)) {
          deque.pushBack(Integer.parseInt(line[1]));
        } else if (POP_FRONT.equals(cmd)) {
          bw.write(deque.popFront() + System.lineSeparator());
        } else if (POP_BACK.equals(cmd)) {
          bw.write(deque.popBack() + System.lineSeparator());
        } else if (SIZE.equals(cmd)) {
          bw.write(deque.size() + System.lineSeparator());
        } else if (EMPTY.equals(cmd)) {
          bw.write(deque.empty() + System.lineSeparator());
        } else if (FRONT.equals(cmd)) {
          bw.write(deque.front() + System.lineSeparator());
        } else if (BACK.equals(cmd)) {
          bw.write(deque.back() + System.lineSeparator());
        }
      }
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }
  }
}

class Deque {

  int[] deque = new int[10000];
  int begin = 0;
  int end = 0;

  void pushFront(int data) {
    if (begin == end) {
      deque[begin] = data;
      end++;
    } else {
      int[] temp = new int[10000];
      temp[begin] = data;
      for (int i = begin; i < end; i++) {
        temp[i + 1] = deque[i];
      }
      deque = temp;
      end++;
    }
  }

  void pushBack(int data) {
    deque[end++] = data;
  }

  int popFront() {
    if (begin == end) {
      return -1;
    } else {
      return deque[begin++];
    }
  }

  int popBack() {
    if (begin == end) {
      return -1;
    } else {
      return deque[--end];
    }
  }

  int front() {
    if (begin == end) {
      return -1;
    } else {
      return deque[begin];
    }
  }

  int back() {
    if (begin == end) {
      return -1;
    } else {
      return deque[end - 1];
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
