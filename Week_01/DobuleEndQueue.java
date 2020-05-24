package com.gkb.algorithm;

/**
 * @author  Byron Wang
 * @desc    双端队列
 * @date    2020-05-24
 */
public class DobuleEndQueue {

    private int capcity;

    private int size;

    private Node head, tail;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public DobuleEndQueue(int k) {
        this.capcity = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (size == capcity) {
            return false;
        }

        Node curr = new Node(value);
        if (size == 0) {
            tail = curr;
            head = curr;
        } else {
            head.prev = curr;
            curr.next = head;
            head = curr;
        }
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size == capcity) {
            return false;
        }

        Node curr = new Node(value);
        if (size == 0) {
            tail = curr;
            head =tail;
        } else {
            tail.next = curr;
            curr.prev = tail;
            tail = curr;
        }
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (head == null) {
            return -1;
        } else {
            return head.val;
        }
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (tail == null) {
            return -1;
        } else {
            return tail.val;
        }
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capcity;
    }
}

class Node {
    int val;
    Node next;
    Node prev;

    Node(int x) {
        val = x;
    }
}