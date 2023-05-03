package com.datastructures;

import java.util.ArrayList;
import java.util.Iterator;

public class IntLinkedList implements Iterable<Integer> {

    class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        public int getValue() {
            return value;
        }

        public Node getNextElement() {
            return next;
        }

        public void add(int value) {
            if (next == null) {
                next = new Node(value);
            } else {
                next.add(value);
            }
        }

        public boolean contains(int value) {
            if (this.value == value) {
                return true;
            }
    
            if (next == null) {
                return false;
            }
    
            return next.contains(value);
        }

        public void remove(int value) {
            if (next != null) {
                if (next.getValue() == value) {
                    next = next.getNextElement();
                } else {
                    next.remove(value);
                }
            }
        }

        public int size() {
            if (next == null) {
                return 1;
            }
            return 1 + next.size();
        }
    }


    private Node head;

    public IntLinkedList() {
        this.head = null;
    }

    @Override
    public Iterator<Integer> iterator() {
        ArrayList<Integer> values = new ArrayList<>();
        Node node = head;
        while (node != null) {
            values.add(node.value);
            node = node.next;
        }
        return values.iterator();
    }

    public void add(int value) {
        if (head == null) {
            head = new Node(value);
        } else {
            head.add(value);
        }
    }

    public int size() {
        if (head == null) {
            return 0;
        }

        return head.size();
    }

    public void remove(int value) {
        if (head == null) {
            return;
        }

        if (head.getValue() == value) {
            head = head.getNextElement();
        } else {
            head.remove(value);
        }
    }

    public boolean contains(int value) {
        if (head == null) {
            return false;
        }

        return head.contains(value);
    }

}
